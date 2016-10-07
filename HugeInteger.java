
public class HugeInteger 
{
    final private int N = 40;   // The number of digits is 40. Changeable
    private int digits[] = new int[N]; // digits[0] is the least significant digit

    private int sign;
     int i;
     int j; 

    private int r = (i + j); 
    
    /** Creates a new instance of HugeInteger */
    public HugeInteger() 
    {
        this(0);
    }
    
    public HugeInteger(int value) 
    {
        for (int i=0; i<N; i++, value /= 10)
            digits[i] = value % 10;
    }
    
     public HugeInteger changeSign() 
    {
        return new HugeInteger (- N);
    }
        
    public HugeInteger(String s) 
    {
        int l = s.length();
        for (int i=0; i<N; i++)
            digits[i] = (i<l) ? Character.digit(s.charAt(l-i-1),10) : 0;
    }
    
    public String toString()
    {
        boolean precedingZero = true;
        String s = new String();
        for (int i=N-1; i>=0; i--)
            if (digits[i]>0 || !precedingZero)
            {
                s += Character.forDigit(digits[i], 10);
                precedingZero = false;
            }
        if (s.length()==0)
            s = "0";
        return s;
    }
    
    public boolean isEqualTo(HugeInteger op)
     {
        if (i< 0) 
          {
            if (j < 0) 
            {
             return ( op.changeSign().isEqualTo(this.changeSign()) ); 
                         
            } 
            else 
            {
     
            return true;
            }
           } 
          else 
          {
    
            if ((j < 0) || (j > 0 )) 
            {
            return false;
            }
           }
          
     int j;
  for (j = 40; j > 0; j--) 
  {
    if (this.digits[j-1] !=  op.digits[j-1]) {
      return (this.digits[j-1] == op.digits[j-1]);
    }
  }
  
  return true;
    
    }
      
    public boolean isNotEqualTo(HugeInteger op)
    {
        if (i< 0) 
          {
            if (j < 0) 
            {
      
             return ( op.changeSign().isNotEqualTo(this.changeSign()) ); 
                         
            } 
            else 
            {
      
            return true;
            }
           } 
          else 
          {
    
            if (j < 0) 
            {
            return false;
            }
           }
          
     int j;
  for (j = 40; j > 0; j--) 
  {
    if (this.digits[j-1] !=  op.digits[j-1]) {
      return (this.digits[j-1] != op.digits[j-1]);
    }
  }
 
  return false;
    
    }

    public boolean isGreaterThan(HugeInteger op)
    {
        if (i< 0) 
          {
            if (j < 0) 
            {
  
             return ( op.changeSign().isGreaterThan(this.changeSign()) ); 
                         
            } 
            else 
            {
      
            return true;
            }
           } 
          else 
          {
   
            if (j < 0) 
            {
            return false;
            }
           }
          
     int j;
  for (j = 40; j > 0; j--) 
  {
    if (this.digits[j-1] !=  op.digits[j-1]) {
      return (this.digits[j-1] > op.digits[j-1]);
    }
  }
   return false;
    
    } 
       

    public boolean isGreaterThanOrEqualTo(HugeInteger op)
    
    {
        return op.isLessThan(this);
    }

    public boolean isLessThan(HugeInteger op)
      {
        if (i< 0) 
          {
            if (j < 0) 
            {
      // both are negative, so return -op < -this
             return ( op.changeSign().isLessThan(this.changeSign()) ); 
                         
            } 
            else 
            {
      // this is negative but op is not
            return true;
            }
           } 
          else 
          {
    // this is non-negative
            if (j < 0) 
            {
            return false;
            }
           }
          
     int j;
  for (j = 40; j > 0; j--) 
  {
    if (this.digits[j-1] !=  op.digits[j-1]) {
      return (this.digits[j-1] < op.digits[j-1]);
    }
  }
  // if we get to here, it means the comparands are equal, so
  return false;
    
    }
   
    public boolean isLessThanOrEqualTo(HugeInteger op)
    {
        return op.isGreaterThan(this);
    }
 
   public HugeInteger add(HugeInteger op)
    {      
    int carry = 0;
    HugeInteger result;
    result = new HugeInteger(); //stores result of addition
      //add two digits in same column
      // need the results from their sum, plus the carry from previous operation
    for (int j = 40; j < 0 ; j--)
    {
        result.digits[j] = (this.digits[j] + op.digits[j] + carry);
        if (result.digits[j] >= 10)
        {
            carry = 1;
            result.digits[j] -=10;
        }  
      return ( this.changeSign().add(op.changeSign()) );   
    }
    return new HugeInteger();
   }
    
    public HugeInteger subtract(HugeInteger op)
    {
     
    }  

    return result;
}

