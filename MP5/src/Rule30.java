import java.util.Scanner;

public class Rule30 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        boolean[][] arr = new boolean[x][x];

        
        int seedIndex = x / 2;
        arr[0][seedIndex] = true;

        for (int i = 1; i < x; i++) {
            for (int j = 0; j < x; j++) {

                boolean m = j - 1 >= 0 ? arr[i - 1][j - 1] : false;
                boolean n = arr[i - 1][j];
                boolean o = j + 1 < x ? arr[i - 1][j + 1] : false;
                if ((m && n) || (m && o) || (!m && !n && !o)) {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        print(arr);
    }

    public static void print(boolean[][] arr) {
        for (boolean[] boolArr : arr) {
            for (boolean bool : boolArr) {
                if (bool) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }
}
