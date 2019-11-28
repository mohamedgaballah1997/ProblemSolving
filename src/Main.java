
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class Main {
	
    public int[] plusOne(int[] digits) {
     int i=digits.length-1;
     boolean carry=false;
     while(i>=0) {
    	 if(digits[i]==9) {
    		 digits[i]=0;
    		 if(i==0) {
    			 carry=true;
    		 }
    		 i--;
    		 continue;
    	 }
    	 else {
    		 digits[i]++;
    		 break;
    	 }
     }
     if(carry) {
    	 int[] digits2=new int[digits.length+1];
    	 digits2[0]=1;
    	 for (int j=1;j<digits.length;j++) {
    		 digits2[j]=digits[j];
    	 }
    	 return digits2;
     }
     return digits ;
    }
	
	
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> a=new ArrayList<>();
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        for(int i=0;i<nums1.length;i++) {
        	if(hm.containsKey(nums1[i])) {
        		hm.put(nums1[i],hm.get(nums1[i])+1);
        	}
        	else
        		hm.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++) {
        	if(hm.containsKey(nums2[i])&& hm.get(nums2[i])>1) {
        		hm.replace(nums2[i], hm.get(nums1[i])-1);
        		a.add(nums2[i]);
        	}
        }
        int[] nums3 =new int[a.size()];
        for(int k=0;k<a.size();k++)
        	nums3[k]=a.get(k);
        return nums3;
    }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
	//	if(n==1) return head.next;
         	int k=1,t=1;
        	
        	ListNode temp=head;
        	while(temp.next!=null) {
        		k++;
        		temp=temp.next;
        	}
        	k=k-n;
        	if(k==0) return head.next;
        	temp=head;
        	while(k!=1) {
        		temp=temp.next;
        		k--;
        	}
        	System.out.println(temp.val);
        	temp.next=temp.next.next;
        	return head;
        	
    }
	public static void deleteNode(ListNode node) {
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
    public static void rotate(int[] nums, int k) {
    	int[] arr=new int[nums.length];
    	k=k%nums.length;
    	for(int i=0;i<nums.length;i++) {
    		int index=(i+(nums.length-k))%nums.length;
    		if(index<0)
    			index*=-1;
    		arr[i]=nums[index];
    		
    	}
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;i<nums.length;j++) {
        		nums[i]=arr[i];
    		}
    		nums[i]=arr[i];
    		
    	}
    }
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
    	for(int i=0;i<s.length()-1;i+=2) {
    			if(hm.containsKey(s.charAt(i)))
    				hm.replace(s.charAt(i), hm.get(s.charAt(i))+1);
    			else
    				hm.put(s.charAt(i),1);
    	}
    	for(int i=0;i<s.length()-1;i+=2) {
    			if(hm.get(s.charAt(i))==1)
    				return i;
	}
    	return -1;
    	
    }
     public static char getC(String s) {
         char tempArray[] = s.toCharArray(); 
         
         Arrays.sort(tempArray); 
         s=new String(tempArray);
        	for(int i=0;i<s.length()-1;i+=2) {
           		if(s.charAt(i)!=s.charAt(i+1))
           			return s.charAt(i);
        	}
           	return s.charAt(s.length()-1);
        }
    
    public static int singleNumber(int[] nums) {
    	Arrays.sort(nums);
       	for(int i=0;i<nums.length-1;i+=2) {
       		if(nums[i]!=nums[i+1])
       			return nums[i];
    	}
       	return nums[nums.length-1];
    	
    }
    public static boolean containsDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-1;i++) {
    		if(nums[i]==nums[i+1])
    			return true;
    	}
    	return false;
    }
    
    
public static int reverse(int x) {
	
	int n=x;
	int i=-1;
       while(n!=0) {
    	   i++;
    	   n=n/10;
     
       }
       while(x!=0) {
    	   long temp=(long)((x%10)* (long)(Math.pow(10,i)));
    	   if(n+temp>(long)Integer.MAX_VALUE || n+temp<(long)Integer.MIN_VALUE) {
    		   return 0;
    	   }
    	   n+=temp;
    	   x=x/10;
    	   i--;
       }

  //     if(isnegative) n=n*-1;
       System.out.println(n);
       return n;
    }
    public static void reverseString(char[] s) {
    	if(s.length==0) return;
        int i=0,j=s.length-1;
        while(j>i) {
        	char temp=s[i];
        	System.out.println(i+" "+j);
        	s[i]=s[j];
        	s[j]=temp;
        	i++;
        	j--;
        }
    }
    public static int maxProfit(int[] prices) {
    	if(prices.length==0) return 0;
    	int profit=0;
    	for(int i=0;i<prices.length-1;i++)
    		if(prices[i+1]>prices[i])
    			profit+=prices[i+1]-prices[i];
    	return profit;
    	/*
        int max=0,profit=0;
        for(int i=0;i<prices.length;i++) {
        	int test=0;
        	int index=i;
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i]-prices[j]>test) {
        			test=prices[i]-prices[j];
        			index=j;
        		}
        	}
        	i=index;
        //	profit+=;
        }
    	return max; 
    	*/
    }
	 public static int removeDuplicates(int[] nums) {
		 if(nums.length==0) return 0;
	        int k=0;
	        for (int i = 0; i < nums.length-1; i++) {
	            if(nums[i]==nums[i+1]) nums[i]=Integer.MAX_VALUE;
	        }
	        for (int i = 0; i < nums.length; i++) {
	           if(nums[i]==Integer.MAX_VALUE) {
	        	   continue;
	           }
	           nums[k++]=nums[i];
	        }
	        return k;
	    }
	    public static int hammingWeight(int n) {
	        String str=Integer.toBinaryString(n);
	        System.out.println(str);
	        int counter=0;
	        for(int i=0;i<str.length();i++) {
	        	if(str.charAt(i)=='1')
	        		counter++;
	        }
	        return counter;
	    }
	    public ArrayList<String> fizzBuzz(int n) {
	    	ArrayList<String> l=new ArrayList<>();
	        for(int i=1;i<=n;i++) {
	        	if(i%3==0 && i%5==0) {
	        		l.add("FizzBuzz");
	        	}
	        	else if(i%5==0) {
	        		l.add("Buzz");
	        	}
	        	else if(i%3==0) {
	        		l.add("Fizz");
	        	}
	        	else
	        		l.add(""+i);
	        		
	        }
	        return l;
	    }
	    public static int hammingDistance(int x, int y) {
	    	String strx=String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
	    	String stry=String.format("%32s", Integer.toBinaryString(y)).replace(" ", "0");
	    //	strx.
	    	//int diff=Ma
	    	//System.out.println(stry);
	    	int counter=0;
	    	for(int i=0;i<32;i++) {
	    		if(strx.charAt(i)!=stry.charAt(i))
	    			counter++;
	    	}
	    	return counter;
	    	
	    }
	    public static int[] shuffle(int [] nums) {
	        int[] nums2=nums.clone();
	        int i,j;
	        Random rd=new Random();
	        for(int k=0;k<nums2.length;k++) {
	        i=(rd.nextInt() & Integer.MAX_VALUE)%nums2.length;
	        System.out.println(i+" "+nums2.length);
	        j=(rd.nextInt() & Integer.MAX_VALUE)%nums2.length;
	        int temp=nums2[i];
	        nums2[i]=nums2[j];
	        nums2[j]=temp;
	        }
	        return nums2;
	    }
	public static void main(String[] args) {
		System.out.println(String.format("%32s", Integer.toBinaryString(1)).replace(" ", "0"));
		System.out.println(hammingDistance(1, 4));
		Scanner sc=new Scanner(System.in);
		int x=Integer.MAX_VALUE;
		int y=Integer.MAX_VALUE;
		ListNode node = new ListNode(1);
		node.next=new ListNode(2);
		//removeNthFromEnd(node, 2);
		int[] nums1= {1,2,2,1};
		int[] nums2= {2,2};
		System.out.println(hammingWeight(-11));
		//int[] nums3=intersect(nums1,nums2);
		//containsDuplicate(nums);
		//System.out.println(reverse(-2147483412));
		//System.out.println(firstUniqChar("leetcode"));
		char[] s= {'h','e','l','l','o'};
	//	reverseString(s);
	//	reverse(l);
		//removeNthFromEnd(new ListNode(1), 1);
		/*
		for (int i = 0; i <nums3.length; i++) {
	       
	          System.out.println(nums3[i]);
		
		}*/
		sc.close();
		
	}
}