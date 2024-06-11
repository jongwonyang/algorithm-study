import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AOJPicnic {
    static int TC, N, M;
    static boolean[][] areFriends;
    static boolean[] taken;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            areFriends = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                areFriends[a][b] = true;
                areFriends[b][a] = true;
            }

            taken = new boolean[N];
            answer = 0;
            countPairings();

            System.out.println(answer);
        }

    }

    static void countPairings() {
        int firstFree = -1;

        for (int i = 0; i < N; i++) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }

        if (firstFree == -1) {
            answer++;
            return;
        }

        for (int pairWith = firstFree + 1; pairWith < N; pairWith++) {
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                taken[firstFree] = taken[pairWith] = true;
                countPairings();
                taken[firstFree] = taken[pairWith] = false;
            }
        }

    }
}
