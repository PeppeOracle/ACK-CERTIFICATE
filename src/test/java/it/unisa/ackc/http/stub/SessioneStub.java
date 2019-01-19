package it.unisa.ackc.http.stub;

import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.http.Sessione;

import java.util.Date;

public class SessioneStub implements Sessione {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Object ottieni(String chiave) {
        if(chiave.equals("domanda")) {
            return new Domanda();
        }
        if(chiave.equals("attestato")) {
            return new Attestato();
        }
        return account;
    }

    @Override
    public void aggiungi(String chiave, Object valore) {

    }

    @Override
    public void rimuovi(String chiave) {

    }
}
