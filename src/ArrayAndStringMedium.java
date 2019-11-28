import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class ArrayAndStringMedium {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
    	ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++) {
    		if(i>0 && nums[i]==nums[i-1])continue;
    		int  low=i+1;
    		int high=nums.length-1;
    		while(low<high) {
    			if(nums[low]+nums[high]==-nums[i]) {
    				ArrayList<Integer> temp=new ArrayList<>();
    				temp.add(nums[i]);
    				temp.add(nums[low]);
    				temp.add(nums[high]);
    				arr.add(temp);
    				high--;
    				low++;
    				while(nums[low]==nums[low-1] && low<nums.length-1) low++;
    				while(nums[low]==nums[high+1] && high>=0) high--;
    			}
    			else if(nums[low]+nums[high]>-nums[i]) high--;
    			else low++;
    		}
    	}
    	return arr;
        
    }
    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
    	ArrayList<ArrayList<String>> arr=new ArrayList<>();
    	HashMap<String, ArrayList<Integer>> hm=new HashMap<>();
    	for(int i=0;i<strs.length;i++) {
    		char[] temp=strs[i].toCharArray();
    		Arrays.sort(temp);
    		String temps=new  String(temp);
    		if(hm.containsKey(temps))
    			hm.get(temps).add(i);
    		else {
    			hm.put(temps,new ArrayList<>());
    			hm.get(temps).add(i);
    		}
    	}

    	for(int i=0;i<strs.length;i++) {
    		char[] temp=strs[i].toCharArray();
    		Arrays.sort(temp);
    		String temps=new  String(temp);
    		if(!hm.containsKey(temps)) continue;
    		ArrayList<String> tempa=new ArrayList<>();
    		for(Integer j: hm.get(temps)) {
    			tempa.add(strs[j]);
    		}
    		hm.remove(temps);
    		arr.add(tempa);
    	}
    	return arr;
        
    }
    public static void setZeroes(int[][] matrix) {
    	HashSet<Integer> hi=new HashSet<>();
    	HashSet<Integer> hj=new HashSet<>();
    	 for(int i=0;i<matrix.length;i++) {
    		 for(int j=0;j<matrix[0].length;j++) {
    			 if(matrix[i][j]==0) {
    				 hi.add(i);
    				 hj.add(j);
    			 }
    		 }
    	 }
    	 for(int i=0;i<matrix.length;i++) {
    		 if(hi.contains(i))
    			 for(int j=0;j<matrix[0].length;j++) {
    				 matrix[i][j]=0;
     			 }
    		 }
    	 for(int j=0;j<matrix[0].length;j++) {
    		 if(hj.contains(j))
    			 for(int i=0;i<matrix.length;i++) {
    				 matrix[i][j]=0;
    			 }
    	 }
    	 }

    public static String longestPalindrome(String s) {
    	if(s.length()<=1 ) return s;
    	boolean[][] arr=new boolean[s.length()][s.length()];
    	int l=s.length()-1,r=s.length()-1;
    	int max=1;
    	arr[s.length()-1][s.length()-1]=true;
    	for(int i=s.length()-2;i>=0;i--) {
    		arr[i][i]=true;
    		arr[i][i+1]=s.charAt(i)==s.charAt(i+1);
			if(arr[i][i+1]==true && max<2) {
				l=i;
				r=i+1;
				max=r-l+1;
			}
    		for(int j=i+2;j<s.length();j++) {
    			arr[i][j]=arr[i+1][j-1] && s.charAt(i)==s.charAt(j);
    			//System.out.println(i+"    "+j+"   "+arr[i][j]);
    			if(arr[i][j]==true && j-i+1>max) {
    				l=i;
    				r=j;
    				max=r-l+1;
    			}
    		}
    	}
    	//System.out.println(l+" ----- "+r);
        return s.substring(l,r+1);
    }
    public static int lengthOfLongestSubstring(String s) {
	    	if(s.isEmpty()) return 0;
	    	int max=1,l=0;
	    	HashMap<Character, Integer> hm=new HashMap<>();
	    
	    	for(int i=0;i<s.length();i++){
	    		if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))>=l) {
	    			if(i-l>max) max=i-l;
	    			l=hm.get(s.charAt(i))+1;
	    			hm.put(s.charAt(i),i);
	    			
	    		
	    		}
	    		else
	    			hm.put(s.charAt(i), i);
	    	}
	    	 max=Math.max(s.length()-l,max);
	        return max;

    }
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
		//System.out.println(s.substring(3,5));
	}
		 
		 
}
