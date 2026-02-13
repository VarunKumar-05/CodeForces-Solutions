import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextInt())return;
        int t=sc.nextInt();
        while(t-->0){
            long p=sc.nextLong();
            long q=sc.nextLong();
            if(3*p>=2*q && p<q)System.out.println("Bob");
            else System.out.println("Alice");
        }
    }
}