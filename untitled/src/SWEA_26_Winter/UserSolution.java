package SWEA_26_Winter;

class UserSolution {

    static int[][] map = new int[8][8];
    static int[] nextY = new int[8];
    static boolean[][] visited;
    static int resultCal, stdX, stdY, sideX, sideY;
    static int[] ny = new int[] {0,0,1,-1};
    static int[] nx = new int[] {1,-1,0,0};

    void init(int N, int mTiles[][])
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = mTiles[i][j];
            }
            nextY[i] = 8;
        }
    }

    int[] takeTurn()
    {
        int[] ret = new int[5];

        //전체를 탐색하여 가장 높은 점수를 찾는다.
        calScore();
        //결과에 따라 이동한다.

        //삭제 후 빈공간을 채우고 점수를 추가한다.

        //값을 반환한다.
        return ret;
    }

    private void calScore() {
        visited = new boolean[8][8];
        resultCal = 0; stdX = 0; stdY = 0; sideX = 0; sideY = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                int target = map[i][j];

                for (int a = 0; a < 4; a++) {
                    int NX = i + nx[a];
                    int NY = j + ny[a];

                    int semiResult = 0;
                    if (NX >=0 && NX < 8 &&NY >= 0 && NY < 8) {

                        semiResult += leftCheck(NX, NY, target, 0);
                        semiResult += rightCheck(NX, NY, target, 0);
                        semiResult += upCheck(NX, NY, target, 0);
                        semiResult += downCheck(NX, NY, target, 0);
                    }

                    if (semiResult > resultCal) {
                        resultCal = semiResult;
                        stdX = i;
                        stdY = j;
                        sideX = NX;
                        sideY = NY;
                    }
                }
            }
        }
    }

    private int leftCheck(int x, int y, int tar, int depth) {
        if (map[x][y] == tar && y - 1 >= 0) {
            depth = leftCheck(x, y - 1, tar, depth + 1);
        }
        return depth;
    }

    private int rightCheck(int x, int y, int tar, int depth) {
        if (map[x][y] == tar && y + 1 < 8) {
            depth = leftCheck(x, y + 1, tar, depth + 1);
        }
        return depth;
    }

    private int upCheck(int x, int y, int tar, int depth) {
        if (map[x][y] == tar && x + 1 < 8) {
            depth = leftCheck(x + 1, y, tar, depth + 1);
        }
        return depth;
    }

    private int downCheck(int x, int y, int tar, int depth) {
        if (map[x][y] == tar && x - 1 >= 0) {
            depth = leftCheck(x - 1, y, tar, depth + 1);
        }
        return depth;
    }
}
