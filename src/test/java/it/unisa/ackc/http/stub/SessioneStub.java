package it.unisa.ackc.http.stub;

import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Sessione;

import java.util.Date;

public class SessioneStub implements Sessione {
    @Override
    public Object ottieni(String chiave) {
        if(chiave.equals("domanda")) {
            return new Domanda();
        }
        if(chiave.equals("attestato")) {
            return new Attestato();
        }
        AccountStudente accountStudente = new AccountStudente();
        accountStudente.setTipologiaDiLaurea("Triennale");
        accountStudente.setDataDiNascita(new Date());
        return accountStudente;
    }

    @Override
    public void aggiungi(String chiave, Object valore) {

    }

    @Override
    public void rimuovi(String chiave) {

    }
}
