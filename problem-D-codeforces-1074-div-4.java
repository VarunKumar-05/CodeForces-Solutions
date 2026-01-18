import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ProblemDCodeforces1074Div4{
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out=new StringBuilder();
        for (int caseIdx=0;caseIdx < t;caseIdx++) {
            int n=fs.nextInt();
            int m=fs.nextInt();
            int h=fs.nextInt();
            long[] original=new long[n];
            long[] current=new long[n];
            for (int i=0;i<n;i++){
                long val = fs.nextLong();
                original[i]=val;
                current[i]=val;
            }
            for (int op=0;op<m;op++) {
                int idx=fs.nextInt()-1;
                long add=fs.nextLong();
                long newVal=current[idx]+add;
                long diff=newVal-(long)h-1L;
                boolean crash = (diff >>> 63) == 0;
                if (crash) System.arraycopy(original, 0, current, 0, n);
                else current[idx] = newVal;
            }
            for (int i=0;i<n;i++){
                if (i > 0)out.append(' ');
                out.append(current[i]);
            }
            if (caseIdx + 1 < t)out.append('\n');
        }
        System.out.print(out);
    }
//skeleton for Fast Input
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
