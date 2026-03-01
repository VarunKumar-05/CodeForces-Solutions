import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class problemA1084div3 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-->0){
            int n =sc.nextInt();
            int[] a =new int[n];
            for (int i=0;i<n;i++)a[i] = sc.nextInt();
            boolean[] canWin=new boolean[n];
            int winCount=0;
            for (int start =0;start<n;start++) {
                int[] rem =a.clone();
                int total =0;
                for (int x : rem)total += x;
                int curr =start;
                int lastEater= -1;
                while (total >0) {
                    if (rem[curr] > 0) {
                        rem[curr]--;
                        total--;
                        lastEater=curr;
                    }
                    curr =(curr+1) % n;
                }
                if (!canWin[lastEater]) {
                    canWin[lastEater] = true;
                    winCount++;
                }
            }
            out.append(winCount).append("\n");
        }
        System.out.print(out);
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