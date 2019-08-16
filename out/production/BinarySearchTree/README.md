# Binary Search Tree
The user will be prompted to enter a sequence of values separated by spaces. <br>
The commands the user can call are:
<li>I to insert a value</li>
<li>D to delete a value</li>
<li>P to find the predecesor of a value in the tree</li>
<li>S to find the successor of a value in the tree</li>
<li>E to exit the program</li>
<li>H for help to display this menu</li>
<br>
<i>The commands need to be called with a value after it.</i>

####Sample Output
```
Please enter the initial sequence of values:
51 40 21 38 32 8 27 9 28 36 3 48 13 44
51 has been inserted into the binary search tree.
40 has been inserted into the binary search tree.
21 has been inserted into the binary search tree.
38 has been inserted into the binary search tree.
32 has been inserted into the binary search tree.
8 has been inserted into the binary search tree.
27 has been inserted into the binary search tree.
9 has been inserted into the binary search tree.
28 has been inserted into the binary search tree.
36 has been inserted into the binary search tree.
3 has been inserted into the binary search tree.
48 has been inserted into the binary search tree.
13 has been inserted into the binary search tree.
44 has been inserted into the binary search tree.

Preorder: 51 40 21 8 3 9 13 38 32 27 28 36 48 44 
Inorder: 3 8 9 13 21 27 28 32 36 38 40 44 48 51 
Postorder: 3 13 9 8 28 27 36 32 38 21 44 48 40 51 

 I. Insert a value
 D. Delete a value
 P. Find predecessor
 S. Find successor
 E. Exit the program
 H. Display this message
Command? i 39
39 has been inserted into the binary search tree.

Inorder: 3 8 9 13 21 27 28 32 36 38 39 40 44 48 51 
Command? d 24
24 does not exist in the binary search tree.

Inorder: 3 8 9 13 21 27 28 32 36 38 39 40 44 48 51 
Command? d 27
27 has been deleted from the binary search tree.

Inorder: 3 8 9 13 21 28 32 36 38 39 40 44 48 51 
Command? p 44
The predecessor is 40

Command? s 44
The successor is 48

Command? h

 I. Insert a value
 D. Delete a value
 P. Find predecessor
 S. Find successor
 E. Exit the program
 H. Display this message
Command? e

Thank you for using my program!
```