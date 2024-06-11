import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AOJBoardCover {
    static int[][][] coverType = {
            {{0, 0}, {0, 1}, {1, 0}},
            {{0, 0}, {1, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 1}}
    };

    static int TC, H, W;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new int[H][W];
            int countWhite = 0;
            for (int y = 0; y < H; y++) {
                char[] row = br.readLine().trim().toCharArray();
                for (int x = 0; x < W; x++) {
                    if (row[x] == '#')
                        board[y][x] = 1;
                    else
                        countWhite++;
                }
            }

            if (countWhite % 3 != 0) {
                System.out.println(0);
                continue;
            }

            System.out.println(cover());
        }
    }

    static boolean set(int y, int x, int type, int delta) {
        boolean ok = true;

        for (int i = 0; i < 3; i++) {
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];

            if (ny < 0 || ny >= H || nx < 0 || nx >= W)
                ok = false;
            else if ((board[ny][nx] += delta) > 1)
                ok = false;
        }

        return ok;
    }

    static int cover() {
        int y = -1, x = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) break;
        }

        if (y == -1) return 1;

        int ret = 0;
        for (int type = 0; type < 4; type++) {
            if (set(y, x, type, 1)) {
                ret += cover();
            }
            set(y, x, type, -1);
        }

        return ret;
    }
}
