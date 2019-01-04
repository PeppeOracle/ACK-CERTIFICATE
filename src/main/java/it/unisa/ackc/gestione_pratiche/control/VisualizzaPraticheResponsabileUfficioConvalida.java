package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_storage.ejb.ACKStorageFacadeEJB;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.inject.Inject;

/**
 * Si occupa della convalida della valutazione di una pratica.
 *
 * @version 0.0.1
 */
final class VisualizzaPraticheResponsabileUfficioConvalida {

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
    private VisualizzaPraticheResponsabileUfficioConvalida() { }

    /**
     * Convalida il filtro della lista di pratiche.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_FILTRO =
            request -> {
                Notifica notifica = new Notifica();
                int filtro = Integer.parseInt(request.getParameter(
                        VisualizzaPraticheResponsabileUfficioControl.
                                FILTRO_PARAMETRO
                ));
                if (filtro < 0
                    || filtro > VisualizzaPraticheResponsabileUfficioControl.
                        PRATICHE_CHIUSE) {
                    notifica.addError(
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
            request -> {
                Notifica notifica = new Notifica();
                int filtro = Integer.parseInt(request.getParameter(
                        VisualizzaPraticheResponsabileUfficioControl.
                                FILTRO_PARAMETRO
                ));
                int pagina = Integer.parseInt(request.getParameter(
                        VisualizzaPraticheResponsabileUfficioControl.
                                PAGINA_PARAMETRO
                ));
                AccountResponsabileUfficio account =
                        (AccountResponsabileUfficio)
                        request.getSession().getAttribute("account");
                int maxPag = 0;
                switch (filtro) {
                    case VisualizzaPraticheResponsabileUfficioControl.
                            PRATICHE_SOSPESE:
                        maxPag = ackStorage.
                            countPraticheSospeseForResponsabileUfficio(account)
                        / VisualizzaPraticheResponsabileUfficioControl.
                                LIMITE_PAGINA;
                        break;
                    case VisualizzaPraticheResponsabileUfficioControl.
                            PRATICHE_DA_VALUTARE:
                        maxPag = ackStorage.
                        countPraticheDaValutareForResponsabileUfficio(account)
                        / VisualizzaPraticheResponsabileUfficioControl.
                                LIMITE_PAGINA;
                        break;
                    case VisualizzaPraticheResponsabileUfficioControl.
                            PRATICHE_CHIUSE:
                        maxPag = ackStorage.
                            countPraticheChiuseForResponsabileUfficio(account)
                        / VisualizzaPraticheResponsabileUfficioControl.
                                LIMITE_PAGINA;
                        break;
                    case VisualizzaPraticheResponsabileUfficioControl.
                            NESSUN_FILTRO:
                    default:
                        maxPag = ackStorage.
                        countAllPraticheForResponsabileUfficio(account)
                        / VisualizzaPraticheResponsabileUfficioControl.
                                LIMITE_PAGINA;
                }
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
