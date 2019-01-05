package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.http.Notifica;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Contiene le condizioni di convalida per la gestione pratiche.
 *
 * @version 0.1.1
 */
public final class GestionePratiche {
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private GestionePratiche() { }

    /**
     * Macro del parametro numero_cfu.
     */
    public static final String NUMERO_CFU_PARAMETRO =
            "numero_cfu";
    /**
     * Macro del parametro identificativo della pratica.
     */
    public static final String PRATICA_PARAMETRO = "pratica";
    /**
     * Lunghezza massima di un numero a due cifre positivo.
     */
    private static final int MAX_NUMBER_DUE_CIFRE = 99;

    /**
     * Convalida del numero di cfu.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NUMERO_CFU = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Integer numeroCfu = formDati.ottieniDatoIntero(
                    NUMERO_CFU_PARAMETRO
            );
            if (!isNumeroUnaDueCifre(numeroCfu)) {
                notifica.aggiungiErrore(
                        "Il numero di cfu deve essere maggiore di 0 e "
                                + "può essere al più un numero a due cifre"
                );
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
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
    public static final CondizioneConvalida VALIDA_PRATICA = formDati -> {
        Notifica notifica = new Notifica();
        try {
            Long praticaId = Long.parseLong(formDati.ottieniDato(
                    PRATICA_PARAMETRO
            ));
            if (praticaId <= 0) {
                notifica.aggiungiErrore(
                        "L'identificativo della pratica "
                                + "deve essere maggiore di 0"
                );
            } else {
                ACKStorageFacade ackStorage = null;
                try {
                    Context context = new InitialContext();
                    ackStorage = (ACKStorageFacade)
                            context.lookup(
                                    ACKStorageFacade.LOOKUP
                            );
                } catch (NamingException e) {
                    notifica.aggiungiErrore(
                            "Non è stato possibile effettuare l'operazione", e
                    );
                }
                Pratica pratica = ackStorage.findPraticaById(praticaId);
                if (pratica == null) {
                    notifica.aggiungiErrore(
                            "L'identificativo di pratica indicato non esiste"
                    );
                }
            }
        } catch (NumberFormatException e) {
            notifica.aggiungiErrore(
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
