package BOJ_10026_적록색약;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Character[][] map;
    static Character[][] map2;
    static int[] calX = {0,0,-1,1};
    static int[] calY = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Character[N][N];
        map2 = new Character[N][N];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                map2[i][j] = c == 'R' ? 'G' : c;
            }
        }

        StringBuilder sb = new StringBuilder();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'O') continue;

                result++;
                dfs(i, j, map[i][j], map);
            }
        }
        sb.append(result).append(' ');

        result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map2[i][j] == 'O') continue;

                result++;
                dfs(i, j, map2[i][j], map2);
            }
        }

        sb.append(result);
        System.out.println(sb);
    }

    static void dfs(int x, int y, int c, Character[][] map) {
        for (int i = 0; i < 4; i++) {
            int nx = x + calX[i];
            int ny = y + calY[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            else if (map[nx][ny] != c) continue;

            map[nx][ny] = 'O';
            dfs(nx, ny, c, map);
        }
    }
}
