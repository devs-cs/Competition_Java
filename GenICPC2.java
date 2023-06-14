import java.io.IOException;
import java.io.PrintWriter;

public class GenICPC2 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(1);
        int rand = (int) (10 * Math.random()) + 1;
        pw.println(rand);
        for (int i = 0; i < rand; i++) {
            pw.println(rand() + "." + rand() + " " + rand() + "." + rand());
        }
        pw.close();
    }

    private static int rand() {
        return (int) (Math.random() * 9);
    }
}
