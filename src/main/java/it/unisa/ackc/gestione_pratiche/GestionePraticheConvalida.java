package it.unisa.ackc.gestione_pratiche;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Si occupa della convalida delle richieste di gestione pratiche.
 *
 * @version 0.0.1
 */
public final class GestionePraticheConvalida {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private GestionePraticheConvalida() { }

    /**
     * Macro del parametro numero_cfu.
     */
    public static final String NUMERO_CFU_PARAMETRO =
            "numero_cfu";
    /**
     * Lunghezza massima di un numero a due cifre positivo.
     */
    private static final int MAX_NUMBER_DUE_CIFRE = 99;
    /**
     * Stringa di lookup per lo storage.
     */
    private static final String STORAGE_LOOKUP =
            "java:global/ACK-CERTIFICATE/"
                    + "ACKStorageFacadeEJB!it.unisa.ackc."
                    + "gestione_storage.ACKStorageFacade";
    /**
     * Macro del parametro identificativo della pratica.
     */
    private static final String PRATICA_PARAMETRO = "pratica";

    /**
     * Convalida del numero di cfu.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NUMERO_CFU = request -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCfu = Integer.parseInt(request.getParameter(
                    NUMERO_CFU_PARAMETRO
            ));
            if (!isNumeroUnaDueCifre(numeroCfu)) {
                notifica.addError(
                        "Il numero di cfu deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "Il numero di cfu deve essere un numero"
            );
        }
        return  notifica;
    };

    /**
     * Convalida l'identificativo della pratica.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PRATICA = request -> {
        Notifica notifica = new Notifica();
        try {
            Long praticaId = Long.parseLong(request.getParameter(
                    PRATICA_PARAMETRO
            ));
            if (praticaId <= 0) {
                notifica.addError(
                        "L'identificativo della pratica "
                                + "deve essere maggiore di 0"
                );
            } else {
                ACKStorageFacade ackStorage = null;
                try {
                    Context context = new InitialContext();
                    ackStorage = (ACKStorageFacade)
                            context.lookup(
                                    STORAGE_LOOKUP
                            );
                } catch (NamingException e) {
                    notifica.addError(
                            "Non è stato possibile effettuare l'operazione", e
                    );
                }
                Pratica pratica = ackStorage.findPraticaById(praticaId);
                if (pratica == null) {
                    notifica.addError(
                            "L'identificativo di pratica indicato non esiste"
                    );
                } else {
                    request.setAttribute("pratica", pratica);
                }
            }
        } catch (NumberFormatException e) {
            notifica.addError(
                    "L'identificativo della pratica deve essere un numero"
            );
        }
        return  notifica;
    };

    /**
     * Controlla se un numero è positivo e al più di due cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo a due cifre, false altrimenti
     * @since 0.0.1
     */
    public static boolean isNumeroUnaDueCifre(final Integer number) {
        return number <= MAX_NUMBER_DUE_CIFRE && number > 0;
    }
}
