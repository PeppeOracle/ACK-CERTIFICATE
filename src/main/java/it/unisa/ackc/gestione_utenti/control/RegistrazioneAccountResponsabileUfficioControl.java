package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Si occupa della registrazione di un account responsabile.
 *
 * @version @version 0.1.1
 */
@WebServlet("/gestione-utente/registrazione-account-responsabile-ufficio")
public class RegistrazioneAccountResponsabileUfficioControl extends HttpServlet {
    private static final String CAMPUS_PARAMETRO = "campus";
    private static final String EDIFICIO_PARAMETRO = "edificio";
    private static final String PIANO_PARAMETRO = "piano";
    private static final String NUMERO_STANZA_PARAMETRO = "numero_stanza";
    private static final String TIPOLOGIA_PRATICHE_PARAMETRO = "tipologia_pratiche";

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

    private String campus;
    private String edificio;
    private int piano;
    private int numeroStanza;
    private ArrayList<Pratica.Tipo> eTipologiaPraticaDaGestire;
    private String[] tipologiaPraticaDaGestire;

    /**
     * Si occupa di effettuare il controllo sui campi della form, in caso di successo
     * salverà l'account e rendirizzerà alla homepage del sito.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) {
        email = request.getParameter(AccountConvalida.EMAIL_PARAMETRO);
        password = request.getParameter(AccountConvalida.PASSWORD_PARAMETRO);
        telefono = request.getParameter(AccountConvalida.TELEFONO_PARAMETRO);
        nome = request.getParameter(AccountConvalida.NOME_PARAMETRO);
        cognome = request.getParameter(AccountConvalida.COGNOME_PARAMETRO);
        ruolo = Account.Ruolo.valueOf(request.getParameter(AccountConvalida.RUOLO_PARAMETRO));
        sesso = Account.Sesso.valueOf(request.getParameter(AccountConvalida.SESSO_PARAMETRO));

        campus = request.getParameter(CAMPUS_PARAMETRO);
        edificio = request.getParameter(EDIFICIO_PARAMETRO);
        piano = Integer.parseInt(
                request.getParameter(PIANO_PARAMETRO)
        );
        numeroStanza = Integer.parseInt(
                request.getParameter(NUMERO_STANZA_PARAMETRO)
        );

        tipologiaPraticaDaGestire = request.getParameterValues(TIPOLOGIA_PRATICHE_PARAMETRO);

        //TODO controllo campi

        eTipologiaPraticaDaGestire = new ArrayList<>();
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
                ruolo,
                sesso,
                campus,
                edificio,
                piano,
                numeroStanza,
                eTipologiaPraticaDaGestire
        );

        //TODO ACKStorageFacade.salvaAccountResponsabileUfficio(responsabileUfficio)

        request.setAttribute("successful", SUCCESSFUL_MESSAGE);
        request.getRequestDispatcher(SUCCESSFUL_JSP).forward(request, response);
    }
}