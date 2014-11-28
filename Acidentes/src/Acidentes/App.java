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
        if (cads.readFile("acidentes-2013.csv")) {
            System.out.println(cads.toString());
        } else {
            System.out.println("Erro de arquivo");
        }
        
        System.out.println("");
        System.out.println("Acontecem mais acidentes no Dia Semana: " + cads.retornaDiaSemana());
        System.out.println("Acontecem mais acidentes no Turno: " + cads.retornaTurno());
        System.out.println("Acontecem mais acidentes em tempo: "+ cads.retornaAcidenteTempo());
        System.out.println("Acontecem mais acidentes no dia do mês: "+ cads.retornaAcidenteDia());
        System.out.println("Acontecem mais acidentes na Hora: "+ cads.retornaAcidenteHora());
    }

}
