package BOJ_5972_택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {

    static class Node {
        int to, w;
        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, M;
    static List<Node>[] graph;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        dij(1);
        System.out.println(dist[N]);
    }

    public static void dij(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        dist[s] = 0;
        pq.add(new int[] {s, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int curX = poll[0];
            int curW = poll[1];

            if (curW > dist[curX]) continue;

            List<Node> nodes = graph[curX];
            if (nodes == null) continue;

            for (Node node : nodes) {
                int to = node.to;
                int w = node.w;

                if (curW + w < dist[to]) {
                    dist[to] = curW + w;
                    pq.add(new int[] {to, dist[to]});
                }
            }
        }
    }
}
