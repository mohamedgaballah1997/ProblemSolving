import java.util.Stack;

public class DesignMinStack {
	Stack<Integer> stack;
	int min;
	boolean isPoped;
    public DesignMinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
        isPoped=false;
    }
    
    public void push(int x) {
        stack.push(x);
        if(x<min) min=x;
    }
    
    public void pop() {
    	isPoped=true;
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {	
    	if(!isPoped) return min;
    	int minIndex=0;
    	for(int i=1;i<stack.size();i++) {
    		if(stack.get(i)<stack.get(minIndex)) minIndex=i;
    	}
    	min=stack.get(minIndex);
    	isPoped=false;
        return min;
    }
	
	
	
	
	
	
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

//	}

}
