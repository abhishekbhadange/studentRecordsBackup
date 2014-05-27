package studentBackup.visitor;

import studentBackup.bst.BST;
import studentBackup.bst.Node;
import studentBackup.util.BSTBuilder;

public class UpdateVisitor implements Visitor
{
	BST localTree;
	/**
	 * Implements the visitor interface method
	 */
	public void visit(BST tree)
	{
		localTree = tree;
		Node r = localTree.root;
		updateTree(r);
		System.out.println("Tree updated!!!");
	}
	/**
	 * Updates all tree node values by adding
	 * them with supplied input value
	 * 
	 * @param fNode
	 */
	public void updateTree(Node fNode)
	{
		int oldBno;
		if(fNode!=null)
		{
			updateTree(fNode.getLeft());
			updateTree(fNode.getRight());
			oldBno = fNode.getbno();
			fNode.setbno(fNode.getbno()+BSTBuilder.upValue);
			localTree.valuesChanged(fNode, oldBno);
		}
	}
}
