/**
 * File:		Node.java
 * Author:		Annie Wu
 * Class:		CS 241 - Data Structures and Algorithms II
 * 
 * Assignment:	Program 1
 * Date:		22 January 2018
 * 
 * Purpose:		This class contains the nodes in the BST and 
 * 			    any functions regarding the nodes.
 */

public class Node {
	
    Node left;
    Node right;
    int value;

    /**
     * This is the default constructor.
     * The purpose is to call the constructor with the given integer, 0.
     */
    public Node() {
        this(0);
    }

    /**
     * This is the constructor.
     * The purpose is to call the constructor with the given data and null nodes.
     * @param data given value
     */
    public Node(int data) {
        this(data, null, null);
    }
    
    /**
     * This is the constructor.
     * The purpose is to set the value to the data, 
     * set the left child to a new left child,
     * and set the right child to a new right child.
     * @param data given value
     * @param newLeft new left child
     * @param newRight new right child
     */
    public Node(int data, Node newLeft, Node newRight) {
    	value = data;
    	left = newLeft;
    	right = newRight;
    }
    
    /**
     * This is the function hasLeft.
     * The purpose is to check to see if a left child exists.
     * @return true if left child exists
     */
    public boolean hasLeft() {
    	return left != null;
    }
    
    /**
     * This is the function setLeft.
     * The purpose is to set the left node.
     * @param node current node
     */
    public void setLeft(Node node) {
        left = node;
    }

    /**
     * This is the function getLeft.
     * The purpose is to return the left node.
     * @return left node
     */
    public Node getLeft() {
        return left;
    }
    
    /**
     * This is the function hasRight.
     * The purpose is to check to see if a right child exist.
     * @return true if right child exists
     */
    public boolean hasRight() {
    	return right != null;
    }
    
    /**
     * This is the function setRight.
     * The purpose is to set the right node.
     * @param node current node
     */
    public void setRight(Node node) {
        right = node;
    }

    /**
     * This is the function getRight.
     * The purpose is to return the right node.
     * @return right node
     */
    public Node getRight() {
        return right;
    }

    /**
     * This is the function setValue.
     * The purpose is to set value to a node.
     * @param data value to give to a node
     */
    public void setValue(int data) {
        value = data;
    }

    /**
     * This is the function getValue.
     * The purpose is to return the value of the node.
     * @return value of the node
     */
    public int getValue() {
        return value;
    }
    
    /**
     * This is the function isLeaf.
     * The purpose is to check to see if the node is a leaf.
     * @return true if the node has no children
     */
    public boolean isLeaf() {
    	return (left == null) && (right == null);
    }
    
    /**
     * This is the function getNumberOfNodes.
     * The purpose is to get the total number of nodes in the BST.
     * @return number of nodes in the tree
     */
    public int getNumberOfNodes() {
    	int leftNodes = 0;
    	int rightNodes = 0;
    	if (hasLeft()) {
    		leftNodes = left.getNumberOfNodes();
    	}
    	if (hasRight()) {
    		rightNodes = right.getNumberOfNodes();
    	}
    	return leftNodes + rightNodes + 1;
    }

}

