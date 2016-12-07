import java.util.Scanner;

public class Rule30Thread extends Thread {
    public static final int MIN = 1;
    public static final int MAX = 1000;
    public static final int THREAD_COUNT = 10;
	private int min;
    private int max;
    private int maxGenerationCount;
    private int intWithMaxGenerationCount;
    private boolean solved = false;
    
	public Rule30Thread(int min, int max) {
        if (min >= max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        this.min = min;
        this.max = max;
    }
	
	public void run() {
        int maxGenerationCount = 0;
        int intWithMaxGenerationCount = 0;
        for (int i = min; i <= max; i++) {
            int generation = countGeneration(i);
            if (generation > maxGenerationCount) {
                maxGenerationCount = generation;
                intWithMaxGenerationCount = i;
            }
        }
        
        this.intWithMaxGenerationCount = intWithMaxGenerationCount;
        this.maxGenerationCount = maxGenerationCount;
        processGeneration();
        this.solved = true;   
	}
	
	private int countGeneration(int N) {
        int count = MAX;
        return count;
    }
	
	public int getMaxGenerationCount() throws Exception {
        if (!solved) {
            throw new Exception("Not yet solved!");
        }
        return maxGenerationCount;
    }
	
	public int getIntWithMaxGenerationCount() throws Exception {
	        if (!solved) {
	            throw new Exception("Not yet solved!");
	        }
	        return intWithMaxGenerationCount;
	}
	
	public void processGeneration() {
		int generationsPerThread = MAX / THREAD_COUNT;
    	int start = MIN;
    	int end = start + generationsPerThread - 1;
    	
        int cells = generationsPerThread;
        boolean[][] arr = new boolean[cells][cells];

        int seedIndex = cells / 2;
        arr[0][seedIndex] = true;

        for (int i = min; i < cells; i++) {
            for (int j = 0; j < cells; j++) {

                boolean m = j - 1 >= 0 ? arr[i - 1][j - 1] : false;
                boolean n = arr[i - 1][j];
                boolean o = j + 1 < cells ? arr[i - 1][j + 1] : false;
                if ((m && n) || (m && o) || (!m && !n && !o)) {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        printGeneration(arr);
    }

    public void printGeneration(boolean[][] arr) {
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


