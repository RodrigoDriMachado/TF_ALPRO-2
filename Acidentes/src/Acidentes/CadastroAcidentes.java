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
            String str = null, nome = null, tp_acidente =null;
            String date =null;
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            sc.nextLine();
            while (sc.hasNext()) {
                str = sc.next();
                nome = str;
                str =  sc.next();
                tp_acidente = str;
                str = sc.next();
                date = str;
                Acidente a = new  Acidente (nome, tp_acidente, date);
                lista.add(a);
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
