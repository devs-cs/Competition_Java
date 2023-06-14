import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ICPC_Local_P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            double[] w = new double[n];
            double[] c = new double[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(r.readLine());
                w[i] = Double.parseDouble(st.nextToken());
                c[i] = Double.parseDouble(st.nextToken());
            }
            int[] overlap = new int[n];
            overlap[0] = 1;
            for (int i = 1; i < n; i++) {
                int pos = i;
                int maxOverlap = 0;
                while (pos >= 0) {
                    if (w[pos] < w[i] && c[pos] > c[i]) {
                        if (overlap[pos] > maxOverlap) {
                            maxOverlap = overlap[pos];
                            overlap[i] = overlap[pos] + 1;
                        }
                    }
                    pos--;
                }
                if (overlap[i] == 0)
                    overlap[i] = 1;

            }
            int maxOverlap = overlap[0];
            for (int i = 1; i < n; i++)
                maxOverlap = Math.max(maxOverlap, overlap[i]);
            pw.println(maxOverlap);
        }
        pw.close();
    }
}
