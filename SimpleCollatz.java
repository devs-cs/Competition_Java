import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleCollatz {


    private static long count = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
//        recur(1, 0);
        long even = 0;
        long odd = 1;
        for (int i = 1; i < n; i++) {
            long tempEven = even;
            long tempOdd = odd;
            even = (tempEven + tempOdd) % 1000007;
            odd = tempEven % 1000007;
        }
        pw.println((even + odd) % 1000007);
        pw.close();
    }


}
