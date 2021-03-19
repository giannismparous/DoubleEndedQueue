import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
static class Node<T> {
	T i; //data
	Node<T> next;
	Node<T> prev;
	Node(T i){
	this.i=i;	
	}
	public T getData() {//epistrefei to Data dhladh to i.
		return i;
	}
}
public StringDoubleEndedQueueImpl() {
	this.head=null;
	this.tail=null;
}
public boolean isEmpty() {
	return head==null;
}
public void addFirst(T item) {
	Node<T> t = new Node<T>(item);
	if (isEmpty()) {
		tail = t;
	}else {
		head.prev = t;
		t.next = head;
	}
	head = t;
	size++;
}

public T removeFirst() throws NoSuchElementException {
	if (isEmpty()) {
		throw new NoSuchElementException("Queue is empty");
	}
	Node<T> temp = head;
	 if(head.next == null){
		 tail = null;
	 }else{
		 head.next.prev=null;
	 }
	head = head.next;
	size--;
	return temp.getData();
}

public void addLast(T item) {
	Node<T> t = new Node<T>(item);
	if (isEmpty()) {
		head = t;
	}else {
		tail.next = t;
		t.prev=tail;
	}
	tail=t;
	size++;
}

public T removeLast() throws NoSuchElementException{
	if (isEmpty()) {
		throw new NoSuchElementException("Queue is empty");
	}
	Node<T> temp = tail;
	 if(tail.prev == null){
		 head = null;
	 }else{
		 tail.prev.next=null;
	 }
	tail = tail.prev;
	size--;
	return temp.getData();
}

public T getFirst() throws NoSuchElementException {
	if(isEmpty()){
		throw new NoSuchElementException("Queue is empty");
	}
	return head.i;
}

public T getLast() throws NoSuchElementException {
	if(isEmpty()){
		throw new NoSuchElementException("Queue is empty");
	}
	return tail.i;
}

public void printQueue(PrintStream stream) {
	Node<T> iter = head;
	while(iter!=null) {
		stream.println(iter.getData());
		iter = iter.next;
	}
}

public int size() {
	return size;
}

}
