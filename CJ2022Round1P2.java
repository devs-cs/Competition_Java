import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CJ2022Round1P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cases = Integer.parseInt(st.nextToken());
        long[] A = new long[100]; //just be wary about the longs
        for (int i = 0; i < 29; i++) //removed one character
            A[i] = Math.round(Math.pow(2, i + 1));
        long constant = 100L;
        long multiple = 1L;

        for (int i = 30; i < 98; i += 4) //these all pair to cancel
        {
            A[i] = Math.round(Math.pow(2, 28)) - 1 - constant * multiple;
            A[i + 1] = Math.round(Math.pow(2, 28)) - 2 - constant * multiple;
            A[i + 2] = Math.round(Math.pow(2, 28)) + 1 - constant * multiple;
            A[i + 3] = Math.round(Math.pow(2, 28)) + 2 - constant * multiple;
            multiple++;
            //this ensures they are all disjoint numbers satisfying the desired qualities
            //can also use all 4 to perform a shift by 2^29 (approx)
        }
        A[29] = 100;
        A[98] = 101;
        A[99] = 102;


        for (int c = 0; c < cases; c++) {
            st = new StringTokenizer(r.readLine());
            long set1 = 0L;
            long set2 = 0L;
            boolean[] decA = new boolean[100]; //true means it goes to set1, false is set2
            boolean[] decB = new boolean[100];
            for (int i = 30; i < 98; i++) {
                decA[i] = true;
                decA[i + 2] = true;
            }
            for (int i = 0; i < 100; i++)
                System.out.print(A[i] + " ");
            System.out.println();
            st = new StringTokenizer(r.readLine());
            long[] B = new long[100];
            for (int i = 0; i < 100; i++) {
                B[i] = Integer.parseInt(st.nextToken());
                if (set1 <= set2) {
                    decB[i] = true;
                    set1 += B[i];
                } else
                    set2 += B[i];

            }

            int ind = 30; //using this for indexing
            if (set2 > set1) //this ensures set1 is always larger
            {
                for (int i = 0; i < 100; i++)
                    decB[i] = !decB[i]; //switching so set1 is larger
                long temp = set1;
                set1 = set2;
                set2 = temp;
            }

            set1 += A[29] + A[98] + A[99]; //just because
            decA[29] = true;
            decA[98] = true;
            decA[99] = true;

            //first 29 can make differences for the form 2^30 - 2 - 2n = diff
            long num = (Math.round(Math.pow(2, 30) - 2) - (set1 - set2)) / 2;
            String bin = Long.toBinaryString(num);
            for (int i = bin.length() - 1; i >= 0; i--) {
                if (bin.charAt(i) == '1') { //i.e 10110, so for i = 3, 2^(5- 0- 1)
                    decA[bin.length() - i - 1] = true;
                }
            }
            for (int i = 0; i < 100; i++) {
                if (decA[i])
                    System.out.print(A[i] + " ");
                if (decB[i])
                    System.out.print(B[i] + " ");

            }
        }

    }
}
