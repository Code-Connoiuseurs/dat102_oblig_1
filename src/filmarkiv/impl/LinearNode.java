package filmarkiv.impl;

public class LinearNode<T> {

	public T data;
	public LinearNode<T> neste;

	public LinearNode(T data) {
		this.data = data;
		this.neste = null;
	}

	public T getData() {
		return data;
	}

	public LinearNode<T> getNeste() {
		return neste;
	}

	public void setNeste(LinearNode<T> neste) {
		this.neste = neste;
	}
}
