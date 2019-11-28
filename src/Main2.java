import java.util.Scanner;

public class Main2 {
	public static void TokitsukazeAndEnhancement573() {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int add=0;
		if(getCategory(n+1)<getCategory(n)) {
			n++;
			add++;
			if(getCategory(n+1)<getCategory(n)) {
				n++;
				add++;
			}
		}
		else if(getCategory(n+2)<getCategory(n)) {
			n+=2;
			add+=2;
			
		}
		System.out.println(add+" "+getCategory(n));
		
		
	}
	public static char getCategory(int n) {
		if(n%4==1)
			return 'A';
		else if(n%4==3)
			return 'B';
		else if(n%4==2)
			return 'C';
		else 
			return 'D';
		
	}
	public static void main(String[] args) {
		TokitsukazeAndEnhancement573();
	}

}
