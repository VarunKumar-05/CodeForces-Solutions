import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackslexPlants {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] lArr = new int[q];
            int[] rArr = new int[q];
            for (int i = 0; i < q; i++) {
                lArr[i] = sc.nextInt();
                rArr[i] = sc.nextInt();
            }
            
            long[] finalAns = new long[n + 1];
            
            // Iterate through each bit position p
            // 2^17 < 200000 < 2^18. So p goes up to 17.
            for (int p = 0; p < 18; p++) {
                int M = 1 << (p + 1);
                long twoP = 1L << p;
                long A_val = (long)M * twoP; // M * 2^p
                
                // We need to manage difference arrays for each residue R
                // To avoid array of arrays overhead, we use one flat array
                // We need to know the start index for each residue
                
                int[] startIdx = new int[M];
                int[] kStart = new int[M];
                int currentIdx = 0;
                
                for (int R = 0; R < M; R++) {
                    startIdx[R] = currentIdx;
                    // Calculate range of k for this residue in [1, n]
                    // i = k*M + R. 1 <= i <= n
                    // k*M >= 1 - R => k >= ceil((1-R)/M)
                    // k*M <= n - R => k <= floor((n-R)/M)
                    
                    int k_s = floorDiv(1 - R - 1, M) + 1;
                    int k_e = floorDiv(n - R, M);
                    
                    kStart[R] = k_s;
                    
                    int count = k_e - k_s + 1;
                    if (count > 0) {
                        currentIdx += count + 5; // +5 for safety with difference array boundary
                    } else {
                        // Even if count is 0, we might need space if queries map to this residue?
                        // If count is 0, no i in [1, n] matches this residue.
                        // But queries might still generate updates.
                        // However, if no i in [1, n] matches, we don't need to add to finalAns.
                        // But we need to handle the updates logic without crashing.
                        // If count <= 0, we can just point to a dummy area or skip?
                        // Let's just allocate a small dummy space if count <= 0
                        currentIdx += 5;
                    }
                }
                
                long[] D = new long[currentIdx];
                
                for (int i = 0; i < q; i++) {
                    int l = lArr[i];
                    int r = rArr[i];
                    
                    // We want i - l + 1 == 2^p (mod 2^(p+1))
                    // i == l - 1 + 2^p (mod M)
                    int R = (int)((l - 1 + twoP) & (M - 1)); // & (M-1) is same as % M
                    
                    int k_min = floorDiv(l - R - 1, M) + 1;
                    int k_max = floorDiv(r - R, M);
                    
                    if (k_min <= k_max) {
                        // Update parameters
                        // val(k) = A * k + B
                        // A = M * 2^p
                        // B = (R - l + 1) * 2^p
                        long B_val = (R - l + 1) * twoP;
                        
                        long S = A_val * k_min + B_val;
                        long d = A_val;
                        
                        int base = startIdx[R];
                        int offset = kStart[R];
                        
                        // Map k to index in D: base + (k - offset)
                        // We need to check bounds? 
                        // The k_min and k_max are derived from l and r which are in [1, n].
                        // So k will be within valid range for residue R (mostly).
                        // Wait, k_min could be less than kStart[R] if l < 1? No l >= 1.
                        // k_max could be > k_end? No r <= n.
                        // So indices are safe.
                        
                        int idx = base + (k_min - offset);
                        int len = k_max - k_min + 1;
                        
                        // Apply second order difference update
                        // D[idx] += S
                        // D[idx+1] += d - S
                        // D[idx + len] -= S + len*d
                        // D[idx + len + 1] += S + (len-1)*d
                        
                        // Simplified:
                        // D[L] += S
                        // D[L+1] += d - S
                        // D[R+1] -= S + (len)*d
                        // D[R+2] += S + (len-1)*d
                        
                        // Let's stick to the derived formula:
                        // D2[L] += S
                        // D2[L+1] += d - S
                        // D2[R+1] -= S + (R_idx - L_idx + 1) * d
                        // D2[R+2] += S + (R_idx - L_idx) * d
                        
                        // Here R_idx corresponds to k_max, L_idx to k_min.
                        // R_idx - L_idx = k_max - k_min = len - 1.
                        // Term 3: S + len * d
                        // Term 4: S + (len - 1) * d
                        
                        D[idx] += S;
                        D[idx + 1] += d - S;
                        D[idx + len] -= S + len * d;
                        D[idx + len + 1] += S + (len - 1) * d;
                    }
                }
                
                // Process D to get values and add to finalAns
                for (int R = 0; R < M; R++) {
                    int k_s = kStart[R];
                    int k_e = floorDiv(n - R, M);
                    int count = k_e - k_s + 1;
                    
                    if (count <= 0) continue;
                    
                    int base = startIdx[R];
                    long val = 0;
                    long diff = 0;
                    
                    // We iterate through the allocated range
                    // We need to go enough steps to cover all k in [k_s, k_e]
                    // The D array has updates relative to k_s.
                    // D[0] corresponds to k_s.
                    
                    for (int j = 0; j < count; j++) {
                        diff += D[base + j];
                        val += diff;
                        
                        // val is the value for k = k_s + j
                        int k = k_s + j;
                        int i = k * M + R;
                        if (i >= 1 && i <= n) {
                            finalAns[i] += val;
                        }
                    }
                }
            }
            
            for (int i = 1; i <= n; i++) {
                sb.append(finalAns[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static int floorDiv(int x, int y) {
        int r = x / y;
        // if the signs are different and modulo not zero, adjust result
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
