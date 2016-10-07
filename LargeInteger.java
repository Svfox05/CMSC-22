import java.io.*;
import java.util.*;


class LargeInteger{

	int [] num;
	
	public void sub(String a, String b){
	
		char [] arr1 = a.toCharArray();
		char [] arr2 = b.toCharArray();

		char[] big ;
		char[] small;

		char [] ans; 
		int i=0;
		int carry=0;
		int borrow=0;
		int flag=0;
		int bigl=0;
		int smalll=0;
		int len1=0;
		int len2=0;

		len1= arr1.length;
		len2= arr2.length;

		System.out.println(len1);
		System.out.println(len2);

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
			
			if ((char)(big[i]-48)<(char)(small[i]-48)){

				big[i] += (char)10;

				flag=1;
			}

		if(big[i+1] == '0') //Checks if the num is zero
			big[i+1] += 10;

		
		/*for(i = 0; i < big[bigl]; i++){
			if(big[i+1] != '1')
			if(big[i+1] == '0') //how to check if the num is zero
				big[i+1] += 10;
		}*/
		
		ans[i]=(char)(((big[i]-48)-(small[i]-48)-borrow)+48);

		if(flag==1){
			
			ans[i] = (char)((ans[i]-48)%10);
			ans[i] += (char)48;
			borrow = 1;
		}
		else{
			
			borrow = 0;
		}


	}	
		for(;i < bigl;i++){
			

			if(borrow == 1){
				
				ans[i] = (char)(big[i]-1);
			}

			else{
				
				ans[i] = (char)big[i];
			}

			
			borrow=0;

		}

		ans[i] = '\0';
		
		reverse(ans);
		System.out.print("SUBTRACTION -->");

		for(int c=0;c<ans.length;c++)
			System.out.print(ans[c]);
		System.out.println();
		//LargeInteger rev = new LargeInteger();
		//rev.reverse(ans);
	}	

	public void add(String a,String b){

		char [] arr1 = a.toCharArray();
		char [] arr2 = b.toCharArray();

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
			ans[i]=(char)(((big[i]-48)+(small[i]-48)+carry)+48);		
		
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

	reverse(ans);
	System.out.println("ADDITION -->");
	for(int c=0;c<ans.length;c++)
			System.out.print(ans[c]);

		//LargeInteger rev1 = new LargeInteger();
		//rev1.reverse(ans);
			
	}

	void multiply(String a, String b){
		char [] arr1 = a.toCharArray();
		char [] arr2 = b.toCharArray();

		char[] ans;

		reverse(arr1);
		reverse(arr2);


		ans = new char[(arr1.length+arr2.length) * 2];
		int i = 0;
		int j = 0;
		int k = 0;
		int rem = 0;
		int tmp = 0;
	
		int carry = 0;
		

		if(arr1.length >= arr2.length) {
			for(i = 0; i < arr1.length; i++) {
				for(j = 0; j < arr2.length; j++) {
					tmp = ((arr1[i] - 48)* (arr2[j] - 48)) + carry;
					//ans[j] = (char)tmp;
					if(tmp > 57) {
						rem = (tmp % 10);
						carry = (tmp / 10);
					} 
					ans= String.valueOf(tmp).toCharArray();
					
				}
			}
		} else {
			for(i = 0; i < arr2.length; i++) {
				for(j = 0; j < arr1.length; j++) {
					tmp = ((arr1[i] - 48)* (arr2[j] - 48)) + carry;
					//ans[j] = (char)tmp;
					if(tmp > 57) {
						rem = (tmp % 10);
						carry = (tmp / 10);
					}
					ans = String.valueOf(tmp).toCharArray(); 
				}
			}

    	reverse(ans);
    	System.out.println("multiplication -->");
		for(int c=0;c<ans.length;c++)
			System.out.print(ans[c]);
    
	}


		public void reverse(char[] str){

			int i=0;
			int j=0;
			int len =0;
			char temp;

			len = str.length;

			i=0;
			j=len-1;

			while(i<j){
				temp=str[i];
				str[i]=str[j];
				str[j]=temp;
				i++;
				j--;
			}

			
		}



	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 String operand1 = sc.next();
         //String operator = sc.next();
        String operand2 = sc.next();
        //int operand1 = sc.nextInt();
        //int operand2 = sc.nextInt();


         LargeInteger test = new LargeInteger();
         //test.sub(operand1,operand2);
         //test.add(operand1,operand2);
        	test.multiply(operand1,operand2);

	 }


}