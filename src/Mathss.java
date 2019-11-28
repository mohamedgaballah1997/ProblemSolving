public class Mathss {
	   public static int countPrimes(int n) {
		   if(n<=2) return 0;
		 boolean[] arr=new boolean[n];
		 for(int i=2;i*i<n;i++) {
			 for(int j=2 ;j*i<n;j++) {
				 arr[i*j]=true;
			 }
		 }
		 int counter=1;
		 for(int i=3;i<n;i++) {
			 if(arr[i]==false) counter++;
		 }
		 
		 return counter;
	    }
	    public static boolean isPowerOfThree(int n) {
	        int begin=0,last=n/3;
	        while(begin<=last) {
	        	int middle=(begin+last)/2;
	        	if(Math.pow(3, middle)==n) return true;
	        	else if(Math.pow(3, middle)>n) last=middle-1;
	        	else begin=middle+1;
	        }
	        return false;
	    }
	   
	    public  static int romanToInt(String s) {
	    	if(s.isEmpty()) return 0;
    int n=0;
    for(int i=0;i<s.length();i++) {
    	switch (s.charAt(i)) {
    	
		case 'I':
			if(i==s.length()-1) n+=1;
			else if(s.charAt(i+1)=='V') {n+=4; i++;}
			else if( s.charAt(i+1)=='X') {n+=9; i++;}
			else n+=1;
			break;

		case 'X':
			if(i==s.length()-1) n+=10;
			else if(s.charAt(i+1)=='L') {n+=40; i++;}
			else if( s.charAt(i+1)=='C'){n+=90; i++;}
			else n+=10;
			break;
		case 'C':
			if(i==s.length()-1) n+=100;
			else if(s.charAt(i+1)=='D') {n+=400; i++;}
			else if( s.charAt(i+1)=='M') {n+=900; i++;}
			else n+=100;
			break;
		case 'V':
			n+=5;
			break;
        case 'L':
			n+=50;
			break;
		case 'D':
			n+=500;
			break;
		default:
			n+=1000;
			
		}
    	
    }
    return n;
	    }
	public static void main(String[] args) {
	System.out.println(romanToInt("DCXXI"));
	}

}
