import java.util.*;
public class Main{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String a=sc.nextLine();
String b=sc.nextLine();
String l1=a.toLowerCase();
String l2=b.toLowerCase();
int result=l1.compareTo(l2);
if(result==0)System.out.print(0);
else if(result<0)System.out.print(-1);
else System.out.print(1);
}
}