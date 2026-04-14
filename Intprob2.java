import java.util.*;
public class Intprob2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int sum=0;
            int max=-100;
            for(int i=0;i<7;i++){
                int x=sc.nextInt();
                sum+=x;
                if(x>max){
                    max=x;
                }
            }
            System.out.println(2*max-sum);
        }
        
    }
}