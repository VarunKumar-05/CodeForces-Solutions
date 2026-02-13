import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-- >0){
            int n = sc.nextInt();
            int[] a=new int[n + 1];
            for (int i = 1;i<=n; i++)a[i]=sc.nextInt();
            int B = Math.max(1, (int) Math.sqrt(n));
            long count=0;
            for (int v = 1; v <= B; v++) {
                for (int j = 1; j <= n; j++) {
                    long ii = (long) j - (long) v * a[j];
                    if (ii >= 1 && ii<=n&&a[(int)ii]==v)count++;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (a[i] > B) {
                    for (int m = 1; ; m++) {
                        long jj = (long) i + (long) a[i] * m;
                        if (jj > n) break;
                        if (a[(int) jj] == m) count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }System.out.print(sb);
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

        String nextString() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
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

