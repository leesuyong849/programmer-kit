package BOJ_2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] tower, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        tower = new int[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> que = new PriorityQueue<>((a, b)-> tower[b] - tower[a]);
        que.add(--N);


        while (N-- > 0) {
            if (que.isEmpty()) continue;

            while (!que.isEmpty()) {
                Integer peek = que.peek();

                if (tower[peek] <= tower[N]) {
                    que.poll();
                    result[peek] = N + 1;
                } else {
                    break;
                }
            }

            que.add(N);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}
