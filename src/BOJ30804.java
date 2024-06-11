import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ30804 {
    static int N;
    static int[] fruits;
    static int[] selected;
    static int maxFruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[2];
        maxFruits = 0;
        combinationDup(0);

        System.out.println(maxFruits);
    }

    static void combinationDup(int index) {
        if (index == 2) {
            // 과일 종류 선택 완료
            int len = getMaxSection();
            maxFruits = Math.max(maxFruits, len);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            selected[index] = i;
            combinationDup(index + 1);
        }
    }

    static int getMaxSection() {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < N) {
            if (fruits[right] == selected[0] || fruits[right] == selected[1]) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                left = right + 1;
                right++;
            }
        }

        return maxLen;
    }
}
