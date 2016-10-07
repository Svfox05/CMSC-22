
import java.util.Scanner;
public class HugeIntegerTest {
    
    /** Creates a new instance of HugeIntegerTest */
    public HugeIntegerTest() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HugeInteger i, j;
        
        Scanner input = new Scanner(System.in);
        String s;
        
        System.out.print("First number ==> ");
        s = input.nextLine();
        i = new HugeInteger(s);
        System.out.print("Second number ==> ");
        s = input.nextLine();
        j = new HugeInteger(s);
        
        
        System.out.println("The first number is " + i.toString());
        System.out.println("The second number is " + j.toString());
        System.out.println(i.toString() + " == " + j.toString() + " : " + i.isEqualTo(j));
        System.out.println(i.toString() + " != " + j.toString() + " : " + i.isNotEqualTo(j));
        System.out.println(i.toString() + " > " + j.toString() + " : " + i.isGreaterThan(j));
        System.out.println(i.toString() + " >= " + j.toString() + " : " + i.isGreaterThanOrEqualTo(j));
        System.out.println(i.toString() + " < " + j.toString() + " : " + i.isLessThan(j));
        System.out.println(i.toString() + " <= " + j.toString() + " : " + i.isLessThanOrEqualTo(j));
        System.out.println(i.toString() + " + " + j.toString() + " = " + (i.add(j)).toString());
        System.out.println(i.toString() + " - " + j.toString() + " = " + (i.subtract(j)).toString());
    }    
}