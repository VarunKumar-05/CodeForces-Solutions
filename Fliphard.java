import java.util.*;
public class Fliphard{
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

            int []p=new int[k];
            for(int i=0;i<k;i++)p[i]=sc.nextInt();

            int x=a[p[0]-1];

            int []b=new int[n+2];
            for(int i=1;i<=n;i++)b[i]=(a[i-1]==x) ? 0 : 1;

            b[0]=0;
            b[n+1]=0;
            int [] c=new int[k+1];
            int px=0;
            for(int i=1;i<=n+1;i++){
                if(b[i]!=b[i-1])c[px]++;
                if(px<k && i==p[px])px++;
            }

            int s=0;
            int cm=0;
            for(int count:c){
                s+=count;
                cm=Math.max(cm,count);
            }
            sb.append(Math.max(s/2,cm)).append("\n");
        }
        System.out.print(sb);
    }
}