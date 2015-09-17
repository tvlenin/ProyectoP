package dataStructures;

import dataStructures.Node;

/**
 * <p> LinkedList <p>
 * 
 * The class allows to create a linked list to save information,
 * regardless the object type desired, the user can even use
 * their own object types. It is a doubly linked list, which
 * means that each node has reference to the next and the 
 * previous node in the list.
 * 
 * @author Fabian A. Solano Madriz
 * @param <k> Object type to be used in the List
 * @since September, 2015
 */
public class LinkedList<k> {
	protected Node<k> _head;
	protected Node<k> _tail;
	protected int _length;
	
	
	public LinkedList(){
		_head = null;
		_tail = null;
		_length = 0;
	}
	
	/**
	 * <p> insertHead() <p>
	 * Method which allows to insert data at the beggining
	 * of the list. (List's head)
	 * @param pData: new head value
	 */
	public void insertHead(k pData){
		if(_head == null){
			_head = _tail = new Node<k>(pData);
		}
		else{
			Node<k> tmp = new Node<k>(pData);
			_head.setPrevious(tmp);
			tmp.setNext(_head);
			_head = tmp;
		}
		_length++;
	}
	
	/**
	 * <p> insertTail() <p>
	 * Method which allows to insert data at the end
	 * of the list. (List's tail)
	 * @param pData: new tail value
	 */
	public void insertTail(k pData){
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
	 * <p> findData() <p>
	 * Method which allows to verify if an specific data is
	 * in the list
	 * @param pData
	 * @return true if data is in list, false if data is not in the list.
	 */
	public boolean findData(k pData){
		Node<k> tmp = _head;
		int pointer = 0;
		while (pointer != _length){
			if (tmp.getData().equals(pData)){
				return true;
			}
			else{
				tmp = tmp.getNext();
				pointer++;
			}
		}
		return false;
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
	 * <p> delete() <p>
	 * Method that allows to delete an specific data in the list
	 * @param pData: data to remove
	 */
	public void delete(k pData){
		if (_head == null) {
			System.out.println("** ERROR: Linked List is empty **");
			return;
		}
		//Case 1: data to delete is the list's head
		if (_head.getData().equals(pData) ){
			if(_length >= 2){
				_head = _head.getNext();
				_head.setPrevious(null);
				_length--;
				return;
			}
			else{
				_head = null;
				_length--;
				return;
			}
		}
		
		//Case 2: data to delete is the list's tail
		if (_tail.getData().equals(pData) ){
			_tail = _tail.getPrevious();
			_tail.setNext(null);
			_length--;
			return;
		}
		
		//Case 3: other cases
		Node<k> tmp = _head.getNext();
		while (tmp.getNext() != null){
			if(tmp.getData().equals(pData)){
				tmp.getPrevious().setNext(tmp.getNext());
				tmp.getNext().setPrevious(tmp.getPrevious());
				break;
			}
			tmp = tmp.getNext();
		}
		
	}
	
	/**
	 * <p> swapNodes <p>
	 * Method that allows to swap the data of two nodes in the list
	 * @param firstElement: first node to swap
	 * @param secondElement: seconde node to swap
	 */
	public void swapNodes(Node<k> firstElement, Node<k> secondElement){
		Node<k> tmp = firstElement;
		k tmp3 = firstElement.getData();
		while(tmp.getNext() != null){
			if (tmp == firstElement){
				firstElement.setData(secondElement.getData());
				secondElement.setData(tmp3);
			}
			tmp = tmp.getNext();
		}
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
	
	/**
	 * Retrieves the head Node
	 * @return head node
	 */
	public Node<k> getHead(){
		return _head;
	}
	
	/**
	 * Retrieves the tail node
	 * @return tail node
	 */
	public Node<k> getTail(){
		return _tail;
	}
	
	/**
	 * Returns the lenght of the list, which correspond
	 * to the number of objects stored in the list
	 * @return list's length
	 */
	public int length(){
		return _length;
	}
}
