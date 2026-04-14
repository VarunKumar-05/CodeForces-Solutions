import java.util.Scanner;
public class Equalizer{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextInt())return;

        int n=sc.nextInt();
        while(n-->0){
            int t=sc.nextInt();
            int k=sc.nextInt();
            long sum=0;
            for(int i=0;i<t;i++)sum+=sc.nextInt();
            if(sum%2!=0||(t*k)%2==0)System.out.println("Yes");
            else System.out.println("No");
        }

    }
}