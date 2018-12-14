import java.util.ListIterator;
 
public class DoublyLinkedList<T> implements Iterable<T> {
 
    private class Node<T> {
        T data;
        Node<T> next, prev;
 
        public Node(T data){
            this.data = data;
        }
 
        public Node(T data, Node<T> next, Node<T> prev){
            this(data);
            this.next = next;
	    this.prev = prev;
        }
 
        public String toString(){
            return "" + data;
        }
    }
    
    public class LLIterator<U> implements ListIterator<U>{
        DoublyLinkedList<U> ll;
        DoublyLinkedList<U>.Node<U> curr;
 
        public LLIterator(DoublyLinkedList<U> ll){
            this.ll = ll;
            curr = null;
        }
 	public void add(U u) throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
	
        public void remove() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
 
        public void set(U u) throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

	public int previousIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

	public int nextIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
	
        public boolean hasNext(){
            if (curr == ll.tail && ll.tail != null) return false;
            return true;
        }
	
        public U next(){
            if(curr == null)
                curr = ll.head;
            else curr = curr.next;
            return curr.data;
        }

	public boolean hasPrevious(){
	    if (curr == ll.head && ll.head != null) return false;
            return true;
        }
	
	public U previous(){
            if(curr == null)
                curr = ll.head;
            else curr = curr.prev;
            return curr.data;
        
	    }
    
    }
 
    private Node<T> head, tail;
    private int count;
 
    public DoublyLinkedList(){
        count = 0;
    }
 
    public void prepend (T i){
        if (count == 0) head = tail = new Node<T>(i);
        else  head = new Node<T>(i, head, null);
        count++;
    }
 
    public void append(T i){
        if (count == 0){
            head = tail = new Node<T>(i);
        }
        else {
            tail = tail.next = new Node<T>(i,null,tail);
        }
        count++;
    }
 
    public int size(){
        return count;
    }
   
    public boolean isEmpty(){
        return this.head == null;
    }

    public Node<T> getHead(){
	return this.head;
    }
 
    public String toString() {
        String retVal = "";
        //Node temp = head;
        //while(temp != null){
        //    retVal += temp + " ";
        //    temp = temp.next;
        //}
 
        for (Node<T> temp = head; temp != null; temp = temp.next)
            retVal += temp + " ";
	
	for (Node<T> temp = tail; temp != null; temp = temp.prev)
            retVal += temp + " ";
	
        return retVal;
    }
 
    public ListIterator<T> iterator(){
        return new LLIterator<T>(this);
    }
}
