

import java.util.Random;
import java.util.Scanner;

class Node {
	int data;
	Node next, pre;
	
	public Node(int val){
		this.data = val;
	}
	
}
class DoublyLinkedList{
		
		Node first;
		Node last;
		Node result= null;
		
		public DoublyLinkedList(){
			first = null;
			last = null;
		}
		
		public void insert(int val){
			if(first == null){
			Node newNode = new Node(val);
			newNode.next = null;
			newNode.pre = null;
			first = last = newNode;
			}else{
				Node newNode = new Node(val);
				newNode.next = null;
				newNode.pre = last;
				
				last.next = newNode;
				
				last = newNode;
			}
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
			Node firstPre = elementAt(first11).pre;
			Node first1 = elementAt(first11);
			Node second2 = elementAt(second22);
			
			//if(first1 == first){
				first1.next = secondNext;
				first1.pre = second2;
				
				second2.next = first1;
				second2.pre = firstPre;
				
				//if(firstPre)
				
				if(first1 == first && second2 == last){
					first = second2;
					last = first1;
				}else if(first1 == first){
					secondNext.pre = first1;
					first = second2;
				}else if(second2 == last){
					firstPre.next = second2;
					last = first1;
				}else if(first1 != first && second2 != last){
					secondNext.pre = first1;
					firstPre.next = second2;
				}			
			
		}
		public void bubbleSort(int size){
			
			
			for(int i = 0; i < size; i++){
				for(int j = 0; j< size-1; j++){
					if(elementAt(j).data > elementAt(j+1).data){
						swap(j, j+1);
					}
					
				}
				
			}
						
		}
	}


class DoublyLLBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner sc = new Scanner(System.in);
		DoublyLinkedList object = new DoublyLinkedList();
		Random random = new Random();
		
		//System.out.println("Enter the size of linkedlist :");
		int size =Math.abs(random.nextInt(100));
		
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


