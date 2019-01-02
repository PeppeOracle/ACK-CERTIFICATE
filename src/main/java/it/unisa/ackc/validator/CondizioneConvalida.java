package it.unisa.ackc.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * Contiene la logica di una condizione di convalida.
 */
public interface CondizioneConvalida {
    /**
     * Convalida la condizione.
     *
     * @param request da validare
     * @return notifica contenente la collezione di errori trovati
     */
    Notifica validate(HttpServletRequest request);
}
