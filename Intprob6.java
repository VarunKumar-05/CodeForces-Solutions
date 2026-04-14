import java.util.*;
public class Intprob6{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int n=x+y;
            if(n%2==0){
                if (x>=1 && y>=x){
                    System.out.println("YES");
                    int nextnode=2;
                    for(int i=0;i<x-1;i++){
                        int u=nextnode++;
                        int v=nextnode++;
                        System.out.println(1+" "+u);
                        System.out.println(u+" "+v);   
                    }
                    while(nextnode<=n){
                        System.out.println(1+" "+nextnode);
                        nextnode++;
                    }
                }else
                    System.out.println("NO");
                
            }else{
                if(y>x){

                    System.out.println("YES");
                    int nextnode=2;
                    for(int i=0;i<x;i++){
                        int u=nextnode++;
                        int v=nextnode++;
                        System.out.println(1+" "+u);
                        System.out.println(u+" "+v);   
                    }
                    while(nextnode<=n){
                        System.out.println(1+" "+nextnode);
                        nextnode++;
                    }
                }else
                    System.out.println("NO");
                
                }
            
            }

        }
    }