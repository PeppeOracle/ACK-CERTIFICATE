package it.unisa.ackc.http;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permette di collezionare un insieme di errori.
 */
public class Notifica {
    /**
     * Contiene la lista degli errori aggiunti.
     */
    private List<Errore> errori = new ArrayList<>();

    /**
     * Aggiunge un errore.
     *
     * @param messaggio messaggio dell'errore
     */
    public void aggiungiErrore(final String messaggio) {
        aggiungiErrore(messaggio, null);
    }

    /**
     * Aggiunge un errore.
     *
     * @param messaggio messaggio dell'errore
     * @param causa eccezzione causa dell'errore
     */
    public void aggiungiErrore(final String messaggio, final Exception causa) {
        errori.add(new Errore(messaggio, causa));
    }

    /**
     * Veririfica se sono presenti errori o meno.
     *
     * @return true se ci sono errori, false altrimenti
     */
    public boolean contieneErrori() {
        return !errori.isEmpty();
    }

    /**
     * Restituisce gli errori sotto forma di stringa.
     *
     * @return stringa di errori concatenati da ','
     */
    public String erroreMessaggio() {
        return errori.stream()
                .map(e -> e.messaggio)
                .collect(Collectors.joining(", "));
    }

    /**
     * Aggiunge gli errori contenuti nella notifica
     * a quella attuale.
     *
     * @param aNotifica contenente gli errori da aggiungere
     */
    public void aggiungiErrori(final Notifica aNotifica) {
        errori.addAll(aNotifica.errori);
    }

    /**
     * Incapsula le informazioni riguardante un errore.
     */
    private final class Errore {
        /**
         * Messaggio dell'errore.
         */
        private String messaggio;
        /**
         * Causa dell'errore.
         */
        private Exception causa;

        /**
         * Permette di instanziare un oggetto di tipo <code>Notifica</code>.
         *
         * @param aMessaggio messaggio dell'erore
         * @param aCausa causa dell'errore
         */
        private Errore(final String aMessaggio, final Exception aCausa) {
            this.messaggio = aMessaggio;
            this.causa = aCausa;
        }
    }
}


