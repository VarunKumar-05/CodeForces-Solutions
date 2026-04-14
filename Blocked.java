import java.util.*;
public class Blocked{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        StringBuilder sb=new StringBuilder();
        if(s==null)return;
        int t=Integer.parseInt(s);
        while(t-- > 0){
           int n=sc.nextInt();
           Integer []a=new Integer[n];
           Set<Integer>ue=new HashSet<>();
           boolean flag=false;
           for(int i=0;i<n;i++){
               a[i]=sc.nextInt();
               if(!ue.add(a[i])){
                   flag=true;
               }
           }
           if(flag){
               sb.append("-1\n");
           }else{
            Arrays.sort(a,Collections.reverseOrder());
            for(int i=0;i<n;i++){
                sb.append(a[i]).append(i== n - 1 ? "" : " ");
            }
            sb.append("\n");
           }
        }
        System.out.print(sb);
        sc.close();
    }
}