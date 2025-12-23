import java.util.*;
public class DreamNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                //Input 
                for (int i = 0; i < n; i++)a[i] = sc.nextInt();
                //Sort
                Arrays.sort(a);
                if (a[1]<= 2L*a[0])System.out.println(a[0]);
                else System.out.println(a[1] - a[0]);
                
            }
        }
    }
}
