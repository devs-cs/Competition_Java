import java.io.IOException;
import java.io.PrintWriter;

public class Generator3 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        int rand = (int) (200 * Math.random()) + 1;
        pw.println(1);
        pw.println(rand);
        for (int i = 0; i < rand; i++) {
            int r = (int) (10 * Math.random());
            pw.print(r);
        }
        pw.println();
        pw.close();

    }
}
