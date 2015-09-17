package dataStructures;

/**
 * Stack
 * 
 * @author fabian
 *
 * @param <k> Object Type that will be used in the Stack
 */
public class Stack<k> {
	protected Node<k> _head;
	protected Node<k> _tail;
	protected int _length;
	
	
	public Stack(){
		_head = null;
		_tail = null;
		_length = 0;
	}
	
	/**
	 * <p> push() <p>
	 * Inserts the specified element into the stack
	 * @param pData: new value
	 */
	public void push(k pData){
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
	 * <p> pop() <p>
	 * Retrieves and removes the first element from the stack
	 */
	public Node<k> pop(){
		if(_tail == null){
			return null; //When using the pop method, it shoudl be surrounded with a try/catch statement.
						 //To catch the exception if the stack is empty because it will return a null pointer exception.
		}
		else{
			Node<k> top = _tail;
			
			if(_length == 1){
				_head = _tail = null;
				_length--;
			}
			else{
				_tail = _tail.getPrevious();
				_tail.setNext(null);
				_length--;
			}
			
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
