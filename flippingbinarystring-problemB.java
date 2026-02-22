import java.io.*;

public class flippingbinarystringproblemB{
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int t =sc.nextInt();
        StringBuilder sb =new StringBuilder();
        while (t-- >0){
            int n = sc.nextInt();
            String s =sc.next();
            int ones =0;
            for (int i=0;i<n;i++)if (s.charAt(i) =='1') ones++;
            int zeros=n-ones;
            if (ones % 2==0){
                sb.append(ones).append('\n');
                boolean first =true;
                for (int i=0;i<n;i++) {
                    if (s.charAt(i)=='1') {
                        if (!first) sb.append(' ');
                        sb.append(i+1);
                        first =false;
                    }
                }
                sb.append('\n');
            } else if (zeros % 2 == 1) {
                sb.append(zeros).append('\n');
                boolean first = true;
                for (int i =0;i<n;i++) {
                    if (s.charAt(i)=='0') {
                        if (!first) sb.append(' ');
                        sb.append(i + 1);
                        first = false;
                    }
                }sb.append('\n');
            } else sb.append(-1).append('\n');
        }
        System.out.print(sb);
    }
//skeleton for fast scanner
    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) { this.in = in; }

        int nextInt() throws IOException { return (int) nextLong(); }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') { if (c == -1) return Long.MIN_VALUE; }
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return neg ? -val : val;
        }

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ') { if (c == -1) return null; }
            StringBuilder sb = new StringBuilder();
            while (c > ' ') { sb.append((char) c); c = read(); }
            return sb.toString();
        }

        private int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
    }
}
