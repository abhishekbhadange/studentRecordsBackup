package studentBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import studentBackup.bst.BST;
import studentBackup.visitor.SumVisitor;
import studentBackup.visitor.UpdateVisitor;

public class BSTBuilder 
{
	public static int upValue;
	BST tree = new BST();
	BST backup1 = new BST();
	BST backup2 = new BST();
	/**
	 * Constructor
	 */
	public BSTBuilder()
	{
		tree.registerObserver(backup1);
		tree.registerObserver(backup2);
	}
	/**
	 * Reads input Bnumbers from file and 
	 * creates a Binary Search Tree
	 * 
	 * @param file
	 */
	public void createTree(String file)
	{
		String line;
		int flag=0, bno;
		try
		{
			File f1 = new File(file);
			FileReader fr = new FileReader(f1);
			BufferedReader reader = new BufferedReader(fr);
			line = reader.readLine();
			while(line!=null)
			{
				flag = 1;
				bno = Integer.parseInt(line);
				tree.insert(bno);
				backup1.insert(bno);
				backup2.insert(bno);
				line = reader.readLine();
			}
			reader.close();
			if(flag==0)
				System.out.println("Empty input file!!!");
			else
				System.out.println("All nodes inserted successfully!!!");
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("FileNotFoundException occured: "+fnfe.getMessage());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			System.exit(0);
		}
	}
	/**
	 * Traverses Binary tree using in-order traversal
	 * to print node values
	 */
	public void inorderTraversal()
	{
		tree.printInorder(tree.root);
		System.out.println("");
		backup1.printInorder(backup1.root);
		System.out.println("");
		backup2.printInorder(backup2.root);
		System.out.println("");
	}
	/**
	 * Calculates sum of all nodes of a tree
	 */
	public void findSum()
	{
		SumVisitor sv = new SumVisitor();
		System.out.println("Sum of the tree:");
		tree.accept(sv);
		sv.sum = 0;
		System.out.println("Sum of the backup tree1:");
		backup1.accept(sv);
		sv.sum = 0;
		System.out.println("Sum of the backup tree2:");
		backup2.accept(sv);
		sv.sum = 0;
	}
	/**
	 * Updates values of a tree
	 * 
	 * @param value
	 */
	public void updateValue(int value)
	{
		upValue = value;
		UpdateVisitor uv = new UpdateVisitor();
		tree.accept(uv);
	}
}
