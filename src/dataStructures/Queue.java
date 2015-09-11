package dataStructures;

public class Queue<k> {
	protected Node<k> _head;
	protected Node<k> _tail;
	protected int _length;
	
	
	public Queue(){
		_head = null;
		_tail = null;
		_length = 0;
	}
	
	/**
	 * <p> enQueue() <p>
	 * Inserts the specified element into the queue
	 * @param pData: new value
	 */
	public void enQueue(k pData){
		if(_head == null){
			_head = _tail = new Node<k>(pData);
		}
		else{
			Node<k> tmp = new Node<k>(pData);
			_tail.setNext(tmp);
			tmp.setPrevious(_tail);
			_tail = tmp;
		}
		_length++;
	}
	/**
	 * <p> enQueue() <p>
	 * Retrieves and removes the first element from the queue
	 * @param pData: new value
	 */
	public Node<k> deQueue(){
		if(_head == null){
			return null;
		}
		else{
			Node<k> top = _head;
			_head = _head.getNext();
			return top;
			
		}
	}
	
	/**
	 * <p> showData() <p>
	 * 
	 * Method that prints all the contents of the list
	 */
	public void showData(){
		if (isEmpty() == true){
			return;
		}
		Node<k> tmp = _head;
		while (tmp.getNext() != null){
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
		System.out.println(tmp.getData());
	}
	
	/**
	 * <p> is Empty()<p>
	 * Method that checks if the list is empty and
	 * returns the result as a boolean
	 * 
	 * @return true if list is empty, false if it is not
	 */
	public boolean isEmpty(){
		if(_length == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
