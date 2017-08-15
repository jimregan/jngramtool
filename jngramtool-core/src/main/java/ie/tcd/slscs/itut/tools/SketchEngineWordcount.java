package ie.tcd.slscs.itut.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class SketchEngineWordcount {

    public static void main(String[] args) {
        String line;

        try {
            InputStream fis = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            int total_raw = 0;
            int file_raw = 0;
            int total_words = 0;
            int file_words = 0;
            String filename = "";
            while ((line = br.readLine()) != null) {
                if(line.startsWith("<file ")) {
                    int filename_beg = line.indexOf(" filename=\"", 5);
                    filename_beg += 11;
                    int filename_end = line.indexOf('"', filename_beg+1);
                    filename = line.substring(filename_beg, filename_end);
                } else if(line.contains("\t")){
                    total_raw++;
                    file_raw++;
                    if (Character.isAlphabetic(line.charAt(0))) {
                        total_words++;
                        file_words++;
                    }
                } else if(line.startsWith("</file")) {
                    System.out.println(filename + "\t" + file_raw + "\t" + file_words);
                    file_raw = file_words = 0;
                }
            }
            System.out.println("Totals" + "\t" + total_raw + "\t" + total_words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
