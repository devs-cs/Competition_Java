import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ICPC_Local_P4 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int cases = 0; cases < t; cases++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashMap<Character, Integer> votes = new HashMap<Character, Integer>();
            char[][] voteHistory = new char[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(r.readLine());
                voteHistory[i] = st.nextToken().toCharArray();
            }
            for (int i = 0; i < n; i++) {
                char poli = voteHistory[i][0];
                votes.put(poli, votes.get(poli) + 1);
            }
            int max = 0;
            

        }

    }
}
