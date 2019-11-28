import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class DP_Medium {
    public static boolean canJump(int[] nums) {
    	if(nums.length==0) return false;
      boolean[] arr=new boolean[nums.length]  ;
      arr[0]=true;
      for(int i=0;i<nums.length-1;i++) {
    	  if(arr[i]==false) return false;
    	  for(int j=nums[i];j>0;j--) {
    		  if(i+j>=nums.length) return true;
    		  if(arr[i+j]==true) break;
    		  arr[i+j]=true;
    	  }
      }
    return arr[arr.length-1];
    }
    public int uniquePaths(int m, int n) {
        int[][] arr=new int [n][m];
        arr[0][0]=1;
        for (int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(i==n-1 & j==m-1) return arr[i][j];
        		if(i<n-1) arr[i+1][j]+=arr[i][j];
        		if(j<m-1) arr[i][j+1]+=arr[i][j];
        	}
        }
    return arr[n-1][m-1];
    }
    public static int lengthOfLIS(int[] nums) {
    	if(nums.length==0) return 0;
    	int max=1;
    	int[] arr=new int[nums.length];
    	int maxSofar=0;
    	for(int i=0;i<nums.length;i++) {
    		arr[i]=1;
    		for(int j=i;j>=0;j--) {
    			if(nums[i]>nums[j]) {
    				if(arr[j]>maxSofar) maxSofar=arr[j];
    				
    			}
    		}
    		arr[i]+=maxSofar;
    	if(arr[i]>max) max=arr[i];
    	}
    	return max;}
        
    
    public static int coinChange(int[] coins, int amount) {
    	if(amount==0) return 0;
        if(coins.length==0)return -1;
        int[] arr=new int [amount+1];
        for(int i=0;i<amount+1;i++) {
        	arr[i]=-1;
        	for(int j=0;j<coins.length;j++) {
        		int k=i-coins[j];
        		if(k==0) {
        			arr[i]=1;
        			break;
        		}
        		if(k<0) continue;
        		if(arr[k]==-1) continue;
        		if(arr[i]==-1 || arr[i]>arr[k]+1) arr[i]=arr[k]+1;
        	}
        }
        return arr[amount ];
    }
	/*
    public static boolean canJump(int[] nums,int index) {
    	if(index==nums.length-1) return true;
    	boolean ans=false;;
    	for(int i=1;i<=nums[index];i++) {
    		
    		if(i+index<nums.length) {
    		ans=canJump(nums, i+index);
    		if(ans) return true;
    		}
    		}
    	
        return ans;
    }*/
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] arr=new int[nums.length];
        arr[0]=nums[0];
        arr[1]=Math.max(nums[0], nums[1]);
        int max=arr[1];
        for(int i=2;i<nums.length;i++) {
        	arr[i]=Math.max(arr[i-2]+arr[i], arr[i-1]);
        	if(arr[i]>max) max=arr[i];
        }
    return max;}
	public static void main(String[] args) {
		int[] nums= {2,7,9,3,1};
		System.out.println(rob(nums));

	}

}
