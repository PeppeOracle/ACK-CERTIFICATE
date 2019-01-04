package it.unisa.ackc.gestione_utenti.control;

import it.unisa.ackc.HttpServletWithCheck;
import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Si occupa della modifica del profilo di uno studente.
 *
 * @version 0.0.1
 */
public class ModificaProfiloStudenteControl extends HttpServletWithCheck {
    /**
     * Macro del parametro matricola.
     */
    private static final String MATRICOLA_PARAMETRO = "matricola";
    /**
     * Macro del parametro data di nascita.
     */
    private static final String DATA_DI_NASCITA_PARAMETRO = "data_di_nascita";
    /**
     * Macro del parametro luogo di nascita.
     */
    private static final String LUOGO_DI_NASCITA_PARAMETRO = "luogo_di_nascita";
    /**
     * Macro del parametro indirizzo di residenza.
     */
    private static final String INDIRIZZO_DI_RESIDENZA_PARAMETRO =
            "indirizzo_di_residenza";
    /**
     * Macro del parametro numero civico.
     */
    private static final String NUMERO_CIVICO_PARAMETRO = "numero_civico";
    /**
     * Macro del parametro cap.
     */
    private static final String CAP_PARAMETRO = "cap";
    /**
     * Macro del parametro citt&agrave;.
     */
    private static final String CITTA_PARAMETRO = "citta";
    /**
     * Macro del parametro paese.
     */
    private static final String PAESE_PARAMETRO = "paese";
    /**
     * Macro del parametro tipologia di laurea.
     */
    private static final String TIPOLOGIA_DI_LAUREA_PARAMETRO =
            "tipologia_di_laurea";
    /**
     * Macro del parametro corso di laurea.
     */
    private static final String CORSO_DI_LAUREA_PARAMETRO = "corso_di_laurea";
    /**
     * Macro del parametro anno di immatricolazione.
     */
    private static final String ANNO_DI_IMMATRICOLAZIONE_PARAMETRO =
            "anno_di_immatricolazione";
    /**
     * Macro della jsp della modifica del profilo.
     */
    private static final String MODIFICA_JSP = "modifica_jsp";
    /**
     * Macro della jsp di successo della valutazione.
     */
    private static final String SUCCESSFUL_JSP = "";
    /**
     * Macro del messaggio di successo della valutazione.
     */
    private static final String SUCCESSFUL_MESSAGE = "";

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Recupera le informazioni dell'utente e delega la
     * presentazione alla componente jsp Del profilo dello
     * studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute(
                "studente",
                request.getSession().getAttribute("account")
        );
        request.getRequestDispatcher(MODIFICA_JSP).forward(request, response);
    }

    /**
     * Si occupa di effettuare il controllo sui campi della form,
     * in caso di successo aggiornerà l'account dello studente e
     * rendirizzerà alla componente jsp del profilo dello studente.
     *
     * @since 0.0.1
     */
    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response
    ) throws ServletException, IOException {
        valida(request);
        Account account = (Account)
                request.getSession().getAttribute("account");
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
        String matricola = request.getParameter(MATRICOLA_PARAMETRO);
        Date dataDiNascita = null;
        try {
            dataDiNascita = new SimpleDateFormat("dd/MM/yyyy").parse(
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
        AccountStudente studente = (AccountStudente) ackStorage.findAccountById(
                account.getId()
        );
        if (email != null) {
            studente.setEmail(email);
        }
        if (password != null) {
            studente.setPassword(password);
        }
        if (telefono != null) {
            studente.setTelefono(telefono);
        }
        if (nome != null) {
            studente.setNome(nome);
        }
        if (cognome != null) {
            studente.setCognome(cognome);
        }
        if (ruolo != null) {
            studente.setRuolo(ruolo);
        }
        if (sesso != null) {
            studente.setSesso(sesso);
        }
        if (matricola != null) {
            studente.setMatricola(matricola);
        }
        if (dataDiNascita != null) {
            studente.setDataDiNascita(dataDiNascita);
        }
        if (luogoDiNascita != null) {
            studente.setLuogoDiNascita(luogoDiNascita);
        }
        if (indirizzoDiResidenza != null) {
            studente.setIndirizzoDiResidenza(indirizzoDiResidenza);
        }
        if (numeroCivico != null) {
            studente.setNumeroCivico(numeroCivico);
        }
        if (citta != null) {
            studente.setCitta(citta);
        }
        if (cap != null) {
            studente.setCap(cap);
        }
        if (paese != null) {
            studente.setPaese(paese);
        }
        if (tipologiaDiLaurea != null) {
            studente.setTipologiaDiLaurea(tipologiaDiLaurea);
        }
        if (corsoDiLaurea != null) {
            studente.setCorsoDiLaurea(corsoDiLaurea);
        }
        if (annoDiImmatricolazione != null) {
            studente.setAnnoDiImmatricolazione(annoDiImmatricolazione);
        }
        ackStorage.updateAccount(studente);
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
                ModificaProfiloStudenteConvalida.VALIDA_EMAIL
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_COGNOME
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_NOME
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_PASSWORD
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_SESSO
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_TELEFONO
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_LUOGO_DI_NASCITA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_DATA_DI_NASCITA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_INDIRIZZO_DI_RESIDENZA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_NUMERO_CIVICO
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_CAP
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_CITTA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_PAESE
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_MATRICOLA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_TIPOLOGIA_DI_LAUREA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_CORSO_DI_LAUREA
        );
        addCondizione(
                ModificaProfiloStudenteConvalida.VALIDA_ANNO_DI_IMMATRICOLAZIONE
        );
        super.valida(request);
    }
}
