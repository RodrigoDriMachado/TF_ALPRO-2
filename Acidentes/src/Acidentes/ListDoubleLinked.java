/*
 * To change this license headerRua, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acidentes;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author RODRIGO
 */
public class ListDoubleLinked {

    private Node headerRua;
    private Node trailerRua;
    private Node headerData;
    private Node trailerData;
    private int count;

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
    }

    public void add(Acidente element) {
        Node novoNodo = new Node(element);
        boolean inseriu = false;
        if (count == 0) {
            headerData.nextData = novoNodo;
            trailerData.prevData = novoNodo;
            novoNodo.prevData = headerData;
            novoNodo.nextData = trailerData;
            headerRua.nextRua = novoNodo;
            trailerData.prevRua = novoNodo;
            novoNodo.prevRua = headerRua;
            novoNodo.nextRua = trailerRua;

        } else {
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = headerRua.nextRua;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            System.out.println("\n");
            aux = aux.nextRua;
        }
        return s.toString();
    }
}
