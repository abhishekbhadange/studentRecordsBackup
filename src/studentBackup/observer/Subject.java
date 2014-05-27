package studentBackup.observer;

import studentBackup.bst.Node;

public interface Subject 
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers(Node infNode, int oldBno);
}
