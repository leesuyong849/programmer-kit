//package BOJ_2086_내려가기;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int[][] map;
//    static int[][] map2;
//    static int[][][] result;
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        map = new int[N][3];
//        result = new int[N][3][3];
//
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            map[i][0] = Integer.parseInt(st.nextToken());
//            map[i][1] = Integer.parseInt(st.nextToken());
//            map[i][2] = Integer.parseInt(st.nextToken());
//        }
//
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(map2[i], Integer.MAX_VALUE);
//            for (int j = 0; j < 3; j++) {
//                Arrays.fill(result[1][j], Integer.MAX_VALUE);
//            }
//        }
//
//        for (int i = 0; i < 3; i++) {
//            result[0][i][0] = map[0][i];
//            result[0][i][1] = map[0][i];
//            result[0][i][2] = map[0][i];
//            map2[0][i] = map[0][i];
//        }
//
//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (j > 0) {
//                    map2[i][j] = Math.min(map2[i - 1][j], map2[i - 1][j - 1]);
//                    return;
//                } else if (j , 2) {
//
//                }
//
//                map2[]
//            }
//        }
//    }
//}
