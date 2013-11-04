package DoubleListIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import ClassesPrincipais.Visitante;


public class ListDoubleLinked<E> implements Iterable<E> {
	 
    public Node<E> header;
    public Node<E> trailer;
    public int count;
 
    /**
     * Cria uma lista vazia.
     */
    public ListDoubleLinked() {
        header = new Node<E>(null); // cria sentinela de início
        trailer = new Node<E>(null);// cria sentinela de fim
        header.next = trailer; // conecta sentinela de início no sentinela de fim
        trailer.prev = header; // conecta sentinela de fim no sentinela de início
        count = 0; // indica que a lista está vazia
    }
 
    

	public void add(E e) {
        Node<E> n = new Node<E>(e); // novo nodo que será adicionado à lista
        Node<E> last = trailer.prev;// nodo anterior ao novo nodo, após a
                                    // inserção
        n.prev = last; // conecta o novo com o atual último elemento
        n.next = trailer; // conecta o novo com o sentinela de fim
        last.next = n; // conecta o último elemento atual com o novo
        trailer.prev = n; // conecta o sentinela de fim com o novo
        count++; // registra que a lista recebeu mais um nodo
    }
 
    public void add(int index, E element) {
        // TODO Auto-generated method stub
 
    }
 
    public void clear() {
        header.next = trailer; // conecta sentinela de início no sentinela de fim
        trailer.prev = header; // conecta sentinela de fim no sentinela de início
        count = 0; // indica que a lista está vazia
    }
 
    public boolean contains(E e) {
        // TODO Auto-generated method stub
        return false;
    }
 
    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }
 
    public int indexOf(E e) {
        Node<E> n = header.next;
        int p = 0;
        while (n != trailer) {
            if (n.element.equals(e)) {
                return p;
            }
            n = n.next;
            p++;
        }
        return -1;
    }
 
    public boolean isEmpty() {
        return count == 0;
    }
 
    public boolean remove(E e) {
        // TODO Auto-generated method stub
        return false;
    }
 
    public E remove(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Pos. inválida: " + index);
        }
        Node<E> aux = header.next;
        for (int pos = 0; pos < index; pos++)
            aux = aux.next;
        E value = aux.element;
        Node<E> beforeAux = aux.prev;
        Node<E> afterAux = aux.next;
        beforeAux.next = afterAux;
        afterAux.prev = beforeAux;
        count--;
        return value;
    }
 
    public int size() {
        return count;
    }
 
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        return null;
    }
 
    public void addFirst(E e) {
        // TODO Auto-generated method stub
 
    }
 
    public E getFirst() {
        // TODO Auto-generated method stub
        return null;
    }
 
    public E getLast() {
        // TODO Auto-generated method stub
        return null;
    }
 
    public E removeFirst() {
        if (isEmpty()) { // não há elemento para remover
            throw new NoSuchElementException();
        }
        Node<E> target = header.next; // indica o primeiro nodo da lista (first)
        E item = target.element; // coleta o conteúdo do primeiro nodo
        Node<E> prox = target.next; // indica o segundo nodo da lista atual
        prox.prev = header; // conecta o segundo nodo com o sentinela de início
        header.next = prox; // conecta o sentinela de início com o segundo nodo
                            // da lista original
        target.prev = null; // libera dados do nodo removido
        target.element = null;
        target.next = null;
        count--; // registra que a lista perdeu um nodo
        return item; // retorna a informação que havia no nodo destruído
    }
 
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia!");
        }
 
        Node<E> aux = trailer.prev; // último da lista
        Node<E> beforeAux = aux.prev; // penúltimo da lista ou sentinela
 
        E value = aux.element; // recupera valor do nodo a ser removido
 
        beforeAux.next = trailer; // penúltimo passa a ser o último nodo
        trailer.prev = beforeAux; // .. ou a lista fica vazia
 
        count--;
 
        return value;
    }
 
    @Override
    public String toString() {
        // ver
        // http://www.docjar.com/html/api/java/util/AbstractCollection.java.html
        String s = "[";
        Node<E> aux = header.next;
        if (aux != trailer) {
            s += "" + aux.element;
            aux = aux.next;
            while (aux != trailer) {
                s += ", " + aux.element;
                aux = aux.next;
            }
        }
        s += "]";
        return s;
    }
 
    public DoubleLinkedIterator iterator() {
        // TODO Auto-generated method stub
        return new DoubleLinkedIterator();
    }
    
    
 
}