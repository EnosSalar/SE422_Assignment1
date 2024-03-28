import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DirectorySizeCalculator {

    public static CalculationResult calculateDirectorySize(File directory, int threads, boolean useThreadPool) {
        long startTime = System.nanoTime();
        FileSizeUsage fileSizeUsage = new FileSizeUsage();
        FileSizeCalculatorThread[] fileSizeCalculatorThreads = new FileSizeCalculatorThread[threads];
        File[][] filesSegmented = ArrayDivider.divideArray(directory.listFiles(), threads);

        for (int i = 0; i < filesSegmented.length; i++) {
            fileSizeCalculatorThreads[i] = new FileSizeCalculatorThread(fileSizeUsage, filesSegmented[i]);
        }

        if (useThreadPool) {
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (FileSizeCalculatorThread thread : fileSizeCalculatorThreads) {
                pool.execute(thread);
            }
            try {
                pool.shutdown();
                pool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        } else {
            for (Thread thread : fileSizeCalculatorThreads){
                thread.start();
            }
            for (Thread thread : fileSizeCalculatorThreads){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        CalculationResult calculationResult = new CalculationResult(timeTaken,threads,useThreadPool,fileSizeUsage);
        return calculationResult;
    }

}
