package BOJ_12919_A와_B_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        int bf = bf(S);
        System.out.println(bf);
    }

    public static int bf(String str) {
        if (str.equals(T)) {
            return 1;
        } else if (str.length() == T.length()) {
            return 0;
        }


        String next1 = str + "A";

        int bf = bf(next1);
        if (bf == 1) return 1;

        String next2 = new StringBuilder(str + "B").reverse().toString();
        bf = bf(next2);
        if (bf == 1) return 1;

        return 0;
    }
}
