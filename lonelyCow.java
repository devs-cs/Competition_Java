import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lonelyCow {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] cows = new boolean[n];
        st = new StringTokenizer(r.readLine());
        int[] nextH = new int[n + 1];
        int[] nextG = new int[n + 1];
        String input = st.nextToken();
        for (int i = 0; i < n; i++)
            cows[i] = (input.charAt(i) == 'G'); //true if G, false if H
        int mostRecentH = -1;
        int mostRecentG = -1;
        nextH[n] = -1;
        nextG[n] = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (cows[i])
                mostRecentG = i;
            else
                mostRecentH = i;
            nextH[i] = mostRecentH;
            nextG[i] = mostRecentG;
        }
//        System.out.println(Arrays.toString(nextH));
//        System.out.println(Arrays.toString(nextG));

        long sum = 0L;
        for (int i = 2; i < n; i++) {
//            System.out.println(i);
            int countG = 0;
            int countH = 0;
            for (int j = 0; j < 3; j++) {
                if (cows[i - j])
                    countG++;
                else
                    countH++;
            }
//            System.out.println(i + " " + sum + " " + countG + " " + countH);
            if (countG == 3) // GGG.. H... H, //GHG.... H // HHG.. G //HHH -> G ->G
            {
                if (nextH[i + 1] == -1)
                    sum += n - i + 1;
                else if (nextH[i + 1] != -1 && nextH[nextH[i + 1] + 1] == -1)
                    sum += nextH[i + 1] - i;
                else {
                    sum += nextH[i + 1] - i;
                    sum += n - nextH[nextH[i + 1] + 1] + 1; //1 2 3 4 5
                }
            } else if (countG == 2) {
                if (nextH[i + 1] == -1) ;
                else
                    sum += n - nextH[i + 1];
            } else if (countG == 1) {
                if (nextG[i + 1] == -1) ;
                else {
//                    System.out.println("occurs");
                    sum += n - nextG[i + 1];
                }

            } else {
                if (nextH[i + 1] == -1)
                    sum += n - i + 1;
                else if (nextH[i + 1] != -1 && nextH[nextH[i + 1] + 1] == -1) {
                    sum += nextG[i + 1] - i;
                } else {
                    sum += nextG[i + 1] - i;
                    sum += n - nextG[nextG[i + 1] + 1] + 1;
                }
            }
        }
        pw.println(sum);
        pw.close();

    }
}



/*
GGHGHHGHGH
0GGH-6 solutions
1GHG - 6 solutions
2HGH - 4 solutions
3GHH - 4
4HHG - 2
5HGH - 2
6GHG - 1
7 HGH - 0

6 + 6 + 4 + 4 + 2 + 2 + 1

GGHGH...
when is our next H;
when is our next G;

 */

//GGGGG - 3 + 2 + 1
