import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Array {
    public static void moveZeroes(int[] nums) {
    	int index=0;
    	 for(int i=0;i<nums.length;i++) {
    		 if(nums[i]!=0) {
    			 nums[index]=nums[i];
    			 if(i!=index++)
    				 nums[i]=0;
    		 }
    	 }
    }
    public int[] twoSum(int[] nums, int target) {
    	 int i1=0,i2=0;
    	HashMap<Integer, Integer> hm=new HashMap<>();
    	for(int i=0;i<nums.length;i++) {
    		hm.put(nums[i],i);
    	}
    	for(int i=0;i<nums.length;i++) {
    		i1=i;
    		if(hm.containsKey(target-nums[i])) {
    			i2=hm.get(target-nums[i]);
    			if(i==i2) continue;
    			break;
    		}
    	}
        int[] arr=new int[2];
        arr[0]=i1;
        arr[1]=i2;
        
        return arr;
    }
    
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> h;
        for(int i=0;i<9;i++) {
        	h=new HashSet<>();
        	for(int j=0;j<9;j++) {
        		if(board[i][j]=='.') continue;
        		if(h.contains(board[i][j])) return false;
        		h.add(board[i][j]);
        	}
        }
        for(int i=0;i<9;i++) {
        	h=new HashSet<>();
        	for(int j=0;j<9;j++) {
        		if(board[j][i]=='.') continue;
        		if(h.contains(board[j][i])) return false;
        		h.add(board[j][i]);
        	}
        }
        for(int i=0;i<9;i++) {
        	h=new HashSet<>();
        	int row2=3*(i/3);
        	
        	int column2=3*(i%3);
        	for(int row=3*(i/3);row<row2+3;row++) {
        		for(int column=3*(i%3);column<column2+3;column++) {
            		if(board[row][column]=='.') continue;
            		if(h.contains(board[row][column])) return false;
            		h.add(board[row][column]);
        		}
        	}
        }
    	
    	return true;
    }
    public void rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));
        for (int i=0;i<matrix.length;i++) {
        	for(int j=0;j<i;j++) {
        		int temp=matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i]=temp;
        	}
        }
        
    }
	public static void main(String[] args) {
		int[] nums= {0,1,0,3,12};
		Arrays.sort(nums);
		System.out.println((-1)%3);
		//moveZeroes(nums);
		char[][] board={{'.','.','.','.','5','.','.','1','.'},
		                {'.','4','.','3','.','.','.','.','.'},
		                {'.','.','.','.','.','3','.','.','1'},
		                {'8','.','.','.','.','.','.','2','.'},
		                {'.','.','2','.','7','.','.','.','.'},
		                {'.','1','5','.','.','.','.','.','.'},
		                {'.','.','.','.','.','2','.','.','.'},
		                {'.','2','.','9','.','.','.','.','.'},
		                {'.','.','4','.','.','.','.','.','.'}};
		System.out.println(isValidSudoku(board));
    	HashMap<Integer, Integer> hm=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
		//	System.out.println(nums[i]);
		}

	}

}
