import java.io.IOException;
import java.io.InputStream;

public class Problemcf1076div3 {
    public static void main(String[] args) throws Exception {
        FastScanner fs=new FastScanner(System.in);
        int t=fs.nextInt();
        StringBuilder out=new StringBuilder();
        while (t-->0){
            int n=fs.nextInt();
            int q=fs.nextInt();

            int[] a=new int[n];
            int[] b=new int[n];
            for (int i =0; i<n;i++) a[i]= fs.nextInt();
            for (int i =0; i<n;i++) b[i]= fs.nextInt();

            long[] best = new long[n];
            long suffixMax = 0;
            for (int i = n - 1; i >= 0; i--) {
                long cur = Math.max(a[i], b[i]);
                if (suffixMax>cur)cur=suffixMax;
                best[i]=cur;
                suffixMax=cur;
            }

            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + best[i];

            for (int qi = 0; qi < q; qi++) {
                int l = fs.nextInt();
                int r = fs.nextInt();
                long ans = prefix[r] - prefix[l - 1];
                if (qi > 0) out.append(' ');
                out.append(ans);
            }
            if (t > 0) out.append('\n');
        }
        System.out.print(out.toString());
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
