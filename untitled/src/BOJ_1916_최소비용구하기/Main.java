package BOJ_1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, M, S, E;
    static List<Edge>[] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        ArrayDeque<int[]> que = new ArrayDeque<>();
        for (Edge edge : map[S]) {
            que.add(new int[]{edge.to, edge.w});
        }

        dij(S);
        System.out.println(result[E]);

    }

    static void dij(int start) {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        result[start] = 0;
        que.add(new int[]{start, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int position = cur[0];
            int cost = cur[1];

            //이미 비용 추월
            if (cost > result[position]) continue;
            //도착지
            if (position == E) return;

            //나머지 경우에 대해 값을 넣는다.
            for (Edge e : map[position]) {
                int next = e.to;
                int weight = e.w;

                if (result[next] > weight + cost) {
                    result[next] = weight + cost;
                    que.add(new int[]{next, weight + cost});
                }
            }
        }
    }
}
