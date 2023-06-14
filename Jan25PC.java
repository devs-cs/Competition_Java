import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Jan25PC {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> meals = new HashMap<Integer, Integer>();
            int[] tables = new int[m];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (meals.putIfAbsent(num, 1) != null)
                    meals.put(num, meals.get(num) + 1);
            }

            TreeMap<Integer, Integer> mealsRev = new TreeMap<Integer, Integer>();
//            System.out.println("MEALS " + meals.keySet());
//            System.out.println("MEALS VAL " + meals.values());
            for (int key : meals.keySet()) {
                {

                    if (mealsRev.putIfAbsent(meals.get(key), 1) != null)
                        mealsRev.put(meals.get(key), mealsRev.get(meals.get(key)) + 1); //ok so key is amount of people for that meals, and val is amount of overlap (basically like a set)

                }

            }
//            System.out.println("MEALSREV " + mealsRev.keySet());


            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < m; i++)
                tables[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(tables);
            int ans = 0;
            for (int i = m - 1; i >= 0; i--) {
                int max = mealsRev.lastKey();
                int used = Math.min(max, tables[i]);
                ans += used;
//                System.out.println("MAX + USED" + max + " " + used);
                if (mealsRev.get(max) > 1)
                    mealsRev.put(max, mealsRev.get(max) - 1);
                else
                    mealsRev.remove(max);
                if (mealsRev.putIfAbsent(max - used, 1) != null)
                    mealsRev.put(max - used, mealsRev.get(max - used) + 1);
            }
            pw.println(ans);
        }
        pw.close();
    }
}
