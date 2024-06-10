import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ30802 {
    static int N, T, P;
    static int[] shirtsNeed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        shirtsNeed = new int[6];
        for (int i = 0; i < 6; i++) {
            shirtsNeed[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int shirtSetsNeed = 0;
        for (int i = 0; i < 6; i++) {
            shirtSetsNeed += shirtsNeed[i] / T;
            if (shirtsNeed[i] % T != 0) shirtSetsNeed++;
        }

        int penSetsNeed = N / P;
        int pensNeed = N % P;

        System.out.println(shirtSetsNeed);
        System.out.println(penSetsNeed + " " + pensNeed);
    }
}
