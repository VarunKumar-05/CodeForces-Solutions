import java.util.*;
public class Partition{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int n = sc.nextInt();
            int[]a=new int[n];
            int []copy=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                copy[i]=a[i];
            }
            Arrays.sort(copy);
            int m=copy[n/2];
            int []prefx=new int[n+1];
            int []prefy=new int[n+1];
            for(int i=0;i<n;i++){
                prefx[i+1]=prefx[i]+(a[i]>=m?1:-1);
                prefy[i+1]=prefy[i]+(a[i]<=m?1:-1);
            }
            int[]dp=new int[n+1];
            Arrays.fill(dp,-1);
            dp[0]=0;
            for(int i=0;i<=n;i++){
                for(int j=i-1;j>=0;j-=2){
                    if(dp[j]!=-1){
                    if(prefx[i]-prefx[j]>0 && prefy[i]-prefy[j]>0){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                }
                
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
           
}