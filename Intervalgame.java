import java.util.*;
public class Intervalgame{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x1=sc.nextInt();
            int x2=sc.nextInt();

            long minw=Long.MAX_VALUE;
            int optv=-1;
            for(int v=0;v<x1;v++){
                long ways=calcw(v,x2);
                if(ways<minw){
                    minw=ways;
                    optv=v;
                }
                if(minw==0)break;
            }
            int l1=optv+1;
            int r1=x1;
            System.out.println(l1+" "+r1);
        }
    }
    private static long calcw(int v,int x2){
        if(x2-1-v<0)return 0;
        int maxk=(x2-1-v)/2;
        if(maxk<0)return 0;
        long countv=countk(v,maxk);
        return countv * (1L <<Integer.bitCount(v));
           
        
    }
    private static long countk(int v, int maxK){
    if (maxK <0) return 0;

    int[] zeros =new int[21];
    for (int i =1; i <=20; i++)
        
        zeros[i] =zeros[i-1]+(((v>> (i-1)) & 1) ==0 ? 1 : 0);
    

    long ans =0;
    for (int i =19; i>=0; i--){
        int bV =(v>> i) & 1;
        int bM =(maxK>> i) & 1;

        if (bV ==1){
            if (bM ==1){
                ans +=(1L <<zeros[i]);
                return ans;
            }
        } else{
            if (bM ==1)ans +=(1L <<zeros[i]);
        }
    }
    
    ans++; 
    return ans;
}

}