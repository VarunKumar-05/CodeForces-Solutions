import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String tt=sc.next();
        if (tt == null) return;
        int t=Integer.parseInt(tt);
        StringBuilder out=new StringBuilder();
        while (t-- > 0) {
            int n =sc.nextInt();
            int k =sc.nextInt();
            int p =sc.nextInt();
            long m =sc.nextLong();
            long[] a =new long[n];
            for (int i =0; i< n;i++) {
                a[i]=sc.nextLong();
            }
            
            long ap=a[p- 1];
            
            long pre=0;
            long[] preArr=new long[p- 1];
            for (int i=0; i< p- 1; i++) {
                preArr[i]=a[i];
                pre += a[i];
            }
            
            long aa=0;
            for (int i=p; i< n; i++)
                aa += a[i];            
            long All=pre + aa + ap;
            
            Arrays.sort(preArr);
            long A=0;
            int takePre=Math.min(p- 1, k- 1);
            for (int i=0; i< takePre; i++)
                A += preArr[preArr.length- 1- i];
            long[] dup=new long[n- 1];
            int idx=0;
            for (int i=0; i< p- 1; i++) dup[idx++]=a[i];
            for (int i=p; i< n; i++) dup[idx++]=a[i];
            
            Arrays.sort(dup);
            long sB_single=0;
            int other=Math.min(n- 1, k- 1);
            for (int i=0; i< other; i++) 
                sB_single += dup[dup.length- 1- i];
            
            long M=All- sB_single;
            long K=sB_single- aa- A;
            
            if (M + K > m)
                out.append(0).append("\n");
            else {
                long ans=(m- K) / M;
                out.append(ans).append("\n");
            }
        }
        
        System.out.print(out);
    }
    
   
}