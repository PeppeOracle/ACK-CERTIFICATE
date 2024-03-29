package it.unisa.ackc.gestione_pratiche.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Fornisce delle funzionalità utili per la gestione di file pdf.
 */
public final class PdfUtils {
    /**
     * Per prevenire l'istanziazione della classe.
     */
    private PdfUtils() {
    }

    /**
     * Fornisce la logica per la compilazione di un file pdf.
     *
     * @param is input stream
     * @param os output stream
     * @param formData mappa contenente le corrispondenze tra nome del campo
     *                 del pdf e valore da inserire
     * @throws IOException lanciata se ci sono stati problemi
     *                     nella lettura o nella scrittura sugli stream
     * @throws DocumentException lanciata se ci sono stati problemi nella
     *                           produzione del documento.
     */
    public static void compilePdf(
            final InputStream is,
            final OutputStream os,
            final Map<String, String> formData
    ) throws IOException, DocumentException {
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            reader = new PdfReader(is);
            stamper = new PdfStamper(reader, os);
            stamper.setFormFlattening(true);
            AcroFields form = stamper.getAcroFields();
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                form.setField(
                        entry.getKey(),
                        entry.getValue(),
                        entry.getValue()
                );
            }
        } finally {
            if (stamper != null) {
                stamper.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }
}
