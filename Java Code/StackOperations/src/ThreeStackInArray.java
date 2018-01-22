
public class ThreeStackInArray {

	int stackSize =  300;
	int indexUsed = 0;
	int[] stackPointer ={-1,-1,-1};
	StackNode[] buffer = new StackNode[stackSize * 3];
	
	public void push(int stackNum, int val){
		int lastIndexUsed = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNode(lastIndexUsed, val);
	}
	
	public int pop(int stackNum){
		int value = buffer[stackPointer[stackNum]].val;
		int lastIndex = stackPointer[stackNum];
		indexUsed--;
		stackPointer[stackNum] = indexUsed;
		buffer[lastIndex] = null;
		return value; 
	}
	
	public int peek(int stackNum){
		//int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[stackPointer[stackNum]].getVal();
		
	}
	
	boolean isEmpty(int stackNum){
		
		return stackPointer[stackNum] == -1;
	}
	class StackNode{
		int previous;
		int val;
		
		StackNode(){}
		
		public StackNode(int previous, int val){
			this.previous = previous;
			this.val = val;
		}

		public int getPrevious() {
			return previous;
		}

		public void setPrevious(int previous) {
			this.previous = previous;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
		
		
	}
	public static void main(String[] args) {
		 ThreeStackInArray s = new ThreeStackInArray();
		 s.push(0, 10);
		 s.push(0, 13);
		 s.push(2, 12);
		 s.push(1, 11);
		 s.push(1, 15);
		 System.out.println(s.peek(0));
		 /*for(int i =0; i < 900; i++ )
		 System.out.println(s.peek(1));
	*/
	}
}
