import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CodeJamRound1AP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int cnt = 0; cnt < n; cnt++) {
            st = new StringTokenizer(r.readLine());
            String word = st.nextToken();
            char[] letters = word.toCharArray();
            ArrayList<Character> letterChanges = new ArrayList<Character>();
            for (int i = 0; i < letters.length; i++) {
                if (i == 0 || letters[i] != letters[i - 1])
                    letterChanges.add(letters[i]);
            }
            StringBuilder str = new StringBuilder();
            int index = 0;
            for (int i = 0; i < letters.length - 1; i++) {
                if (letterChanges.size() > index + 1 && letters[i] < letterChanges.get(index + 1)) {
                    str.append(letters[i]);
                    str.append(letters[i]);
                } else
                    str.append(letters[i]);
                if (letters[i] != letters[i + 1])
                    index++;
            }
            str.append(letters[letters.length - 1]);
            pw.println("Case #" + cnt + ": " + str);


        }
        pw.close();

    }
}
