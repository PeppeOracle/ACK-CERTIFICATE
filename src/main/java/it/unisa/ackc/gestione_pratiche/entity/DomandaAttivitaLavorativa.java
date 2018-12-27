package it.unisa.ackc.gestione_pratiche.entity;

/**
 * Rappresenta la specifica di un attestazione di un'attività lavorativa.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.0.1
 */
public class DomandaAttivitaLavorativa extends Domanda {
    private String ente;
    private String indirizzoSede;
    private String profilo;
    private String tipoDiContratto;
    private String periodo;
    private int oreSvolte;

    /**
     * Permette di istanziare un oggetto di tipo <code>DomandaAttivitaLavorativa</code>
     *
     * @since 0.0.1
     */
    public DomandaAttivitaLavorativa() {
        super();
    }

    /**
     * Permette di istanziare un oggetto di tipo <code>DomandaAttivitaLavorativa</code>
     *
     * @param path            percorso del file
     * @param numeroCfu       numero di CFU di cui si richiede il riconoscimento
     * @param ente            ente presso il quale si è svolta l'attività lavorativa
     * @param indirizzoSede   indirizzo della sede dell'ente
     * @param profilo         prfilo inerente all'attività lavorativa svolta
     * @param tipoDiContratto tipologia di contratto
     * @param periodo         periodo in cui si è svolta l'attività lavorativa
     * @param oreSvolte       numero di ore svolte
     * @since 0.0.1
     */
    public DomandaAttivitaLavorativa(String path, int numeroCfu, String ente, String indirizzoSede, String profilo, String tipoDiContratto, String periodo, int oreSvolte) {
        super(path, numeroCfu);
        this.ente = ente;
        this.indirizzoSede = indirizzoSede;
        this.profilo = profilo;
        this.tipoDiContratto = tipoDiContratto;
        this.periodo = periodo;
        this.oreSvolte = oreSvolte;
    }

    /**
     * Restituisce l'ente presso il quale si è svolta l'attività lavorativa
     *
     * @return ente
     * @since 0.0.1
     */
    public String getEnte() {
        return ente;
    }

    /**
     * Permette di impostare l'ente presso il quale si è svolta l'attività lavorativa
     *
     * @param ente
     * @since 0.0.1
     */
    public void setEnte(String ente) {
        this.ente = ente;
    }

    /**
     * Restituisce l'indirizzo della sede presso la quale si è svolta l'attività lavorativa
     *
     * @return indirizzoSede
     * @since 0.0.1
     */
    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    /**
     * Permette di impostare l'indirizzo della sede presso la quale si è svolta l'attività lavorativa
     *
     * @param indirizzoSede
     * @since 0.0.1
     */
    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }

    /**
     * Restituisce il profilo lavorativo inerente all'attività lavorativa
     *
     * @return profilo
     * @since 0.0.1
     */
    public String getProfilo() {
        return profilo;
    }

    /**
     * Permette di impostare il profilo lavorativo inerente all'attività lavorativa
     *
     * @param profilo
     * @since 0.0.1
     */
    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }

    /**
     * Restituisce il tipo di contratto lavorativo
     *
     * @return tipoDiContratto
     * @since 0.0.1
     */
    public String getTipoDiContratto() {
        return tipoDiContratto;
    }

    /**
     * Permette di impostare il tipo di contratto lavorativo
     *
     * @param tipoDiContratto
     * @since 0.0.1
     */
    public void setTipoDiContratto(String tipoDiContratto) {
        this.tipoDiContratto = tipoDiContratto;
    }

    /**
     * Restituisce il periodo lavorativo
     *
     * @return periodo
     * @since 0.0.1
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Permette di impostare il periodo lavorativo
     *
     * @param periodo
     * @since 0.0.1
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * Restituisce le ore lavorative svolte durante all'attività lavorativa
     *
     * @return oreSvolte
     * @since 0.0.1
     */
    public int getOreSvolte() {
        return oreSvolte;
    }

    /**
     * Permette di impostare le ore lavorative svolte durante all'attività lavorativa
     *
     * @param oreSvolte
     * @since 0.0.1
     */
    public void setOreSvolte(int oreSvolte) {
        this.oreSvolte = oreSvolte;
    }
}
