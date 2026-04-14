import java.util.*;
public class Flipthebits{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        if(!sc.hasNextInt())return;
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int []a=new int[n];

            for(int i=0;i<n;i++)a[i]=sc.nextInt();

            int p=sc.nextInt();
            int x=a[p-1];

            int []b=new int[n+2];
            for(int i=1;i<=n;i++)b[i]=(a[i-1]==x) ? 0 : 1;

            b[0]=0;
            b[n+1]=0;
            int L=0;
            int R=0;
            for(int i=1;i<=p;i++){
                if(b[i]!=b[i-1])L++;
            }            
            for(int i=p+1;i<=n+1;i++){
                if(b[i]!=b[i-1])R++;
            }
            sb.append(Math.max(L,R)).append("\n");
        }
        System.out.print(sb);
    }
}