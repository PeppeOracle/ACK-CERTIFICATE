package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.GestionePraticheConvalida;
import it.unisa.ackc.gestione_pratiche.entity.DomandaAttivitaLavorativa;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.gestione_pratiche.PdfUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Si occupa della creazione di una nuova domanda di attività lavorativa.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-pratiche/creazione-domanda-attivita-lavorativa")
public class CreazioneDomandaAttivitaLavorativaControl
        extends HttpServletWithCheck {
    /**
     * Macro del parametro ente.
     */
    static final String ENTE_PARAMETRO =
            "ente";
    /**
     * Macro del parametro indirizzo_sede.
     */
    static final String INDIRIZZO_SEDE_PARAMETRO = "indirizzo_sede";
    /**
     * Macro del parametro profilo.
     */
    static final String PROFILO_PARAMETRO =
            "profilo";
    /**
     * Macro del parametro tipo_di_contratto.
     */
    static final String TIPO_CONTRATTO_PARAMETRO =
            "tipo_di_contratto";
    /**
     * Macro del parametro periodo.
     */
    static final String PERIODO_PARAMETRO =
            "periodo";
    /**
     * Macro del parametro ore svolte.
     */
    static final String ORE_SVOLTE_PARAMETRO =
            "ore_svolte";
    /**
     * Istanza di date format per ottenere la data in formato stringa.
     */
    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-mm-dd");

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
        String ente = request.getParameter(ENTE_PARAMETRO);
        Integer numeroCfu = Integer.parseInt(
                request.getParameter(
                        GestionePraticheConvalida.NUMERO_CFU_PARAMETRO
                )
        );
        String indirizzoSede = request.getParameter(INDIRIZZO_SEDE_PARAMETRO);
        String profilo = request.getParameter(PROFILO_PARAMETRO);
        String tipoDiContratto = request.getParameter(
                TIPO_CONTRATTO_PARAMETRO
        );
        String periodo = request.getParameter(PERIODO_PARAMETRO);
        int oreSvolte = Integer.parseInt(
                request.getParameter(ORE_SVOLTE_PARAMETRO)
        );
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
        HashMap<String, String> documentMap = new HashMap<>();
        documentMap.put("name", account.getNome() + " " + account.getCognome());
        documentMap.put("born_place", account.getLuogoDiNascita());
        documentMap.put("born_date", DATE_FORMAT.format(
                account.getDataDiNascita()
        ));
        documentMap.put("residence_city", account.getCitta());
        documentMap.put("province", account.getPaese());
        documentMap.put("residence_street", account.getIndirizzoDiResidenza());
        documentMap.put("phone", account.getTelefono());
        documentMap.put("mail", account.getEmail());
        documentMap.put("degree", account.getCorsoDiLaurea());
        documentMap.put("serial", account.getMatricola());
        documentMap.put("society", ente);
        documentMap.put("society_address", indirizzoSede);
        documentMap.put("profile", profilo);
        documentMap.put("contract_type", tipoDiContratto);
        documentMap.put("init_end_date", periodo);
        documentMap.put("hours", oreSvolte + "");
        documentMap.put("cfu", numeroCfu + "");
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
                            "DomandaAttivitaLavorativa.pdf"
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
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_ENTE
        );
        addCondizione(
                GestionePraticheConvalida.
                        VALIDA_NUMERO_CFU
        );
        addCondizione(
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_INDIRIZZO_SEDE
        );
        addCondizione(
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_PROFILO
        );
        addCondizione(
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_TIPO_CONTRATTO
        );
        addCondizione(
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_PERIODO
        );
        addCondizione(
                CreazioneDomandaAttivitaLavorativaConvalida.
                        VALIDA_ORE_SVOLTE
        );
        super.valida(request);
    }
}
