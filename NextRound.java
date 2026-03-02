import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        
        int threshold = scores[k - 1]; 
        int advancers = 0;
        
        for (int i = 0; i < n; i++) {
            if (scores[i] >= threshold && scores[i] > 0) 
                advancers++;
            else break; 
            
        }
        
        System.out.println(advancers);
        sc.close();
    }
}