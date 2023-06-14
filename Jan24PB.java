import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Jan24PB {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            int a4 = Integer.parseInt(st.nextToken());
            if (a2 > a3) {
                int temp = a2;
                a2 = a3;
                a3 = temp;
            }
            if (a1 == 0)
                pw.println(1);
            else {
                int ans = a1 + 2 * a2;
                if (a3 - a2 > a1) {
                    ans += a1;
                    ans++;
                    pw.println(ans);
                } else {
                    ans += a3 - a2;
                    ans += Math.min(a1 - (a3 - a2) + 1, a4);
                    pw.println(ans);
                }
            }
        }
        pw.close();
    }
}
