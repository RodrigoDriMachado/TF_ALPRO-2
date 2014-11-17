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
        
        CadastroAcidentes cads = CadastroAcidentes.getInstance();
        cads.cleanAll();
        if(cads.readFile("teste2.csv"))
            System.out.println(cads.toString());
        else{
            System.out.println("erro ao ler arquvio");
        }
        System.out.println(cads.toString());
        
    }
    
}
