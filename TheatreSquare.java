import java.util.*;
public class TheatreSpuare{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        long m=sc.nextInt();
        long a=sc.nextInt();
        Long Stoneforn=(n+a-1)/a;
        Long Stoneform=(m+a-1)/a;
        System.out.println(Stoneforn*Stoneform);
    }
}