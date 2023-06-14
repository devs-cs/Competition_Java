import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SpringFinal1 {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cases = Integer.parseInt(st.nextToken());
        for (int t = 0; t < cases; t++) {
            int m;
            int s;
            st = new StringTokenizer(r.readLine());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            int arr[] = new int[m];
            st = new StringTokenizer(r.readLine());
            int max = 0;
            HashSet<Integer> repeated = new HashSet<Integer>();
            boolean valid = true;
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (repeated.contains(arr[i]))
                    valid = false;
                else
                    repeated.add(arr[i]);
                max = Math.max(max, arr[i]);
            }

            int count = 1;
            while (count < max) {
                if (repeated.contains(count))
                    count++;
                else {
                    s -= count;
                    count++;
                }
            }
            while (s > 0) {
                if (repeated.contains(count))
                    count++;
                else {
                    s -= count;
                    count++;
                }
            }
            if (s != 0)
                valid = false;
            if (valid)
                pw.println("YES");
            else
                pw.println("NO");
        }

        pw.close();
    }


}
