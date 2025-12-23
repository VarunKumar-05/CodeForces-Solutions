import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            if(a>10 && b>10 && c>10 && d>10){
                System.out.println("YES");
                return;
            }
            if(a==b&&c==d&&b==c)System.out.println("YES");
            
            else{
                System.out.println("NO");
            }
        }
        
    }
}