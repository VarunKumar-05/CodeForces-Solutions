import java.util.*;
public class MSS{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []a =new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        long mss=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                List<Integer> inside=new ArrayList<>();
                List<Integer> outside=new ArrayList<>();
                for(int l=0;l<n;l++){
                    if(l>=i && l<=j){
                        inside.add(a[l]);
                    }else{
                        outside.add(a[l]);
                    }
                }
                Collections.sort(inside);
                Collections.sort(outside, Collections.reverseOrder());
                long csum=0;
                for(int xs: inside){
                    csum+=xs;
                }
                int swapp=Math.min(k, Math.min(inside.size(), outside.size()));
                for(int l=0;l<swapp;l++){
                    if(inside.get(l)<outside.get(l)){
                        csum+=outside.get(l)-inside.get(l);
                    }else{
                        break;
                    }
                }              mss=Math.max(mss, csum);
            }
        }
        System.out.println(mss);
    }
}