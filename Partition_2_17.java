import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Partition_2_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            sum += Math.abs(Integer.parseInt(st.nextToken()));
        }
        pw.println(sum);
        pw.close();
    }
}
