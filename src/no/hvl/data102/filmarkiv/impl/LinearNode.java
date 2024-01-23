package no.hvl.data102.filmarkiv.impl;


public class LinearNode<T> {
	public T data;
	public LinearNode<T> neste;
	
	public LinearNode(T data, LinearNode<T> neste) {
		this.data = data;
		this.neste = neste;
	}
	public LinearNode(T data) {
		this(data, null);
	}
	
	public int getSize() {
		LinearNode<T> node = this;
		int size = 0;
		while (node != null) {
			size++;
			node = node.neste;
		}
		return size;
	}
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[this.getSize()];
		LinearNode<T> node = this;
		int index = 0;
		while ((index < this.getSize()) && (node != null)) {
			array[index] = node.data;
			index++;
			node = node.neste;
		}
		return array;
	}
}