package BOJ_7682_틱택토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Character[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            map = new Character[3][3];

            if (s.equals("end")) break;

            //각 문자 갯수
            int countX = 0, countO = 0;
            //. 이 있는지 확인
            boolean flagDot = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int floor = (int) Math.floor(i / 3);
                int y = i % 3;
                map[floor][y] = c;

                if (c == '.') flagDot = true;
                else if (c == 'X') countX++;
                else if (c == 'O') countO++;
            }

            //연속된 것이 몇개 있는지 확인한다.
            int flag = check();

            if (Math.abs(countX - countO) > 1 || countX < countO) {
                System.out.println("invalid1");
                continue;
            }

            if (flag > 1) {
                if (flag == 2 && checkDoubleCross()) System.out.println("valid");
                else System.out.println("invalid2");
            }
            else if (flag == 0) {
                if (flagDot) System.out.println("invalid3");
                else System.out.println("valid");
            } else {
                System.out.println("valid");
            }
        }
    }

    public static int check() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] != '.') count++;
            else if (map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] != '.') count++;
        }
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[1][1] != '.') count++;
        if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && map[1][1] != '.') count++;
        return count;
    }

    public static boolean checkDoubleCross() {
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[1][1] != '.') {
            if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                return true;
            }
        }
        return false;
    }
}
