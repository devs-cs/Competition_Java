import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SpringFinal4 {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int horses = Integer.parseInt(st.nextToken());
        int counter = 0; //give each horse a num maybe
        HashMap<String, Integer> horseNum = new HashMap<String, Integer>();
        HashMap<Integer, String> numHorse = new HashMap<Integer, String>();
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < horses; i++) {
            String horse = st.nextToken();
            horseNum.put(horse, counter);
            numHorse.put(counter, horse);
            counter++;
        }
        int horseCap[] = new int[horses]; //highest position you could possibly be

        st = new StringTokenizer(r.readLine());
        int raceC = Integer.parseInt(st.nextToken());

        HashSet<Integer>[] horseNot = new HashSet[horses];
        for (int i = 0; i < horses; i++)
            horseNot[i] = new HashSet<Integer>();


        for (int i = 0; i < raceC; i++) {
            st = new StringTokenizer(r.readLine());
            int M, W;
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            HashSet<Integer> used = new HashSet<Integer>();
            for (int j = 0; j < M; j++) {
                String h = st.nextToken();
                int index = horseNum.get(h);
                horseCap[index] = Math.max(W, horseCap[index]);
                used.add(index);
            }
//            for (int k : used)
//                System.out.println(k);
            for (int j = 0; j < horses; j++) {
                if (!used.contains(j))
                    horseNot[j].add(W);
            }
        }
//        System.out.println(Arrays.toString(horseCap));
//        System.out.println(horseNot[2].contains(2));
//        System.out.println(numHorse.get(0));

        for (int i = 1; i <= horses; i++) {
            boolean hit = false;
            for (int j = 0; j < horses; j++) {
                if (horseCap[j] <= i && !horseNot[j].contains(i)) {
//                    pw.println(i);
                    hit = true;
                    pw.println(numHorse.get(j) + " ");
                    horseCap[j] = 10000;
                    break;
                }
            }
            if (!hit) {
                int count = 0;
                while (true) {
                    count++;
                }
            }
        }
        pw.close();
    }


}
