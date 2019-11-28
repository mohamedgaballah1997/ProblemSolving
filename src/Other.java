import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;


public class Other {
    public int missingNumber(int[] nums) {
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<nums.length;i++) {
        	hm.add(nums[i]);
        }
        for(int i=0;i<=nums.length;i++) {
        	if(!hm.contains(i))
        		return i;
        }
        return -1;
    }
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> l =new ArrayList<>();
    	for(int i=0;i<numRows;i++) {
    		l.add(new ArrayList<>());
    		ArrayList<Integer> row=l.get(i);
    		row.add(1);
    		if(i==0) continue;
    		ArrayList<Integer> parent=l.get(i-1);
    		for(int j=0;j<parent.size()-1;j++) {
    			row.add(parent.get(j)+parent.get(j+1));
    		}
    		row.add(1);
    	
    	}
        return l;
    }
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(c=='{' || c=='[' || c=='(') {
        		st.push(c);
        	}
        	else {
        		if(st.isEmpty()) return false;
        		if(c=='}' && st.peek()=='{') 
        			st.pop();
        		else if(c==')' && st.peek()=='(') 
        			st.pop();
        		else if(c==']' && st.peek()=='[') 
        			st.pop();
        		else return false;
        	}
        }
        if(st.isEmpty()) return true;
        return false;
    }
    public static int reverseBits(int n) {
    	char[] arr=String.format("%32s", Integer.toBinaryString(n)).replace(" ", "0").toCharArray();
        int i=0,j=arr.length-1;
        while(i<j) {
        	char c=arr[i];
        	arr[i++]=arr[j];
        	arr[j--]=c;
        }
        String b=new String(arr);
        return (int) Long.parseLong(b,2);
    }
	public static void main(String[] args) {
		String s="hiiii";
        for(Character c:s.toCharArray()) {
        	System.out.println(c);
        }

	}

}
