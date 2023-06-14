import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class TheoremAI {
    /*
    Essentially, we represent all the implications on a graph
    We iterate through the entire graph n times, setting something to true
    if all of its prereqs are true. Then by the end, we see if the
    necessary theorems are true.

    I was not sure about the input format (seems to be different in question
    and test cases, so I defaulted to the one in the test cases)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> axioms = new ArrayList<String>();
        ArrayList<String> theorems = new ArrayList<String>();
        ArrayList<ArrayList<String>> dependencies = new ArrayList<>();
        ArrayList<String> toProve = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            String start = st.nextToken();
            if (start.equals("axiom"))
                axioms.add(st.nextToken());
            else if (start.equals("imply")) {
                int rem = Integer.parseInt(st.nextToken());
                ArrayList<String> temp = new ArrayList<String>();
                for (int j = 0; j < rem; j++)
                    temp.add(st.nextToken());
                theorems.add(st.nextToken());
                dependencies.add(temp);
            } else if (start.equals("prove")) {
                int rem = Integer.parseInt(st.nextToken());
                for (int j = 0; j < rem; j++)
                    toProve.add(st.nextToken());
            } else
                System.out.println("ERROR");
        }
        HashSet<String> proved = new HashSet<String>();
        for (int i = 0; i < axioms.size(); i++) {
            proved.add(axioms.get(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dependencies.size(); j++) {
                if (proved.contains(theorems.get(j)))
                    continue;
                boolean pro = true;
                for (int k = 0; k < dependencies.get(j).size(); k++) {
                    if (!proved.contains(dependencies.get(j).get(k))) {
                        pro = false;
                        break;
                    }
                }
                if (pro)
                    proved.add(theorems.get(j));
            }
        }
        boolean output = true;
        for (int i = 0; i < toProve.size(); i++) {
            if (!proved.contains(toProve.get(i)))
                output = false;
        }
        if (output)
            pw.println("provable");
        else
            pw.println("unprovable");
        pw.close();
    }
}
