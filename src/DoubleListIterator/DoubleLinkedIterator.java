package DoubleListIterator;

import java.util.Iterator;


public class DoubleLinkedIterator<E> implements Iterator<E> {
 
        private Node<E> corrente = new ListDoubleLinked<E>().header.next ;
        private Node<E> trailer = new ListDoubleLinked<E>().trailer;
        
 
        public boolean hasNext() {
            return corrente != trailer;
        }
 
        public E next() {
            E valor = corrente.element;
            corrente = corrente.next;
            return valor;
        }
 
        public void remove() {
            throw new UnsupportedOperationException();
        }
 
    }
