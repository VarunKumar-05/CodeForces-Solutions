//Question
//https://codeforces.com/contest/1008/problem/B

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int w = sc.nextInt();
        int h = sc.nextInt();
        int prev = Math.max(w, h);

        boolean possible = true;
        for (int i = 1; i < n; i++) {
            w = sc.nextInt();
            h = sc.nextInt();

            int big = Math.max(w, h);
            int small = Math.min(w, h);

            if (big <= prev) {
                prev = big;
            } else if (small <= prev) {
                prev = small;
            } else {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "yes" : "no");
    }
}
