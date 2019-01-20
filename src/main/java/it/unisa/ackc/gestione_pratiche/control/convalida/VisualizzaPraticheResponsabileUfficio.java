package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

/**
 * Contiene le condizioni di convalida per la visualizzazione delle
 * pratiche per un responsabile ufficio.
 *
 * @version 0.1.1
 */
public final class VisualizzaPraticheResponsabileUfficio {
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
    public static final CondizioneConvalida VALIDA_FILTRO =
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
    public static final CondizioneConvalida VALIDA_PAGINA =
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
                long maxPag;
                switch (filtro) {
                    case it.unisa.ackc.gestione_pratiche.control
                                    .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_SOSPESE:
                        maxPag = formDati
                                .ottieniDatoIntero("pratiche_sospese")
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_DA_VALUTARE:
                        maxPag = formDati
                                .ottieniDatoIntero("pratiche_da_valutare")
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            PRATICHE_CHIUSE:
                        maxPag = formDati
                                .ottieniDatoIntero("pratiche_chiuse")
                                / it.unisa.ackc.gestione_pratiche.control
                                .VisualizzaPraticheResponsabileUfficio.
                                LIMITE_PAGINA;
                        break;
                    case it.unisa.ackc.gestione_pratiche.control
                            .VisualizzaPraticheResponsabileUfficio.
                            NESSUN_FILTRO:
                    default:
                        maxPag = formDati
                                .ottieniDatoIntero("pratiche_totali")
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
