import java.util.Random;
import java.util.Scanner;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
}

class BSTree{
	Node root;
	
	public BSTree(){
		this.root = null;
	}
	
	public void insertData(Node node)
    {
        //Node node=new Node(data);
        insert(node,this.root);

    }

    private Node insert(Node node,Node root1)
    {
            if(root1==null)
            {

                root1=new Node(((Node)node).data);
                if(this.root==null)
                {
                    this.root=root1;
                }
            }
            else if(node.data < root1.data)
            {
                root1.left = insert(node,root1.left);
            }
            else if(node.data > root1.data)
            {

                root1.right = insert(node,root1.right);
            }

     return root1;  
    }
    
    public void inOrder(Node head){
		if(head != null){
			inOrder(head.left);
			System.out.print("["+head.data+"]");
			inOrder(head.right);
		}else
			return;
		
	}
    
    public void postOrder(Node head){
		if(head != null){
			postOrder(head.left);
			postOrder(head.right);
			System.out.print("["+head.data+"]");
		}else
			return;
		
	}
    
    public void preOrder(Node head){
		if(head != null){
			System.out.print("["+head.data+"]");
			preOrder(head.left);
			preOrder(head.right);
		}else
			return;
		
	}
    
    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
        	return (1 + Math.max(maxDepth(node.left),maxDepth(node.right)));
            /* compute the depth of each subtree 
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
 
             use the larger one 
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }*/
        }
    }
	
    int minDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
        	return (1 + Math.min(minDepth(node.left),minDepth(node.right)));
           /*  compute the depth of each subtree 
            int lDepth = minDepth(node.left);
            int rDepth = minDepth(node.right);
 
             use the larger one 
            if (lDepth < rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }*/
        }
    }
}


public class BST {
		
	public static void shuffle (int[] array) {
		Random random = new Random();
	    int n = array.length;
	    while (n > 1) {
	        int k = random.nextInt(n--); //decrements after using the value
	        int temp = array[n];
	        array[n] = array[k];
	        array[k] = temp;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner sc = new Scanner(System.in);
		
		//System.out.println("Enter the number of elements in node :");
		
		
		Random random = new Random();
		
		int n = 10;//Math.abs(random.nextInt());
		int sum = 0;
		int[] array = new int[n];
		int noOfRun = 1000;
		int[] arrayOfHeight = new int[noOfRun];
		
		System.out.println("The Array of Tree nodes:");
		for(int i= 0; i <n ; i++){
			array[i] = Math.abs(random.nextInt(100));
			System.out.print(" "+array[i]+" ");
			
		}
		System.out.println();
		
		//run the program for 100 times
		for(int j= 0; j<noOfRun; j++){
		System.out.println("The shuffled Array is:");
		
		shuffle(array);
		
		for(int i= 0; i <n ; i++){
			System.out.print(" "+array[i]+" ");
			
		}
		
		System.out.println();
		//shuffle(int[] array);

		//Node root = null;
		BSTree bst = new BSTree();
		for(int i = 0 ; i < n; i++ ){
			Node node = new Node(array[i]);
			bst.insertData(node);
			System.out.println("the Node :["+node.data+"] at max ["+bst.maxDepth(bst.root)+"] level and min ["+ bst.minDepth(bst.root)+"] level" );
			
		}
		
		arrayOfHeight[j] = bst.maxDepth(bst.root);
		sum = sum + bst.maxDepth(bst.root);
		if(j == n){
		System.out.println("The inOrder way is:");
		bst.inOrder(bst.root);
		System.out.println();
		
		System.out.println("The preOrder way is:");
		bst.preOrder(bst.root);
		System.out.println();
		
		System.out.println("The postOrder way is:");
		bst.postOrder(bst.root);
		System.out.println();
		}
		}
		
		System.out.println("The array of heights is");
		for(int k=0; k < arrayOfHeight.length; k++){
			System.out.print("["+arrayOfHeight[k]+"]");
		}
		
		System.out.println();
		System.out.println("The Average Height of the tree is : "+ sum/noOfRun );
		
	}

}
