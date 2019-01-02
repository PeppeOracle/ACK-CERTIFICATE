package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_storage.ACKStorageFacade;
import it.unisa.ackc.validator.CondizioneConvalida;
import it.unisa.ackc.validator.Notifica;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

final class PraticaConvalida {
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
     * Convalida l'identificativo della pratica.
     *
     * @since 0.0.1
     */
    static final CondizioneConvalida VALIDA_PRATICA = request -> {
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
}
