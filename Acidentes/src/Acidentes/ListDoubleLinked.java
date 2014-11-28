/*
 * To change this license headerRua, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acidentes;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author RODRIGO
 */
public class ListDoubleLinked {

    private Node headerRua;
    private Node trailerRua;
    private Node headerData;
    private Node trailerData;
    private Node posicaoData;
    private Node posicaoRua;
    private int count;
    private HashMap<String, Integer> contaAcidenteDiaSemana;
    private HashMap<String, Integer> contaAcidenteTurno;
    private HashMap<String, Integer> contaAcidenteTempo;
    private HashMap<Date, Integer> contaAcidenteDia;
    private HashMap<String, Integer> contaAcidenteHora;
    private Set<String> palavrasArq1;
    private Set<String> palavrasArq2;

    private class Node {

        public Acidente element;
        public Node nextRua;
        public Node prevRua;
        public Node nextData;
        public Node prevData;
        public Node currentPositionRua;
        public Node currentPositionData;

        public Node(Acidente e) {
            element = e;
            nextRua = null;
            prevRua = null;
            nextData = null;
            prevData = null;
            currentPositionData = null;
            currentPositionRua = null;
        }

    }

    public HashMap<String, Integer> getContaAcidenteTempo() {
        return contaAcidenteTempo;
    }
    
    public HashMap<String, Integer> getContaAcidenteDiaSemana() {
        return contaAcidenteDiaSemana;
    }

    public HashMap<String, Integer> getContaAcidenteTurno() {
        return contaAcidenteTurno;
    }

    public HashMap<Date, Integer> getContaAcidenteDia() {
        return contaAcidenteDia;
    }

    public HashMap<String, Integer> getContaAcidenteHora() {
        return contaAcidenteHora;
    }
    
    

    public ListDoubleLinked() {
        this.headerRua = new Node(null);
        this.trailerRua = new Node(null);
        this.headerData = new Node(null);
        this.trailerData = new Node(null);
        headerRua.nextRua = trailerRua;
        trailerRua.prevRua = headerRua;
        headerData.nextData = trailerData;
        trailerData.prevData = headerData;
        this.count = 0;
        this.posicaoRua = headerRua;
        this.posicaoData = headerData;
        contaAcidenteDiaSemana = new HashMap<>();
        contaAcidenteTurno = new HashMap<>();
        contaAcidenteTempo = new HashMap<>();
        contaAcidenteDia = new HashMap<>();
        contaAcidenteHora = new HashMap<>();
    }

    public void add(Acidente element) {
        Node novoNodo = new Node(element);
        Date aux;
        String stringAux;
        boolean inseriu = false;
        if (count == 0) {
            headerData.nextData = novoNodo;
            trailerData.prevData = novoNodo;
            novoNodo.prevData = headerData;
            novoNodo.nextData = trailerData;
            headerRua.nextRua = novoNodo;
            trailerRua.prevRua = novoNodo;
            novoNodo.prevRua = headerRua;
            novoNodo.nextRua = trailerRua;
            contaAcidenteDiaSemana.put(element.getDia_sem(), 1);
            contaAcidenteTurno.put(element.getTurno(), 1);
            contaAcidenteTempo.put(element.getTempo(), 1);
            
            aux = null;
            aux = element.getData();
            aux.setHours(0);
            aux.setMinutes(0);
            aux.setSeconds(0);
            contaAcidenteDia.put(aux,1);
            
            stringAux = "" + element.getData().getHours() + ":" + element.getData().getMinutes();
            contaAcidenteHora.put(stringAux,1);
        }
          /*  if (contaTurnoAcidente.containsKey(element.getTurno())) {
                contaTurnoAcidente.put(element.getTurno(), contaTurnoAcidente.get(element.getTurno()) + 1);
            }
            else {
                contaTurnoAcidente.put(element.getTurno(), 1);
            }

        } else {
            if (contaTurnoAcidente.containsKey(element.getTurno())) {
                contaTurnoAcidente.put(element.getTurno(), contaTurnoAcidente.get(element.getTurno()) + 1);
            } // Se não ele adiciona a palavra pela primeira vez
            else {
                contaTurnoAcidente.put(element.getTurno(), 1);
            }*/
        else{
            if(contaAcidenteDiaSemana.containsKey(element.getDia_sem())){
                contaAcidenteDiaSemana.put(element.getDia_sem(), contaAcidenteDiaSemana.get(element.getDia_sem())+1);
            }
            else{
                contaAcidenteDiaSemana.put(element.getDia_sem(), 1);
            }
            if(contaAcidenteTurno.containsKey(element.getTurno())){
                contaAcidenteTurno.put(element.getTurno(), contaAcidenteTurno.get(element.getTurno())+1);
            }
            else{
                contaAcidenteTurno.put(element.getTurno(), 1);
            }
            if(contaAcidenteTempo.containsKey(element.getTempo())){
                contaAcidenteTempo.put(element.getTempo(), contaAcidenteTurno.get(element.getTurno())+1);
            }
            else{
                contaAcidenteTempo.put(element.getTempo(), 1);
            }
            stringAux = "" + element.getData().getHours() + ":" + element.getData().getMinutes();
            if(contaAcidenteHora.containsKey(stringAux)){
                contaAcidenteHora.put(stringAux, contaAcidenteHora.get(stringAux)+1);
            }
            else{
                contaAcidenteHora.put(stringAux,1);
            }
            aux = element.getData();
            aux.setHours(0);
            aux.setMinutes(0);
            aux.setSeconds(0);
             if(contaAcidenteDia.containsKey(aux)){
                contaAcidenteDia.put(aux, contaAcidenteDia.get(aux)+1);
            }
            else{
                contaAcidenteDia.put(aux, 1);
            }
            Node auxData = headerData.nextData;
            while (auxData != trailerData) {
                try {
                    if (element.getData().after(auxData.element.getData())) {
                        auxData = auxData.nextData;
                    } else if (element.getData().before(auxData.element.getData())) {
                        novoNodo.nextData = auxData;
                        novoNodo.prevData = auxData.prevData;
                        auxData.prevData.nextData = novoNodo;
                        auxData.prevData = novoNodo;
                        inseriu = true;
                        break;
                    } else {
                        novoNodo.nextData = auxData;
                        novoNodo.prevData = auxData.prevData;
                        auxData.prevData.nextData = novoNodo;
                        auxData.prevData = novoNodo;
                        inseriu = true;
                        break;
                    }
                } catch (Exception exp) {
                    System.out.println("Erro list: " + exp);
                }
            }
            if (inseriu == false) {
                novoNodo.prevData = trailerData.prevData;
                novoNodo.nextData = trailerData;
                trailerData.prevData.nextData = novoNodo;
                trailerData.prevData = novoNodo;
            }
            inseriu = false;
            Node auxRua = headerRua.nextRua;
            int str;
            while (auxRua != trailerRua) {
                str = element.getNome_rua().compareTo(auxRua.element.getNome_rua());
                if (str < 0) {
                    novoNodo.nextRua = auxRua;
                    novoNodo.prevRua = auxRua.prevRua;
                    auxRua.prevRua.nextRua = novoNodo;
                    auxRua.prevRua = novoNodo;
                    inseriu = true;
                    break;
                } else if (str > 0) {
                    auxRua = auxRua.nextRua;
                } else {
                    novoNodo.prevRua = auxRua;
                    novoNodo.nextRua = auxRua.nextRua;
                    auxRua.nextRua.prevRua = novoNodo;
                    auxRua.nextRua = novoNodo;
                    inseriu = true;
                    break;
                }
            }
            if (inseriu == false) {
                novoNodo.prevRua = trailerRua.prevRua;
                novoNodo.nextRua = trailerRua;
                trailerRua.prevRua.nextRua = novoNodo;
                trailerRua.prevRua = novoNodo;
            }
        }
        count++;
    }

    /*public String verificaAcidentes() {
        if(contaTurnoAcidente.get("noite")>contaTurnoAcidente.get("dia"))
        return "noite";
        else{
            return "dia";
        }
    }*/

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public boolean contains(Acidente element) {
        Node aux = headerRua.nextRua;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return true;
            } else {
                aux = aux.nextRua;
            }
        }
        return false;
    }

    public int indexOf(Acidente element) {
        int index = 0;
        Node aux = headerRua.nextRua;
        while (aux != null) {
            if (aux.element.equals(element)) {
                return (index);
            }
            aux = aux.nextRua;
            index++;
        }
        return -1;

    }

    public void clear() {
        headerRua.nextRua = trailerRua;
        trailerRua.prevRua = headerRua;
        count = 0;
    }
/*
    public String retornaRua() {
        String rua;
        Node aux = posicaoRua.nextRua;
        rua = aux.element.getNome_rua();
        posicaoRua = posicaoRua.nextRua;
        return rua;
    }
*/
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = headerRua.nextRua;
        while (aux.element != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.nextRua;
        }
        return s.toString();
    }
}
