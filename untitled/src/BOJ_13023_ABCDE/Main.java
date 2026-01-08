package BOJ_13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] map;
    static int[] resultMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            resultMap = new int[N];
            resultMap[i] = 1;
            boolean result = dfs(i, 1);

            if (result) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean dfs(int start, int depth) {
        if (depth == 5) return true;

        ArrayList<Integer> nexts = map[start];
        for (Integer next : nexts) {
            if (resultMap[next] == 0) {
                resultMap[next] = depth + 1;
                if (dfs(next, depth + 1)) return true;
                resultMap[next] = 0;
            }
        }

        return false;
    }
}
