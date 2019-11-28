
public class SortingAndSearching {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[nums1.length];
        int i=0, k=0,j=0;
      while(i<m && j<n) {
    	   if(nums1[i]<nums2[j]) {
    		   arr[k]=nums1[i];
    		   i++;
    	   }
    	   else {
    		   arr[k]=nums2[j];
    		   j++;
    	   }
    	   k++;
       }
      while(i<m) {
    	  arr[k++]=nums1[i++];
      }
      while(j<n) {
    	  arr[k++]=nums2[j++];
      }
      for(int l=0;l<nums1.length;l++) {
    	  nums1[l]=arr[l];
      }
      
    	
    }
  public static  boolean  isBadVersion(int version) {
	  if (version >= 1702766719) return true;
    	return false;
    }
 public static int firstBadVersion(int n) {
	    int first=1,last=n,firstBad=0;
	       while(first<=last) {
	    	   System.out.println(first+"   "+last);
	    //	  long sum=first+last;
	    //	  System.out.println(first+"   "+last+"    "+sum);
	    	   int middle=(int) (first/2.0 + last/2.0);
	            System.out.println(middle + "     "+isBadVersion(middle));
	    	   if(isBadVersion(middle)==true) {
	    		   last=middle-1;
	               firstBad=middle;
	    	   }
	    	   else if(isBadVersion(middle)==false) {
	    		   first=middle+1;
	    	   }
	       }
	     return firstBad;
    }
	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));

	}

}
