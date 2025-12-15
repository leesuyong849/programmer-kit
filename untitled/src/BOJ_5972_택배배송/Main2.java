package BOJ_5972_택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

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
            graph[b].add(new Node(a, w));  // 양방향

            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dij(1);

            System.out.println(dist[N]);
        }
    }

    public static void dij(int a) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{a, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int curW = poll[1];

            if (poll[1] <= dist[a]) {
                dist[a] = poll[1];

                List<Node> nodes = graph[cur];
                for (Node node : nodes) {
                    int next = node.to;
                    int w = node.w;

                    if (curW + w < dist[next]) {
                        dist[next] = curW + w;
                        pq.add(new int[] {next, curW + w});
                    }
                }
            }
        }

    }
}
