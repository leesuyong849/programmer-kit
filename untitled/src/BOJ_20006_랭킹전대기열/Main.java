package BOJ_20006_랭킹전대기열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int p, m;
    static ArrayList<Room> rooms;

    static class Room {
        int standard;
        int memberCnt;
        Map<String, Integer> map = new TreeMap<>();

        public Room(int s, int m) {
            this.standard = s;
            this.memberCnt = m;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            int fullNum = isFull(sc);
            if (fullNum == Integer.MAX_VALUE) {     //가능한 방이 없다면
                Room room = new Room(sc, 1);
                room.map.put(name, sc);
                rooms.add(room);

            } else {
                Room room = rooms.get(fullNum);
                room.map.put(name, sc);
                room.memberCnt++;
            }
        }

        for (Room room : rooms) {
            if (room.memberCnt == m) sb.append("Started!").append('\n');
            else sb.append("Waiting!").append('\n');
            Map<String, Integer> map = room.map;
            for (String s : map.keySet()) {
                Integer integer = map.get(s);
                sb.append(integer).append(' ').append(s).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    //사용가능한 방이 있으면 해당 인덱스를,
    //없으면 MAX_VALUE를 반환한다.
    public static int isFull(int sc) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);

            if (room.memberCnt < m && Math.abs(room.standard - sc) <= 10) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }
}
