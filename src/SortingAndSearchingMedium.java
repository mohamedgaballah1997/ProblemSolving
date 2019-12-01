import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingAndSearchingMedium {
    public void sortColors(int[] nums) {
        if(nums.length==0) return;
int separator0=-1;
int separator2=nums.length;
for(int i=0;i<separator2;i++) {
    if(nums[i]==2) {
	separator2--;
		int temp=nums[i];
		nums[i]=nums[separator2];
		nums[separator2]=temp;
        i--;
	}
	else if(nums[i]==0) {
	separator0++;
		int temp=nums[i];
		nums[i]=nums[separator0];
		nums[separator0]=temp;
	}
   
}
    }
    public int findPeakElement(int[] nums) {
    	if(nums.length==1) return 0;
        for(int i=0;i<nums.length;i++) {
        	int before,after;
        	if(i==0) before=Integer.MIN_VALUE;
        	else before=nums[i-1];
        	if(i==nums.length-1) after=Integer.MIN_VALUE;
        	else after=nums[i+1];
        	if(nums[i]>before && nums[i]>after) return i;
        }
        return nums.length;
    }
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return - Integer.compare(o1,o2);
    }
});
for(int i=0;i<nums.length;i++)
 heap.add(nums[i]);
for(int i=0;i<k-1;i++)
 heap.poll();
return heap.poll();
    }
    public static int[] searchRange(int[] nums, int target) {
    	 int[] arr=new int[2];
    	 arr[0]=-1;
         arr[1]=-1;
        int low =0;
        int high=nums.length-1;
        int begin=-1,last=-1;
        while(low<high) {
        	int mid=(low+high)/2;
        	
        	if(nums[mid]<target) {
        		low=mid+1;
        	}
        	else if(nums[mid]>target) {
        		high=mid-1;
        	}
        	else {
        		begin=mid;
        		high=mid-1;
        	}
        }
         low =0;
         high=nums.length-1;
        while(low<high) {
        	int mid=(low+high)/2;
        	if(nums[mid]<target) {
        		low=mid+1;
        	}
        	else if(nums[mid]>target) {
        		high=mid-1;
        	}
        	else {
        		last=mid;
        		low=mid+1;
        	}
        }
        arr[0]=begin;
        arr[1]=last;       
return arr;
    }
    public static int[][] merge(int[][] intervals) {
    	if(intervals.length<=1) return intervals;
    	Arrays.sort(intervals,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[0], o2[0]);
			}
		});
    	for(int i=0;i<intervals.length;i++) {
    		System.out.println(intervals[i][0]+"  "+intervals[i][1]);
    	}
    	ArrayList<Integer> l=new ArrayList<>();
    	int begin=intervals[0][0];
    	int last=intervals[0][1];
    	for(int i=1;i<intervals.length;i++) {
    		if(intervals[i][0]<=last) {
    			begin=Math.min(begin, intervals[i][0]);
    			last=Math.max(last, intervals[i][1]);
    		}
    		else {
    			l.add(begin);
    			l.add(last);
    				begin=intervals[i][0];
    				last=intervals[i][1];
    				
    		}
    	}
        l.add(begin);
    			l.add(last);
    	int[][] arr=new int[l.size()/2][2];
    	System.out.println(l);
        int index=0;
    	for(int i=0;i<l.size();i+=2) {
arr[index][0]=l.get(i);
arr[index++][1]=l.get(i+1);
    	}
    	return arr;
    }
    public static int findK(int[] nums) {
        int low=0,high=nums.length-1;
        while(low <= high) {
        	int mid=(low+high)/2;
        	if(nums[mid]<nums[mid-1]) return mid;
        	if(nums[low]>nums[mid]) high=mid-1;
        	else if(nums[high]<nums[mid]) low=mid+1;
        	else return low;
        }
        return 0;
    	
    }
    public static int search(int[] nums, int target) {
    	int low=0,high=nums.length-1,k=findK(nums);
    	System.out.println(k);
    	while(low<=high) {
    		int mid=(low+high)/2;
    		if(nums[mid]==target) return (mid+k)%nums.length;
    		else if(nums[(mid+k)%nums.length]>target) high=mid-1;
    		else low=mid+1;
    	}
    	
    	return -1;
        
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length==0) return false;
     int i=0; 
     int j=matrix[0].length-1;
     System.out.println(i+"  "+j);
     while(i<matrix.length && j>=0) {
    	 if(matrix[i][j]==target ) return true;
    	 else if(matrix[i][j]>target ) 
    		 j--;
    	 else
    		 i++;
     }
     return false;
    }
	public static void main(String[] args) {
			System.out.println(findK(new int[] {4,5,6,7,0,1,2}));
	}

}
