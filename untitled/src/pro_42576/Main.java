package pro_42576;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
    }

    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> map = new HashMap<>();

            for (String s : participant) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (String s : completion) {
                map.put(s, map.get(s) - 1);
            }

            for (Map.Entry<String, Integer> s : map.entrySet()) {
                if (s.getValue() > 0) return s.getKey();
            }
            return "";
        }
    }
}
