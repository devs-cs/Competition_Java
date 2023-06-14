import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Mean_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        double sum = 0;
        int n = Integer.parseInt(st.nextToken());
        if (n == 0) return;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            sum += Integer.parseInt(st.nextToken());
        }
        int real = (int) sum / n;
        int decimal = (int) Math.round(sum / n * 1000 - 1000 * real);
        if (decimal < 10)
            pw.println(real + ".00" + decimal);
        else if (decimal < 100)
            pw.println(real + ".0" + decimal);
        else
            pw.println(real + "." + decimal);
        pw.close();
    }
}
