/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;



/**
 *
 * @author SenMa
 */
public class MacinaPdf {

    public static String nomeFile="C:\\Users\\senma\\Desktop\\File Telecom\\TICRMB_2017_C40_4220517800019165";

    
    public static void main(String[] args) throws Exception {   
       //converto il file in .txt
       File file = new File(nomeFile+".pdf");
       PDDocument inputDoc= PDDocument.load(file);   
       PDFTextStripper stripper = new PDFTextStripper();
       PrintWriter outputStream = new PrintWriter(new FileWriter(nomeFile+".txt"));
       outputStream.println(stripper.getText(inputDoc));
       outputStream.close();
       //ripulisco il file e lo savo con nome diverso
       Scansionatore.scansiona();
       

       
    }
    
    
 /*
    https://www.mattepuffo.com/blog/articolo/298-java-excel.html
    
    Il metodo write è quello principale; richiede una String come parametro e corrisponde al percorso di salvataggio del file.

WorkbookSettings server per settare alcune impostazioni generali, mentre WritableWorkbook e WritableSheet settano il foglio di lavoro.

Poi ci sono due metodi: createLabel e createContent creati da me; entrambi richiedono come parametri lo sheet da usare.

Con il primo creo tutta la intestazione formattando le celle in grassetto.

Con il secondo invece creo il contenuto estrapolandonolo dalla JTable.

CellView serve per settare le varie impostazioni delle celle.

Label server per scriver il contenuto dentro le celle.

Il costruttore che ho usato prevede di passare 4 argomenti: numero colonna, numero riga, contenuto, formato usato.

Notate bene che il primo ciclo for di createContent, che rappresenta il numero di righe, inizia da 1.

Questo perchè il conteggio di righe e colonne in Excel comincia da zero, e la riga 0 è occupata dall'intestazione.

Dopo aver lanciato quei due metodi scriviamo il file e lo chiudiamo.
    
    
    
    import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportXls {

    private WritableCellFormat timesBold;
    private WritableCellFormat times;

    public void create(String inputFile) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("it", "IT"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Book", 0);
        WritableSheet excelSheet = workbook.getSheet(0);

        createLabel(excelSheet);
        createContent(excelSheet);

        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet) throws WriteException {
        WritableFont timesFontBold = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        timesBold = new WritableCellFormat(timesFontBold);
        timesBold.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(timesBold);
        cv.setAutosize(true);

        addCaption(sheet, 0, 0, "ID");
        addCaption(sheet, 1, 0, "TITLE");
        addCaption(sheet, 2, 0, "AUTHOR");
        addCaption(sheet, 3, 0, "EDITOR");
        addCaption(sheet, 4, 0, "PRICE");
        addCaption(sheet, 5, 0, "ISBN");
        addCaption(sheet, 6, 0, "NOTE");
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s) throws RowsExceededException, WriteException {
        Label label = new Label(column, row, s, timesBold);
        sheet.addCell(label);
    }

    private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
        WritableFont timesFont = new WritableFont(WritableFont.TIMES, 12);
        times = new WritableCellFormat(timesFont);
        times.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setAutosize(true);
        
        for (int i = 1; i < FormBook.getTable().getRowCount(); i++) {
            for (int j = 0; j < FormBook.getTable().getColumnCount(); j++) {
                Label lb = new Label(j, i, (String) (FormBook.getTable().getValueAt(i, j)), times);
                sheet.addCell(lb);
            }
        }
    }
}
    */   
    
    
}

    
    

