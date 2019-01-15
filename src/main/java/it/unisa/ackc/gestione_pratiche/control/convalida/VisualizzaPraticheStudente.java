package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.storage.ejb.ACKStorageFacadeDefault;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Notifica;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Contiene le condizioni di convalida per la visualizzazione delle
 * pratiche per uno studente.
 *
 * @version 0.1.1
 */
public final class VisualizzaPraticheStudente {
    /**
     * Istanza dello storage facade.
     */
    //@Inject
    private ACKStorageFacade ackStorage;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private VisualizzaPraticheStudente() { }

    /**
     * Convalida il numero di pagina della lista di pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PAGINA =
            formDati -> {
                Notifica notifica = new Notifica();
                int pagina = formDati.ottieniDatoIntero(
                        it.unisa.ackc.gestione_pratiche.
                                control.VisualizzaPraticheStudente.
                                PAGINA_PARAMETRO
                );
                AccountStudente account = (AccountStudente)
                        formDati.ottieni("account");
                ACKStorageFacade ackStorage = null;
                try {
                    Context context = new InitialContext();
                    ackStorage = new ACKStorageFacadeDefault();
                } catch (NamingException e) {
                    notifica.aggiungiErrore(
                            "Non è stato possibile effettuare l'operazione", e
                    );
                }
                long maxPag = ackStorage.
                        countAllPraticheForStudente(account)
                        /
                        it.unisa.ackc.gestione_pratiche.
                                control.VisualizzaPraticheStudente.
                        LIMITE_PAGINA;
                maxPag++;
                if (pagina < 0) {
                    notifica.aggiungiErrore(
                            "Il numero di pagina non può essere negativo"
                    );
                } else if (pagina > maxPag) {
                    notifica.aggiungiErrore(
                            "Il numero di pagina supera il valore ammissibile"
                    );
                }
                return  notifica;
            };
}
