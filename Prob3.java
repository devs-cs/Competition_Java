import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] h = new int[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(r.readLine());
        int height = Integer.parseInt(st.nextToken());
        int min = 0;
        int minValue = height % h[0];
        for (int i = 1; i < n; i++) {
            if (minValue > height % h[i]) {
                min = i;
                minValue = height % h[i];
            }
        }
        pw.println(h[min]);
        pw.close();
    }
}
