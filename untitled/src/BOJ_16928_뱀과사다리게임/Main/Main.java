package BOJ_16928_뱀과사다리게임.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] map;
    static int N, M;
    static Queue<Integer> que;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[101];
        result = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        que = new ArrayDeque<>();
        que.add(1);
        result = new int[101];
        result[1] = 0;

        while(!que.isEmpty()) {
            Integer cur = que.poll();

            //목적지 도착
            if (cur == 100) break;

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;

                if (map[next] != 0) next = map[next];

                //이미 방문한 곳
                if (result[next] != 0) continue;

                result[next] = result[cur] + 1;
                que.add(next);
            }
        }

        System.out.println(result[100]);
    }
}
