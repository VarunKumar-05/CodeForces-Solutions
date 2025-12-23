import java.util.*;                                 //Blackslex and Showering  
public class BlackslexAndPassword{                                  //B
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t=sc.nextInt();
            while (t-- >0) {
                int n=sc.nextInt();
                int[] a=new int[n];
                for (int i = 0; i < n; i++)a[i] = sc.nextInt();
                long totalSum = 0;
                for (int i=0;i<n-1; i++)totalSum +=Math.abs(a[i] - a[i + 1]);
                long maxReduction=0;
                if (n>1)maxReduction=Math.max(maxReduction,Math.abs(a[0]-a[1]));
                if (n>1)maxReduction=Math.max(maxReduction,Math.abs(a[n-2]-a[n-1]));
                for (int i =1;i<n-1; i++) {
                    long oldDist=Math.abs(a[i-1]-a[i])+Math.abs(a[i]-a[i+1]);
                    long newDist=Math.abs(a[i-1]-a[i+1]);
                    long reduction=oldDist-newDist;
                    maxReduction=Math.max(maxReduction, reduction);
                }
                System.out.println(totalSum- maxReduction);
            }
        }
    }
}
