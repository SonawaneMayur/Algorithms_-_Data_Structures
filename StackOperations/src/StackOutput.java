import java.util.Stack;

public class StackOutput {

	static void stackPush(Stack st, int a){
		st.push(a);
		System.out.println("st :"+ st);
		
	}
	
	static void stackPop(Stack st){
		System.out.println("pop item :" + st.pop());
		
	}
	public static void main(String[] args) {
		Stack st = new Stack();
		
		stackPush(st, 1);
		stackPush(st, 1);
		stackPush(st, 1);
		stackPush(st, 1);
		stackPush(st, 1);
		stackPush(st, 6);
		//stackPop(st);
		System.out.println("st:" + st);
		int i = 0;
		while( i < st.capacity()){
			System.out.println("st -->" + st.elementAt(i));
			i++;
		}
	}

}
