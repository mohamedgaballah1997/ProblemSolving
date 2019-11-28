
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
