import java.io.IOException;
import java.io.PrintWriter;

public class generator {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(n);
        for (int i = 0; i < n; i++)
            pw.println((int) (Math.random() * 10000) + 1);
        pw.close();
    }
}
