import java.io.*;

public class allinonegunproblemc{
    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        while (t-- >0) {
            int n =sc.nextInt();
            long h= sc.nextLong();
            long k =sc.nextLong();
            long[] a =new long[n];
            for (int i =0; i<n;i++) a[i]=sc.nextLong();
            long S =0;
            for (long x : a)S+=x;
            long[] prefix =new long[n + 1];
            for (int i=0;i <n;i++) prefix[i +1]=prefix[i] +a[i];
            long[] minLeft =new long[n+1];
            minLeft[1]=a[0];
            for (int i=2;i<=n;i++) minLeft[i]=Math.min(minLeft[i-1],a[i-1]);
            long[] maxRight =new long[n];
            maxRight[n - 1] =a[n -1];
            for (int i =n- 2;i >= 0; i--)maxRight[i]=Math.max(maxRight[i+1], a[i]);
            long ans = Long.MAX_VALUE;
            {
                long full =(h+S-1)/S;
                long time =full*n +(full- 1)* k;
                ans = Math.min(ans, time);
            }
            for (int extra=1;extra<=n;extra++) {
                long best;
                if (extra <n)best=prefix[extra] +Math.max(0, maxRight[extra] -minLeft[extra]);
                else best =S;
                

                if (best >=h)ans =Math.min(ans,(long)extra);
                else {
                    long remaining = h-best;
                    long full =(remaining+S-1)/S;
                    long time =full*((long) n + k) + extra;
                    ans =Math.min(ans,time);
                }
            }sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
//fast scanner skeleton
    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int nextInt() throws IOException { return (int) nextLong(); }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return Long.MIN_VALUE;
            }
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return neg ? -val : val;
        }

        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            StringBuilder sb = new StringBuilder();
            while (c > ' ') { sb.append((char) c); c = read(); }
            return sb.toString();
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
