package BOJ_1406_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        M = Integer.parseInt(br.readLine());

        int cursor = s.length() - 1;
        String newS = s;
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            String command = br.readLine();

            if (command.equals("L")) {
                cursor = Math.min(0, cursor - 1);

            } else if (command.equals("D")) {
                cursor = Math.max(s.length() - 1, cursor + 1);
            }  else if (command.equals("B")) {
                newS = newS.substring(0, cursor - 1) + newS.substring(cursor + 1);
            } else {
                char target = command.charAt(2);
                newS = newS.substring(0, cursor - 1) + target + newS.substring(cursor);
            }
        }

        System.out.println(newS);
    }
}
