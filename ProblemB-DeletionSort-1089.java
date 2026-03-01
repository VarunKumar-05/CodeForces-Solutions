    import java.util.*;
    import java.io.*;

    class ProblemB {
        public static void main(String[] args) throws IOException {
            FastScanner sc =new FastScanner(System.in);
            int t = sc.nextInt();
            StringBuilder x =new StringBuilder();
            while (t-- >0){
                int n =sc.nextInt();
                int[] a =new int[n];
                boolean sorted =true;
                for (int i=0;i<n;i++) {
                    a[i] = sc.nextInt();
                    if (i>0 && a[i]<a[i-1])sorted = false;
                }
                if (sorted) x.append(n).append("\n");
                else x.append(1).append("\n");
                
            }
            System.out.print(x);
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
