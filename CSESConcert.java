import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CSESConcert {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.merge(temp, 1, (oldVal, newVal) -> oldVal + 1);
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            Integer val = map.get(num);
            Integer lwr = -1;
            boolean ran = false;
            if (val != null) {
                pw.println(num);
                if (map.get(num) == 1)
                    map.remove(num);
                else
                    map.put(num, val - 1);
                ran = true;
            }
            if (!ran)
                lwr = map.lowerKey(num);
            if (!ran && lwr != null) {
                pw.println(lwr);
                if (map.get(lwr) == 1)
                    map.remove(lwr);
                else
                    map.put(lwr, map.get(lwr) - 1);
            } else
                pw.println(-1);
        }
        pw.close();
    }
}
