package it.unisa.ackc.gestione_pratiche.entity;

/**
 * Rappresenta la specifica di un'attestazione di lingua inglese.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}.
 *
 * @version 0.1.1
 */
public class DomandaLinguaInglese extends Domanda {
    /**
     * Ente certificatore della lingua inglese.
     */
    private String enteCertificatore;
    /**
     * Grado dell'attestazione di lingua inglese.
     */
    private String grade;
    /**
     * Livello cefr dell'attestazione di lingua inglese.
     */
    private String livelloCefr;

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>DomandaLinguaInglese</code>.
     *
     * @param aPath percorso del file
     * @param aNumeroCfu numero di CFU di cui si richiede il riconoscimento
     * @param aEnteCertificatore ente che ha rilasciato la certificazione
     * @param aGrade livello GRADE dell'attestazione
     * @param aLivelloCefr livello CEFR dell'attestazione
     * @since 0.0.1
     */
    public DomandaLinguaInglese(final String aPath,
                                final int aNumeroCfu,
                                final String aEnteCertificatore,
                                final String aGrade,
                                final String aLivelloCefr) {
        super(aPath, aNumeroCfu);
        this.enteCertificatore = aEnteCertificatore;
        this.grade = aGrade;
        this.livelloCefr = aLivelloCefr;
    }

    /**
     * Costruttore di default.
     */
    public DomandaLinguaInglese() { }

    /**
     * Restituisce
     * l'ente che ha rilasciato la certificazione.
     *
     * @return enteCertificatore
     * @since 0.0.1
     */
    public String getEnteCertificatore() {
        return enteCertificatore;
    }

    /**
     * Permette di impostare
     * l'ente che ha rilasciato la certificazione.
     *
     * @param aEnteCertificatore nuovo ente certificatore
     * @since 0.0.1
     */
    public void setEnteCertificatore(final String aEnteCertificatore) {
        this.enteCertificatore = aEnteCertificatore;
    }

    /**
     * Restituisce
     * il livello GRADE dell'attestazione.
     *
     * @return grade
     * @since 0.0.1
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Permette di impostare
     * il livello GRADE dell'attestazione.
     *
     * @param aGrade nuovo grade
     * @since 0.0.1
     */
    public void setGrade(final String aGrade) {
        this.grade = aGrade;
    }

    /**
     * Restituisce
     * il livello CEFR dell'attestazione.
     *
     * @return livelloCefr
     * @since 0.0.1
     */
    public String getLivelloCefr() {
        return livelloCefr;
    }

    /**
     * Permette di impostare
     * il livello CEFR dell'attestazione.
     *
     * @param aLivelloCefr nuovo livello cerf
     * @since 0.0.1
     */
    public void setLivelloCefr(final String aLivelloCefr) {
        this.livelloCefr = aLivelloCefr;
    }

    /**
     * Permette di rimpiazzare i campi di una domanda di lingua inglese.
     * @param aDomanda da cui prendere i campi
     * @since 0.1.1
     */
    @Override
    public void replace(final Domanda aDomanda) {
        super.replace(aDomanda);
        DomandaLinguaInglese aDomandaLinguaInglese =
                (DomandaLinguaInglese) aDomanda;
        livelloCefr = aDomandaLinguaInglese.getLivelloCefr();
        enteCertificatore = aDomandaLinguaInglese.getEnteCertificatore();
        grade = aDomandaLinguaInglese.getGrade();
    }
}
