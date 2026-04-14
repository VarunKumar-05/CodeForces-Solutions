import java.util.*;
import java.io.*;
public class Intprob7{
    static final long MOD=676767677;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int []b=new int[n];
            int []c=new int[m];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
                c[b[i]]++;
            }
            int []s=new int[m+1];
            for(int i=0;i<m;i++){
                s[i+1]=s[i]+c[i];
            }
            long ans=1;
            for(int i=0;i<n;i++){
                int time=b[i];
                int tNeigh=Integer.MAX_VALUE;
                if(time==0)continue;
                
                if (i>0)tNeigh=Math.min(tNeigh,b[i-1]);
                if(i<n-1)tNeigh=Math.min(tNeigh,b[i+1]);

                if (tNeigh>=time) {
                    ans=0;
                    break;
                } else if(tNeigh==time-1)
                    ans=(ans*s[time])%MOD;
                else
                    ans=(ans*c[time-1])%MOD;
            }
            System.out.println(ans);
        }

    }
}