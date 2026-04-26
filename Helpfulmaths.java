import java.util.*;
public class Helpfulmaths{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s==null)return ;
        // if(s.length()==1)System.out.println(s);

        String[] arr=s.split("\\+");
        int[] nums=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            sb.append(nums[i]);
            if(i!=nums.length-1)sb.append("+");
        }
        System.out.println(sb.toString());
    }
}