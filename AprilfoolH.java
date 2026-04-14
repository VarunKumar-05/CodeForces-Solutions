import java.util.Scanner;

public class AprilfoolH {
    public static void main(String[] args) {
        String[] answers = {
            "", 
            "drive", 
            "yes", 
            "no", 
            "yes", 
            "no", 
            "no", 
            "sdrawkcab", 
            "seven"
        };
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < answers.length) {
            System.out.println(answers[n]);
        }
        scanner.close();
    }
}