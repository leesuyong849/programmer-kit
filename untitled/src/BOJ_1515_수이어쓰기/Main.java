package BOJ_1515_수이어쓰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targe = br.readLine();
        int N = targe.length();
        boolean[] visited = new boolean[N];
        int result = 0;

        for (int i = 0; ; i++) {
            String t = String.valueOf(i);
            targe.replace(t, "");

            if (targe.length() == 0) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
