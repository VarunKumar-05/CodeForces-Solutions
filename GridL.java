import java.util.*;
public class GridL{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        int tt=Integer.parseInt(s);
        while(tt-->0){
            long p=sc.nextLong();
            long q=sc.nextLong();
            long t=2*p+4*q+1;
            long sqrtt=(long)Math.sqrt((double)t);
            while((sqrtt+1)*(sqrtt+1)<=t)sqrtt++;
            while(sqrtt*sqrtt>t)sqrtt--;
            long bestA=-1;
            for(long a=sqrtt;a>=3;a--){
                if(t%a==0){
                   bestA=a;
                     break;
                }
            }
            if(bestA==-1)
                sb.append("-1\n");
            else{
                long b=t/bestA;
                if(b-bestA<=2*p){
                    long n=(bestA-1)/2;
                    long m=(b-1)/2;
                    sb.append(n).append(' ').append(m).append("\n");
                }else{
                    sb.append("-1\n");
                }
            }
        }
        System.out.print(sb);
            
    }
}