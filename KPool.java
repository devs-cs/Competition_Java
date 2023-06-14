import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KPool {


    private static long count = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        double p = Double.parseDouble(st.nextToken());
        boolean exit = true;
        int minN = -1;
        double min = 100;
        for (int n = 2; n <= 16; n++) {
            double e = 1 * Math.pow(1 - p, n) + n * (1 - Math.pow(1 - p, n));
            if (e < n) exit = false;
            if (e / n < min || minN == -1) {
                minN = n;
                min = e / n;
            }
        }
        if (!exit)
            pw.println(minN);
        else
            pw.println(1);
        pw.close();
    }


}
