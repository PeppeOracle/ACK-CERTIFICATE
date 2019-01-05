package it.unisa.ackc.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Permette di collezionare un campi del form.
 */
public class FormDati {
    /**
     * Oggetto DateFormat per il parse delle date.
     */
    private static final DateFormat DATE_FORMAT =
            new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Collezione di campi del form.
     */
    private Map<String, Object> dati;

    /**
     * Permette di instanziare un oggetto di tipo <code>FormDati</code>.
     *
     * @since 0.0.1
     */
    public FormDati() {
        dati = new HashMap<>();
    }

    /**
     * Permette di aggiungere un nuovo dato.
     *
     * @param chiave del nuovo dato
     * @param valore del nuovo dato
     * @since 0.0.1
     */
    public void aggiungiDato(final String chiave, final Object valore) {
        dati.put(chiave, valore);
    }

    /**
     * Restituisce il dato come oggetto String.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @since 0.0.1
     */
    public String ottieniDato(final String chiave) {
        if (dati.get(chiave) == null) {
            return null;
        }
        return String.valueOf(dati.get(chiave));
    }

    /**
     * Restituisce il dato come oggetto array di String.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @since 0.0.1
     */
    public String[] ottieniDati(final String chiave) {
        return (String[]) dati.get(chiave);
    }

    /**
     * Restituisce il dato come oggetto.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @since 0.0.1
     */
    public Object ottieni(final String chiave) {
        return dati.get(chiave);
    }

    /**
     * Restituisce il dato come oggetto Integer.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @since 0.0.1
     */
    public Integer ottieniDatoIntero(final String chiave) {
        return Integer.parseInt(ottieniDato(chiave));
    }

    /**
     * Restituisce il dato come oggetto Long.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @since 0.0.1
     */
    public Long ottieniDatoLong(final String chiave) {
        return Long.parseLong(ottieniDato(chiave));
    }

    /**
     * Restituisce il dato come oggetto Date.
     *
     * @param chiave corrispondente al dato desiderato
     * @return dato corrispondente alla chiave
     * @throws ParseException lanciata nel momento in cui
     *                        ci siano errori con il parsing
     * @since 0.0.1
     */
    public Date ottieniDatoData(final String chiave) throws ParseException {
        return DATE_FORMAT.parse(ottieniDato(chiave));
    }
}
