package it.unisa.ackc.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.form.FormControl;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.DomandaLinguaInglese;
import it.unisa.ackc.gestione_pratiche.pdf.PdfUtils;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Risposta;
import it.unisa.ackc.http.Sessione;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Si occupa della creazione di una nuova pratica di lingua inglese.
 *
 * @version 1.1.1
 */
public class CreazioneDomandaLinguaInglese extends FormControl {
    /**
     * Macro del parametro ente.
     */
    public static final String ENTE_PARAMETRO =
            "ente";
    /**
     * Macro del parametro grade.
     */
    public static final String GRADE_PARAMETRO =
            "grade";
    /**
     * Macro del parametro livello_cefr.
     */
    public static final String LIVELLO_CEFR_PARAMETRO =
            "livello_cefr";
    /**
     * Macro del nome del file.
     */
    private static final String FILE_NOME = "DomandaLinguaInglese";
    /**
     * Macro dell'estensione del file.
     */
    private static final String FILE_ESTENSIONE = ".pdf";
    /**
     * Account loggato.
     */
    private AccountStudente account;
    /**
     * Ente certificatore della domanda.
     */
    private String enteCertificatore;
    /**
     * Numero cfu della domanda.
     */
    private Integer numeroCfu;
    /**
     * Grade della domanda.
     */
    private String grade;
    /**
     * Livello cefr della domanda.
     */
    private String livelloCefr;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il control
     * @since 1.1.1
     */
    public CreazioneDomandaLinguaInglese(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     * @version 1.1.1
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        account = (AccountStudente)
                getSessione().ottieni("account");
        enteCertificatore = formDati.ottieniDato(ENTE_PARAMETRO);
        numeroCfu = formDati.ottieniDatoIntero(
                GestionePratiche.NUMERO_CFU_PARAMETRO
        );
        grade = formDati.ottieniDato(GRADE_PARAMETRO);
        livelloCefr = formDati.ottieniDato(LIVELLO_CEFR_PARAMETRO);
        nuovaDomanda();
        downloadFile();
    }

    /**
     * Scrive sullo stream della risposta il file risultante.
     *
     * @since 1.1.1
     */
    private void downloadFile() {
        getRisposta().impostaTipoContenuto(Risposta.TipoDiContenuto.PDF);
        getRisposta().impostaHeader(
                "Content-disposition",
                "attachment; filename=" + FILE_NOME + FILE_ESTENSIONE
        );
        OutputStream out = getRisposta().getOutput();
        try {
            PdfUtils.compilePdf(
                    getClass().getClassLoader().getResourceAsStream(
                            FILE_NOME + FILE_ESTENSIONE
                    ),
                    out,
                    ottieniMappa()
            );
            out.flush();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea e aggiunge la nuova domanda alla sessione.
     *
     * @since 1.1.1
     */
    private void nuovaDomanda() {
        DomandaLinguaInglese domanda = new DomandaLinguaInglese(
                null,
                numeroCfu,
                enteCertificatore,
                grade,
                livelloCefr
        );
        getSessione().aggiungi("domanda", domanda);
    }

    /**
     * Mappa i campi del documento con quelli inviati.
     *
     * @return mappa necessaria per la compilazione del pdf
     * @since 1.1.1
     */
    private HashMap<String, String> ottieniMappa() {
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
        return documentMap;
    }

    /**
     * {@inheritDoc}
     * @since 1.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        aggiungiCondizioni(it.unisa.ackc.gestione_pratiche.control.convalida
                .CreazioneDomandaLinguaInglese.class);
        aggiungiCondizione(GestionePratiche.VALIDA_NUMERO_CFU);
        super.valida(formDati);
    }
}
