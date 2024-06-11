import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AOJClockSync {
    static final int SWITCHES = 10;
    static final int CLOCKS = 16;
    static final int[][] linked = {
            {0, 1, 2},
            {3, 7, 9, 11},
            {4, 10, 14, 15},
            {0, 4, 5, 6, 7},
            {6, 7, 8, 10, 12},
            {0, 2, 14, 15},
            {3, 14, 15},
            {4, 5, 7, 14, 15},
            {1, 2, 3, 4, 5},
            {3, 4, 5, 9, 13}
    };
    static final int INF = 987654321;

    static int TC;
    static int[] clocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            clocks = new int[CLOCKS];
            for (int i = 0; i < 16; i++) {
                clocks[i] = Integer.parseInt(st.nextToken());
            }

            int answer = solve(0);

            System.out.println(answer == INF ? -1 : answer);
        }
    }

    static int solve(int swtch) {
        if (swtch == SWITCHES) {
            if (areAligned())
                return 0;
            return INF;
        }

        int ret = INF;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = Math.min(ret, solve(swtch + 1) + cnt);
            push(swtch);
        }

        return ret;
    }

    static void push(int swtch) {
        for (int clock : linked[swtch]) {
            clocks[clock] += 3;
            if (clocks[clock] == 15) clocks[clock] = 3;
        }
    }

    static boolean areAligned() {
        for (int i = 0; i < CLOCKS; i++) {
            if (clocks[i] != 12)
                return false;
        }
        return true;
    }
}
