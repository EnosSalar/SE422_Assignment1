import java.io.File;

public class FileSizeCalculatorThread extends Thread {
    private final FileSizeUsage fileSizeUsage;
    private final File[] files;


    public FileSizeUsage getFileSizeUsage() {
        return fileSizeUsage;
    }

    public FileSizeCalculatorThread(FileSizeUsage fileSizeUsage, File[] files) {
        this.fileSizeUsage = fileSizeUsage;
        this.files = files;
    }

    @Override
    public void run() {
        for (File file : files) {
            fileSizeUsage.addSize(calculateFolderSize(file));
        }
    }

    // Method source: ChatGPT
    public static long calculateFolderSize(File folder) {
        long size = 0;

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        size += calculateFolderSize(file); // Recursive call for subfolders
                    } else {
                        size += file.length(); // Add file size
                    }
                }
            }
        } else {
            size += folder.length(); // Add size of the file if it's not a directory
        }
        return size;
    }
}
