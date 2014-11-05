/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acidentes;

/**
 *
 * @author 12280437 Rodrigo / Lariel
 */
public class App {
    
    public static void main(String[] args) {
        
        Acidente ac = new Acidente("AV","Ana Cesar", "21/10/2014");
        //CadastroAcidentes cads = CadastroAcidentes.getInstance();
        ListDoubleLinked<Acidente> l = new ListDoubleLinked<>();
        l.add(ac);
        System.out.println(l);

        /*
        if(cads.readFile("acidente.csv"))
            System.out.println(cads.toString());
        
        else
            System.out.println("Erro de LEITURA JUMENTO");
        
        */
    }
    
}
