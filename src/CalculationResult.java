public class CalculationResult {
    private final long timeTakenInNano;
    private final int threadsUsed;
    private final boolean isThreadPoolUsed;
    private final FileSizeUsage fileSizeUsage;

    @Override
    public String toString() {
        return "Total time taken: " + ((double) timeTakenInNano / 1000000.0) + " milliseconds\n" +
                "Directory size: " + fileSizeUsage.getSize() + " bytes\n" +
                "Threads used: " + threadsUsed + "\n" +
                "Is Thread pool used: " + isThreadPoolUsed;
    }

    public CalculationResult(long timeTakenInNano, int threadsUsed, boolean isThreadPoolUsed, FileSizeUsage fileSizeUsage) {
        this.timeTakenInNano = timeTakenInNano;
        this.threadsUsed = threadsUsed;
        this.isThreadPoolUsed = isThreadPoolUsed;
        this.fileSizeUsage = fileSizeUsage;
    }
}
