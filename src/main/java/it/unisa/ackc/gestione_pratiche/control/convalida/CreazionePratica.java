package it.unisa.ackc.gestione_pratiche.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.Notifica;

import java.util.regex.Pattern;

/**
 * Si occupa della convalida della creazione di una pratica.
 *
 * @version 0.0.1
 */
public final class CreazionePratica {
    /**
     * Lunghezza massima del messaggio dello studente.
     */
    private static final int MESSAGGIO_MAX = 512;

    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private CreazionePratica() { }

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
                                .CreazionePratica.MESSAGGIO_PARAMETRO
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
                String domanda;
                domanda = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazionePratica.DOMANDA_PARAMETRO
                );
                if (domanda == null) {
                    notifica.aggiungiErrore(
                            "La domanda non è presente"
                    );
                } else {
                    String[] splitDomanda = domanda.split(Pattern.quote("."));
                    if (splitDomanda.length != 2
                            || !splitDomanda[1].equals("pdf")) {
                        notifica.aggiungiErrore(
                                "Il formato della domanda non è corretto [pdf]"
                        );
                    }
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
                String attestato;
                attestato = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazionePratica.ATTESTATO_PARAMETRO
                );
                if (attestato == null) {
                    notifica.aggiungiErrore(
                            "L'attestato non è presente"
                    );
                } else {
                    String[] splitAttestato = attestato.split(
                            Pattern.quote(".")
                    );
                    if (splitAttestato.length != 2
                            || !splitAttestato[1].equals("pdf")) {
                        notifica.aggiungiErrore(
                                "Il formato dell'attestato non"
                                        + " è corretto [pdf]"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida il tipo della pratica.
     *
     * @since 0.1.1
     */
    public static final CondizioneConvalida VALIDA_TIPO =
            formDati -> {
                Notifica notifica = new Notifica();
                String tipo = formDati.ottieniDato(
                        it.unisa.ackc.gestione_pratiche.control
                                .CreazionePratica.TIPO_PARAMETRO
                );
                if (tipo == null || tipo.trim().equals("")) {
                    notifica.aggiungiErrore(
                            "Il tipo non è stato indicato"
                    );
                } else {
                    try {
                        Pratica.Tipo.valueOf(tipo);
                    } catch (IllegalArgumentException e) {
                        notifica.aggiungiErrore(
                                "Il tipo della pratica indicato"
                                        + "non è corretto"
                        );
                    }
                }
                return  notifica;
            };
}
