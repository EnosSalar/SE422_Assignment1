public class FileSizeCalculatorThread extends Thread{
    private FileSizeUsage fileSizeUsage;

    public void setFileSizeUsage(FileSizeUsage fileSizeUsage) {
        this.fileSizeUsage = fileSizeUsage;
    }

    public FileSizeUsage getFileSizeUsage() {
        return fileSizeUsage;
    }

    public FileSizeCalculatorThread(FileSizeUsage fileSizeUsage){
        setFileSizeUsage(fileSizeUsage);
    }

    @Override
    public void run() {

    }
}
