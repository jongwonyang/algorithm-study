import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {
    static final int INF = 987654321;
    static int N, M;
    static int[][] minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        minCost = new int[N + 1][N + 1];
        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++) {
                if (from == to) minCost[from][to] = 0;
                else minCost[from][to] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            minCost[from][to] = Math.min(minCost[from][to], c);
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int from = 1; from <= N; from++) {
            for (int to = 1; to <= N; to++) {
                if (minCost[from][to] == INF)
                    sb.append(0);
                else
                    sb.append(minCost[from][to]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void floyd() {
        for (int by = 1; by <= N; by++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    minCost[from][to] = Math.min(minCost[from][to], minCost[from][by] + minCost[by][to]);
                }
            }
        }
    }
}
