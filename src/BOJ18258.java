import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {
    static int N;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    static void push(int x) {
        q.offerLast(x);
    }

    static int pop() {
        if (!q.isEmpty())
            return q.pollFirst();
        return -1;
    }

    static int size() {
        return q.size();
    }

    static int empty() {
        return q.isEmpty() ? 1 : 0;
    }

    static int front() {
        if (!q.isEmpty())
            return q.peekFirst();
        return -1;
    }

    static int back() {
        if (!q.isEmpty())
            return q.peekLast();
        return -1;
    }
}
