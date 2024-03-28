import java.util.concurrent.locks.ReentrantLock;

public class FileSizeUsage {
    private long size;
    private final ReentrantLock lock;

    public FileSizeUsage() {
        size = 0;
        lock = new ReentrantLock();
    }

    public long getSize() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

    public void setSize(long newSize) {
        lock.lock();
        try {
            size = newSize;
        } finally {
            lock.unlock();
        }
    }

    public void addSize(long extraSize) {
        lock.lock();
        try {
            size += extraSize;
        } finally {
            lock.unlock();
        }
    }
}
