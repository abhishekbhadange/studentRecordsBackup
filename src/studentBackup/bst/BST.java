package studentBackup.bst;

import studentBackup.visitor.Visitor;
import java.util.ArrayList;
import studentBackup.observer.Observer;
import studentBackup.observer.Subject;

public class BST implements Subject, Observer
{
	private ArrayList observers;
	public Node root;
	/**
	 * Constructor
	 */
	public BST()
	{
		observers = new ArrayList();
	}
	/**
	 * Inserts tree node with Bnumber as value
	 * 
	 * @param bno
	 */
	public void insert(int bno)
	{
		Node temp, fNode, parent;
		temp = new Node(bno);
		try
		{
			if(root == null)
			root = temp;
			else
			{
				fNode = root;
				while(true)
				{
					parent = fNode;
					if(bno < fNode.getbno())
					{
						fNode = fNode.getLeft();
						if(fNode==null)
						{
							parent.setLeft(temp);
							return;
						}
					}
					else
					{
						fNode = fNode.getRight();
						if(fNode==null)
						{
							parent.setRight(temp);
							return;
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			System.exit(0);
		}
	}
	/**
	 * Prints to standard output tree node
	 * values using in-order traversal
	 * 
	 * @param fNode
	 */
	public void printInorder(Node fNode)
	{
		if(fNode!=null)
		{
			printInorder(fNode.getLeft());
			System.out.print(fNode.getbno()+" ");
			printInorder(fNode.getRight());
		}
	}
	/**
	 * This method is called whenever there is any 
	 * update on the original tree
	 * 
	 * @param infNode
	 * @param oldBno
	 */
	public void valuesChanged(Node infNode, int oldBno)
	{
		notifyObservers(infNode, oldBno);
	}
	/**
	 * Accepts the visitor request
	 * 
	 * @param v
	 */
	public void accept(Visitor v)
	{
		v.visit(this);
	}
	/**
	 * Registers the observers
	 */
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}
	/**
	 * Removes an observer
	 */
	public void removeObserver(Observer o)
	{
		int i = observers.indexOf(o);
		if(i >= 0)
			observers.remove(i);
	}
	/**
	 * Notifies all observers
	 */
	public void notifyObservers(Node infNode, int oldBno)
	{
		for(int i=0; i<observers.size(); i++)
		{
			Observer o = (Observer)observers.get(i);
			o.update(infNode, oldBno);
		}
	}
	/**
	 * Method is called whenever update operation 
	 * on original tree happens and corresponding 
	 * observers will get updated 
	 */
	public void update(Node infNode, int oldBno)
	{
		Node old;
		int temp = infNode.getbno();
		if(infNode != null)
		{
			old = findNode(oldBno);
			if(old!=null)
				old.setbno(temp);
			else
				System.out.println("Node to be updated not found!!!");
		}
	}
	/**
	 * Locates updated node in the observer tree 
	 * to set new value
	 * 
	 * @param oldBno
	 * @return
	 */
	public Node findNode(int oldBno)
	{
		Node fNode = root;
		while(fNode.getbno() != oldBno)
		{
			if(oldBno < fNode.getbno())
				fNode = fNode.getLeft();
			else
				fNode = fNode.getRight();
			if(fNode == null)
				return null;
		}
		return fNode;
	}
	/**
	 * Overridden toString() method to
	 * return the private members in 
	 * form of a string
	 */
	public String toString()
	{
		return "Bnumber of root node of the tree is: "+root.getbno();
	}
}
