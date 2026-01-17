import java.io.IOException;
import java.io.InputStream;
//codeforces 1073 - div 2 - D
public class SubRBSEasy{
    public static void main(String[] args) throws Exception {
        FastScanner fs =new FastScanner(System.in);
        int t=fs.nextInt();
        StringBuilder out = new StringBuilder();
        for (int caseIdx = 0; caseIdx < t; caseIdx++) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            int[] suffixOpen = new int[n + 2];
            for (int i = n - 1; i >= 0; i--)suffixOpen[i] = suffixOpen[i + 1] + (s[i] == '(' ? 1 : 0);
            boolean possible = false;
            for (int i = 0; i < n; i++){
                if (s[i] == ')'&&suffixOpen[i + 1] >= 2) {
                    possible=true;
                    break;
                }
            }
            if (caseIdx > 0)out.append('\n');
            out.append(possible ? n - 2 : -1);
        }
        System.out.print(out);
    }
//Skeleton for Fast Input
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

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) {
                    return null;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
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
