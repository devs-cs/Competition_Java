import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Tri_Color {
    private static boolean[][][] options;
    private static int s;
    private static int[][] colors;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        s = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
//        ArrayList<Integer>[][] edges = new ArrayList[s][s];
        int n = (s) * (s + 1) / 2;
        colors = new int[s][s];
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                colors[i][j] = -1;
        for (int i = 0; i < I; i++) {
            st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            colors[x - 1][y - 1] = c;
        }
        options = new boolean[s][s][3];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j <= i; j++) {

                for (int col = 0; col < 3; col++) {
                    if (validColor(i, j, col, colors))
                        options[i][j][col] = true;
                }
            }
        }
        int testX = 1;
        int testY = 1;
//        System.out.println(testX + " " + testY + " " + colors[testX][testY] + " " + Arrays.toString(options[testX][testY]));
        recur(colors, options, s);
        pw.println(count);
        pw.close();
    }

    private static void recur(int[][] gColors, boolean[][][] gOpt, int s) {
        int rem = 0;

        for (int i = 0; i < s; i++)
            for (int j = 0; j <= i; j++)
                if (gColors[i][j] == -1)
                    rem++;
        if (rem == 0)
            count++;

        int[][] curColors = new int[s][s];
        for (int i = 0; i < s; i++)
            for (int j = 0; j <= i; j++)
                curColors[i][j] = gColors[i][j];
        boolean[][][] curOpt = new boolean[s][s][3];
        for (int i = 0; i < s; i++)
            for (int j = 0; j < s; j++)
                for (int h = 0; h < 3; h++)
                    curOpt[i][j][h] = gOpt[i][j][h];

        boolean madeChange = true;
        while (madeChange) {
            madeChange = false;
//            System.out.println("REM:" + rem);
            for (int i = 0; i < s; i++) {
                for (int j = 0; j <= i; j++) {
                    if (curColors[i][j] != -1) continue;
                    int cnt = 0;
                    int val = 0;
                    for (int col = 0; col < 3; col++) {
                        if (validColor(i, j, col, curColors)) {
                            cnt++;
                            val = col;
                        } else
                            curOpt[i][j][col] = false;
                    }
                    if (cnt == 0) {
//                        System.out.println(i + " " + j + " " + curColors[i][j] + " " + Arrays.toString(curOpt[i][j]));
//                        System.out.println();
//                        for (int as = 0; as < s; as++)
//                            System.out.println(Arrays.toString(curColors[as]));
                        return;
                    }
                    if (cnt == 1) {
                        curColors[i][j] = val;
                        rem--;
                        madeChange = true;
                    }
                }
            }
        }
        if (rem == 0) {
            for (int as = 0; as < s; as++)
                System.out.println(Arrays.toString(curColors[as]));
            count++;
            return;
        }
        for (int i = 0; i < s; i++)
            for (int j = 0; j <= i; j++)
                if (curColors[i][j] == -1) {
                    if (curOpt[i][j][0]) {
                        curColors[i][j] = 0;
                        recur(curColors, curOpt, s);
                        curColors[i][j] = -1;
                    }
                    if (curOpt[i][j][1]) {
                        curColors[i][j] = 1;
                        recur(curColors, curOpt, s);
                        curColors[i][j] = -1;
                    }
                    if (curOpt[i][j][2]) {
                        curColors[i][j] = 2;
                        recur(curColors, curOpt, s);
                        curColors[i][j] = -1;
                    }
                    return;
                }
    }

    private static boolean validCoord(int i, int j) {
        if (i < s && j <= i && j >= 0)
            return true;
        return false;
    }

    private static boolean validColor(int i, int j, int color, int[][] colors) {
        if (colors[i][j] != -1)
            return false;
        boolean val = true;
        if (validCoord(i, j - 1) && validCoord(i - 1, j - 1)) {
            if (colors[i][j - 1] == -1 || colors[i - 1][j - 1] == -1)
                val &= true;
            else if (colors[i][j - 1] == colors[i - 1][j - 1])
                val &= (colors[i - 1][j] == color);
            else if (colors[i][j - 1] != colors[i - 1][j - 1])
                val &= (color == 3 - colors[i][j - 1] - colors[i - 1][j - 1]);
        }
        if (validCoord(i, j + 1) && validCoord(i - 1, j)) {
            if (colors[i][j + 1] == -1 || colors[i - 1][j] == -1)
                val &= true;
            else if (colors[i][j + 1] == colors[i - 1][j])
                val &= (colors[i][j + 1] == color);
            else if (colors[i][j + 1] != colors[i - 1][j])
                val &= (color == 3 - colors[i][j + 1] - colors[i - 1][j]);
        }
        if (validCoord(i + 1, j) && validCoord(i + 1, j + 1)) {
            if (colors[i + 1][j] == -1 || colors[i + 1][j + 1] == -1)
                val &= true;
            else if (colors[i + 1][j] == colors[i + 1][j + 1])
                val &= (colors[i + 1][j] == color);
            else if (colors[i + 1][j] != colors[i + 1][j + 1])
                val &= (color == 3 - colors[i + 1][j] - colors[i + 1][j + 1]);
        }
        return val;
    }


}
