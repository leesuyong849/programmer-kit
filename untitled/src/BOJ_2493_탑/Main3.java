package BOJ_2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3 {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                int peekMap = map[peek];

                if (peekMap < map[i]) {
                    stack.pop();

                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(i);
                        break;
                    }
                } else {
                    stack.push(i);
                    sb.append(peek).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
