import java.util.*;
public class Intprob3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            int left=1;
            int right=3*n;
            for(int i=0;i<n;i++){
                System.out.print(left+" "+(right-1)+" "+right+" ");
                left++;
                right-=2;
            }
            System.out.println();
        }        
    }
}