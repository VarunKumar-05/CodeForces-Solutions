import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
		String a= watermelon(t);
        System.out.println(a);

	}
	public static String watermelon(int n){
		if(n%2==0 && n>2)return "YES";
		return "NO";
	}
 

}
