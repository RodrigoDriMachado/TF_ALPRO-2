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
import java.util.Scanner;

public class CadastroAcidentes {

    private ListDoubleLinked<Acidente> lista;
    private static CadastroAcidentes cad = null;

    private CadastroAcidentes() {
        lista = new ListDoubleLinked<>();
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

    /* public boolean saveFile(String nomeArq) {
     Path path1 = Paths.get(nomeArq);
     try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
     for (Acidente f : lista) {
     writer.println(f.getCodigo() + ";" + f.getNome() + ";" + f.getSalarioBruto());
     }
     } catch (IOException e) {
     return false;
     }
     return true;

     }*/
    public boolean readFile(String nomeArq) {
        Path path = Paths.get(nomeArq);

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            String str = null, nome_r = null, pref_rua = null, data = null;
            sc.useDelimiter("[./;n]"); // separadores: ; e nova linha
            while (sc.hasNext()) {
                System.out.println("passei por aqui");
                str = sc.next();
                pref_rua = str;
                nome_r = sc.next();
                data = sc.next();
                Acidente a = new Acidente(pref_rua, nome_r, data);
                lista.add(a);
                //sc.next("/n");
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
