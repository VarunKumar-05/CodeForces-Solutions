
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ProblemD1076Div3 {
	public static void main(String[] args) throws Exception {
		FastScanner fs =new FastScanner(System.in);
		int t =fs.nextInt();
		StringBuilder out =new StringBuilder();
		for (int caseIdx =0; caseIdx < t; caseIdx++) {
			int n =fs.nextInt();
			int[] a =new int[n];
			int[] b =new int[n];
			for (int i =0;i < n; i++)a[i] =fs.nextInt();
			for (int i =0;i < n; i++)b[i] =fs.nextInt();
			Arrays.sort(a);
			long[] prefixB =new long[n + 1];
			for (int i =0;i<n;i++)prefixB[i + 1] =prefixB[i] + b[i];

			long bestScore = 0;

			int idx =n - 1;
			long used=0; 
			while (idx >=0) {
				int val =a[idx];
				int j =idx;
				while (j >= 0 && a[j] == val) j--;
				int cntThis =idx - j;
				used +=cntThis;
				int levels =maxLevels(prefixB, used);
				long score =(long) val * levels;
				if (score>bestScore)bestScore = score;
				idx = j;
			}

			out.append(bestScore);
			if (caseIdx + 1 < t) out.append('\n');
		}
		System.out.print(out.toString());
	}

	private static int maxLevels(long[] prefixB, long swordsAvailable) {
		int n = prefixB.length - 1;
		int lo=0,hi=n;
		while (lo< hi) {
			int mid=(lo + hi + 1)>>>1;
			if (prefixB[mid] <= swordsAvailable) lo=mid;
			else hi=mid-1;
		}
		return lo;
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
