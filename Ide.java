/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   Scanner sc = new Scanner(System.in);
	   
	   
		
		    System.out.println("Enter a string :");
	        String input = sc.next();
	        
	        System.out.println("Enter the cipher key:");
	        int cipher = sc.nextInt();
	        
	        char [] arr = input.toCharArray();
	        
	        if(cipher>=26)
	            cipher=cipher%26;
	       else if(cipher>=0)
	            cipher=cipher;
	        
	   int temp;
	   
	    for(int j=0; arr[j] != '\0'; j++){
	        if((char)(arr[j] >='A' && arr[j]<= 'Z')){
	           if((char)(arr[j] - cipher >= 'A'))
	            (char) arr[j] = arr[j] - cipher;
	            
	           else if((arr[j] - cipher) <'A')
	            arr[j] = (arr[j] - cipher) + 26;
	            
	        }
	        else if(arr[j] >='a' && (int)arr[j] <='z'){
	            if(arr[j] - cipher >='a')
	               arr[j] = arr[j] - cipher;
	            else if((arr[j] - cipher) < 'z')
	              arr[j] = (arr[j]-cipher)+ 26;
	                
	        }
	        else{
	           arr[j] = arr[j];
	            
	        }
	    }
	    
	    System.out.println(arr);
	    
		
	}
}
