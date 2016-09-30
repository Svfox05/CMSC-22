import java.util.*;


class StringStack1{
	private String[] elements;
	private int count;
	public static final int DEFAULT_SIZE =10;


public StringStack1(){

	elements = new String[DEFAULT_SIZE];
	
}

public StringStack1(int size){
	if(size<=0)
		throw new IllegalArgumentException("Size cannpt be less than 0");
	else
		elements = new String[size];
}


public int size(){
	return count;
}

public int getSize(){
	return elements.length;
}

public void push(String item){
	
	if(count >= getSize()){
		String[] tmp = new String[getSize()+5];

		for(int i =0; i<getSize();i++){
			tmp[i] = elements[i];
		}
		elements = tmp;

	}

	elements[count] = item;
	count++;
}

public String pop(){
	
	if(count<=0)
		throw new ArrayIndexOutOfBoundsException("The stack is empty"); 
	
	else{	
		count = count - 1;
		return elements[count];
	}
}

public String toString(){
	if(count == 0){
		return "Stack is Emtpy";

	}

	String str = "";

	for(int i =0 ; i<count-1;i++){
		str = str + elements[i] + ", ";
	}

	return str + elements[count-1];
}

public String peek(){
	if(count == 0)
		throw new IllegalArgumentException("The stack is empty");

	else
		return elements[count-1];	
}

public String pop(int n){
	if(count< n)
		throw new IllegalArgumentException("Elements is less than desired number of elemtents to be removed");

	else{
		String str = "";
		
		while(n>0){
			str = pop();
			n--;
		}

		return str;
	}
}

public static void main(String[] args) {
        StringStack1 stack = new StringStack1(2);
        stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
        System.out.println(stack); // paper, plastic, tissue
        System.out.println(stack.size()); // 3
        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();
		

		stack.push("paper");
        stack.push("plastic");
        stack.push("tissue");
		String item4 = stack.pop(2);

        System.out.println(item1); // tissue
        System.out.println(item2); // plastic
        System.out.println(item3); // paper
       System.out.println(item4); //paper
        System.out.println(stack); // EMPTY
        System.out.println(stack.size()); // 0
    }
 }