import java.util.Random;
 
class Node 
{
    public int item;
    public Node next;
 
    public Node(int val) 
    {
        item = val;
    }
 
    public Node() 
    {}
 
    public void displayNode() 
    {
        System.out.print("[" + item + "] ");
    }
}
 
class LinkedList 
{
    private Node first;
 
    public LinkedList() 
    {
        first = null;
    }
 
    public boolean isEmpty() 
    {
        return (first == null);
    }
 
    public void insert(int val)
    {
        Node newNode = new Node(val);
        newNode.next = first;
        first = newNode;
    }
 
    public void append(Node result) 
    {
        first = result;
    }
 
    public void display() 
    {
        Node current = first;
        while (current != null) 
        {
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
 
    public Node extractFirst() 
    {
        return first;
    }
 
    public Node MergeSort(Node headOriginal) 
    {
        if (headOriginal == null || headOriginal.next == null)
            return headOriginal;
        Node a = headOriginal;
        Node b = headOriginal.next;
        while ((b != null) && (b.next != null)) 
        {
            headOriginal = headOriginal.next;
            b = (b.next).next;
        }
        b = headOriginal.next;
        headOriginal.next = null;
        return merge(MergeSort(a), MergeSort(b));
    }
 
    public Node MergeSort1(Node headOrg){
    	if(headOrg == null || headOrg.next == null)
    		return headOrg;
    	Node a = headOrg;
    	Node b = headOrg.next;
    	if((b != null) && (b.next != null)){
    		headOrg = headOrg.next;
    		b = (b.next).next;
    	}
    	b = headOrg.next;
    	headOrg.next = null;
		return merge(MergeSort(a), MergeSort(b));
    	
    }
    public Node merge(Node a, Node b) 
    {
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null)) 
        {
            if (a.item <= b.item) 
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else 
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        c.next = (a == null) ? b : a;
        return head.next;
    }
    
    public void removeDup(Node head){
    	if(head == null){
    		return;
    	}
    	Node previous = head;
    	Node current= previous.next;
    	
    	while(current != null){
    		Node runner = head;
    		while(runner != current){
    			if(runner.item == current.item){
    				Node tmp = current.next; // remove current
    				 previous.next = tmp;
    				 current = tmp; // update current to next node
    				 break; // all other dups have already been removed
    			}
    			runner = runner.next;
    		}
    		if(runner == current){
    		previous = current;
    		current = current.next;
    		}
    	}
    }
}
 
class RemoveDupUnsortedList 
{
    public static void main(String[] args) 
    {
        LinkedList object = new LinkedList();
        Random random = new Random();
        int N = 5;
        for (int i = 0; i < N; i++)
            object.insert(Math.abs(random.nextInt(100)));// 
 
        System.out.println("List items before sorting :");
        object.display();
        System.out.println("List items after removing duplicate :");
        object.removeDup(object.extractFirst());
        object.display();
        object.append(object.MergeSort(object.extractFirst()));
        System.out.println("List items after sorting :");
        object.display();
    }
}