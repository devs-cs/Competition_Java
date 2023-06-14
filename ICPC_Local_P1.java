import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ICPC_Local_P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
//        System.out.println("T" + t);
        for (int cases = 0; cases < t; cases++) {

            st = new StringTokenizer(r.readLine());

            int V = Integer.parseInt(st.nextToken());
//            System.out.println("TEST" + V);
            int[] count = new int[1000];
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(r.readLine());
                int val = Integer.parseInt(st.nextToken());
//                System.out.println("VAL" + val);
                count[val - 1]++;
            }
            int max = 0;
            int maxCount = count[0];
            for (int i = 1; i < count.length; i++) {
                if (count[i] > maxCount) {

                    max = i;
                    maxCount = count[i];
                }
            }
            pw.println(max + 1);
        }
        pw.close();
    }
}
