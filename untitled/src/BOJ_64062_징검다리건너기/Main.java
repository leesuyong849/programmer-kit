package BOJ_64062_징검다리건너기;

public class Main {


}

class Solution64062 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        while(true) {
            int check = 0;
            for (int i = 0; i < stones.length; i++) {
                if(stones[i] > 0) {
                    stones[i] -= 1;
                    check = 0;
                } else {
                    check++;
                    if (check == k) {
                        return answer;
                    }
                }
            }
            answer++;
        }
    }
}
