package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.storage.ACKStorageFacade;
import it.unisa.ackc.storage.ejb.ACKStorageFacadeDefault;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.http.Notifica;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Contiene le condizioni di convalida per la visualizzazione delle
 * pratiche per un responsabile ufficio.
 *
 * @version 0.1.1
 */
public final class VisualizzaPraticheResponsabileUfficio {
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
    private VisualizzaPraticheResponsabileUfficio() { }

    /**
     * Convalida il filtro della lista di pratiche.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_FILTRO =
            formDati -> {
                Notifica notifica = new Notifica();
                int filtro = formDati.ottieniDatoIntero(
                        it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                FILTRO_PARAMETRO
                );
                if (filtro < 0
                        || filtro > it.unisa.ackc.gestione_pratiche.control
                        .VisualizzaPraticheResponsabileUfficio.
                        PRATICHE_CHIUSE) {
                    notifica.aggiungiErrore(
                            "Il filtro non è corretto"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida il numero di pagina della lista di pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PAGINA =
            formDati -> {
                Notifica notifica = new Notifica();
                int filtro = formDati.ottieniDatoIntero(
                        it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                FILTRO_PARAMETRO
                );
                int pagina = formDati.ottieniDatoIntero(
                        it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                PAGINA_PARAMETRO
                );
                AccountResponsabileUfficio account =
                        (AccountResponsabileUfficio)
                                formDati.ottieni("temp_account");
                ACKStorageFacade ackStorage = null;
                try {
                    Context context = new InitialContext();
                    ackStorage = new ACKStorageFacadeDefault();
                } catch (NamingException e) {
                    notifica.aggiungiErrore(
                            "Non è stato possibile effettuare l'operazione", e
                    );
                }
                long maxPag;
                switch (filtro) {
                    case it.unisa.ackc.gestione_pratiche.control
                                    .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_SOSPESE:
                        maxPag = ackStorage.
                                countPraticheSospeseForResponsabileUfficio(
                                        account)
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_DA_VALUTARE:
                        maxPag = ackStorage.
                                countPraticheDaValutareForResponsabileUfficio(
                                        account)
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_CHIUSE:
                        maxPag = ackStorage.
                                countPraticheChiuseForResponsabileUfficio(
                                        account)
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            NESSUN_FILTRO:
                    default:
                        maxPag = ackStorage.
                                countAllPraticheForResponsabileUfficio(account)
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                }
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
