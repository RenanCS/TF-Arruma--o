package DoubleListIterator;

class Node<Visitante> {
    public Visitante element;
	public Node<Visitante> next;
	public Node<Visitante> prev;

    public Node(Visitante vi) {
        element = vi;
        prev = null;
		next = null;
    }
	
}
