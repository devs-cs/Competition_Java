import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Good_Subarrays_2_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] arrChar = new char[n];
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            arrChar = st.nextToken().toCharArray();
            for (int i = 0; i < n; i++) {
                arr[i] = arrChar[i] - '0';
                arr[i]--; //this way we just want a sum of 0
            }
            int[] pSums = new int[n + 1];
            pSums[0] = 0;
            for (int i = 1; i < n + 1; i++)
                pSums[i] = pSums[i - 1] + arr[i - 1];
            // so we are actually trying to decompose  it
            // into "base chunks" of 0 sums and notice they can't overlap

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, -1);
            //last time we've seen a value
            int[] chunksBefore = new int[n]; //for each element  in the array, how many chunks that sum to 0 are before it
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0 && i > 0)
                    chunksBefore[i] = chunksBefore[i - 1] + 1;
                else if (arr[i] == 0)
                    chunksBefore[i] = 1;

                if (!map.containsKey(pSums[i + 1])) {
                    chunksBefore[i] = 0;
                } else {
                    int pos = map.get(pSums[i + 1]);
                    if (pos == -1)
                        chunksBefore[i] = 1;
                    else
                        chunksBefore[i] = 1 + chunksBefore[pos];
                }
                map.put(pSums[i + 1], i);
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += chunksBefore[i];
            }
//            System.out.println(cases + " " + Arrays.toString(chunksBefore));
//            System.out.println(Arrays.toString(pSums));
            pw.println(sum);
        }
        pw.close();
    }
}
