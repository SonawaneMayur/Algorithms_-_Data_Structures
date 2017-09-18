import java.util.Scanner;

class Node{
	Integer data;
	Node left;
	Node right;
	
	Node(){
		data = null;
		left = null;
		right = null;
	}
	
}

class BinaryTree{
	
	Node head;
	Scanner input = new Scanner(System.in);
	Node temp = head;
	
	BinaryTree(){
		head = null;
	}
	
	public void createNode(Node temp, Node newNode){
		
		if(head == null){
			System.out.println("No value in the tree ");
			head = newNode;
			return;
		}
		
		if(temp == null){
			temp = head;
		}
		
		System.out.println("Where you want to insert node, L for left and R for right");
		char inputChar = input.next().charAt(0);
			
			if(inputChar == 'L'){
				if(temp.left == null){
					temp.left = newNode;
					return;
				}else{
					createNode(temp.left, newNode);
				}
			}
			else if(inputChar == 'R'){
				if(temp.right == null){
				temp.right = newNode;
				return;
				}else{
					createNode(temp.right, newNode);
				}
			}
			else{
				System.out.println("Wrong output");
				return;
			}
			
		}
	
	public Node SearchNode(int value){
		
		Node result = null;
		if(temp.data == value){
			
			result = temp;
			return result;
			
		}
		else if(temp.data > value){
			result = SearchNode((temp.left).data);
			temp = temp.left;
		}
		else if(temp.data < value){
			result = SearchNode((temp.right).data);
			temp = temp.right;
		}
		return result;
		
	}
	
	public void inOrder(Node head){
		if(head != null){
			inOrder(head.left);
			System.out.println(head.data);
			inOrder(head.right);
		}else
			return;
		
	}
	
	
}

public class BTreeOperations {
	
	static BinaryTree treeObj = null;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]){ 
		
		int choice;
		
		
		do{
			System.out.println("Select the operation:");
			System.out.println("1: Create Tree \n 2: Insert \n 3: Search \n 4: print \n 5: generate tree \n 6: Exit");
			choice = input.nextInt();
			
			switch(choice){
			
			case 1:  
				treeObj = new BinaryTree();
				break;
				
			case 2: 
				Node newNode = new Node();
				newNode.data = input.nextInt();
				newNode.left = null;
				newNode.right = null;
				treeObj.createNode(treeObj.head, newNode);
				break;
				
			case 3:
				System.out.println("Enter the value to search:");
				int searchValue = input.nextInt();
				
				if(treeObj.SearchNode(searchValue) == null){
					System.out.println("No value found");
				}else{
					
					System.out.println("Value found");
				}
				
			case 4: 
				treeObj.inOrder(treeObj.head);
				//preOrder
				//System.out.println();
				
			}
			
		}while(true);
	}
}
