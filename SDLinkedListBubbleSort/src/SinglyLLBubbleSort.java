import java.util.Random;
import java.util.Scanner;

class Node {
	int data;
	Node next;
	
	public Node(int val){
		this.data = val;
	}
	
}
class SinglyLinkedList{
		
		Node first;
		
		Node result= null;
		
		public SinglyLinkedList(){
			first = null;
			
		}
		
		public void insert(int val){
			Node newNode = new Node(val);
			newNode.next = first;
			first = newNode;
		}
		
		public Node insertResult(int val){
			Node newNode = new Node(val);
			newNode.next = result;
			result = newNode;
			return result;
		}
		
		public void display(){
			Node temp = first;
			while(temp != null){
				System.out.println("["+temp.data+"]");
				temp = temp.next;
			}
		}
		
		public Node elementAt(int index){
			Node temp = first;
			
			for(int i = 0; i < index; i++ ){
				temp = temp.next;
			}
			
			return temp;
			
		}
		
		public void swap(int first11, int second22){
			Node secondNext = elementAt(second22).next;
			Node firstPre = elementAt(first11 - 1);
			Node first1 = elementAt(first11);
			Node second2 = elementAt(second22);
			
			if(first1 == first){
				first1.next = secondNext;
				second2.next = first1;
				first = second2;
				
			}else{
			firstPre.next = second2;
			second2.next = first1;
			first1.next = secondNext;
			}
			
			
		}
		public void bubbleSort(int size){
			/*Node current = first;
			Node Result = first;
			Node temp;
			int cnt=0;
			int swappedCnt = 1;
			//Node next = current.next;
			//Node temp;
			boolean swapped = false;*/
			
			for(int i = 0; i < size; i++){
				for(int j = 0; j< size-1; j++){
					if(elementAt(j).data > elementAt(j+1).data){
						swap(j, j+1);
					}
					
				}
				
			}
			/*while(current.next != null && swappedCnt > 0){
				swappedCnt = 0;
				Node Next = current.next;
				while (Next != null){
				if(current.data > (Next).data){
					temp = current.next;
					current.next = temp.next;
					temp.next = current;
					
					insertResult();
					Next = Next.next;
					swapped = true;
					cnt++;
					if(cnt == 1)
					first = temp;
					}else{
						current = Next;
						Next = current.next;
						
							
					}
					if(swapped){
						swappedCnt++;
						swapped = false;
					}
				}
				current = first;
			}
			first = current;*/
			//display();
			
		}
	}


class SinglyLLBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner sc = new Scanner(System.in);
		SinglyLinkedList object = new SinglyLinkedList();
		Random random = new Random();
		
		//System.out.println("Enter the size of linkedlist :");
		int size = Math.abs(random.nextInt(100));
		
		for(int i =0; i < size; i++){
			object.insert(Math.abs(random.nextInt(5000)));
		}
		
		System.out.println("List items before sorting :");
        object.display();
        
        object.bubbleSort(size);
        
        System.out.println("List items after sorting :");
        object.display();
	
        

	}
				
}


