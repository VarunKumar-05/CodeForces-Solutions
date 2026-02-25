import java.io.*;
import java.util.*;

public class problemBeducationalround {
	public static void main(String[] args) throws IOException {
		FastScanner sc =new FastScanner(System.in);
		StringBuilder sb =new StringBuilder();
		int t = sc.nextInt();
		while (t-- > 0) {
			long x =sc.nextLong();
			String s=Long.toString(x);
			int n=s.length();
			if (n==1) {
				sb.append(0).append('\n');
				continue;
			}
			int[] digits = new int[n];
			for (int i=0; i<n; i++)digits[i] =s.charAt(i)-'0';
			int[] rem= new int[n - 1];
			for (int i=1;i<n; i++)rem[i-1]=digits[i];
			Arrays.sort(rem);

			int budgetA =9-digits[0];
			int keptA =0;
			int sum =0;
			for (int i=0; i<rem.length;i++) {
				if (sum + rem[i] <= budgetA) {
					sum += rem[i];
					keptA++;
				} else break;
			}
			int changesA =(n-1)-keptA;

			int keptB = 0;
			sum = 0;
			for (int i = 0; i < rem.length; i++) {
				if (sum +rem[i] <= 8) {
					sum +=rem[i];
					keptB++;
				} else break;
			}
			int changesB =1+(n-1)-keptB;

			sb.append(Math.min(changesA, changesB)).append('\n');
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