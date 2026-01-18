package BOJ_2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {

    static int N;
    static int[] map, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        result = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int anInt = Integer.parseInt(st.nextToken());
            map[i] = anInt;
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(i);
                continue;
            }

            while (true) {

                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(i);
                    break;
                } else {
                    Integer peekIdx = stack.peek();
                    int height = map[peekIdx];
                    if (map[i] > height) {
                        stack.pop();
                    } else {
                        sb.append(peekIdx).append(" ");
                        stack.push(i);
                        break;
                    }
                }

            }
        }

        System.out.println(sb.toString());
    }
}
