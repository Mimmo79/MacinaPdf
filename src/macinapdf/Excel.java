/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macinapdf;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Massi
 */

public class Excel {

    static int rownum;  
    
    public static void compilaExcel(String [][] data) {
        
        try {

            try ( // apro il file excel
                FileOutputStream fileXLSOut = new FileOutputStream(MacinaPdf.nomeFile+".xls")) {
                Workbook wb = new HSSFWorkbook();
                Sheet sheet1 = wb.createSheet("Foglio 1");
                
                for (rownum = (short) 0; rownum < (Scansionatore.n_row) ; rownum++) { 

                    Row r = sheet1.createRow(rownum);               // creo una riga
                    
                    for (short cellnum = (short) 0; cellnum < 10; cellnum += 1) {                          

                        Cell c = r.createCell(cellnum);             // creo la cella
                        if (rownum==0){
                            CellStyle cs = wb.createCellStyle();    // creo un CellStyle
                            Font f = wb.createFont();               // creo fun Font
                            f.setFontHeightInPoints((short) 10);    // setto la dimensione del font
                            f.setColor( (short)0xc );               // imposto il colore del font
                            f.setBold(true);                        // grassetto
                            cs.setFont(f);                          // assegno al CellStyle il font
                            sheet1.autoSizeColumn(rownum, true);
                            c.setCellStyle(cs);                     // assegno alla cella lo stile
                            c.setCellValue(data[rownum][cellnum]);  // inserisco i valori
                        } else {
                            if (cellnum==0){
                            c.setCellValue(data[rownum][cellnum]);  // salvo il campo come stringa
                            } else {
                                c.setCellValue(Double.parseDouble(data[rownum][cellnum]));  // salvo il campo come double  
                            }        
                        } 
                    }
                }
                
                wb.write(fileXLSOut);
            }

        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Errore nella classe Excel ** "+e);
        }

    }
}
