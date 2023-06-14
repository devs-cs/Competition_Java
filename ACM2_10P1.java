import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACM2_10P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        st = new StringTokenizer(r.readLine());
        char[] arr = st.nextToken().toCharArray();
        int pos = 0;
        int a = 0;
        int b = 1;
        while (pos < n) {
            if (pos % 2 == a && arr[pos] == 'R') {
                a = 1 - a;
                b = 1 - b;
                count++;
            }

            if (pos % 2 == b && arr[pos] == 'L') {
                a = 1 - a;
                b = 1 - b;
                count++;
            }
            pos++;
        }
        pw.println(Math.max(k - count, 0));
        pw.close();

        ///LLL, first go Left, then Right (fall), sot they go left, then start right.
    }
}
