package BOJ_14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int H, W, result;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[W];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int stand = map[0];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i < W; i++) {
            int now = map[i];
            if (now >= stand) {
                while (!stack.isEmpty()) {
                    int one = stand - stack.poll();
                    result += one;
                }
                stand = now;
            } else {
                stack.add(now);
            }
        }

        if (!stack.isEmpty()) {
            for (Integer integer : stack) {
                int i =  Math.abs(map[W - 1] - integer);
                result += i;
            }
        }

        System.out.println(result);
    }
}
