package studentBackup.bst;

public class Node 
{
	private int bno;
	private Node left;
	private Node right;
	/**
	 * Constructor
	 * 
	 * @param bno
	 */
	public Node(int bno)
	{
		this.bno = bno; 
	}
	/**
	 * Sets Bnumber
	 * 
	 * @param inbno
	 */
	public void setbno(int inbno)
	{
		bno = inbno;
	}
	/**
	 * Gets Bnumber
	 * 
	 * @return
	 */
	public int getbno()
	{
		return bno;
	}
	/**
	 * Gets left child
	 * 
	 * @return
	 */
	public Node getLeft() 
	{
		return left;
	}
	/**
	 * Sets left child
	 * 
	 * @param left
	 */
	public void setLeft(Node left) 
	{
		this.left = left;
	}
	/**
	 * Gets right child
	 * 
	 * @return
	 */
	public Node getRight() 
	{
		return right;
	}
	/**
	 * Sets right child
	 * 
	 * @param right
	 */
	public void setRight(Node right) 
	{
		this.right = right;
	}
	/**
	 * Overridden toString() method to
	 * return the private members in 
	 * form of a string 
	 */
	public String toString()
	{
		return "Bnumber of the node is: "+bno;
	}
}
