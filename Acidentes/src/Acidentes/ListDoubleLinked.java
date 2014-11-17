/*
 * To change this license header, choose License Headers in Project Properties.
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

    private Node header;
    private Node trailer;
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
            currentPositionData=null;
            currentPositionRua=null;
        }

    }

    public ListDoubleLinked() {
        this.header = new Node(null);
        this.trailer = new Node(null);
        header.nextRua = trailer;
        trailer.prevRua = header;
        this.count = 0;
    }
 //Falta inserir metodo de ordenação;
    public void add(Acidente element) {
        Node novoNodo = new Node(element);
        novoNodo.nextRua = trailer;
        novoNodo.prevRua = trailer.prevRua;
        trailer.prevRua.nextRua = novoNodo;
        trailer.prevRua = novoNodo;
        count++;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public int size() {
        return count;
    }

    public boolean contains(Acidente element) {
        Node aux = header.nextRua;
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
        Node aux = header.nextRua;
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
        header.nextRua = trailer;
        trailer.prevRua = header;
        count = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.nextRua;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
           System.out.println("\n");
            aux = aux.nextRua;
        }
        return s.toString();
    }
}
