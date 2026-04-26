import java.util.Scanner;

public class WonderfulContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean has100 = false;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a == 100) {
                    has100 = true;
                }
            }
            
            if (has100) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}