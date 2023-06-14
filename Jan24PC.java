import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Jan24PC {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int ca = 0; ca < t; ca++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            if (n % 2 == 0) {
                int left = 0; //num we are looking for n/2 and n/2+1
                int right = n - 1;
                while (arr[left] != n / 2)
                    left++;
                while (arr[right] != n / 2 + 1)
                    right--;
                if (left > right) {
                    pw.println(n / 2);
                    continue;
                }
                int proper = 2;
                int lowExtreme = 0;
                int highExtreme = 0;
                int curLow = arr[left];
                int curHigh = arr[left];
                int lastValue = arr[left];
                while (left - 1 >= 0) {
                    if (arr[left - 1] == lastValue - 1) {
                        proper++;
                        curLow = Math.min(lastValue - 1, curLow);
                        lastValue--;
                    } else if (arr[left - 1] < curLow) //this will allow us to look at "revealed" sequences as stuff outside the border will be moved at some point
                        curLow = arr[left - 1];
                    left--;
                }
                lowExtreme = lastValue;
                curLow = arr[right];
                curHigh = arr[right];
                lastValue = arr[right];
                while (right + 1 < n) {
                    if (arr[right + 1] == lastValue + 1) {
                        proper++;
                        curHigh = Math.max(lastValue + 1, curHigh);
                        lastValue++;
                    } else if (arr[right + 1] > curHigh)
                        curHigh = arr[right + 1];
                    right++;
                }
                highExtreme = lastValue;

//                pw.println("low, high, proper" + lowExtreme + " " + highExtreme + " " + proper);
                pw.println(Math.min(n / 2, Math.min(lowExtreme - 1, (n - highExtreme)) + Math.abs((n - highExtreme) - (lowExtreme - 1))));
            } else {
                int left = 0; //num we are looking for n/2 and n/2+1
                int right = n - 1;
                while (arr[left] != n / 2 + 1) //i.e with 5 we want 3, so 5/2 + 1 = 3
                    left++;
                while (arr[right] != n / 2 + 1)
                    right--;
                int proper = 1;
                int lowExtreme = 0;
                int highExtreme = 0;
                int curLow = arr[left];
                int curHigh = arr[left];
                int lastValue = arr[left];
                while (left - 1 >= 0) {
                    if (arr[left - 1] == lastValue - 1) {
                        proper++;
                        curLow = Math.min(lastValue - 1, curLow);
                        lastValue--;
                    } else if (arr[left - 1] < curLow) //this will allow us to look at "revealed" sequences as stuff outside the border will be moved at some point
                        curLow = arr[left - 1];
                    left--;
                }
                lowExtreme = lastValue;
                curLow = arr[right];
                curHigh = arr[right];
                lastValue = arr[right];
                while (right + 1 < n) {
                    if (arr[right + 1] == lastValue + 1) {
                        proper++;
                        curHigh = Math.max(lastValue + 1, curHigh);
                        lastValue++;
                    } else if (arr[right + 1] > curHigh)
                        curHigh = arr[right + 1];
                    right++;
                }
                highExtreme = lastValue;

//                pw.println("low, high, proper" + lowExtreme + " " + highExtreme + " " + proper);
                pw.println(Math.min(n / 2, Math.min(lowExtreme - 1, (n - highExtreme)) + Math.abs((n - highExtreme) - (lowExtreme - 1))));
            }

        }
        pw.close();
    }
}
