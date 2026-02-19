import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() > 10) {
                output.append(word.charAt(0))
                      .append(word.length() - 2)
                      .append(word.charAt(word.length() - 1))
                      .append("\n");
            } else {
                output.append(word).append("\n");
            }
        }

        System.out.print(output);
    }
}
