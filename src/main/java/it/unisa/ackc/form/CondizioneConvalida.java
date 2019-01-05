package it.unisa.ackc.form;

import it.unisa.ackc.http.Notifica;

/**
 * Contiene la logica di una condizione di convalida.
 */
public interface CondizioneConvalida {
    /**
     * Convalida la condizione.
     *
     * @param formDati da validare
     * @return notifica contenente la collezione di errori trovati
     */
    Notifica validate(FormDati formDati);
}
