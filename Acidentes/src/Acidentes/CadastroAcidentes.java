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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

     public boolean readFile(String nomeArq) {
        Path path = Paths.get(nomeArq);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            String str, nome, tp_acidente,prefixo_rua;
            Date data =null;
            SimpleDateFormat format = new SimpleDateFormat("yyyymmdd HH:mm");
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNext()) {
                str = sc.next();
                prefixo_rua = str;
                nome = str;
                str =  sc.next();
                tp_acidente = str;
                str = sc.next();
                try {  
                    data = format.parse(str);
                } catch (Exception ex) {
                    System.out.println("Erro: " + ex);
                }
                Acidente a = new  Acidente (prefixo_rua,nome, tp_acidente, data);
                this.lista.add(a);    
                
            }
        } catch (IOException e) 
        {
            System.out.println("ERRO Cads: " + e);
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return lista.toString();
    }
}
