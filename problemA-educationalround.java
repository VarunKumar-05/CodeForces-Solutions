import java.io.*;

public class problemAeducationalround {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			int maxHeight=d/m+1; 
			int towers=(n+maxHeight-1)/maxHeight; 
			sb.append(towers).append('\n');
		}
		System.out.print(sb);
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