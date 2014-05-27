package studentBackup.driver;

import studentBackup.util.BSTBuilder;

public class Driver 
{
	public static void main(String[] args) 
	{
		try
		{
			BSTBuilder bst = new BSTBuilder();
			bst.createTree(args[0]);
			bst.inorderTraversal();
			bst.findSum();
			System.out.println("Updating the tree...");
			bst.updateValue(Integer.parseInt(args[1]));
			bst.inorderTraversal();
			bst.findSum();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			System.exit(0);
		}
	}
}
