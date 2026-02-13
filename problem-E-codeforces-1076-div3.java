import java.io.IOException;
import java.io.InputStream;

public class ProblemECodeforces1076Div3 {
	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);
		int t = fs.nextInt();
		StringBuilder out = new StringBuilder();
		while (t-- > 0) {
			int n = fs.nextInt();
			boolean[] has = new boolean[n + 1];
			for (int i = 0; i < n; i++) {
				int v = fs.nextInt();
				if (v <= n) has[v] = true;
			}
			int[] dp = new int[n + 1];
			final int INF = 1_000_000_000;
			for (int i = 1; i <= n; i++) dp[i] = INF;
			if (has[1]) dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				if (has[i]) dp[i] = 1;
				int limit = (int) Math.sqrt(i);
				for (int d = 2; d <= limit; d++) {
					if (i % d != 0) continue;
					int other = i / d;
					if (has[d] && dp[other] != INF) dp[i] = Math.min(dp[i], dp[other] + 1);
					if (other != d && has[other] && dp[d] != INF) dp[i] = Math.min(dp[i], dp[d] + 1);
				}
			}

			for (int i = 1; i <= n; i++) {
				int ans = dp[i] == INF ? -1 : dp[i];
				if (i > 1) out.append(' ');
				out.append(ans);
			}
			if (t > 0) out.append('\n');
		}
		System.out.print(out.toString());
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
