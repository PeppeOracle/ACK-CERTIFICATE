package it.unisa.ackc.http;

/**
 * Interfaccia per la sessione http.
 */
public interface Sessione {
    /**
     * Permette di ottenere un campo della sessione.
     *
     * @param chiave corrispondente al campo desiderato
     * @return il valore corrispondente alla chiave indicata
     */
    Object ottieni(String chiave);

    /**
     * Permette di aggiungere un campo alla sessione.
     *
     * @param chiave del campo
     * @param valore del campo
     */
    void aggiungi(String chiave, Object valore);

    /**
     * Permette di rimuovere un campo dalla sessione.
     *
     * @param chiave del campo
     */
    void rimuovi(String chiave);
}
