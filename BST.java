/**
 * File:		BST.java
 * Author:		Annie Wu
 * Class:		CS 241 - Data Structures and Algorithms II
 * 
 * Assignment:	Program 1
 * Date:		22 January 2018
 * 
 * Purpose:		This class contains the binary search tree (BST) 
 * 				and any functions regarding the BST.
 */

public class BST {
	
	private Node root;
	
	private String alreadyInTree = " is already in the binary search tree!";
	private String emptyTree = "The binary search tree is empty!";
	private String doesNotExist = " does not exist in the binary search tree.";
	private String inserted = " has been inserted into the binary search tree.";
	private String deleted = " has been deleted from the binary search tree.";
	private String predecessor = "The predecessor is ";
	private String noPredecessor = " does not have a predecessor.";
	private String successor = "The successor is " ;
	private String noSuccessor = " does not have a successor.";
	private String space = " ";
	
	/**
	 * This is the default constructor for the BST.
	 * The purpose is to set the root to null.
	 */
	public BST() {
		root = null;
	}	
	
	/**
	 * This is the constructor when the user inputs a value.
	 * The purpose is to create a new node with that value and 
	 * set it as the root node.
	 * @param rootEntry new root node
	 */
	public BST(int rootEntry) {
		root = new Node(rootEntry);
	}
	
	/**
	 * This is the function insert.
	 * The purpose is to take an integer to insert into the BST
	 * and call the recursive insert function.
	 * @param value given value to insert
	 */
	public void insert(int value) {
		this.root = insert(this.root, value);
	}
	
	/**
	 * This is the function insert. 
	 * The purpose is to recursively insert a node and its value into the BST.
	 * @param root current node
	 * @param value given value to insert
	 * @return node that is inserted
	 */
	 public Node insert(Node root, int value) {
	        //if the BST is empty, it will add a new node
	        if (root == null) {
	            root = new Node(value);
				System.out.println(value + inserted);
	            return root;
	        }
	        //recursively call insert to add the node into the BST
	        else if (value < root.getValue())
	            root.left = insert(root.getLeft(), value);
	        else if (value > root.getValue())
	            root.right = insert(root.getRight(), value);
	        else //if the value is already in the BST
	        	System.out.println(value + alreadyInTree);
	        return root;
	    }
			
	/**
	 * This is the function delete.
	 * The purpose is to delete a value from the user and 
	 * call the recursive delete function.
	 * @param value given value to delete
	 */
	public void delete(int value) {
		if (isEmpty()) 
			System.out.println(emptyTree);
		else if (!search(value))
			System.out.println(value + doesNotExist);
		else {
			root = delete(root, value);
			System.out.println(value + deleted);
		}
	}
	
	/**
	 * This is the function delete.
	 * The purpose is to recursively delete a now and its value in the BST.
	 * @param root current node
	 * @param value given value to delete
	 * @return node that is deleted
	 */
	public Node delete(Node root, int value) throws NullPointerException{
		if (root != null) {
			//if the value is less than the root value
			if (value < root.getValue())
				root.left = delete(root.getLeft(), value);
			//if the value is greater than the root value
			else if (value > root.getValue()) {
				root.right = delete(root.getRight(), value);
			}
			//if it is the root
			else {
				//if it only has left child
				if (root.getRight() == null)
					return root.getLeft();
				//if it only has right child
				if (root.getLeft() == null)
					return root.getRight();
				//if it has no children
				if (root.getLeft() == null && root.getRight() == null) 
					root = null;
				
				//create a temporary root node.
				//the root will be swapped with the minimum value 
				//of the right subtree to delete the root node
				Node temp = root;
				root = getLeftmost(temp.getRight());
				root.right = deleteMin(temp.getRight());
				root.left = temp.getLeft();
			}
		}
		return root;
	}
	
	/**
	 * This is the function deleteMin.
	 * The purpose is to delete the minimum value in the BST.
	 * @param root current node
	 * @return the minimum value that is deleted
	 */
	public Node deleteMin(Node root) {
	    if(root.getLeft() == null) {
	        return root.getRight();
	    }
	    root.left = deleteMin(root.getLeft());
	    return root;
	}
	
	/**
	 * This is the function predecessor.
	 * The purpose is to get the inorder predecessor of the user's entry.
	 * @param value given value
	 */
	public void predecessor(int value) {
		//if tree is empty
		if (isEmpty()) {
			System.out.println(emptyTree);
		}
		//if value does not exist in BST
		else if (!search(value)) {
			System.out.println(value + doesNotExist);
		}
		else
			predecessor(root, value);
	}

	/**
	 * This is the function predecessor.
	 * The purpose is to get the inorder predecessor of the given node.
	 * @param root current node
	 * @param value given value
	 * @return predecessor
	 */
	public Node predecessor(Node root, int value) {
		Node pred = null;
		//the given value is not the root
		while (root.getValue() != value) {
			if(root.getValue() < value) {
				pred = root;
				root = root.getRight();
			}
			else {
				root = root.getLeft();
			}
		}
		
		//NEED TO DO IF THERE IS NO PREDECESSOR
		
		//it has a left subtree
		if (root != null && root.getLeft() != null) {
			root = root.getLeft();
			pred = getRightmost(root);
			System.out.println(predecessor + pred.getValue());
			return pred;
		}
		
		System.out.println(predecessor + pred.getValue());
		return pred;
	}
	
	/**
	 * This is the function successor.
	 * The purpose is to get the inorder successor of the user's entry.
	 * @param value given value
	 */
	public void successor(int value) {
		//if tree is empty
		if (isEmpty()) {
			System.out.println(emptyTree);
		}
		//if value does not exist in BST
		else if (!search(value)) {
			System.out.println(value + doesNotExist);
		}
		else
			successor(root, value);
	}
	
	/**
	 * This is the function successor.
	 * The purpose is to get the inorder successor of the given node.
	 * @param root current node
	 * @param value given value
	 * @return successor
	 */
	public Node successor(Node root, int value) {
		Node succ = null;
		//the given value is the not the root
		while (root.getValue() != value) {
			if(root.getValue() > value) {
				succ = root;
				root = root.getLeft();
			}
			else {
				root = root.getRight();
			}
		}
		
		//NEED TO DO IF THERE IS NO SUCCESSOR
		
		//it has a right subtree
		if (root != null && root.getRight() != null) {
			root = root.getRight();
			succ = getLeftmost(root);
			System.out.println(successor + succ.getValue());
			return succ;
		}
		
		System.out.println(successor + succ.getValue());
		return succ;
	}
	
	/**
	 * This if the function getLeftmost.
	 * The purpose is to recursively get the leftmost node.
	 * @param root current node
	 * @return leftmost node
	 */
	public Node getLeftmost(Node root) {
		if (!root.hasLeft())
			return root;
		else
			return getLeftmost(root.getLeft());
	}
	
	/**
	 * This is the function getRightmost.
	 * The purpose is to recursively get the rightmost node.
	 * @param root current node
	 * @return rightmost node
	 */
	public Node getRightmost(Node root) {
		if (!root.hasRight())
			return root;
		else
			return getRightmost(root.getRight());
	}

	/**
	 * This is the function search.
	 * The purpose is to search for a value in the BST.
	 * @param value given value
	 * @return true if value exists
	 */
	public boolean search(int value) {
        return search(root, value);
    }

	/**
	 * This is the function search.
	 * The purpose is to recursively search for a given node and value in the BST.
	 * @param node given node
	 * @param value given value
	 * @return value if it exists
	 */
    public boolean search(Node node, int value) {
    	//start with the found node as false
    	boolean found = false;

    	if (node == null) {
        	found = false;
        }
        while ((node != null)) {
        	//get the value for the node
            int nodeValue = node.getValue();
            
            //if the input value is less than the value of the node,
            //get the left node
            if (value < nodeValue)
                node = node.getLeft();
            
            //if the input value is greater than the value of the node,
            //get the right node
            else if (value > nodeValue)
                node = node.getRight();
            
            //stop the function when the value is found
            else {
                found = true;
                break;
            }
            found = search(node, value);
        }
        return found;
    }    	
    
    /**
     * This is the function searchForNode.
     * The purpose is to call the recursive function searchForNode
     * with the given value.
	 * @param value given value
	 * @return node of a given value
	 */
	public Node searchForNode(int value) {
    	return searchForNode(root, value);
    }
    
    /**
     * This is the function searchForNode.
     * The purpose is to recursively search for the node of the entered value.
	 * @param node given node
	 * @param value given value
	 * @return node of a given value
	 */
    public Node searchForNode(Node node, int value) {
    	Node found = null;
    	while ((node != null)) {
        	//get the value for the node
            int nodeValue = node.getValue();
            
            //if the input value is less than the value of the node,
            //get the left node
            if (value < nodeValue)
                node = node.getLeft();
            
            //if the input value is greater than the value of the node,
            //get the right node
            else if (value > nodeValue)
                node = node.getRight();
            
            //stop the function when the value is found
            else {
                found = node;
                break;
            }
            found = searchForNode(node, value);
        }
        return found;
    }
    
    /**
     * This is the function preorder.
     * The purpose is to call the recursive preorder traversal function with
     * the root.
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * This is the function preorder.
     * The purpose is to recursively print the preorder traversal.
	 * @param node current node
	 */
	public void preorder(Node node) {
        if (node != null) {
        	//first, process root
        	//then, process nodes in the left subtree recursively
        	//lastly, process nodes in the right subtree recursively
            System.out.print(node.getValue() + space);
            preorder(node.getLeft());         
            preorder(node.getRight());
        }
    }
    
    /**
     * This is the function inorder.
     * The purpose is to call the recursive inorder traversal function with
     * the root.
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * This is the function inorder.
     * The purpose is to recursively print the inorder traversal.
	 * @param node current node
	 */
	public void inorder(Node node) {
        if (node != null) {
        	//first, process nodes in the left subtree recursively
        	//then, process root
        	//lastly, process nodes in the right subtree recursively
            inorder(node.getLeft());
            System.out.print(node.getValue() + space);
            inorder(node.getRight());
        }
    }
    
    /**
     * This is the function postorder.
     * The purpose is to call the recursive postorder traversal function with
     * the root.
     */
    public void postorder() {
        postorder(root);
    }

    /**
     * This is the function postorder.
     * The purpose is to recursively print the postorder traversal.
	 * @param node current node
	 */
	public void postorder(Node node) {
        if (node != null) {
        	//first, process nodes in the left subtree recursively
        	//then, process nodes in the right subtree recursively
        	//lastly, process root
            postorder(node.getLeft());             
            postorder(node.getRight());
            System.out.print(node.getValue() + space);
        }
    }     
	
	/**
	 * This is the function isEmpty.
	 * The purpose is to check to see if the tree is empty.
	 * @return true if tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}
}

