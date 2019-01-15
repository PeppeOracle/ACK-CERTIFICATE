package it.unisa.ackc.gestione_utenti.control.convalida;

import it.unisa.ackc.form.CondizioneConvalida;
import it.unisa.ackc.form.FormDati;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.http.Notifica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Si occupa della convalida della modifica dello studente.
 *
 * @version 0.1.1
 */
public final class ModificaProfiloStudente {
    /**
     * Lunghezza massima di un numero a tre cifre positivo.
     */
    private static final int MAX_NUMBER_TRE_CIFRE = 999;
    /**
     * Costruttore di default.
     *
     * @since 0.0.1
     */
    private ModificaProfiloStudente() { }

    /**
     * Convalida del nome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NOME =
            formDati -> {
                return validaNome(formDati, AccountConvalida.NOME_PARAMETRO);
            };

    /**
     * Convalida del cognome.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_COGNOME =
            formDati -> {
                return validaNome(formDati, AccountConvalida.COGNOME_PARAMETRO);
            };

    /**
     * Convalida dell'email.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_EMAIL =
            formDati -> {
                Notifica notifica = new Notifica();
                String email = formDati.ottieniDato(
                        AccountConvalida.EMAIL_PARAMETRO
                );
                if (email != null) {
                    if (email.length() < 19 || email.length() > 64) {
                        notifica.aggiungiErrore("La lunghezza dell'email "
                                + "deve compresa tra 19 e 64");
                    }
                    if (!email.matches(
                            "[A-Z,a-z,0-9,-,.,_ ]+[@studenti.unisa.it]+")) {
                        notifica.aggiungiErrore("Il formato dell'email "
                                + "non è stato rispettato");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida della password.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PASSWORD =
            formDati -> {
                Notifica notifica = new Notifica();
                String password = formDati.ottieniDato(
                        AccountConvalida.PASSWORD_PARAMETRO
                );
                if (password != null) {
                    if (!password.matches("\\w{2,8}$")) {
                        notifica.aggiungiErrore("La lunghezza della password "
                                + "deve compresa tra 2 e 8");
                    }
                    if (!password.matches("[A-Z, a-z,0-9]+")) {
                        notifica.aggiungiErrore("Il formato della password "
                                + "non è stato rispettato");
                    }
                    if (!AccountConvalida.containsLetteraENumero(password)) {
                        notifica.aggiungiErrore("La password deve"
                                + " contenere almeno una lettera e un numero");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del telefono.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TELEFONO =
            formDati -> {
                Notifica notifica = new Notifica();
                String telefono = formDati.ottieniDato(
                        AccountConvalida.TELEFONO_PARAMETRO
                );
                if (telefono != null) {
                    if (!telefono.matches("\\w{9,10}$")) {
                        notifica.aggiungiErrore("La lunghezza del telefono "
                                + "deve compresa tra 9 e 10");
                    }
                    if (!telefono.matches("[0-9]+")) {
                        notifica.aggiungiErrore("Il formato del telefono "
                                + "non è stato rispettato");
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del sesso.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_SESSO =
            formDati -> {
                Notifica notifica = new Notifica();
                String sesso = formDati.ottieniDato(
                        AccountConvalida.SESSO_PARAMETRO
                );
                if (sesso != null) {
                    try {
                        Account.Sesso.valueOf(sesso);
                    } catch (IllegalArgumentException e) {
                        notifica.aggiungiErrore(
                                "Il sesso indicato"
                                        + " non è corretto"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del luogo di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_LUOGO_DI_NASCITA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        AccountStudente.
                                LUOGO_DI_NASCITA_PARAMETRO
                );
            };

    /**
     * Convalida della data di nascita.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_DATA_DI_NASCITA =
            formDati -> {
                Notifica notifica = new Notifica();
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String dataDiNascita = formDati.ottieniDato(
                        AccountStudente.
                                DATA_DI_NASCITA_PARAMETRO
                );
                if (dataDiNascita != null) {
                    try {
                        format.parse(dataDiNascita);
                    } catch (ParseException e) {
                        notifica.aggiungiErrore(
                                "Il formato del periodo"
                                        + " non è stato rispettato", e
                        );
                    }
                }
                return notifica;
            };

    /**
     * Convalida dell'indirizzo di residenza.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_INDIRIZZO_DI_RESIDENZA =
            formDati -> {
                Notifica notifica = new Notifica();
                String indirizzo = formDati.ottieniDato(
                        AccountStudente.
                                INDIRIZZO_DI_RESIDENZA_PARAMETRO
                );
                if (indirizzo != null) {
                    if (indirizzo.length()
                            > AccountStudente.
                            INDIRIZZO_DI_RESIDENZA_MAX) {
                        notifica.aggiungiErrore(
                                "L'indirizzo di residenza "
                                        + "non può superare i 64 caratteri"
                        );
                    } else if (indirizzo.trim().equals("")) {
                        notifica.aggiungiErrore(
                                "L'indirizzo di residenza "
                                        + " non può essere vuoto"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del numero civico.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_NUMERO_CIVICO =
            formDati -> {
                Notifica notifica = new Notifica();
                if (formDati.ottieniDato(
                        AccountStudente.
                                NUMERO_CIVICO_PARAMETRO
                ) != null) {
                    try {
                        Integer numeroCivico =
                                Integer.parseInt(formDati.ottieniDato(
                                        AccountStudente.
                                                NUMERO_CIVICO_PARAMETRO
                                ));
                        if (!isNumeroUnaTreCifre(numeroCivico)) {
                            notifica.aggiungiErrore(
                                    "Il numero civico deve essere"
                                            + " maggiore di 0 e deve essere"
                                            + " un numero almeno a tre cifre"
                            );
                        }
                    } catch (NumberFormatException e) {
                        notifica.aggiungiErrore(
                                "Il numero civico deve essere un numero", e
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida del CAP.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CAP =
            formDati -> {
                Notifica notifica = new Notifica();
                String cap = formDati.ottieniDato(
                        AccountStudente.
                                CAP_PARAMETRO
                );
                if (cap != null) {
                    if (cap.length()
                            != AccountStudente.CAP_LENGTH) {
                        notifica.aggiungiErrore(
                                "Il CAP deve essere di 5 caratteri"
                        );
                    } else if (!cap.matches("[0-9]+")) {
                        notifica.aggiungiErrore(
                                "Il CAP deve essere composto solo da cifre"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida della città.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CITTA =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        AccountStudente.
                                CITTA_PARAMETRO
                );
            };

    /**
     * Convalida del paese.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_PAESE =
            formDati -> {
                return AccountConvalida.validaNome(
                        formDati,
                        AccountStudente.
                                PAESE_PARAMETRO
                );
            };

    /**
     * Convalida della matricola.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_MATRICOLA =
            formDati -> {
                Notifica notifica = new Notifica();
                String matricola = formDati.ottieniDato(
                        AccountStudente.
                                MATRICOLA_PARAMETRO
                );
                if (matricola != null) {
                    if (matricola.length()
                            != AccountStudente.MATRICOLA_LENGTH) {
                        notifica.aggiungiErrore(
                                "La matricola deve essere di 10 caratteri"
                        );
                    } else if (!matricola.matches("[0-9]+")) {
                        notifica.aggiungiErrore(
                                "La matricola deve essere composta"
                                        + " solo da cifre"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Convalida della tipologia di laurea.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_TIPOLOGIA_DI_LAUREA =
            formDati -> AccountConvalida.validaNome(
                        formDati,
                        AccountStudente.
                                TIPOLOGIA_DI_LAUREA_PARAMETRO
                );

    /**
     * Convalida del corso di laurea.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_CORSO_DI_LAUREA =
            formDati -> AccountConvalida.validaNome(
                        formDati,
                        AccountStudente.
                                CORSO_DI_LAUREA_PARAMETRO
                );

    /**
     * Convalida dell'anno di immatricolazione.
     *
     * @since 0.0.1
     */
    public static final CondizioneConvalida VALIDA_ANNO_DI_IMMATRICOLAZIONE =
            formDati -> {
                Notifica notifica = new Notifica();
                String annoDiImmatricolazione = formDati.ottieniDato(
                        AccountStudente.
                                ANNO_DI_IMMATRICOLAZIONE_PARAMETRO
                );
                if (annoDiImmatricolazione != null) {
                    if (annoDiImmatricolazione.length()
                            != AccountStudente.
                            ANNO_DI_IMMATRICOLAZIONE_LENGTH) {
                        notifica.aggiungiErrore(
                                "L'anno di immatricolazione deve essere"
                                        + " di 4 caratteri"
                        );
                    } else if (!annoDiImmatricolazione.matches("[0-9]+")) {
                        notifica.aggiungiErrore(
                                "L'anno di immatricolazione deve essere"
                                        + " composto solo da cifre"
                        );
                    }
                }
                return  notifica;
            };

    /**
     * Controlla se un numero è positivo e al più di tre cifre.
     *
     * @param number che si vuole controllare
     * @return true se number è positivo con al più tre cifre,
     * false altrimenti
     * @since 0.0.1
     */
    private static boolean isNumeroUnaTreCifre(final Integer number) {
        return number <= MAX_NUMBER_TRE_CIFRE && number > 0;
    }
    /**
     * Restituisce la notifica degli errori su una convalida del nome.
     * @param formDati da cui prendere il parametro
     * @param nome del parametro
     * @return notifica
     * @since 0.0.1
     */
    static Notifica validaNome(
            final FormDati formDati, final String nome
    ) {
        Notifica notifica = new Notifica();
        String val = formDati.ottieniDato(nome);
        if (val != null) {
            if (!val.matches("\\w{1,64}$")) {
                notifica.aggiungiErrore("La lunghezza del " + nome
                        + " deve essere compresa tra 1 e 64");
            }
            if (!val.matches("[A-Z, a-z,']+")) {
                notifica.aggiungiErrore("Il formato del " + nome
                        + " non è stato rispettato");
            }
        }
        return notifica;
    }
}
