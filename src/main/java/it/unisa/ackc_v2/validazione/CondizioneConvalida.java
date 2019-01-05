package it.unisa.ackc_v2.validazione;

import it.unisa.ackc.validator.Notifica;
import it.unisa.ackc_v2.form.FormDati;

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
