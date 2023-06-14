import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BASH_ICPC2 {

    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        double[] w = new double[n];
        double[] c = new double[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            w[i] = Double.parseDouble(st.nextToken());
            c[i] = Double.parseDouble(st.nextToken());
        }
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        recur(sequence, 0, w, c);
        pw.println(max);
        pw.close();

    }

    private static void recur(ArrayList<Integer> arr, int dep, double[] w, double[] c) {
//        System.out.println(arr);
        if (dep == w.length) {
            for (int i = 0; i < arr.size() - 1; i++) {
                if (w[arr.get(i + 1)] <= w[arr.get(i)] || c[arr.get(i + 1)] >= c[arr.get(i)])
                    return;
            }
            if (max < arr.size()) {
                max = arr.size();
//                System.out.println(arr);
            }

            return;
        }
        recur(arr, dep + 1, w, c);
        arr.add(dep);
        recur(arr, dep + 1, w, c);
        arr.remove(arr.size() - 1);
    }
}
