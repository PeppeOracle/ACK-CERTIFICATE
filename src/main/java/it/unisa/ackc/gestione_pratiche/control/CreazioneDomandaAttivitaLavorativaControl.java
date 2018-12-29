package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.gestione_pratiche.entity.DomandaAttivitaLavorativa;
import it.unisa.ackc.utils.PdfUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Si occupa della creazione di una nuova domanda di attività lavorativa.
 *
 * @version 0.0.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda-attivita-lavorativa")
public class CreazioneDomandaAttivitaLavorativaControl extends HttpServlet {
    /**
     * Ente certificatore dell'attestato.
     */
    private String ente;

    /**
     * Numero di cfu di cui si vuole la convalida.
     */
    private Integer numeroCfu;

    /**
     * Indirizzo sede dell'Ente certificatore dell'attestato.
     */
    private String indirizzoSede;

    /**
     * Profilo lavorativo durante l'attivit&agrave; lavorativa.
     */
    private String profilo;

    /**
     * Tipo di contratto dell'attestato.
     */
    private String tipoDiContratto;

    /**
     * Periodo dell'attivit&agrave;.
     */
    private String periodo;

    /**
     * Numero ore dell'attivit&agrave; lavorativa.
     */
    private int oreSvolte;

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
        ente = request.getParameter("ente");
        numeroCfu = Integer.parseInt(
                request.getParameter("numero_cfu")
        );
        indirizzoSede = request.getParameter("indirizzo_sede");
        profilo = request.getParameter("profilo");
        tipoDiContratto = request.getParameter("tipo_di_contratto");
        periodo = request.getParameter("periodo");
        oreSvolte = Integer.parseInt(
                request.getParameter("oreSvolte")
        );

        //TODO controllo campi

        DomandaAttivitaLavorativa domanda = new DomandaAttivitaLavorativa(
                null,
                numeroCfu,
                ente,
                indirizzoSede,
                profilo,
                tipoDiContratto,
                periodo,
                oreSvolte
        );

        request.getSession().setAttribute("domanda", domanda);
        String fileName = "DomandaAttivitaLavorativa";
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
                            "domanda-attivita-lavorativa.pdf"
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
