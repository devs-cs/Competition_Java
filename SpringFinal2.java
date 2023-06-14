import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SpringFinal2 {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cases = Integer.parseInt(st.nextToken());
        for (int t = 0; t < cases; t++) {
            boolean valid = true;
            int n;
            st = new StringTokenizer(r.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            boolean moved[] = new boolean[n];
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            boolean movedPrior = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1] - arr[i] >= 4) {
                    valid = false;
                    break;
                } else if (arr[i + 1] - arr[i] >= 3 && movedPrior) { //can't move i
                    valid = false;
                    break;
                } else if (arr[i + 1] - arr[i] >= 3) {
                    movedPrior = true;
                    arr[i + 1]--; //now we can only  shift backwards
                } else if (arr[i + 1] - arr[i] >= 2) {
                    arr[i + 1]--; //we can still shift now
                }
            }
            if (valid)
                pw.println("YES");
            else
                pw.println("NO");
        }

        pw.close();
    }


}
