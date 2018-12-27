package it.unisa.ackc.gestione_pratiche.entity;

/**
 * Rappresenta la specifica di un'attestazione di lingua inglese.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.0.1
 * @since 0.0.1
 */
public class DomandaLinguaInglese extends Domanda {
    private String enteCertificatore;
    private String grade;
    private String livelloCefr;

    /**
     * Permette di istanziare un oggetto di tipo <code>DomandaLinguaInglese</code>
     *
     * @since 0.0.1
     */
    public DomandaLinguaInglese() {
        super();
    }

    /**
     * Permette di istanziare un oggetto di tipo <code>DomandaLinguaInglese</code>
     *
     * @param path              percorso del file
     * @param numeroCfu         numero di CFU di cui si richiede il riconoscimento
     * @param enteCertificatore ente che ha rilasciato la certificazione
     * @param grade             livello GRADE dell'attestazione
     * @param livelloCefr       livello CEFR dell'attestazione
     * @since 0.0.1
     */
    public DomandaLinguaInglese(String path, int numeroCfu, String enteCertificatore, String grade, String livelloCefr) {
        super(path, numeroCfu);
        this.enteCertificatore = enteCertificatore;
        this.grade = grade;
        this.livelloCefr = livelloCefr;
    }

    /**
     * Restituisce l'ente che ha rilasciato la certificazione
     *
     * @return enteCertificatore
     * @since 0.0.1
     */
    public String getEnteCertificatore() {
        return enteCertificatore;
    }

    /**
     * Permette di impostare l'ente che ha rilasciato la certificazione
     *
     * @param enteCertificatore
     * @since 0.0.1
     */
    public void setEnteCertificatore(String enteCertificatore) {
        this.enteCertificatore = enteCertificatore;
    }

    /**
     * Restituisce il livello GRADE dell'attestazione
     *
     * @return grade
     * @since 0.0.1
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Permette di impostare il livello GRADE dell'attestazione
     *
     * @param grade
     * @since 0.0.1
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Permette di impostare il livello CEFR dell'attestazione
     *
     * @return livelloCefr
     * @since 0.0.1
     */
    public String getLivelloCefr() {
        return livelloCefr;
    }

    /**
     * Permette di impostare il livello CEFR dell'attestazione
     *
     * @param livelloCefr
     * @since 0.0.1
     */
    public void setLivelloCefr(String livelloCefr) {
        this.livelloCefr = livelloCefr;
    }
}
