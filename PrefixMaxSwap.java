import java.io.IOException;
import java.io.InputStream;

public class PrefixMaxSwap{
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
        for (int caseIdx=0;caseIdx<t;caseIdx++){
            int n=fs.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n; i++)arr[i] = fs.nextInt();//input 
            long best = prefixValue(arr);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++){
                    swap(arr,i,j);
                    best=Math.max(best, prefixValue(arr));
                    swap(arr,i,j);
                }
            }
            if(caseIdx+1<t)out.append(best).append('\n');
            else out.append(best);
        }
        System.out.print(out);
    }

    private static long prefixValue(int[] arr) {
        long sum = 0;
        int currentMax = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > currentMax) {
                currentMax = value;
            }
            sum += currentMax;
        }
        return sum;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
// skeleton for Fast Input
    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return Long.MIN_VALUE;
                }
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }
    }
}
