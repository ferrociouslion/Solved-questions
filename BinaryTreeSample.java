package sample;
import java.util.*; 

class Node { 
	int data; 
	Node left, right; 

	Node(int data) 
	{ 
		this.data = data; 
		left = right = null; 
	} 
} 

class BinaryTreeSample { 
int flag=0;Node root=null;
	Node constructTreeUtil(int post[], int n) 
	{ 
		 root = new Node(post[n - 1]); 
		Stack<Node> s = new Stack<>(); //store the sum of itself and root
        Stack<Node> str = new Stack<>();//store all the nodes 
		s.push(root); 
        str.push(root);

		for (int i = n - 2; i >= 0; --i) { 
			
			Node x = new Node(post[i]); 

			Node temp = null,y=null,temp2=null; 
			//pop all elements less than root
			while (!str.isEmpty() && post[i] < str.peek().data) {
				temp = str.pop();	 
				temp2=s.pop();
			}
             //adding nodes on left subtree
			if (temp != null) {
              y=new Node(post[i]+temp.data);
             
				temp2.left = y;	
            }
              // adding nodes on right subtree
			else{ y=new Node(post[i]+str.peek().data);//node created with sum of itself and its parent node
                
				s.peek().right = y; }
			s.push(y); 
            str.push(x);
		}
      
		return root; 
	} 

	Node constructTree(int post[], int size) 
	{ 
		return constructTreeUtil(post, size); 
	} 

	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
        printInorder(node.left); 
        System.out.print(node.data + " ");
		printInorder(node.right); 
	} 
	public static void main(String[] args) 
	{ 
		BinaryTreeSample tree = new BinaryTreeSample(); 
		int post[] = new int[] {1,7,5,50,40,10}; 
		int size = post.length; 

		Node root = tree.constructTree(post, size); 

		System.out.println("Inorder traversal of the twisted constructed tree:"); 
		tree.printInorder(root); 
	} 
} 
/*
Inorder traversal of the twisted constructed tree:
6 15 12 10 50 90 
*/