package Test;
import java.io.*;

public class checkFacePython {
    public static void main(){
    File file = new File("x.txt");
        try {
            String x = readerfile(file.getAbsolutePath());
            System.out.println(x);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readerfile(String path) throws IOException { // đọc file check_id rồi trả về a với giá trị có trong file tương đương với mã id trong csdl
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String x = br.readLine();
       return x;
    }
    public static void xWriteFile(String x, String path) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(x);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
