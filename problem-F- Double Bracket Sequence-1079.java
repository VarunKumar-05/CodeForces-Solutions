import java.util.*;
import java.io.*;
public class Solution{
    
    public static int solve(String s){
        int roundOpen=0;
        int squareOpen=0;
        int matches=0;
        for(char c: s.toCharArray()){
            if(c=='(')roundOpen++;
            else if(c==')'){
                if(roundOpen>0){
                    matches++;
                    roundOpen--;
                }
            }else if(c=='[')squareOpen++;
            else if(c==']'){
                if(squareOpen>0){
                    matches++;
                    squareOpen--;
                }
            }
        }
        return (s.length()/2)-matches;
    }
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.nextString();
            sb.append(solve(s)).append('\n');
        }
        System.out.print(sb);
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
