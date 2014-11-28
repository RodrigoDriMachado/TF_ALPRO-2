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
        System.out.println("INICIO APP");
        if (cads.readFile("acidentes-2013_2.csv")) {
            System.out.println("Teste de String: " + cads.toString());
        } else {
            System.out.println("Erro de arquivo");
        }
        System.out.println("FIM APP");
        

    //System.out.println("Turno com mais acidentes: " + cads.retornaTurnoMaisAcidente().toString());

    }

}
