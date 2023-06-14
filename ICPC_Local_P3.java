import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ICPC_Local_P3 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] list1 = new String[n];
            String[] list2 = new String[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(r.readLine());
                list1[i] = st.nextToken();
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(r.readLine());
                list2[i] = st.nextToken();
            }
            HashMap<String, Integer> diff = new HashMap<String, Integer>();
            int unPartnered = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count++;
                diff.putIfAbsent(list1[i], 0);
                diff.put(list1[i], diff.get(list1[i]) + 1);
                if (diff.get(list1[i]) == 0)
                    unPartnered--;
                else if (diff.get(list1[i]) == 1)
                    unPartnered++;
                diff.putIfAbsent(list2[i], 0);
                diff.put(list2[i], diff.get(list2[i]) - 1);
                if (diff.get(list2[i]) == 0)
                    unPartnered--;
                else if (diff.get(list2[i]) == -1)
                    unPartnered++;
                if (unPartnered == 0) {
                    pw.print(count + " ");
                    count = 0;
                }
            }
            pw.println();

        }
        pw.close();
    }
}
