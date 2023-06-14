import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class ACM2_10P2 {
    private static HashMap<Character, Integer> dic = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        char[] arrStart = st.nextToken().toCharArray();
        char[] arrEnd = st.nextToken().toCharArray();
        dic.put('N', 0);
        dic.put('W', 270);
        dic.put('S', 180);
        dic.put('E', 90);
//        System.out.println(findDir(new char[]{'E', 'N', 'E'}));


        double val1 = findDir(arrStart, 0);
        double val2 = findDir(arrEnd, 0);
        double ans1 = (val1 - val2);
        if (ans1 > 360)
            ans1 -= 360;
        else if (ans1 < 0)
            ans1 += 360;
        pw.println(Math.min(ans1, 360 - ans1));
        pw.close();


    }

    public static double findDir(char[] arr, int len) {
        System.out.println(len + " " + Arrays.toString(arr));
//      if (arr.length > 30) System.out.println(arr.length + " " + len);
        if (len == arr.length - 1)
            return dic.get(arr[len]);
        if (len == arr.length - 2) {
            if (arr[len] == 'N') {
                if (arr[len + 1] == 'E')
                    return 45;
                else
                    return 315;
            } else if (arr[len] == 'S') {
                if (arr[len + 1] == 'E')
                    return 135;
                else
                    return 225;
            }
        }
        ////SSSSSSSE, goes to SSSSSS


        char firstVal = arr[len];
        char secondVal = 'e';
        boolean clockwise = false;
        for (int i = len + 1; !clockwise && i < arr.length; i++) {
            if (firstVal == 'N' && arr[i] == 'W') {
                clockwise = true;
                secondVal = 'W';
            }

            if (firstVal == 'S' && arr[i] == 'E') {
                secondVal = 'E';
                clockwise = true;
            }
            if (firstVal == 'E' && arr[i] == 'S') {
                secondVal = 'S';
                clockwise = true;
            }
            if (firstVal == 'W' && arr[i] == 'N') {
                secondVal = 'N';
                clockwise = true;
            }
            if (firstVal == 'N' && arr[i] == 'E') {
                clockwise = false;
                secondVal = 'E';
            }

            if (firstVal == 'S' && arr[i] == 'W') {
                secondVal = 'W';
                clockwise = false;
            }
            if (firstVal == 'E' && arr[i] == 'N') {
                secondVal = 'N';
                clockwise = false;
            }
            if (firstVal == 'W' && arr[i] == 'S') {
                secondVal = 'S';
                clockwise = false;
            }
        }
        if (secondVal == 'e')
            return (findDir(arr, arr.length - 1));
        if (clockwise) {
            int pos = arr.length - 1;
            while (arr[pos] == firstVal)
                arr[pos--] = secondVal;
            arr[pos] = firstVal;
        } else {
            int pos = arr.length - 1;
            while (arr[pos] == secondVal)
                arr[pos--] = firstVal;
            arr[pos] = secondVal;
        }
        double imVal = findDir(arr, len + 1);
        double ans = (findDir(arr, len + 1) + dic.get(firstVal)) / 2;
        if (Math.abs(imVal - dic.get(firstVal)) > 180)
            ans += 180;
        return (ans);
    }
}
