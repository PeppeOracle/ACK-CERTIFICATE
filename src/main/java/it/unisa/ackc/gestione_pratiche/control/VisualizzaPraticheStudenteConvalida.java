package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.inject.Inject;

/**
 * Si occupa della convalida della valutazione di una pratica.
 *
 * @version 0.0.1
 */
final class VisualizzaPraticheStudenteConvalida {

    /**
     * Istanza dello storage facade.
     */
    @Inject
    private ACKStorageFacadeEJB ackStorage;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private VisualizzaPraticheStudenteConvalida() { }

    /**
     * Convalida il numero di pagina della lista di pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PAGINA =
            request -> {
                Notifica notifica = new Notifica();
                int pagina = Integer.parseInt(request.getParameter(
                        VisualizzaPraticheStudenteControl.
                                PAGINA_PARAMETRO
                ));
                AccountStudente account =
                        (AccountStudente)
                        request.getSession().getAttribute("account");
                int maxPag = ackStorage.
                        countAllPraticheForStudente(account)
                        / VisualizzaPraticheStudenteControl.
                                LIMITE_PAGINA;
                maxPag++;
                if (pagina < 0) {
                    notifica.addError(
                            "Il numero di pagina non può essere negativo"
                    );
                } else if (pagina > maxPag) {
                    notifica.addError(
                            "Il numero di pagina supera il valore ammissibile"
                    );
                }
                return  notifica;
            };
}
