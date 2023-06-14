import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BF3 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] arrChar = new char[n];
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            arrChar = st.nextToken().toCharArray();
            for (int i = 0; i < n; i++) {
                arr[i] = arrChar[i] - '0';
            }
            int count = 0;
            for (int i = 0; i < n; i++) {

                for (int j = 0; j <= i; j++) {
                    int sum = 0;
                    for (int k = j; k <= i; k++)
                        sum += arr[k];
                    if (sum == i - j + 1)
                        count++;
                }
            }
            pw.println(count);
        }
        pw.close();
    }
}
