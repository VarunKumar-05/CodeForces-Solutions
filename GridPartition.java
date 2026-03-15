import java.util.*;
import java.io.*;

public class GridPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[][] grid = new int[N][M];
            int totalSum = 0;
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < M; j++) {
                    grid[i][j] = line.charAt(j) - '0';
                    totalSum += grid[i][j];
                }
            }
            
            if (totalSum < 6) {
                sb.append("No\n");
                continue;
            }
            
            // Try to solve. If N > M, transpose.
            boolean transposed = false;
            if (N > M) {
                transposed = true;
                int[][] newGrid = new int[M][N];
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < M; j++)
                        newGrid[j][i] = grid[i][j];
                grid = newGrid;
                int tmp = N; N = M; M = tmp;
            }
            
            // Now N <= M. N <= sqrt(NM) <= ~450.
            // Compute prefix sums for each row.
            int[][] ps = new int[N][M + 1]; // ps[r][j] = sum of grid[r][0..j-1]
            for (int r = 0; r < N; r++) {
                for (int j = 0; j < M; j++) {
                    ps[r][j + 1] = ps[r][j] + grid[r][j];
                }
            }
            
            // Compute row sums
            int[] rowSum = new int[N];
            for (int r = 0; r < N; r++) {
                rowSum[r] = ps[r][M];
            }
            
            // Row prefix sums
            int[] RS = new int[N + 1]; // RS[r] = sum of rows 0..r-1
            for (int r = 0; r < N; r++) {
                RS[r + 1] = RS[r] + rowSum[r];
            }
            
            // Try sweep approach with horizontal-line path2 at each r0 (1-indexed: r0 = 1..N-1)
            // Path2 at r0 means: c2[r] = M for r < r0 (0-indexed), c2[r] = 0 for r >= r0
            // "Below" = rows 0..r0-1 (all cells), "Above" = rows r0..N-1 (all cells)
            // T2 = RS[N] - RS[r0], B2 = RS[r0]
            
            String[] result = null;
            
            for (int r0 = 1; r0 < N && result == null; r0++) {
                int T2 = RS[N] - RS[r0];
                int B2 = RS[r0];
                
                if (T2 == 0 || B2 == 0) continue;
                
                // Sweep path1 from leftmost to rightmost.
                // Sweep order: column 0..M-1, within each column: row N-1 down to 0.
                // Initially: TL=0, BL=0, TR=T2, BR=B2.
                int TL = 0, BL = 0, TR = T2, BR = B2;
                
                // We also need to track the staircase c1 to reconstruct the path.
                // At any point during the sweep within column j (processed rows N-1..r_cur):
                // c1[r] = j+1 for r >= r_cur, c1[r] = j for r < r_cur
                // (using 0-indexed rows, 0-indexed columns for staircase = number of cols in "left")
                
                for (int j = 0; j < M && result == null; j++) {
                    for (int r = N - 1; r >= 0 && result == null; r--) {
                        int val = grid[r][j];
                        
                        // Cell (r, j) moves from right to left of path1.
                        // Check if cell is above or below path2:
                        // Above = r >= r0 (0-indexed), Below = r < r0
                        if (r >= r0) {
                            // Above path2: TR -> TL
                            TL += val;
                            TR -= val;
                        } else {
                            // Below path2: BR -> BL
                            BL += val;
                            BR -= val;
                        }
                        
                        // Check if all 4 are distinct
                        if (TL != BL && TL != TR && TL != BR && BL != TR && BL != BR && TR != BR) {
                            // Found! Reconstruct paths.
                            // Current staircase: c1[r'] = j+1 for r' >= r, c1[r'] = j for r' < r
                            // (0-indexed: c1 values are number of columns in "left" for each row)
                            int[] c1 = new int[N];
                            for (int rr = 0; rr < N; rr++) {
                                if (rr >= r) c1[rr] = j + 1;
                                else c1[rr] = j;
                            }
                            
                            // Check c1 is valid (non-decreasing from 0 to M)
                            // c1[0..r-1] = j, c1[r..N-1] = j+1. Non-decreasing. OK.
                            // Also need 0 <= c1[r] <= M for all r.
                            // j >= 0 and j+1 <= M (since j < M). OK.
                            
                            // Path2: c2[r'] = M for r' < r0, c2[r'] = 0 for r' >= r0
                            int[] c2 = new int[N];
                            for (int rr = 0; rr < N; rr++) {
                                if (rr < r0) c2[rr] = M;
                                else c2[rr] = 0;
                            }
                            
                            result = buildPaths(N, M, c1, c2, transposed);
                        }
                    }
                }
            }
            
            if (result != null) {
                sb.append("Yes\n");
                sb.append(result[0]).append('\n');
                sb.append(result[1]).append('\n');
            } else {
                sb.append("No\n");
            }
        }
        
        System.out.print(sb);
    }
    
    static String[] buildPaths(int N, int M, int[] c1, int[] c2, boolean transposed) {
        // Build path1 string from staircase c1 (non-decreasing, 0..M)
        // Path1: (0,0) -> (N,M) using D and R
        // For row r (0 to N-1): output R^(c1[r] - prev) then D
        // At end: output R^(M - c1[N-1])
        
        StringBuilder p1 = new StringBuilder();
        int prev = 0;
        for (int r = 0; r < N; r++) {
            for (int k = prev; k < c1[r]; k++) p1.append('R');
            p1.append('D');
            prev = c1[r];
        }
        for (int k = prev; k < M; k++) p1.append('R');
        
        // Build path2 string from staircase c2 (non-increasing, M..0)
        // Path2: (N,0) -> (0,M) using U and R
        // For row r (N-1 to 0): output R^(c2[r] - prev2) then U
        // At end: output R^(M - c2[0])
        
        StringBuilder p2 = new StringBuilder();
        int prev2 = 0;
        for (int r = N - 1; r >= 0; r--) {
            for (int k = prev2; k < c2[r]; k++) p2.append('R');
            p2.append('U');
            prev2 = c2[r];
        }
        for (int k = prev2; k < M; k++) p2.append('R');
        
        if (transposed) {
            String s1 = p1.toString();
            StringBuilder ns1 = new StringBuilder();
            for (char c : s1.toCharArray()) {
                if (c == 'D') ns1.append('R');
                else ns1.append('D');
            }
            
            String s2 = p2.toString();
            StringBuilder ns2 = new StringBuilder();
            for (char c : s2.toCharArray()) {
                if (c == 'U') ns2.append('R');
                else ns2.append('U');
            }
            
            return new String[]{ns1.toString(), ns2.toString()};
        }
        
        return new String[]{p1.toString(), p2.toString()};
    }
}
