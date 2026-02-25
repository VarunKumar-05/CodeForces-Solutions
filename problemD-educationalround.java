import java.io.*;
import java.util.*;

public class problemCeducationalround {
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while (t-- >0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int maxVal = n+m;
			Set<Integer> setA = new HashSet<>();
			for (int i=0;i<n;i++) {
				setA.add(sc.nextInt());
			}
			int[] bArr = new int[m];// B array 
			for (int i=0;i<m;i++) {
				bArr[i] = sc.nextInt();
            }
			boolean[] divByA = new boolean[maxVal + 1];
			for (int x : setA) {
				for (int mul=x;mul<=maxVal;mul+=x) {
					divByA[mul] = true;
				}
			}

			long lcmA =1;// finding lcm of set A 
			boolean lcmOverflow=false;
			for (int x : setA) {
				long g = gcd(lcmA, x);
				lcmA = lcmA /g*x;
				if (lcmA > maxVal) {
					lcmOverflow = true;
					break;
				}
			}
			int c2 = 0, c3 = 0;
			for (int y : bArr) {
				if (!divByA[y]) c3++;
				else if (!lcmOverflow && y % lcmA == 0) c2++;
			}
			int c1 = m - c2 - c3;
			String result;
			if (c2 > c3 || (c2 == c3 && c1 % 2 == 1)) {
				result = "Alice";
			} else {
				result = "Bob";
			}
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

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
