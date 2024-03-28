import java.io.File;
import java.util.Scanner;

// Enos Salar Azwar - es21020
// Osaed Saadi Najeh - os17180

public class Main {
    public static void main(String[] args) {
        String pathDirectory = getPathDirectoryFromUser();
        File directory = new File(pathDirectory);

        CalculationResult oneThreadCalc = DirectorySizeCalculator.calculateDirectorySize(directory, 1, false);
        CalculationResult threeThreadCalc = DirectorySizeCalculator.calculateDirectorySize(directory, 3, false);
        CalculationResult twentyThreadPoolCalc = DirectorySizeCalculator.calculateDirectorySize(directory, 20, true);
        CalculationResult cpuCoresThreadPoolCalc = DirectorySizeCalculator.calculateDirectorySize(directory, Settings.cpuCoresPlusOne, true);

        printDivider();
        System.out.println(oneThreadCalc);
        printDivider();
        System.out.println(threeThreadCalc);
        printDivider();
        System.out.println(twentyThreadPoolCalc);
        printDivider();
        System.out.println(cpuCoresThreadPoolCalc);
        printDivider();
    }

    public static String getPathDirectoryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the directory: ");
        return scanner.nextLine();
    }

    public static void printDivider(){
        System.out.println("------------------------------------");
    }
}

