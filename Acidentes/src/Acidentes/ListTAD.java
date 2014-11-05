package Acidentes;

import java.util.Iterator;

public interface ListTAD<E>  extends Iterable<E>{
    public void add(E element);
    public void add(int index, E element);
    public E get(int index);
    public E set(int index, E element);
    public boolean remove(E element);
    public E remove(int index);
    public boolean isEmpty();
    public int size();
    public boolean contains(E element);
    public int indexOf(E element);
    public void clear();   
    Iterator<E> iterator();
    
}
