import java.io.File;
import java.util.Arrays;

// Source ChatGPT, with modifications to suit File type
public class ArrayDivider {
    public static File[][] divideArray(File[] array, int parts) {
        File[][] dividedArrays = new File[parts][];

        int chunkSize = array.length / parts;
        int remainder = array.length % parts;

        int startIndex = 0;
        for (int i = 0; i < parts; i++) {
            int size = chunkSize + (i < remainder ? 1 : 0);
            dividedArrays[i] = Arrays.copyOfRange(array, startIndex, startIndex + size);
            startIndex += size;
        }

        return dividedArrays;
    }
}
