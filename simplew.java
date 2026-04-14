import java.util.*;

class simplew {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] store = new int[5];

        for(int i = 0; i < 5; i++) {
            System.out.println("Enter the number:");
            int number = sc.nextInt();
            store[i] = number;
        }
        System.out.println("The numbers you entered are:");
        for(int i:store){
            System.out.println(i);
        }
    }
}