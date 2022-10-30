package Test;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class test {
       public static String LinkSaveImage(){
               File file = new File("src/main/webapp/views/detailVideo/images");
               try {
                       String Path = String.valueOf(file.toURI().toURL()).substring(6);
                       return Path;
               } catch (MalformedURLException e) {
                       return null;
               }
       }
}
