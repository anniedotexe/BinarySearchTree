/**
 * File:		Program1.java
 * @author		Annie Wu
 * Class:		CS 241 - Data Structures and Algorithms II
 * 
 * Assignment:	Program 1
 * Date:		22 January 2018
 * 
 * Purpose:		This program has the main class that contains all
 * 				the user interactions.
 */

import java.util.*;

public class Program1 {

	private static String initial = "Please enter the initial sequence of values:";
	private static String preorder = "\nPreorder: ";
	private static String inorder = "\nInorder: ";
	private static String postorder = "\nPostorder: ";
	private static String command = "\nCommand? ";
	private static String choices = "\n I. Insert a value" +
									"\n D. Delete a value" +
									"\n P. Find predecessor" +
									"\n S. Find successor" +
									"\n E. Exit the program" +
									"\n H. Display this message";
	private static String thankyou = "Thank you for using my program!";
	private static String invalid = "Invalid Entry. Please try again.";
	private static String error = "Error: Not an Integer Value.";
	
	public static void main(String[] args) {
		choices();
	}
	
	public static void choices() {
		Scanner sc = new Scanner(System.in);
		
		BST bst = new BST(); 
		System.out.println(initial);

		try {
			//for the initial integers entered
			//while there is a next integer, insert it into the BST
			bst.insert(sc.nextInt());
			if (sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner scanLine = new Scanner(line);

				while (scanLine.hasNextInt()) {
					bst.insert(scanLine.nextInt());
				}
				scanLine.close();
			}
		}
		catch (InputMismatchException e) {
			System.out.print(error);
			System.exit(0);
		}
		
		//print out the sequence of numbers in these traversals
		System.out.print(preorder);
		bst.preorder();
		System.out.print(inorder);
		bst.inorder();
		System.out.print(postorder);
		bst.postorder();
		System.out.print("\n" + choices);

		boolean run = true;
		while (run) {
			try {
				System.out.print(command);          
				String choice = sc.next().toUpperCase();
				switch (choice) {

				case "I": //insert
					int value = sc.nextInt();
					bst.insert(value);
					System.out.print(inorder);
					bst.inorder();
	                break;
	            case "D": //delete
					value = sc.nextInt();
					bst.delete(value);
					System.out.print(inorder);
					bst.inorder();
					break;                         
				case "P": //predecessor
					value = sc.nextInt();
					bst.predecessor(value);
					break;
				case "S": //successor
					value = sc.nextInt();
					bst.successor(value);
					break;
				case "E": //exit
					System.out.println("\n" + thankyou);
					run = false;
					break;
				case "H": //help menu
					System.out.print(choices);
					break;
				default:
					System.out.println(invalid);
				}
			}
			catch (InputMismatchException e) {
				System.out.println(invalid);				
			}
           
		}
		sc.close();
	}
}

