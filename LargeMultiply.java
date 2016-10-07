import java.util.Scanner; 

public class LargeMultiply { 
// main method 
	public static void main(String args[]) { 
		//System.out.println("\n\t \t WELCOME TO OneArmed Blog !!! \n"); 
		//System.out.println("\t \t Multiplying 2 Large Numbers \n"); 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter 1st Number:"); //input first number 
		String inputA = sc.next(); // taking string input 
		System.out.println("Enter 2nd Number:"); //input second number 
		String inputB = sc.next(); // taking string input 
		LargeMultiply inst = new LargeMultiply(); 
		//Object creation of class LargeMultiply 
		String v = inst.multiply(inputA, inputB); 
		// calling method multiply() 
		System.out.println("RESULT:"); 
		System.out.println(v); // Output result 
	} 
	/*-- multiply method , return type String , 
	2 String parameters---- */ 
	public String multiply(String num1, String num2) { 
		char[] str1 = num1.toCharArray(); 
		//Split the number string into array with each element 
		// containing single digit 
		char[] str2 = num2.toCharArray(); 
		int m1 = 0; 
		int m2 = 0; 
		String[] resultStringArray = new String[str2.length]; 
		//Initializing the resultString array which has input 
		// string2 in Array form with each element 
		//in different Index 
		LargeMultiply inst1 = new LargeMultiply(); 
		//multiply every element of String2 with the String1 
		// using multiplySmall() method 
		for (int j = str2.length - 1; j > 0; j--) 
			resultStringArray[j] = inst1.multiplySmall(num1, str2[j]); 
		// call to multiplySmall() method 
		for (int i = num2.length() - 1; i > 0; i--) { 
			for (int j = 1; j <= i; j++) { 
			resultStringArray[j] = resultStringArray[j].concat("0"); 
			//concat number of zeroes which are equal to the number of 
			//digits in 2nd number 
			} 
		} 
		String finalResult = "0"; // Initialize output String 
		for (int j = str2.length - 1; j > 0; j--) { 
		finalResult = inst1.add(finalResult, resultStringArray[j]); 
		//call to adding large numbers method 
		} 
		return finalResult; //return result 
	} 
	/*----Method to multiply a single digit to large digits----- */ 
	public String multiplySmall(String large, String small) { 
		int smallInt = Integer.parseInt(small); 
		//String to int conversion 
		String[] s = large.split(""); 
		String[] largeStringArray = new String[s.length - 1]; 
		//Initiate a String array 
		//as discussed earlier split function makes 
		//an array which has first element "" empty 
		//so in order to remove that element 
		//we have to make another array,here it is 
		//largeStringArray 
		for (int i = 0; i < largeStringArray.length; i++) { 
			largeStringArray[i] = s[i + 1]; 
		} 

		int[] largeInt = new int[largeStringArray.length]; 
		//make a integer array for num1 which is considered large 
		for (int i = 0; i < largeStringArray.length; i++) { 
		largeInt[i] = Integer.parseInt(largeStringArray[i]); 
		//String to int conversion of every element 
		} 
		//Logic for carry 
		int carry = 0; 
		String[] resultCarry = new String[2]; 
		//carry number represented by 2 element String array 
		String result = "";// result to be stored in string form 
		int resultInt = 0;//carry in form of integer 
		//int count = 0; 
		for (int i = largeStringArray.length - 1; i >= 0; i--) { 
		resultInt = largeInt[i] * smallInt + carry; 
		//multiplying every element of the largeInt 
		// with single digit integer 
		carry = 0;//after every multiplication carry to be made zero 
		if (i == 0) { // if no carry 
		resultInt = resultInt; // no change 
		} else { // If carry then 
		if (resultInt / 10 > 0) { 
		//if output on multiplying is of 2 digits 
		String s2 = Integer.toString(resultInt); 
		//convert int to String 
		String[] s3 = s2.split(""); 
		// Split the Result on basis of every digit 
		carry = Integer.parseInt(s3[1]); 
		//make the first digit stored on index 1, carry 
		resultInt = resultInt % 10; 
		//keep the unit place digit of the carry 
		//result which is concated later 
		} 
		} 
		result = Integer.toString(resultInt).concat(result); 
		//convert unit place of result to String and concat 
		// it with previous results 
		} 
		return result; 
		//return result, which is multiplication of single 
		// digit number of num2 to the whole num1 
	} 
	/*----------Method to add 2 large numbers-------- */ 
	public String add(String num1, String num2) { 
	char[] tempChar1 = num1.toCharArray(); 
	//converting String num1 to character Array using 
	// toCharArray() function 
	char[] tempChar2 = num2.toCharArray(); 
	//converting String num2 to character Array 
	//using toCharArray() function 
	char[] ch2; 
	char[] ch1; 
	//condition to check which number is longer 
	if (tempChar1.length > tempChar2.length) { // if 1st is larger 
	ch2 = tempChar1; // assign ch2 to num1 
	ch1 = tempChar2; // assign ch1 to num2 
	} else { //if second is larger 
	ch2 = tempChar2;// assign ch2 to num2 
	ch1 = tempChar1;// assign ch1 to num1 
	} // so always the small number gets stored in ch1 
	String ans = ""; //Initiating Result String, ans 
	int tempAns = 0; 
	int carry = 0; 
	int smallerStringIndex; 
	char smallerStringNumber; 
	smallerStringIndex = ch1.length - 1; 
	//represents index for smaller number 
	for (int i = ch2.length - 1; i >= 0; i--) { 
	//if index becomes negative add '0' 
	// at the start of smaller digit, will have no effect 
	if (smallerStringIndex < 0) { 
	smallerStringNumber = '0'; 
	} else { 
	smallerStringNumber = ch1[smallerStringIndex]; 
	} 
	tempAns = (smallerStringNumber + ch2[i] - 96 + carry); 
	// -96 the ASCII value gives actual value of the char in int 
	if (tempAns >= 10) { 
	//if there is a carry 
	tempAns = tempAns - 10; 
	//tempAns now contains the unit digit after addition 
	ans = tempAns + ans; 
	carry = 1; //assign 1 to carry 
	} else { 
	ans = tempAns + ans; //case of no carry 
	carry = 0; 
	} 
	smallerStringIndex--; //reduce index by 1 
	} 
	if (carry == 1) { 
	ans = "1" + ans; 
	//adding String "1" to final result if at the 
	//end the last digits add up to give a carry 
	} 
	return ans; //return result in String 
	} 
}