import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
public class MexShift{
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out=new StringBuilder();
        for (int caseIdx=0;caseIdx<t;caseIdx++) {
            int n = fs.nextInt();
            Set<Integer> values = new HashSet<>();
            for (int i=0;i<n;i++)values.add(fs.nextInt());
            int best=0;
            for (int v:values) {
                if (!values.contains(v -1)){
                    int len=0;
                    long cur=v;
                    while (values.contains((int) cur)){
                        len++;
                        cur++;
                    }
                    if (len > best)best=len;
                }
            }
            if (caseIdx + 1 < t)out.append(best).append('\n');
            else out.append(best);
            
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
