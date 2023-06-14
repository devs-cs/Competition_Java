import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Jan25PD {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            int ans = 0;
            boolean know = false;
            while (true) {
                st = new StringTokenizer(r.readLine());
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    pw.close();
                    return;
                }

                if (num == 0) {
                    pw.println("! " + ans);
                    pw.flush();
                    break;
                }
                String outputStr = "";
                for (int i = 0; i < num; i++)
                    outputStr += "1";
                pw.println("- " + Integer.parseInt(outputStr, 2));
                pw.flush();
                ans += Integer.parseInt(outputStr, 2);

            }
        }

    }
}
