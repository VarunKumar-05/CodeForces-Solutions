import java.io.IOException;
import java.io.InputStream;
//codeforces 1073 -div 2-A
public class VadimsHourglass {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out=new StringBuilder();
        for (int i=0;i<t;i++){
            long s=fs.nextLong();
            long k=fs.nextLong();
            long m=fs.nextLong();
            long flips=m/k;
            long remainder=m%k;

            long current;
            if (k>=s){
                current=s;
            }else{
                current=(flips%2==0)?s:k;
            }

            long answer=current-remainder;
            if (answer<0) {
                answer=0;
            }

            out.append(answer);
            if (i+1<t) {
                out.append('\n');
            }
        }
        System.out.print(out);
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
            while ((c=read())<=' '){
                if (c==-1) {
                    return Long.MIN_VALUE;
                }
            }
            boolean neg=false;
            if (c=='-') {
                neg=true;
                c=read();
            }
            long val=0;
            while (c>' ') {
                val=val * 10 + (c - '0');
                c=read();
            }
            return neg ? -val : val;
        }

        private int read() throws IOException {
            if (ptr>=len) {
                len=in.read(buffer);
                ptr=0;
                if (len<=0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }
    }
}
