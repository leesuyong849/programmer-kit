package BOJ_7490_0만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(br.readLine());
            solve(C, sb);
        }
    }

    static void solve(int c, StringBuilder sb) {

        dfs(1, 1, c, "1", null);
    }

    public static void dfs(int depth, int cal, int c, String sb, String buffer) {
        if (depth == c) {
            if (buffer != null) {
                cal += Integer.parseInt(buffer);
                sb = sb + buffer;
            }

            if (cal == 0) {
                System.out.println(sb);
            }
            return;
        }

        int next = depth + 1;
        int nextCal;
        //+의 경우
        if (buffer != null) {
            nextCal = cal + Integer.parseInt(buffer);
            buffer = null;
        } else {
            nextCal = cal;
        }
        String plus = sb + "+" + Integer.toString(next);
        dfs(depth + 1, nextCal + next, c, plus, buffer);

        //-의 경우
        if (buffer != null) {
            nextCal = cal + Integer.parseInt(buffer);
            buffer = null;
        } else {
            nextCal = cal;
        }
        String min = sb + "-" + Integer.toString(next);
        dfs(depth + 1, nextCal - next, c, min, buffer);

        //연장의 경우
        if (buffer != null) {
            buffer = buffer + Integer.toString(next);
        } else {
            buffer = Integer.toString(next);
        }
        String vo = sb + " " + Integer.toString(next);
        dfs(next, cal, c, vo, buffer);
    }
}
