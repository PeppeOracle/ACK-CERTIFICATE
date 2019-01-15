package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.http.Notifica;

import java.util.regex.Pattern;

/**
 * Contiene le condizioni di convalida per la modifica della pratica sospesa.
 *
 * @version 0.1.1
 */
public final class ModificaPraticaSospesa {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ModificaPraticaSospesa() { }

    /**
     * Convalida il messaggio dello studente.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_MESSAGGIO =
            formDati -> {
                Notifica notifica = new Notifica();
                String messaggio = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .ModificaPraticaSospesa.MESSAGGIO_PARAMETRO
                );
                if (messaggio != null) {
                    if (messaggio.length() > MESSAGGIO_MAX) {
                        notifica.aggiungiErrore(
                                "Il messaggio dello studente "
                                        + "non può superare i 64 caratteri"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida la domanda.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_DOMANDA =
            formDati -> {
                Notifica notifica = new Notifica();
                String domanda = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .ModificaPraticaSospesa.DOMANDA_PARAMETRO
                );
                if (domanda == null) {
                    return notifica;
                }
                String[] splitDomanda = domanda.split(Pattern.quote("."));
                if (splitDomanda.length != 2
                        || !splitDomanda[1].equals("pdf")) {
                    notifica.aggiungiErrore(
                            "Il formato della domanda non è corretto [pdf]"
                    );
                }
                return  notifica;
            };

    /**
     * Convalida l'attestato.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ATTESTATO =
            formDati -> {
                Notifica notifica = new Notifica();
                String attestato = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .ModificaPraticaSospesa.ATTESTATO_PARAMETRO
                );
                if (attestato == null) {
                    return notifica;
                }
                String[] splitAttestato = attestato.split(Pattern.quote("."));
                if (splitAttestato.length != 2
                        || !splitAttestato[1].equals("pdf")) {
                    notifica.aggiungiErrore(
                            "Il formato dell'attestato non è corretto [pdf]"
                    );
                }
                return  notifica;
            };
}
