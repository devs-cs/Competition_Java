import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class R845Div2P1actual {
    public static void main(String[] args) throws IOException {
        //idk what this issue is;
        long mod = 1000000007;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(r.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] factorials = new long[10001];
        factorials[0] = 1;
        for (int i = 1; i < 10001; i++)
            factorials[i] = i * factorials[i - 1] % mod;
        for (int cases = 0; cases < t; cases++) {
            int n = arr[cases];
            long ans = factorials[n] * n % mod;
            ans = ans * (n - 1) % mod;
            pw.println(ans);
        }
        pw.close();
    }
}
