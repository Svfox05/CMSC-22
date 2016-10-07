import java.util.*;
import java.io.*;

 public class Mult {
	
		public static void main(String[] args) {
	 	Scanner sc = new Scanner(System.in);

	 	String operand1 = sc.next();
	     //String operator = sc.next();
	    String operand2 = sc.next();
	    //int operand1 = sc.nextInt();
	    //int operand2 = sc.nextInt();


	    LargeInteger test = new LargeInteger();
	    test.sub(operand1,operand2);
	    test.add(operand1,operand2);
	   	test.multiply(operand1,operand2);

	 }

	 public void multiply(String str1, String str2) {
		char [] arr1 = str1.toCharArray();
		char [] arr2 = str2.toCharArray();

		char[] big ;
		char[] small;
		char [] ans;

		int i=0,carry=0;
		//char ans[101];
		int bigl,smalll;
		int len1,len2;

		len1=arr1.length;
		len2=arr2.length;
	
		if(len1>len2){
			bigl = len1;
			smalll = len2;	
			
			big = Arrays.copyOf(arr1,len1);
			small =Arrays.copyOf(arr2,len2);
			ans = new char[len1+2];
						
		}
		
		else{
			bigl = len2;
			smalll = len1;
			
			
			big = Arrays.copyOf(arr2,len2);
			small = Arrays.copyOf(arr1,len1);
			ans = new char[len2+2];
		}
		
		
		reverse(big);
		reverse(small);
		
		for(i=0;i<smalll;i++){
			ans[i] = small[i] * big[i];

			//ans[i]=(char)(((big[i]-48)+(small[i]-48)+carry)+48);		
			
			if(ans[i]>57){
				ans[i]=(char)((ans[i]-48)%10);
				ans[i]+=(char)48;
				carry = 1;
			}
			else{
				carry = 0;
			}
		
		}
		for(;i<bigl;i++){ 
		
			if(carry==1)
			ans[i]=(char)(big[i]+1);
			
			else
			ans[i]=(char)big[i];
			
			carry=0;	
		}
			//ans[i] = '\0';

	
	reverse(ans);
	
	for(int c=0;c<ans.length;c++)
			System.out.print(ans[c]);

		//LargeInteger rev1 = new LargeInteger();
		//rev1.reverse(ans);
 
	 }

}


/*


123456 * 1235

654321 * 
5321

5*6 5*5 5*4 5*3 5*2






*/

