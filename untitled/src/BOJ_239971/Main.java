package BOJ_239971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static float H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        double x = Math.ceil( H / (N + 1));
        double y = Math.ceil(W / (M+1));

        int result = (int) ((int) x * y);

        System.out.println(result);
    }
}
