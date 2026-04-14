import java.util.*;
public class PermutationE{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String ts=sc.next();
        if(ts==null)return;
        int t=Integer.parseInt(ts);
        while(t-->0){
            int n=sc.nextInt();
            int[]p=new int[n+1];
            Integer[]order=new Integer[n];
            for(int i=1;i<=n;i++){
                p[i]=sc.nextInt();
                order[i-1]=i;
            }
            int []d=new int[n+1];
            for(int i=1;i<=n;i++)d[i]=sc.nextInt();

            Arrays.sort(order,(a,b)-> Integer.compare(p[b],p[a]));

            List<Integer>ans =new ArrayList<>();
            boolean pos=true;

            for(int x:order){
                int target=d[x];
                int count=0;
                int insertPos=ans.size();
                for(int i=ans.size()-1;i>=0;i--){
                    if(target==0)break;
                    if(ans.get(i)>x){
                        count++;
                        if(count==target){
                            insertPos=i;
                            break;
                        }
                    }
                }
                if(count<target){
                    pos=false;
                    break;
                }
                ans.add(insertPos,x);
            }
            if(!pos){
                System.out.println("-1");
            }else{
                int []q=new int[n+1];
                for(int i=0;i<ans.size();i++){
                    q[ans.get(i)]=i+1;
                }
                for(int i=1;i<=n;i++){
                    System.out.print(q[i]+(i==n ? "" : " "));
                }
                System.out.println();
            }

        }
    }
}