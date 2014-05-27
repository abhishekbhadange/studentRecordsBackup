package studentBackup.observer;

import studentBackup.bst.Node;

public interface Observer 
{
	public void update(Node infNode, int oldBno);
}
