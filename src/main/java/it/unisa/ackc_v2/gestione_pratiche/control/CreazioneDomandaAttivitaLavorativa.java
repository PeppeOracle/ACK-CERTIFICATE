package it.unisa.ackc_v2.gestione_pratiche.control;

import com.itextpdf.text.DocumentException;
import it.unisa.ackc.gestione_pratiche.GestionePraticheConvalida;
import it.unisa.ackc.gestione_pratiche.entity.DomandaAttivitaLavorativa;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.gestione_pratiche.PdfUtils;
import it.unisa.ackc_v2.form.FormControl;
import it.unisa.ackc_v2.form.FormDati;
import it.unisa.ackc_v2.http.Risposta;
import it.unisa.ackc_v2.http.Sessione;

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
public class CreazioneDomandaAttivitaLavorativa extends FormControl {
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
     * Oggetto DateFormat per il parse delle date.
     */
    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Macro del nome del file.
     */
    private static final String FILE_NOME = "DomandaAttivitaLavorativa";
    /**
     * Macro dell'estensione del file.
     */
    private static final String FILE_ESTENSIONE = ".pdf";
    /**
     * Ente della domanda.
     */
    private String ente;
    /**
     * Numero cfu della domanda.
     */
    private Integer numeroCfu;
    /**
     * Indirizzo sede della domanda.
     */
    private String indirizzoSede;
    /**
     * Profilo della domanda.
     */
    private String profilo;
    /**
     * Tipo di contratto della domanda.
     */
    private String tipoDiContratto;
    /**
     * Periodo della domanda.
     */
    private String periodo;
    /**
     * Ore svolte della domanda.
     */
    private int oreSvolte;
    /**
     * Account loggato.
     */
    private AccountStudente account;

    /**
     * Permette di instanziare un oggetto di tipo <code>Control</code>.
     *
     * @param aSessione dell'utente che ha innescato il control
     * @param aRisposta da restituire all'utente che ha innescato il
     *                  control
     */
    public CreazioneDomandaAttivitaLavorativa(
            final Sessione aSessione,
            final Risposta aRisposta
    ) {
        super(aSessione, aRisposta);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sottomettiForm(final FormDati formDati) {
        valida(formDati);
        this.account = (AccountStudente) getSessione().ottieni("account");
        ente = formDati.ottieniDato(ENTE_PARAMETRO);
        numeroCfu = formDati.ottieniDatoIntero(
                GestionePraticheConvalida.NUMERO_CFU_PARAMETRO
        );
        indirizzoSede = formDati.ottieniDato(INDIRIZZO_SEDE_PARAMETRO);
        profilo = formDati.ottieniDato(PROFILO_PARAMETRO);
        tipoDiContratto = formDati.ottieniDato(
                TIPO_CONTRATTO_PARAMETRO
        );
        periodo = formDati.ottieniDato(PERIODO_PARAMETRO);
        oreSvolte = Integer.parseInt(
                formDati.ottieniDato(ORE_SVOLTE_PARAMETRO)
        );
        nuovaDomanda();
        downloadFile();
    }

    /**
     * Scrive sullo stream della risposta il file risultante.
     *
     * @since 0.1.1
     */
    private void downloadFile() {
        getRisposta().impostaTipoContenuto(Risposta.TIPO_CONTENUTO.PDF);
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
     * @since 0.1.1
     */
    private void nuovaDomanda() {
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
        getSessione().aggiungi("domanda", domanda);
    }

    /**
     * Mappa i campi del documento con quelli inviati.
     *
     * @return mappa necessaria per la compilazione del pdf
     * @since 0.1.1
     */
    private HashMap<String, String> ottieniMappa() {
        HashMap<String, String> documento = new HashMap<>();
        documento.put("name", account.getNome() + " " + account.getCognome());
        documento.put("born_place", account.getLuogoDiNascita());
        documento.put("born_date", DATE_FORMAT.format(
                account.getDataDiNascita()
        ));
        documento.put("residence_city", account.getCitta());
        documento.put("province", account.getPaese());
        documento.put("residence_street", account.getIndirizzoDiResidenza());
        documento.put("phone", account.getTelefono());
        documento.put("mail", account.getEmail());
        documento.put("degree", account.getCorsoDiLaurea());
        documento.put("serial", account.getMatricola());
        documento.put("society", ente);
        documento.put("society_address", indirizzoSede);
        documento.put("profile", profilo);
        documento.put("contract_type", tipoDiContratto);
        documento.put("init_end_date", periodo);
        documento.put("hours", oreSvolte + "");
        documento.put("cfu", numeroCfu + "");
        return documento;
    }

    /**
     * Valida i dati del form sototmessi.
     *
     * @param formDati contenente i dati da validare
     * @since 0.1.1
     */
    @Override
    public void valida(final FormDati formDati) {
        super.valida(formDati);
    }
}
