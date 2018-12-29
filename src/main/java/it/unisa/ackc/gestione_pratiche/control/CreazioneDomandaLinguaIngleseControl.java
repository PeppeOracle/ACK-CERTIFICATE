package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese;
import it.unisa.ackc.utils.PdfUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Si occupa della creazione di una nuova pratica di lingua inglese.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda-lingua-inglese")
public class CreazioneDomandaLinguaIngleseControl extends HttpServlet {
    /**
     * Ente certificatore dell'attestato.
     */
    private String enteCertificatore;
    /**
     * Numero di cfu di cui si vuole la convalida.
     */
    private Integer numeroCfu;
    /**
     * Grade dell'attestato.
     */
    private String grade;
    /**
     * Livello cefr dell'attestato.
     */
    private String livelloCefr;

    /**
     * Si occupa di effettuare il controllo sui campi della form,
     * in caso di successo farà partire il download del file e
     * rendirizzerà alla componente jsp che si occuperà di continuare
     * l'attività (modifica / creazione di una pratica).
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws IOException {
        enteCertificatore = request.getParameter("ente_certificatore");
        numeroCfu = Integer.parseInt(
                request.getParameter("numero_cfu")
        );
        grade = request.getParameter("grade");
        livelloCefr = request.getParameter("livello_cefr");

        //TODO controllo campi

        DomandaLinguaInglese domanda = new DomandaLinguaInglese(
                null,
                numeroCfu,
                enteCertificatore,
                grade,
                livelloCefr
        );

        request.getSession().setAttribute("domanda", domanda);
        String fileName = "DomandaLinguaInglese";
        String fileExt = ".pdf";
        response.setContentType("application/pdf");
        response.setHeader(
                "Content-disposition",
                "attachment; filename=" + fileName + fileExt
        );
        OutputStream out = response.getOutputStream();
        try {
            PdfUtils.compilePdf(
                    getClass().getClassLoader().getResourceAsStream(
                            "domanda-lingua-inglese.pdf"
                    ),
                    out,
                    new HashMap<String, String>()
            );
            out.flush();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
