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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        que = new ArrayDeque<>();
        que.add(1);

        int cnt = 0;
        while(!que.isEmpty()) {
            Integer poll = que.poll();

            if (poll == 0) {
                cnt++;
                continue;
            }

            for (int i = 1; i < 7; i++) {
                int dir = poll + i;
                if (map[dir] != 0) {
                    dir = map[dir];
                }

                if (dir == 100) {
                    cnt++;
                    break;
                } else if (dir > 100) {
                    continue;
                } else {
                    que.add(dir);
                }
                que.add(0);
            }
        }

        System.out.println(cnt);
    }
}
