import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Jan24PD {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            if (n % 2 == 0) {
                int left = 0; //num we are looking for n/2 and n/2+1
                int right = n - 1;
                while (arr[left] != n / 2)
                    left++;
                while (arr[right] != n / 2 + 1)
                    right++;
                if (right > left) {
                    pw.println(n / 2);
                    continue;
                }
                int proper = 2;
                while (left - 1 >= 0 && arr[left - 1] == arr[left] - 1) {
                    left--;
                    proper++;
                }

                while (right + 1 < n && arr[right + 1] == arr[right] + 1) {
                    right++;
                    proper++;
                }
                pw.println((n - proper + 1) / 2); //rounds up for integers
            } else {
                int left = 0; //num we are looking for n/2 and n/2+1
                int right = n - 1;
                while (arr[left] != n / 2 + 1) //i.e with 5 we want 3, so 5/2 + 1 = 3
                    left++;
                while (arr[right] != n / 2 + 1)
                    right++;
                if (right > left) {
                    pw.println(n / 2);
                    continue;
                }
                int proper = 1;
                while (left - 1 >= 0 && arr[left - 1] == arr[left] - 1) {
                    left--;
                    proper++;
                }

                while (right + 1 < n && arr[right + 1] == arr[right] + 1) {
                    right++;
                    proper++;
                }
                pw.println((n - proper + 1) / 2); //rounds up for integers
            }
        }
        pw.close();
    }
}
