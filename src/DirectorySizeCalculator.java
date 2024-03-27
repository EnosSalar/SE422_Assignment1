import java.io.File;

// Assignment 1 by Ossaid Saadi example@auis.edu.krd and ....
public class DirectorySizeCalculator {

    public static FileSizeUsage calculateDirectorySize(File directory, int threads, boolean useThreadPool) {

    }

}
/*public class DirectorySizeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the directory: ");
        String directoryPath = scanner.nextLine();

        scanner.close();

        // Task 2: Calculate size of given directory
        FileSizeUsage fileSizeUsage = new FileSizeUsage();
        long startTime = System.nanoTime();
        calculateDirectorySize(directoryPath, fileSizeUsage);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Print size and time for single thread
        System.out.println("Single Thread:");
        System.out.println("Directory size: " + fileSizeUsage.getSize() + " bytes");
        System.out.println("Time taken: " + elapsedTime + " nanoseconds");

        // Task 3: Print size and time for different number of threads
       
        int[] threadCounts = { 1, 3, 20, 4 }; 

        for (int count : threadCounts) {
            ExecutorService executor = Executors.newFixedThreadPool(count);
            fileSizeUsage.setSize(0); 
            startTime = System.nanoTime();
            for (int i = 0; i < count; i++) {
                executor.execute(() -> calculateDirectorySize(directoryPath, fileSizeUsage));
            }
            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println(count + " Threads:");
            System.out.println("Directory size: " + fileSizeUsage.getSize() + " bytes");
            System.out.println("Time taken: " + elapsedTime + " nanoseconds");
        }
    }

    // Method to calculate directory size
    private static void calculateDirectorySize(String directoryPath, FileSizeUsage fileSizeUsage) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileSizeUsage.setSize(fileSizeUsage.getSize() + file.length());
                    } else if (file.isDirectory()) {
                        calculateDirectorySize(file.getAbsolutePath(), fileSizeUsage);
                    }
                }
            }
        }
    }
}*/
