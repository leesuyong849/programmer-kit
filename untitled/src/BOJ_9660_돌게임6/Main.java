package BOJ_9660_돌게임6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long N = Long.parseLong(br.readLine());

        if(N == 1) System.out.println("SK");
        else if(N == 2) System.out.println("CY");
        else {
            int flag = (int) ((N-3) % 7L);
            if(flag == 4 || flag == 6)
                System.out.println("CY");
            else
                System.out.println("SK");
        }
    }
}
