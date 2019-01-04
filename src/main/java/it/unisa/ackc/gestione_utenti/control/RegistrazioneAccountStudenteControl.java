package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Si occupa della registrazione di un account studente.
 *
 * @version 0.1.1
 */
@WebServlet("/gestione-utente/registrazione-account-studente")
public class RegistrazioneAccountStudenteControl extends HttpServletWithCheck {
    /**
     * Macro della jsp di successo della registrazione studente.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della registrazione studente.
     */
    private static final String SUCCESSFUL_MESSAGE = "";

    /**
     * Macro del parametro matricola.
     */
    static final String MATRICOLA_PARAMETRO =
            "matricola";
    /**
     * Macro del parametro data di nascita.
     */
    static final String DATA_DI_NASCITA_PARAMETRO =
            "data_di_nascita";
    /**
     * Macro del parametro luogo di nascita.
     */
    static final String LUOGO_DI_NASCITA_PARAMETRO =
            "luogo_di_nascita";
    /**
     * Macro del parametro indirizzo di residenza.
     */
    static final String INDIRIZZO_DI_RESIDENZA_PARAMETRO =
            "indirizzo_di_residenza";
    /**
     * Macro del parametro numero civico.
     */
    static final String NUMERO_CIVICO_PARAMETRO =
            "numero_civico";
    /**
     * Macro del parametro cap.
     */
    static final String CAP_PARAMETRO = "cap";
    /**
     * Macro del parametro citta.
     */
    static final String CITTA_PARAMETRO = "citta";
    /**
     * Macro del parametro paese.
     */
    static final String PAESE_PARAMETRO = "paese";
    /**
     * Macro del parametro tipologia di laurea.
     */
    static final String TIPOLOGIA_DI_LAUREA_PARAMETRO =
            "tipologia_di_laurea";
    /**
     * Macro del parametro corso di laurea.
     */
    static final String CORSO_DI_LAUREA_PARAMETRO =
            "corso_di_laurea";
    /**
     * Macro del parametro anno di immatricolazione.
     */
    static final String ANNO_DI_IMMATRICOLAZIONE_PARAMETRO =
            "anno_di_immatricolazione";
    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Si occupa di effettuare il controllo sui campi della form,
     * in caso di successo salverà l'account e rendirizzerà alla
     * homepage del sito.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        String email = request.getParameter(
                AccountConvalida.EMAIL_PARAMETRO
        );
        String password = request.getParameter(
                AccountConvalida.PASSWORD_PARAMETRO
        );
        String telefono = request.getParameter(
                AccountConvalida.TELEFONO_PARAMETRO
        );
        String nome = request.getParameter(AccountConvalida.NOME_PARAMETRO);
        String cognome = request.getParameter(
                AccountConvalida.COGNOME_PARAMETRO
        );
        Account.Sesso sesso = Account.Sesso.valueOf(request.getParameter(
                AccountConvalida.SESSO_PARAMETRO
        ));
        String matricola = request.getParameter(MATRICOLA_PARAMETRO);
        Date dataDiNascita = null;
        try {
            dataDiNascita = new SimpleDateFormat("dd-MM-yyyy").parse(
                    request.getParameter(DATA_DI_NASCITA_PARAMETRO)
            );
        } catch (ParseException e) { }
        String luogoDiNascita = request.getParameter(
                LUOGO_DI_NASCITA_PARAMETRO
        );
        String indirizzoDiResidenza = request.getParameter(
                INDIRIZZO_DI_RESIDENZA_PARAMETRO
        );
        Integer numeroCivico = Integer.parseInt(
                request.getParameter(NUMERO_CIVICO_PARAMETRO)
        );
        String cap = request.getParameter(CAP_PARAMETRO);
        String citta = request.getParameter(CITTA_PARAMETRO);
        String paese = request.getParameter(PAESE_PARAMETRO);
        String tipologiaDiLaurea = request.getParameter(
                TIPOLOGIA_DI_LAUREA_PARAMETRO
        );
        String corsoDiLaurea = request.getParameter(CORSO_DI_LAUREA_PARAMETRO);
        String annoDiImmatricolazione = request.getParameter(
                ANNO_DI_IMMATRICOLAZIONE_PARAMETRO
        );
        AccountStudente account = new AccountStudente(
                email,
                password,
                telefono,
                nome,
                cognome,
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
        ackStorage.createAccount(account);
        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }

    /**
     * Valida i parametri della richiesta.
     *
     * @param request contenente i parametri da validare
     * @since 0.0.1
     */
    @Override
    public void valida(final HttpServletRequest request) {
        addCondizione(
                AccountConvalida.VALIDA_EMAIL
        );
        addCondizione(
                AccountConvalida.VALIDA_COGNOME
        );
        addCondizione(
                AccountConvalida.VALIDA_NOME
        );
        addCondizione(
                AccountConvalida.VALIDA_PASSWORD
        );
        addCondizione(
                AccountConvalida.VALIDA_SESSO
        );
        addCondizione(
                AccountConvalida.VALIDA_TELEFONO
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_LUOGO_DI_NASCITA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_DATA_DI_NASCITA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_INDIRIZZO_DI_RESIDENZA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_NUMERO_CIVICO
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_CAP
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_CITTA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_PAESE
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_MATRICOLA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_TIPOLOGIA_DI_LAUREA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_CORSO_DI_LAUREA
        );
        addCondizione(
                AccountStudenteConvalida.VALIDA_ANNO_DI_IMMATRICOLAZIONE
        );
        super.valida(request);
    }
}

