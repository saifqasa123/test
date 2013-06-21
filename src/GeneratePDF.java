import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class GeneratePDF {
 
    public static void main(String[] args) {
        try {
            String sCurrentLine;
            FileReader infile = new FileReader(new File("c:\\saif\\text.txt"));
            OutputStream file = new FileOutputStream(new File("c:\\saif\\Test.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            BufferedReader br = new BufferedReader(infile);
            document.open();
            while((sCurrentLine=br.readLine())!=null){
            document.add(new Paragraph(sCurrentLine.toString()));
            }
 
            document.close();
            file.close();
 
        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
}