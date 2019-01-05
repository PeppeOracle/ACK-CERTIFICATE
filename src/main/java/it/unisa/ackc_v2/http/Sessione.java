package it.unisa.ackc_v2.http;

public interface Sessione {
    public Object ottieni(String chiave);
    public void aggiungi(String chiave, Object valore);
}
