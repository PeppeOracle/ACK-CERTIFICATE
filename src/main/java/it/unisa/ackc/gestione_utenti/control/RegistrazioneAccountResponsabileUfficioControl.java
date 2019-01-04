package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Si occupa della registrazione di un account responsabile.
 *
 * @version @version 0.1.1
 */
@WebServlet("/gestione-utente/registrazione-account-responsabile-ufficio")
public class RegistrazioneAccountResponsabileUfficioControl
        extends HttpServletWithCheck {
    /**
     * Macro del parametro campus.
     */
    static final String CAMPUS_PARAMETRO = "campus";
    /**
     * Macro del parametro edificio.
     */
    static final String EDIFICIO_PARAMETRO = "edificio";
    /**
     * Macro del parametro piano.
     */
    static final String PIANO_PARAMETRO = "piano";
    /**
     * Macro del parametro numero stanza.
     */
    static final String NUMERO_STANZA_PARAMETRO = "numero_stanza";
    /**
     * Macro del parametro tipologia pratiche.
     */
    static final String TIPOLOGIA_PRATICHE_PARAMETRO =
            "tipologia_pratiche";
    /**
     * Macro della jsp di successo della registrazione responsabile ufficio.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della registrazione responsabile ufficio.
     */
    private static final String SUCCESSFUL_MESSAGE = "";

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
    public void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        String email = request.getParameter(AccountConvalida.EMAIL_PARAMETRO);
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
        Account.Ruolo ruolo = Account.Ruolo.valueOf(
                request.getParameter(AccountConvalida.RUOLO_PARAMETRO)
        );
        Account.Sesso sesso = Account.Sesso.valueOf(
                request.getParameter(AccountConvalida.SESSO_PARAMETRO)
        );
        String campus = request.getParameter(CAMPUS_PARAMETRO);
        String edificio = request.getParameter(EDIFICIO_PARAMETRO);
        Integer piano = Integer.parseInt(
                request.getParameter(PIANO_PARAMETRO)
        );
        Integer numeroStanza = Integer.parseInt(
                request.getParameter(NUMERO_STANZA_PARAMETRO)
        );
        String[] tipologiaPraticaDaGestire = request.getParameterValues(
                TIPOLOGIA_PRATICHE_PARAMETRO
        );
        ArrayList<Pratica.Tipo> eTipologiaPraticaDaGestire = new ArrayList<>();
        for (String tipologia : tipologiaPraticaDaGestire) {
            eTipologiaPraticaDaGestire.add(
                    Pratica.Tipo.valueOf(tipologia)
            );
        }
        AccountResponsabileUfficio account = new AccountResponsabileUfficio(
                email,
                password,
                telefono,
                nome,
                cognome,
                sesso,
                campus,
                edificio,
                piano,
                numeroStanza,
                eTipologiaPraticaDaGestire
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
                AccountResponsabileUfficioConvalida.VALIDA_CAMPUS
        );
        addCondizione(
                AccountResponsabileUfficioConvalida.VALIDA_EDIFICIO
        );
        addCondizione(
                AccountResponsabileUfficioConvalida.VALIDA_NUMERO_STANZA
        );
        addCondizione(
                AccountResponsabileUfficioConvalida.VALIDA_PIANO
        );
        addCondizione(
                AccountResponsabileUfficioConvalida.VALIDA_TIPOLOGIA_PRATICHE
        );
        super.valida(request);
    }
}
