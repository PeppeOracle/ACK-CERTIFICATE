package it.unisa.ackc.gestione_pratiche.entity;

/**
 * Rappresenta la specifica di un attestazione di un'attività lavorativa.
 * Fa parte della pratica {@see it.unisa.ackc.gestione_pratiche.entity.Pratica}
 *
 * @version 0.1.1
 */
public class DomandaAttivitaLavorativa extends Domanda {
    /**
     * Ente certificatore dell'attività lavorativa.
     */
    private String ente;
    /**
     * Indirizzo della sede dell'ente.
     */
    private String indirizzoSede;
    /**
     * Profilo lavorativo dello studente.
     */
    private String profilo;
    /**
     * Tipo di contratto lavorativo dello studente.
     */
    private String tipoDiContratto;
    /**
     * Periodo lavorativo.
     */
    private String periodo;
    /**
     * Numero di ore lavorative svolte.
     */
    private int oreSvolte;

    /**
     * Permette di istanziare
     * un oggetto di tipo <code>DomandaAttivitaLavorativa</code>.
     *
     * @param aPath percorso del file
     * @param aNumeroCfu numero di CFU di cui si richiede il riconoscimento
     * @param aEnte ente presso il quale si è svolta l'attività lavorativa
     * @param aIndirizzoSede indirizzo della sede dell'ente
     * @param aProfilo prfilo inerente all'attività lavorativa svolta
     * @param aTipoDiContratto tipologia di contratto
     * @param aPeriodo periodo in cui si è svolta l'attività lavorativa
     * @param aOreSvolte numero di ore svolte
     * @since 0.0.1
     */
    public DomandaAttivitaLavorativa(
            final String aPath,
            final int aNumeroCfu,
            final String aEnte,
            final String aIndirizzoSede,
            final String aProfilo,
            final String aTipoDiContratto,
            final String aPeriodo,
            final int aOreSvolte) {
        super(aPath,
                aNumeroCfu);
        this.ente = aEnte;
        this.indirizzoSede = aIndirizzoSede;
        this.profilo = aProfilo;
        this.tipoDiContratto = aTipoDiContratto;
        this.periodo = aPeriodo;
        this.oreSvolte = aOreSvolte;
    }

    /**
     * Costruttore di default.
     */
    public DomandaAttivitaLavorativa() {
    }

    /**
     * Restituisce
     * l'ente presso il quale si è svolta l'attività lavorativa.
     *
     * @return ente
     * @since 0.0.1
     */
    public String getEnte() {
        return ente;
    }

    /**
     * Permette di impostare
     * l'ente presso il quale si è svolta l'attività lavorativa.
     *
     * @param aEnte nuovo ente
     * @since 0.0.1
     */
    public void setEnte(final String aEnte) {
        this.ente = aEnte;
    }

    /**
     * Restituisce
     * l'indirizzo della sede dove si è svolta l'attività lavorativa.
     *
     * @return indirizzoSede
     * @since 0.0.1
     */
    public String getIndirizzoSede() {
        return indirizzoSede;
    }

    /**
     * Permette di impostare
     * l'indirizzo della sede dove si è svolta l'attività lavorativa.
     *
     * @param aIndirizzoSede nuovo indirizzo della sede
     * @since 0.0.1
     */
    public void setIndirizzoSede(final String aIndirizzoSede) {
        this.indirizzoSede = aIndirizzoSede;
    }

    /**
     * Restituisce
     * il profilo lavorativo inerente all'attività lavorativa.
     *
     * @return aProfilo
     * @since 0.0.1
     */
    public String getProfilo() {
        return profilo;
    }

    /**
     * Permette di impostare
     * il profilo lavorativo inerente all'attività lavorativa.
     *
     * @param aProfilo nuovo profilo
     * @since 0.0.1
     */
    public void setProfilo(final String aProfilo) {
        this.profilo = aProfilo;
    }

    /**
     * Restituisce
     * il tipo di contratto lavorativo.
     *
     * @return tipoDiContratto
     * @since 0.0.1
     */
    public String getTipoDiContratto() {
        return tipoDiContratto;
    }

    /**
     * Permette di impostare
     * il tipo di contratto lavorativo.
     *
     * @param aTipoDiContratto nuovo tipo di contratto
     * @since 0.0.1
     */
    public void setTipoDiContratto(final String aTipoDiContratto) {
        this.tipoDiContratto = aTipoDiContratto;
    }

    /**
     * Restituisce
     * il periodo lavorativo.
     *
     * @return periodo
     * @since 0.0.1
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Permette di impostare
     * il periodo lavorativo.
     *
     * @param aPeriodo nuovo periodo
     * @since 0.0.1
     */
    public void setPeriodo(final String aPeriodo) {
        this.periodo = aPeriodo;
    }

    /**
     * Restituisce
     * le ore lavorative svolte durante all'attività lavorativa.
     *
     * @return oreSvolte
     * @since 0.0.1
     */
    public int getOreSvolte() {
        return oreSvolte;
    }

    /**
     * Permette di impostare
     * le ore lavorative svolte durante all'attività lavorativa.
     *
     * @param aOreSvolte nuove ore svolte
     * @since 0.0.1
     */
    public void setOreSvolte(final int aOreSvolte) {
        this.oreSvolte = aOreSvolte;
    }

    /**
     * Permette di rimpiazzare i campi di una domanda di lingua inglese.
     * @param aDomanda da cui prendere i campi
     * @since 0.1.1
     */
    @Override
    public void replace(final Domanda aDomanda) {
        super.replace(aDomanda);
        DomandaAttivitaLavorativa aDomandaAttivitaLavorativa =
                (DomandaAttivitaLavorativa) aDomanda;
        ente = aDomandaAttivitaLavorativa.getEnte();
        indirizzoSede = aDomandaAttivitaLavorativa.getIndirizzoSede();
        periodo = aDomandaAttivitaLavorativa.getPeriodo();
        profilo = aDomandaAttivitaLavorativa.getProfilo();
        tipoDiContratto = aDomandaAttivitaLavorativa.getTipoDiContratto();
        oreSvolte = aDomandaAttivitaLavorativa.getOreSvolte();
    }
}
