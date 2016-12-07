public class Rule30ThreadTester {

    public static final int MIN = 1;
    public static final int MAX = 1000;
    public static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws Exception {
    	Rule30Thread test = new Rule30Thread(MIN, MAX);
    	
    	long startTime = System.currentTimeMillis();
        int globalMaxGenerationCount = 0;
        int whichInt = 0;
    	
    	Rule30Thread[] worker = new Rule30Thread[THREAD_COUNT];
    	
    	int generationsPerThread = MAX / THREAD_COUNT;
    	int start = MIN;
    	int end = start + generationsPerThread - 1;
    	
    	for (int i = 0; i < THREAD_COUNT; i++) {
            if (i == THREAD_COUNT - 1) {
                end = MAX;
            }
            worker [i] = new Rule30Thread(start, end);
            start = end + 1;
            end = start + generationsPerThread - 1;
    	}
    	
    	for (int i = 0; i < THREAD_COUNT; i++) {
            worker[i].start();
        }
    	
    	for (int i = 0; i < THREAD_COUNT; i++) {
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                } catch (InterruptedException e) {
                    System.err.println("thread interrupted: " + e.getMessage());
                }
            }
        }
    	
    	for (int i = 0; i < THREAD_COUNT; i++) {
            if (globalMaxGenerationCount < worker[i].getMaxGenerationCount()) {
                globalMaxGenerationCount = worker[i].getMaxGenerationCount();
                whichInt = worker[i].getIntWithMaxGenerationCount();
            }
        }
    	
    	System.out.println("RULE 30: " + MAX + " Generations");
    	test.run();
    	System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
    } 
}
