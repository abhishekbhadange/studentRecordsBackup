package studentBackup.visitor;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class SumVisitor implements Visitor 
{
	public static int sum;
	/**
	 * Implements the visitor interface method
	 */
	public void visit(BST tree)
	{
		Node r = tree.root;
		sumTree(r);
		System.out.println(sum);
	}
	/**
	 * Adds up the values of all nodes of the tree
	 * 
	 * @param fNode
	 */
	public void sumTree(Node fNode)
	{
		if(fNode!=null)
		{
			sum = sum + fNode.getbno();
			sumTree(fNode.getLeft());
			sumTree(fNode.getRight());
		}
	}
}
