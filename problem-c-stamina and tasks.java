import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String tt= sc.next();
        if(tt== null) return;
        int t= Integer.parseInt(tt);
        StringBuilder out= new StringBuilder();
        while(t--> 0){
            int n= sc.nextInt();
            
            int[] c= new int[n];
            int[] p= new int[n];
            
            for(int i= 0;i < n;i++){
                c[i]= sc.nextInt();
                p[i]= sc.nextInt();
            }
            double dp= 0.0;
            for(int i= n- 1;i>= 0;i--){
                double skip= dp;
                double take= c[i]+dp*(1.0- p[i]/ 100.0);
                
                dp= Math.max(skip, take);
            }
            out.append(String.format("%.10f\n", dp));
        }
        
        System.out.print(out);
    }
    
}