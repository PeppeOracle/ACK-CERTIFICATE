package it.unisa.ackc.validator;

import javax.servlet.http.HttpServletRequest;

public interface CondizioneConvalida {
    Notifica validate(HttpServletRequest request);
}
