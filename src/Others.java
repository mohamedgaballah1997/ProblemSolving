import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Others {

    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long sum=0;
        int j=calorie.length-1,i=0;
        while(j>=0) {
        	sum+=Math.pow(2, i)*calorie[j];
        	i++;
        	j--;
        }
        return sum;
    }
    static int getMinimumCost(int k, int[] c) {
    	
    	int sum=0;
    	Arrays.sort(c);
    	int n=0;
    	int counter=0;
    	for(int i=c.length-1;i>=0;i--) {
    		sum+=(n+1)*c[i];
    		counter++;
    		if(counter==k) {
    			counter=0;
    			n++;
    		}
    	
    	}
    	return sum;
    }

	public static void main(String[] args) {
	
	}

}
