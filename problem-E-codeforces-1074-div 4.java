import java.io.*;
import java.util.*;

public class problemECodeforces1074Div4 {
    private static int binarySearch(long A[], long target) {
        int len = A.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)return mid;
            else if (A[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int T = fr.nextInt();
        while (T-- > 0) {
            int N = fr.nextInt(), M = fr.nextInt(), K = fr.nextInt();
            Map<Integer, long[]> robMap = new HashMap<>();
            Map<Long, Set<Integer>> rangeMap = new HashMap<>();
            long robots[] = new long[N];
            for (int i = 0; i < N; ++i) {
                robots[i] = fr.nextLong();
            }
            long spikes[] = new long[M];
            for (int i = 0; i < M; ++i) {
                spikes[i] = fr.nextLong();
            }
            String instruction = fr.next();
            Arrays.sort(spikes);
            for (int i = 0; i < N; ++i) {
                long robotpos = robots[i];
                int rightSpikepos = binarySearch(spikes, robotpos);
                int leftSpikepos = rightSpikepos - 1;
                long rightSpikeVal = 0, leftSpikeVal = 0;
                if (rightSpikepos < M) rightSpikeVal = spikes[rightSpikepos];
                if (leftSpikepos >= 0) leftSpikeVal = spikes[leftSpikepos];
                if (robotpos > spikes[M - 1]) {
                    rightSpikeVal = spikes[M - 1];
                    leftSpikeVal = spikes[M - 1];
                }
                if (robotpos < spikes[0]) {
                    rightSpikeVal = spikes[0];
                    leftSpikeVal = spikes[0];
                }
                if (leftSpikepos < 0)leftSpikeVal = rightSpikeVal;
                leftSpikeVal -= robots[i];
                rightSpikeVal -= robots[i];
                long temp[] = new long[2];
                temp[0] = leftSpikeVal;
                temp[1] = rightSpikeVal;
                robMap.put(i, temp);
                if (!rangeMap.containsKey(leftSpikeVal)) {
                    rangeMap.put(leftSpikeVal, new HashSet<>());
                }
                if (!rangeMap.containsKey(rightSpikeVal)) {
                    rangeMap.put(rightSpikeVal, new HashSet<>());
                }
                rangeMap.get(leftSpikeVal).add(i);
                rangeMap.get(rightSpikeVal).add(i);
            }
            long value = 0L;
            long totalRobots = N;
            totalRobots -= eliminateAt(value, rangeMap, robMap);
            for (int i = 0; i < K; ++i) {
                if (instruction.charAt(i) == 'L')--value;
                else  ++value;
                totalRobots -= eliminateAt(value, rangeMap, robMap);
                out.print(totalRobots + " ");
            }
            out.println();
        }
        out.flush();
    }

    private static long eliminateAt(long value, Map<Long, Set<Integer>> rangeMap, Map<Integer, long[]> robMap) {
        Set<Integer> hit = rangeMap.remove(value);
        if (hit == null || hit.isEmpty())return 0;
        long removed = 0;
        for (int robotNo : hit) {
            ++removed;
            long left = robMap.get(robotNo)[0];
            long right = robMap.get(robotNo)[1];
            if (left != value){
                Set<Integer> s=rangeMap.get(left);
                if (s!=null) {
                    s.remove(robotNo);
                    if (s.isEmpty())rangeMap.remove(left);
                }
            }
            if (right != value){
                Set<Integer> s=rangeMap.get(right);
                if (s!=null){
                    s.remove(robotNo);
                    if (s.isEmpty()) {
                        rangeMap.remove(right);
                    }
                }
            }
        }
        return removed;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}