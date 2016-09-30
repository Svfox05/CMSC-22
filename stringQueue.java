class StringQueue{
	
	private String [] elements;
	private int count;
	public static final int DEFAULT_SIZE =5;

	public StringQueue(){
		elements = new String[DEFAULT_SIZE];
	}

	public int size(){
		return count;
	}

	public int getSize(){
		return elements.length;
	}

	public void enqueue(String item){
		
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

	public String dequeue(){
		if(count==0)
			throw new IllegalArgumentException("The queue is empty");

		else{
			String str = elements[0];
			for(int i =0;i<count;i++){
				elements[i] = elements[i+1];
			}
			count--;

			return str;

		}		

	}

	public String dequeue(int n){
		if(count<n)
			throw new IllegalArgumentException("Elements is less than desired number of elemtents to be removed");

		else{
			String str = "";
			while(n>0){
				str = dequeue();

				n--;
			}
			return str;
	}
}

	public void singit(int pos, String item){
		if(pos<0 || pos>getSize())
			throw new ArrayIndexOutOfBoundsException("Position cannot be found");

		else{
			if(pos>count)
				enqueue(item);
			
			else{
				pos=pos-1;
				for(int i = count;i>pos;i--){
					elements[i] = elements[i-1]; 
				}

				elements[pos] = item;
				count++;
			}
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
			return elements[0];	
	}



	public static void main(String[] args) {
        StringQueue que = new StringQueue();
        que.enqueue("paper");
        que.enqueue("plastic");
        que.enqueue("tissue");
        que.enqueue("rock");
        que.enqueue("scissors");
        que.enqueue("bottle");
        System.out.println(que); // paper, plastic, tissue
        System.out.println(que.size()); // 3
        String item1 = que.dequeue();
        String item2 = que.dequeue();
        String item3 = que.dequeue(2);

		System.out.println(que);

		que.enqueue("paper");
        que.enqueue("plastic");
        que.enqueue("tissue");
        System.out.println(que);
		que.singit(5,"cloth");
	
        System.out.println(item1); // tissue
        System.out.println(item2); // plastic
        System.out.println(item3); // paper
      //  System.out.println(item4); //paper
        System.out.println(que); // EMPTY
        System.out.println(que.size()); // 0
    }

	
}