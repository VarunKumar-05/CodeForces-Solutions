import java.util.*;
public class Intprob5{
    static int [][]trie=new int[300000][2];
    static int nodecount=0;
    static void insert(int n){
        int curr=0;
        for(int i=29;i>=0;i--){
            int bit=(n>>i)&1;
            if(trie[curr][bit]==0){
                trie[nodecount][0]=0;
                trie[nodecount][1]=0;
                trie[curr][bit]=nodecount++;
            }
            curr=trie[curr][bit];
        }
    }
    static int query(int n){
        int curr=0;
        int ans=0;
        for(int i=29;i>=0;i--){
            int bit=(n>>i)&1;
            int opp=1-bit;

            if(trie[curr][opp]!=0){
                ans|=(1<<i);
                curr=trie[curr][opp];
            }else if (trie[curr][bit]!=0)curr=trie[curr][bit];
            
            else break;
        }
        return ans;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int maz=0;
            int n=sc.nextInt();
            trie[0][0]=0;
            trie[0][1]=0;
            nodecount=1;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                if(i>0) maz=Math.max(maz,query(a));
                insert(a);
            }
            System.out.println(maz);
        }
    }
}