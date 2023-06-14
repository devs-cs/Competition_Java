import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Jan25PA {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
//           int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            ArrayList<Integer> even = new ArrayList<Integer>();
            ArrayList<Integer> odd = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0)
                    even.add(i);
                else
                    odd.add(i);
            }
            if (odd.size() >= 1 && even.size() >= 2) {
                pw.println("YES");
                pw.println((odd.get(0) + 1) + " " + (even.get(0) + 1) + " " + (even.get(1) + 1));
            } else if (odd.size() >= 3) {
                pw.println("YES");
                pw.println((odd.get(0) + 1) + " " + (odd.get(1) + 1) + " " + (odd.get(2) + 1));
            } else
                pw.println("NO");

        }
        pw.close();
    }
}
