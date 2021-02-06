package fr.esir.mdi.ci.tpmaven;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;

import java.io.FileOutputStream;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import fr.esir.mdi.ci.tpmaven.FirstPdf;

/**
 * Unit test for FirstPdf.
 */
public class FirstPdfTest 
{
	String FILE = "FirstPdf.pdf";
	Document document = new Document();
	
	@Before
	public void setUp() throws Exception {
		try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            FirstPdf.addMetaData(document);
            FirstPdf.addTitlePage(document,0,0,0);
            FirstPdf.addContent(document,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@After
	public void tearDown() throws Exception {
		try {
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		}
	
    /**
     * Verifie que les méthode travaille sur un document ouvert
     */
    @Test
    public void ouvert()
    {
        assertTrue(document.isOpen());
    }
}
