package BOJ_2668_숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static int N;
    static int[] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0, result = 0, resultCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                Integer dfsResult = dfs(i, ++cnt, 1);

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append('\n');
        for (int i = 1; i <= N; i++) {
            if (visited[i] == resultCnt) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    public static Integer dfs(int x, int cnt, int counting) {
        visited[x] = cnt;

        int next = map[x];
        if (visited[next] == cnt) return counting;
        else if (visited[next] != 0) return null;
        else return dfs(next, cnt, counting + 1);
    }
}
