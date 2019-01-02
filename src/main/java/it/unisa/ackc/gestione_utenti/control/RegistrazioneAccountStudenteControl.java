package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Si occupa della registrazione di un account studente.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-utente/registrazione-account-studente")
public class RegistrazioneAccountStudenteControl extends HttpServlet {
    private static final String MATRICOLA_PARAMETRO = "matricola";
    private static final String DATA_DI_NASCITA_PARAMETRO = "data_di_nascita";
    private static final String LUOGO_DI_NASCITA_PARAMETRO = "luogo_di_nascita";
    private static final String INDIRIZZO_DI_RESIDENZA_PARAMETRO = "indirizzo_di_residenza";
    private static final String NUMERO_CIVICO_PARAMETRO = "numero_civico";
    private static final String CAP_PARAMETRO = "cap";
    private static final String CITTA_PARAMETRO = "citta";
    private static final String PAESE_PARAMETRO = "paese";
    private static final String TIPOLOGIA_DI_LAUREA_PARAMETRO = "tipologia_di_laurea";
    private static final String CORSO_DI_LAUREA_PARAMETRO = "corso_di_laurea";
    private static final String ANNO_DI_IMMATRICOLAZIONE_PARAMETRO = "anno_di_immatricolazione";

    private static final String SUCCESSFUL_JSP = "";
    private static final String SUCCESSFUL_MESSAGE = "";

    /**
     * Email dell'account.
     */
    private String email;
    /**
     * Password dell'account.
     */
    private String password;
    /**
     * Telefono della persona che possiede l'account.
     */
    private String telefono;
    /**
     * Nome della persona che possiede l'account.
     */
    private String nome;
    /**
     * Cognome della persona che possiede l'account.
     */
    private String cognome;
    /**
     * Ruolo dell'account.
     */
    private Account.Ruolo ruolo;
    /**
     * Sesso della persona che possiede l'account.
     */
    private Account.Sesso sesso;
    /**
     * Matricola della persona che possiede l'account.
     */
    private String matricola;
    /**
     * Data di nascita della persona che possiede l'account.
     */
    private Date dataDiNascita;
    /**
     * Luogo di nascita della persona che possiede l'account.
     */
    private String luogoDiNascita;
    /**
     * Indirizzo di residenza della persona che possiede l'account.
     */
    private String indirizzoDiResidenza;
    /**
     * Numero civico della persona che possiede l'account.
     */
    private int numeroCivico;
    /**
     * Cap della persona che possiede l'account.
     */
    private String cap;
    /**
     * Citt&agrave; della persona che possiede l'account.
     */
    private String citta;
    /**
     * Paese della persona che possiede l'account.
     */
    private String paese;
    /**
     * Tipologia di laurea della persona che possiede l'account.
     */
    private String tipologiaDiLaurea;
    /**
     * Corso di laurea della persona che possiede l'account.
     */
    private String corsoDiLaurea;
    /**
     * Anno di immatricolazione della persona che possiede l'account.
     */
    private String annoDiImmatricolazione;

    /**
     * Si occupa di effettuare il controllo sui campi della form,
     * in caso di successo salverà l'account e rendirizzerà alla
     * homepage del sito.
     *
     * @since 0.0.1
     */
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response
    ) {
        email = request.getParameter(AccountConvalida.EMAIL_PARAMETRO);
        password = request.getParameter(AccountConvalida.PASSWORD_PARAMETRO);
        telefono = request.getParameter(AccountConvalida.TELEFONO_PARAMETRO);
        nome = request.getParameter(AccountConvalida.NOME_PARAMETRO);
        cognome = request.getParameter(AccountConvalida.COGNOME_PARAMETRO);
        ruolo = Account.Ruolo.valueOf(request.getParameter(AccountConvalida.RUOLO_PARAMETRO));
        sesso = Account.Sesso.valueOf(request.getParameter(AccountConvalida.SESSO_PARAMETRO));

        matricola = request.getParameter(MATRICOLA_PARAMETRO);
        try {
            dataDiNascita = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter(DATA_DI_NASCITA_PARAMETRO));
        } catch (ParseException e) {
            //TODO gestisci errore
        }
        luogoDiNascita = request.getParameter(LUOGO_DI_NASCITA_PARAMETRO);
        indirizzoDiResidenza = request.getParameter(INDIRIZZO_DI_RESIDENZA_PARAMETRO);
        numeroCivico = Integer.parseInt(
                request.getParameter(NUMERO_CIVICO_PARAMETRO)
        );
        cap = request.getParameter(CAP_PARAMETRO);
        citta = request.getParameter(CITTA_PARAMETRO);
        paese = request.getParameter(PAESE_PARAMETRO);
        tipologiaDiLaurea = request.getParameter(TIPOLOGIA_DI_LAUREA_PARAMETRO);
        corsoDiLaurea = request.getParameter(CORSO_DI_LAUREA_PARAMETRO);
        annoDiImmatricolazione = request.getParameter(ANNO_DI_IMMATRICOLAZIONE_PARAMETRO);

        //TODO controllo campi

        AccountStudente account = new AccountStudente(
                email,
                password,
                telefono,
                nome,
                cognome,
                ruolo,
                sesso,
                matricola,
                dataDiNascita,
                luogoDiNascita,
                indirizzoDiResidenza,
                numeroCivico,
                cap,
                citta,
                paese,
                tipologiaDiLaurea,
                corsoDiLaurea,
                annoDiImmatricolazione
        );

        //TODO ACKStorageFacade.salvaAccountStudente(studente)

        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }
}
