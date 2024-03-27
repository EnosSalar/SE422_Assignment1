import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathDirectory = getPathDirectoryFromUser();
        File directory = new File(pathDirectory);

        FileSizeUsage f1 = DirectorySizeCalculator.calculateDirectorySize(directory, 1, false);
        FileSizeUsage f2 = DirectorySizeCalculator.calculateDirectorySize(directory, 3, false);
        FileSizeUsage f3 = DirectorySizeCalculator.calculateDirectorySize(directory, 20, true);
        FileSizeUsage f4 = DirectorySizeCalculator.calculateDirectorySize(directory, Runtime.getRuntime().availableProcessors() + 1, true);

    }

    public static String getPathDirectoryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the directory: ");
        return scanner.nextLine();
    }


}

