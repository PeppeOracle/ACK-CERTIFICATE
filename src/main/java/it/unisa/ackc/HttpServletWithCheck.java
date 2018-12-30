package it.unisa.ackc;

import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class HttpServletWithCheck extends HttpServlet {
    private List<CondizioneConvalida> condizioniDiConvalida;

    public void addCondizione(final CondizioneConvalida condizione) {
        condizioniDiConvalida.add(condizione);
    }

    public void valida(final HttpServletRequest request) {
        Notifica notifica = new Notifica();
        for (CondizioneConvalida condizione : condizioniDiConvalida) {
            notifica.addErrors(condizione.validate(request));
        }
        if (notifica.hasErrors()) {
            throw new IllegalArgumentException(notifica.errorMessage());
        }
    }
}
