import java.util.*;
import java.io.*;

public class ProblembABAB{
    public static void main(String[] args){
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(br.readLine().trim());
        StringBuilder sb =new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String x = br.readLine().trim();
            boolean canOdd = true;
            boolean canEven = false;
            boolean possible = true;
            for (int k = 1; k <= n; k++) {
                char c = x.charAt(k - 1);
                int diff = n - k;
                if (diff % 2 == 0) {
                    if (c == 'a'){
                        if (!canOdd)possible = false; break;
                    } else if (c == 'b') {
                        if (!canEven)possible = false; break;
                    } else { 
                        if (!canOdd && !canEven) { possible = false; break; }
                    }
                    canOdd =true;
                    canEven =true;
                } else {
                    if (!canOdd && !canEven) { possible = false; break; }
                    if (c == 'a') {
                        canOdd = false;
                        canEven = true;
                    } else if (c == 'b') {
                        canOdd = true;
                        canEven = false;
                    } else { // '?'
                        canOdd = true;
                        canEven = true;
                    }
                }
            }

            sb.append(possible ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}
