import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CJ2020QA {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int Case = 1; Case <= T; Case++) {
            st = new StringTokenizer(r.readLine());
            char[] cArr = st.nextToken().toCharArray();
            int[] arr = new int[cArr.length];

            for (int i = 0; i < cArr.length; i++)
                arr[i] = Integer.parseInt("" + cArr[i]);
            int n = arr.length;

            int[] arrCopy = new int[n];
            for (int i = 0; i < n; i++)
                arrCopy[i] = arr[i];
            int[] startBefore = new int[n];
            int[] endAfter = new int[n];
            recur(arr, 0, n - 1, startBefore, endAfter);
            pw.print("Case #" + Case + ": ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < startBefore[i]; j++)
                    pw.print("(");
                pw.print(arrCopy[i]);
                for (int j = 0; j < endAfter[i]; j++)
                    pw.print(")");
            }
            pw.println();
        }
        pw.close();
    }
//10101 (1(2)1(2))


    public static void recur(int[] arr, int begin, int end, int[] startBefore, int[] endAfter) {
        if (end < begin)
            return;
        int minIndex = begin;
        int min = arr[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        for (int i = begin; i <= end; i++)
            arr[i] -= min;
        startBefore[begin] += min;
        endAfter[end] += min;
        recur(arr, begin, minIndex - 1, startBefore, endAfter);
        recur(arr, minIndex + 1, end, startBefore, endAfter);
    }
}


