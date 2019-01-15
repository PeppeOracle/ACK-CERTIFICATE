package it.unisa.ackc.http.stub;

import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Sessione;

public class SessioneStub implements Sessione {
    @Override
    public Object ottieni(String chiave) {
        if(chiave.equals("domanda")) {
            return new Domanda();
        }
        AccountStudente accountStudente = new AccountStudente();
        accountStudente.setTipologiaDiLaurea("Triennale");
        return accountStudente;
    }

    @Override
    public void aggiungi(String chiave, Object valore) {

    }

    @Override
    public void rimuovi(String chiave) {

    }
}
