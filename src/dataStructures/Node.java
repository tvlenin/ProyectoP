package dataStructures;

/**
 * <p>Node<p>
 * 
 * Allows to save information in a single class, to create
 * a Linked List. It saves the data of the node and the 
 * references to the next and previous nodes.
 * 
 * @author Fabian A. Solano Madriz
 * @param <k> Object type to be used in the Node
 * @since September, 2015
 */
public class Node<k> {
	private k _data;
	private Node<k> _next;
	private Node<k> _previous;
	
	/**
	 * Class constructor
	 * @param pData: Assigns the data to the current Node
	 */
	public Node(k pData){
		_data = pData;
		_next = null;
		_previous = null;
	}
	
	/**
	 * getData()
	 * Method which returns the k type data, assigned to the node.
	 * @return Node data
	 */
	public k getData() { return _data; }
	
	/**
	 * getNext()
	 * Method which returns a Node<k> which contains information
	 * about the next Node in the list.
	 * @return Next node in the list
	 */
	public Node<k> getNext() { return _next; }
	
	/**
	 * getPrevious()
	 * Method which returns a Node<k> which contains information
	 * about the previous Node in the list.
	 * @return Previous node in the list
	 */
	public Node<k> getPrevious() { return _previous; }
	
	/**
	 * setData()
	 * Method which allows to change the data assigned
	 * to the current node
	 * @param pData: New data value
	 */
	public void setData(k pData) { _data = pData; }
	
	/**
	 * setNext()
	 * Method which allows to assign the next node in the list
	 * @param pNext: next node in the list
	 */
	public void setNext(Node<k> pNext) { _next = pNext; }
	
	/**
	 * setPrevious()
	 * Methid which allows to assign the previous node in the list
	 * @param pPrevious: previous node in the list
	 */
	public void setPrevious(Node<k> pPrevious){ _previous = pPrevious; }
	
}
