import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jan24P0 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(
                r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int start = 0;
            int spells = 0;
            while ((arr[start] == 1 || arr[start] == 0) && start + 1 < n) {
                if (arr[start] == 1) {
                    spells++;
                    arr[start]--;
                    arr[start + 1]--;
                }
                start++;
            }
            for (int i = Math.max(spells - 1, 0); i < n; i++)
                if (arr[i] >= 1)
                    spells++;
            pw.println(spells);

        }
        pw.close();
    }
}

// 1 1 1 2 2
// 1 1, 1 1, 1 2
