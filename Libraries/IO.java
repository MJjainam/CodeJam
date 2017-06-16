import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
class IO {
    public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public static void writeFile(String fileName, String text) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            out.println(text);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void writeFile(String fileName, ArrayList<String> text) {
        PrintWriter out;
        try {
            out = new PrintWriter(fileName);
            for (int i = 0; i < text.size(); i++) {
                out.println(text.get(i));
                //out.close();
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}