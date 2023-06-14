import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Jan25PB {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            long sum = 0L;
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            long curSum = 0L;
            long maxGCD = 0;
            for (int i = 0; i < n - 1; i++) {
                curSum += arr[i];
                sum -= arr[i];
                if (gcd(curSum, sum) > maxGCD)
                    maxGCD = gcd(curSum, sum);
            }
            pw.println(maxGCD);
        }
        pw.close();
    }

    private static long gcd(long a, long b) {
        if (a == 0L)
            return (b);
        return (gcd(b % a, a));
    }
}
