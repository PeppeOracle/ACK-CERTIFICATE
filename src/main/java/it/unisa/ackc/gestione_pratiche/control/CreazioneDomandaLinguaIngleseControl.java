package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese;
import it.unisa.ackc.utils.PdfUtils;
import it.unisa.ackc.validator.ValidatorGroup;
import it.unisa.ackc.validator.ValidatorLogic;

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
     * Validator utilizzato per la form.
     */
    private ValidatorGroup validatorGroup;

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
        String enteCertificatore = request.getParameter("ente_certificatore");
        Integer numeroCfu = Integer.parseInt(
                request.getParameter("numero_cfu")
        );
        String grade = request.getParameter("grade");
        String livelloCefr = request.getParameter("livello_cefr");

        
        validatorGroup = new ValidatorGroup();
        validatorGroup.addValidator(ValidatorLogic.CAMPO_NON_VUOTO(
                "Ente Certitificatore",
                enteCertificatore
        ));
        validatorGroup.addValidator(ValidatorLogic.CAMPO_ENTE_CERTIFICATORE(
                "Ente Certificatore",
                enteCertificatore
        ));
        validatorGroup.addValidator(ValidatorLogic.CAMPO_NON_VUOTO(
                "Grade",
                grade
        ));
        // TODO aggiunger validator per grade
        validatorGroup.addValidator(ValidatorLogic.CAMPO_NON_VUOTO(
                "Livello Cefr",
                livelloCefr
        ));
        // TODO aggiungere validator per livello cefr
        validatorGroup.valida();
        DomandaLinguaInglese domandaLinguaInglese = new DomandaLinguaInglese(
                null,
                numeroCfu,
                enteCertificatore,
                grade,
                livelloCefr
        );
        //TODO ACKStorageFacade.createDomandaLinguaInglese(domandaLinguaInglese)
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
            response.sendRedirect("http://google.it");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
