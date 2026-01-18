import java.io.IOException;
import java.io.InputStream;

public class PerfectRoots {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t=fs.nextInt();
        StringBuilder out=new StringBuilder();
        for (int caseIdx=0;caseIdx<t;caseIdx++) {
            int n = fs.nextInt();
            for (int i=1;i<=n;i++){
                if (i > 1)out.append(' ');
                out.append(i);
            }
            if (caseIdx+1<t)out.append('\n');
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
