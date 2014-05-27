studentRecordsBackup
====================

Backup System for Student Records

The main goal of the project is to apply the design principles of Visitor Pattern and Observer 
Pattern. The Node class stores the B-Number which represents the only integer identifier entry in each 
student record. BST class stores Nodes in accordance with the Binary Search Tree (BST) rules. 
The input file should have a list of integer B-Numbers of students on each new line without having any duplicate 
entries. BSTBuilder class reads each line from the input file, converting each string value 
to an integer and inserts it into the BST. Two copies of the BST, backup-1 and backup-2, are 
also created while the original BST is being created. Visitor pattern is used to add the values 
of all nodes. Visitor pattern is also used to update each node of the BST by adding a given 
integer value to the B-Number. It is assumed that the structure of the tree does not change 
due to the update. Observer pattern is employed by updating each node in backup-1 and 
backup-2 whenever a node in the original BST is changed. The BST does not handle deletes.
