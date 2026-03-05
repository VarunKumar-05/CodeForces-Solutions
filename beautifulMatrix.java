import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moves = 0;
        for (int r = 1; r <= 5; r++) {
            for (int c = 1; c <= 5; c++) {
                int value = sc.nextInt();
                    if (value == 1) 
                    moves = Math.abs(r - 3) + Math.abs(c - 3);
                
            }
        }
        
        System.out.println(moves);
        sc.close();
    }
}