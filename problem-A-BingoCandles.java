import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tStr =sc.next();
        if (tStr ==null)return;
        int t=Integer.parseInt(tStr);
        StringBuilder out =new StringBuilder();
        while (t-- >0){
            int n =sc.nextInt();
            int[] count=new int[n*n+1];
            int maxFreq= 0;
            for (int i =0; i <n*n;i++) {
                int color =sc.nextInt();
                count[color]++;
                if (count[color] >maxFreq) {
                    maxFreq =count[color];
                }
            }
            
            if (maxFreq <= n*(n-1))
                out.append("YES\n");
            else 
                out.append("NO\n");
        }
        
        System.out.print(out);
    }
    
   
}