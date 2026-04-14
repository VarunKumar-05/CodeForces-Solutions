import java.util.*;
import java.io.*;
public class Intprob4{
    static ArrayList<Long> primes=new ArrayList<>();
    static void see(){
        int MAX=200000;
        boolean[] isprime=new boolean[MAX];
        Arrays.fill(isprime,true);
        for(int i=2;i<MAX;i++){
            if(isprime[i]){
                primes.add((long)i);
                for(int j=2*i;j<MAX;j+=i)
                    isprime[j]=false;
            }
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        see();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                long a=primes.get(i)*primes.get(i+1);
                System.out.print(a+(i==n-1 ? "":" "));
            }
            System.out.println();
        }

    }
}