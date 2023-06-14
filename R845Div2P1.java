import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R845Div2P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int counter = 0;
            for (int i = 1; i < n; i++) {
                if ((arr[i] - arr[i - 1]) % 2 == 0)
                    counter++;
            }
            pw.println(counter);
        }
        pw.close();
    }
}
