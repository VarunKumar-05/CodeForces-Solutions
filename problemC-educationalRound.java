import java.io.*;

public class problemCeducationalround {
	public static void main(String[] args) throws IOException {
		FastScanner sc=new FastScanner(System.in);
		StringBuilder sb=new StringBuilder();
		int t=sc.nextInt();
		while (t-- > 0){
			long s=sc.nextLong();
			long m=sc.nextLong();

			if (!feasible(s, m, s)){
				sb.append(-1).append('\n');
				continue;
			}
			long lo=1, hi=s;
			while (lo < hi){
				long mid=lo +(hi-lo)/2;
				if (feasible(s, m, mid))hi=mid;
				else lo=mid + 1;
			}
			sb.append(lo).append('\n');
		}
		System.out.print(sb);
	}

	static boolean feasible(long s, long m, long n) {
		long deficit=s;
		for (int j=59; j >= 0; j--){
			if (((m >> j) & 1) == 1){
				long use=Math.min(n, deficit >> j);
				deficit-=use << j;
			}
		}
		return deficit == 0;
	}
//skeleton for fast scanner
	private static final class FastScanner {
		private final InputStream in;
		private final byte[] buffer=new byte[1 << 16];
		private int ptr=0;
		private int len=0;

		FastScanner(InputStream in) {
			this.in=in;
		}

		int nextInt() throws IOException {
			return (int) nextLong();
		}

		long nextLong() throws IOException {
			int c;
			while ((c=read()) <= ' ') {
				if (c == -1) return Long.MIN_VALUE;
			}
			boolean neg=false;
			if (c == '-') {
				neg=true;
				c=read();
			}
			long val=0;
			while (c > ' ') {
				val=val * 10 + (c - '0');
				c=read();
			}
			return neg ? -val : val;
		}

		private int read() throws IOException {
			if (ptr >= len) {
				len=in.read(buffer);
				ptr=0;
				if (len <= 0) return -1;
			}
			return buffer[ptr++];
		}
	}
}