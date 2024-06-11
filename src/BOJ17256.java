import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17256 {
    static int ax, ay, az, bx, by, bz, cx, cy, cz;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ax = Integer.parseInt(st.nextToken());
        ay = Integer.parseInt(st.nextToken());
        az = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cx = Integer.parseInt(st.nextToken());
        cy = Integer.parseInt(st.nextToken());
        cz = Integer.parseInt(st.nextToken());

        bx = cx - az;
        by = cy / ay;
        bz = cz - ax;

        System.out.println(bx + " " + by + " " + bz);
    }
}
