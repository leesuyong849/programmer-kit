package BOJ_7682_틱택토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();

            if (s.equals("end")) break;

            int countX = 0, countO = 0;
            int longX = 0; int longO = 0;       //연속한 값 기록
            boolean flagX = false, flagO= false, flagDot = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'X') {
                    countX++;
                    longO = 0;
                    longX++;

                    if (longX > 3) break;
                    else if (longX == 3) flagX = true;
                } else if (c == 'O') {
                    countO++;
                    longO++;
                    longX = 0;

                    if (longO > 3) break;
                    else if (longO == 3) flagO = true;
                } else {
                    flagDot = true;
                }
            }

            if (longX > 3 || longO > 3 || Math.abs(countX - countO) > 1) System.out.println("invalid");
            else if ((!flagO && !flagX) && flagDot) System.out.println("invalid");
            else if (countX < countO) System.out.println("invalid");
            else System.out.println("valid");

        }
    }
}
