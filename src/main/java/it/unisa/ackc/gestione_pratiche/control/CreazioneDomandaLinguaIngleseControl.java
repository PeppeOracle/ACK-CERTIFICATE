package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.GestionePraticheConvalida;
import it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese;
import it.unisa.ackc.gestione_pratiche.PdfUtils;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Si occupa della creazione di una nuova pratica di lingua inglese.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda-lingua-inglese")
public class CreazioneDomandaLinguaIngleseControl extends HttpServletWithCheck {
    /**
     * Macro del parametro ente.
     */
    static final String ENTE_PARAMETRO =
            "ente";
    /**
     * Macro del parametro grade.
     */
    static final String GRADE_PARAMETRO =
            "grade";
    /**
     * Macro del parametro livello_cefr.
     */
    static final String LIVELLO_CEFR_PARAMETRO =
            "livello_cefr";

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
        valida(request);
        AccountStudente account = (AccountStudente)
                request.getSession().getAttribute("account");
        String enteCertificatore = request.getParameter(ENTE_PARAMETRO);
        Integer numeroCfu = Integer.parseInt(
                request.getParameter(
                        GestionePraticheConvalida.NUMERO_CFU_PARAMETRO
                )
        );
        String grade = request.getParameter(GRADE_PARAMETRO);
        String livelloCefr = request.getParameter(LIVELLO_CEFR_PARAMETRO);
        DomandaLinguaInglese domanda = new DomandaLinguaInglese(
                null,
                numeroCfu,
                enteCertificatore,
                grade,
                livelloCefr
        );
        request.getSession().setAttribute("domanda", domanda);
        HashMap<String, String> documentMap = new HashMap<>();
        documentMap.put("name", account.getNome() + " " + account.getCognome());
        documentMap.put("year", account.getAnnoDiImmatricolazione());
        documentMap.put("serial", account.getMatricola());
        documentMap.put("authority", enteCertificatore);
        if (account.getTipologiaDiLaurea().equals("magistrale")) {
            documentMap.put("c1", "X");
        } else if (account.getTipologiaDiLaurea().equals("triennale")) {
            documentMap.put("c2", "X");
        }
        documentMap.put("grade", grade);
        documentMap.put("cefr", livelloCefr);
        documentMap.put("cfu", numeroCfu + "");
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
                            "DomandaLinguaInglese.pdf"
                    ),
                    out,
                    documentMap
            );
            out.flush();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Valida i parametri della richiesta.
     *
     * @param request contenente i parametri da validare
     * @since 0.1.1
     */
    @Override
    public void valida(final HttpServletRequest request) {
        addCondizione(
                CreazioneDomandaLinguaIngleseConvalida.VALIDA_ENTE_CERTIFICATORE
        );
        addCondizione(
                CreazioneDomandaLinguaIngleseConvalida.VALIDA_GRADE
        );
        addCondizione(
                CreazioneDomandaLinguaIngleseConvalida.VALIDA_LIVELLO_CEFR
        );
        addCondizione(
                GestionePraticheConvalida.VALIDA_NUMERO_CFU
        );
        super.valida(request);
    }
}
