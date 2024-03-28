public class CalculationResult {
    private final long timeTaken;
    private final int threadsUsed;
    private final boolean isThreadPoolUsed;
    private final FileSizeUsage fileSizeUsage;

    @Override
    public String toString() {
        return "Total time taken: " + ((double) timeTaken / 1000000.0) + " milliseconds\n" +
                "Directory size: " + fileSizeUsage.getSize() + " bytes\n" +
                "Threads used: " + threadsUsed + "\n" +
                "Is Thread pool used: " + isThreadPoolUsed;
    }

    public CalculationResult(long timeTaken, int threadsUsed, boolean isThreadPoolUsed, FileSizeUsage fileSizeUsage) {
        this.timeTaken = timeTaken;
        this.threadsUsed = threadsUsed;
        this.isThreadPoolUsed = isThreadPoolUsed;
        this.fileSizeUsage = fileSizeUsage;
    }
}
