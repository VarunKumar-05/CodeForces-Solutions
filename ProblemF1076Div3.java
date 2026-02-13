import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ProblemF1076Div3 {
    private static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            long Ax =fs.nextLong();
            long Ay =fs.nextLong();
            long Bx =fs.nextLong();
            long By=fs.nextLong();
            long[] pair = new long[n];
            for (int i =0;i < n; i++)pair[i] = fs.nextLong();
            for (int i =0;i < n; i++){
                long y =fs.nextLong();
                pair[i] = (pair[i] << 32)|(y & 0xffffffffL);
            }
            Arrays.sort(pair);
            int m = 0;
            long[] xs = new long[n];
            long[] minY = new long[n];
            long[] maxY = new long[n];
            for (int i = 0; i < n; ) {
                long packed = pair[i];
                long x = packed >>> 32;
                long y = packed & 0xffffffffL;
                long lo = y, hi = y;
                int j = i + 1;
                while (j < n && (pair[j] >>> 32) == x) {
                    long yy = pair[j] & 0xffffffffL;
                    if (yy < lo) lo = yy;
                    if (yy > hi) hi = yy;
                    j++;
                }
                xs[m] = x;
                minY[m] = lo;
                maxY[m] = hi;
                m++;
                i = j;
            }

            long prevX = Ax;
            long costEndAtMin = Long.MAX_VALUE / 4;
            long costEndAtMax = Long.MAX_VALUE / 4;

            // first group
            long dx = xs[0] - prevX;
            costEndAtMin = dx + visitCost(Ay, minY[0], maxY[0], true);
            costEndAtMax = dx + visitCost(Ay, minY[0], maxY[0], false);
            prevX = xs[0];

            for (int idx = 1; idx < m; idx++) {
                dx = xs[idx] - prevX;
                long spanCostMinFromMin = costEndAtMin + dx + visitCost(minY[idx - 1], minY[idx], maxY[idx], true);
                long spanCostMaxFromMin = costEndAtMin + dx + visitCost(minY[idx - 1], minY[idx], maxY[idx], false);
                long spanCostMinFromMax = costEndAtMax + dx + visitCost(maxY[idx - 1], minY[idx], maxY[idx], true);
                long spanCostMaxFromMax = costEndAtMax + dx + visitCost(maxY[idx - 1], minY[idx], maxY[idx], false);

                long newEndMin = Math.min(spanCostMinFromMin, spanCostMinFromMax);
                long newEndMax = Math.min(spanCostMaxFromMin, spanCostMaxFromMax);

                costEndAtMin = newEndMin;
                costEndAtMax = newEndMax;
                prevX = xs[idx];
            }

            dx = Bx - prevX;
            long ans = Math.min(costEndAtMin + dx + Math.abs(minY[m - 1] - By),
                                costEndAtMax + dx + Math.abs(maxY[m - 1] - By));
            out.append(ans % MOD);
            if (t > 0) out.append('\n');
        }
        System.out.print(out.toString());
    }

    private static long visitCost(long startY, long lo, long hi, boolean endAtLo) {
        if (lo == hi) return Math.abs(startY - lo);
        long span = hi - lo;
        if (endAtLo) {
            long option1 = Math.abs(startY - hi) + span;
            long option2 = Math.abs(startY - lo) + 2 * span;
            return Math.min(option1, option2);
        } else {
            long option1 = Math.abs(startY - lo) + span;
            long option2 = Math.abs(startY - hi) + 2 * span;
            return Math.min(option1, option2);
        }
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int nextInt() throws IOException { return (int) nextLong(); }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return Long.MIN_VALUE;
            }
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
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
