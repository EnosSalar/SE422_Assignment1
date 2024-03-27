import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the directory: ");
        String pathDirectory = scanner.nextLine();

        calculateDirectorySize(pathDirectory, 5, false);

    }

    public static void calculateDirectorySize(String pathDirectory, int threads, boolean useThreadPool) {
        File file = new File(pathDirectory);
        File[] files = file.listFiles();
        if (files == null) {
            System.err.println("The directory provided does not contain any files");
            return;
        }
        int fileCount = files.length;
        int fileCountPerThread = fileCount / threads;
        int remainder = fileCount % threads;
        FileSizeUsage fileSizeUsage = new FileSizeUsage();
        for (int i = 0 ; i < threads; i++){
            FileSizeCalculatorThread fileSizeCalculatorThread = new FileSizeCalculatorThread(fileSizeUsage);
            fileSizeCalculatorThread.start();
        }

    }
}

