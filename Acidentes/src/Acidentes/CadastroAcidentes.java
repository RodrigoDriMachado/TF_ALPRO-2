/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RODRIGO
 */
package Acidentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeArray;

public class CadastroAcidentes {

    private ListDoubleLinked lista;
    private static CadastroAcidentes cad = null;

    private CadastroAcidentes() {
        lista = new ListDoubleLinked();
    }

    public static CadastroAcidentes getInstance() {
        if (cad == null) {
            cad = new CadastroAcidentes();
        }
        return cad;
    }

    public void cleanAll() {
        lista.clear();
    }

    public void add(Acidente f) {
        lista.add(f);
    }
    /*
     public String retornaRua(){
     return lista.retornaRua();
     }*/

    public String retornaDiaSemana() {
        String dia = "";
        Integer maior = 0;
        Iterator it = lista.getContaAcidenteDiaSemana().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            Integer contador = (Integer) pairs.getValue();
            if (contador.intValue() >= maior.intValue()){
                dia = (String) pairs.getKey();
                maior = contador;
            }
        }
        return dia;
    }

    public String retornaTurno() {
        String turno = "";
        Integer maior = 0;
        Iterator it = lista.getContaAcidenteTurno().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            Integer contador = (Integer) pairs.getValue();
            if (contador.intValue() >= maior.intValue()){
                turno= (String) pairs.getKey();
                maior = contador;
            }
        }
        return turno;
    }
    
    public String retornaAcidenteTempo() {
        String tempo = "";
        Integer maior = 0;
        Iterator it = lista.getContaAcidenteTempo().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            Integer contador = (Integer) pairs.getValue();
            if (contador.intValue() >= maior.intValue()){
                tempo= (String) pairs.getKey();
                maior = contador;
            }
        }
        return tempo;
    }

    public Date retornaAcidenteDia() {
        Date dia = null;
        Integer maior = 0;
        Iterator it = lista.getContaAcidenteDia().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            Integer contador = (Integer) pairs.getValue();
            if (contador.intValue() >= maior.intValue()){
                dia= (Date) pairs.getKey();
                maior = contador;
            }
        }
        return dia;
    }
    
        public String retornaAcidenteHora() {
        String hora = "";
        Integer maior = 0;
        Iterator it = lista.getContaAcidenteHora().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            Integer contador = (Integer) pairs.getValue();
            if (contador.intValue() >= maior.intValue()){
                hora = (String) pairs.getKey();
                maior = contador;
            }
        }
        return hora;
    }
        
    public boolean readFile(String nomeArq) {
        Path path = Paths.get(nomeArq);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            /**
             * declaração de variaveis
             */
            String str, nome, tp_acidente, prefixo_rua, dia_sem;
            String tempo, turno, regiao;
            Date data = null;
            int qntd_feriados, qntd_morte, qntd_morte_post, qntd_fatais, qntd_auto, qntd_taxi,
                    qntd_lotc, qntd_onibus_urb, qntd_onb_int, qntd_caminhao, qntd_moto, qntd_carroca, qntd_bicicleta;
            /**
             * setando formatação da dat
             */
            SimpleDateFormat format = new SimpleDateFormat("yyyymmdd HH:mm");
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            //ignora a primeira linha do cabeçalho
            sc.nextLine();
            /**
             * Começa a ler e atribui os valores para as variaveis declaradas
             * acima
             *
             */
            //	NOITE_DIA	REGIAO 
            while (sc.hasNext()) {
                str = sc.next();
                prefixo_rua = getLogradouroPrefixoRua(str);
                nome = getLogradouroNomeRua(str);
                str = sc.next();
                tp_acidente = str;
                str = sc.next();
                try {
                    data = format.parse(str);
                } catch (Exception ex) {
                    System.out.println("Erro: " + ex);
                }
                dia_sem = sc.next();
                str = sc.next();
                qntd_feriados = Integer.parseInt(str);
                qntd_morte = Integer.parseInt(sc.next());
                qntd_morte_post = Integer.parseInt(sc.next());
                qntd_fatais = Integer.parseInt(sc.next());
                qntd_auto = Integer.parseInt(sc.next());
                qntd_taxi = Integer.parseInt(sc.next());
                qntd_lotc = Integer.parseInt(sc.next());
                qntd_onibus_urb = Integer.parseInt(sc.next());
                qntd_onb_int = Integer.parseInt(sc.next());
                qntd_caminhao = Integer.parseInt(sc.next());
                qntd_moto = Integer.parseInt(sc.next());
                qntd_carroca = Integer.parseInt(sc.next());
                qntd_bicicleta = Integer.parseInt(sc.next());
                tempo = sc.next();
                turno = sc.next();
                regiao = sc.next().replaceAll("\\r*", "");
                Acidente a = new Acidente(prefixo_rua, nome, tp_acidente, data, dia_sem, qntd_feriados, turno, regiao, qntd_morte, qntd_morte_post, qntd_fatais, qntd_auto, qntd_taxi, qntd_lotc, qntd_onibus_urb, qntd_onb_int, qntd_caminhao, qntd_moto, qntd_carroca, qntd_bicicleta, tempo);

                this.lista.add(a);

            }
        } catch (IOException e) {
            System.out.println("ERRO Cads: " + e);
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    private String getLogradouroPrefixo(String fullLogradouro) {
        if (fullLogradouro.indexOf("R.") > 0) {
            return fullLogradouro.substring(fullLogradouro.indexOf("R "));
        }
        if (fullLogradouro.indexOf("AV.") > 0) {
            return fullLogradouro.substring(fullLogradouro.indexOf("AV "));
        }
        return null;
    }

    private String getLogradouroPrefixoRua(String fullLogradouro) {
        if (fullLogradouro.indexOf(" ") > 0) {
            return fullLogradouro.substring(0, fullLogradouro.indexOf(" "));
        }
        return null;
    }

    private String getLogradouroNomeRua(String fullLogradouro) {
        if (fullLogradouro.indexOf(" ") > 0) {
            return fullLogradouro.substring(fullLogradouro.indexOf(" ")).trim();
        }
        return null;
    }
}
