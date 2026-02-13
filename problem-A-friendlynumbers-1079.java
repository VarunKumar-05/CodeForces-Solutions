import java.util
public class FreindlyNumber{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        if (!sc.hasNextInt())return ;
        int t=sc.nextInt();
        while(t-->0){
            long x=sc.nextLong();
            if(x%9!=0){
                System.out.println(0);
                continue;
            }
            int count=0;
            for(long y=x;y<=x+100;y++){
                if(y-sumDigits(y)==x)count++;              
            }
            System.out.println(count);
        }
    }

    private static int sumDigits(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}