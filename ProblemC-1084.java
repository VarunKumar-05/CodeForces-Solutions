import java.io.InputStream;
import java.io.IOException;

public class ProblemC {
    public static void main(String[] args) throws IOException {
        FastScanner sc =new FastScanner(System.in);
        int t = sc.nextInt();
        StringBuilder out =new StringBuilder();
        while (t-- >0) {
            int n =sc.nextInt();
            String s =sc.next();
            char[] stack =new char[n];
            int top =0;
            for (int i =0; i < n; i++) {
                char c =s.charAt(i);
                if (top > 0 && stack[top - 1]==c)top--;
                else stack[top++] =c;
            }
            if (top == 0)out.append("YES\n");
            else out.append("NO\n");
        }
        System.out.print(out);
    }

    //skeleton for fast scanner
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
                if (c == -1) return Long.MIN_VALUE;
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

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            StringBuilder res = new StringBuilder();
            while (c > ' ') {
                res.appendCodePoint(c);
                c = read();
            }
            return res.toString();
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
    }
}
