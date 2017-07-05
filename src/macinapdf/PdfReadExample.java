package macinapdf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SenMa
 */


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class PdfReadExample {

    private static final String FILE_NAME = "/tmp/itext.pdf";

    public static void main(String[] args) {

        PdfReader reader;

        try {

            reader = new PdfReader("Rev.3 PEX.pdf");

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader,1000);

            System.out.println(textFromPage);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}