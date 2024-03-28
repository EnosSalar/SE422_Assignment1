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
            fileSizeUsage.addSize(file.length());
        }
    }
}
