import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpringFinal3 {
    

    public static long exp(long a, long b) {
        long sol = 1;
        for (int i = 0; i < b; i++) {
            sol *= a;
        }
        return sol;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
//        StringTokenizer st = new StringTokenizer(r.readLine());
//        int cases = Integer.parseInt(st.nextToken());
        int cases = 1;
        for (int t = 0; t < cases; t++) {
            int N;
            long P, H;
            StringTokenizer st = new StringTokenizer(r.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Long.parseLong(st.nextToken());
            H = Long.parseLong(st.nextToken());
            String sol = ""; //0 for switch, 1  for not switch

            long pos = exp(2, N);
            H = pos - H; //now posiiton from bottom
            while (N >= 1) { //layer
                if (pos - H > pos / 2) {
                    sol += "1";
                    H = pos - H;
                } else {
                    sol += "0";
                }
                N--;
            }
            pw.println(sol);
        }

        pw.close();
    }


}
