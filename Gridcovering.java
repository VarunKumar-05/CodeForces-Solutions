import java.util.*;
public class Gridcovering{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            long m=sc.nextLong();
            long a=sc.nextLong();
            long b=sc.nextLong();
            if(gcd(a,n)==1 && gcd(b,m)==1 && gcd(n,m)<=2)sb.append("YES\n");
            else sb.append("NO\n");
        }
            System.out.print(sb);
    
}
    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}