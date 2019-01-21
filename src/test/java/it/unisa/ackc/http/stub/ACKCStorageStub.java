package it.unisa.ackc.http.stub;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.entity.Account;
import it.unisa.ackc.gestione_utenti.entity.AccountResponsabileUfficio;
import it.unisa.ackc.gestione_utenti.entity.AccountStudente;
import it.unisa.ackc.storage.ACKStorageFacade;

import java.util.List;

public class ACKCStorageStub implements ACKStorageFacade {
    private Pratica pratica;
    private Account account;

    public void setPratica(Pratica pratica) {
        this.pratica = pratica;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Pratica updatePratica(Pratica aPratica) {
        return null;
    }

    @Override
    public Pratica findPraticaById(Long aId) {
        return pratica;
    }

    @Override
    public List<Pratica> findAllPraticheForResponsabileUfficio(AccountResponsabileUfficio aAccount, int aLimit, int aOffset) {
        return null;
    }

    @Override
    public Long countAllPraticheForResponsabileUfficio(AccountResponsabileUfficio aAccount) {
        return null;
    }

    @Override
    public List<Pratica> findPraticheSospeseForResponsabileUfficio(AccountResponsabileUfficio aAccount, int aLimit, int aOffset) {
        return null;
    }

    @Override
    public Long countPraticheSospeseForResponsabileUfficio(AccountResponsabileUfficio aAccount) {
        return null;
    }

    @Override
    public List<Pratica> findPraticheDaValutareForResponsabileUfficio(AccountResponsabileUfficio aAccount, int aLimit, int aOffset) {
        return null;
    }

    @Override
    public Long countPraticheDaValutareForResponsabileUfficio(AccountResponsabileUfficio aAccount) {
        return null;
    }

    @Override
    public List<Pratica> findPraticheChiuseForResponsabileUfficio(AccountResponsabileUfficio aAccount, int aLimit, int aOffset) {
        return null;
    }

    @Override
    public Long countPraticheChiuseForResponsabileUfficio(AccountResponsabileUfficio aAccount) {
        return null;
    }

    @Override
    public List<Pratica> findAllPraticheForStudente(AccountStudente aAccount, int aLimit, int aOffset) {
        return null;
    }

    @Override
    public Long countAllPraticheForStudente(AccountStudente aAccount) {
        return null;
    }

    @Override
    public List<Pratica> findPraticheAttivitaLavorativa() {
        return null;
    }

    @Override
    public List<Pratica> findPraticheLinguaInglese() {
        return null;
    }

    @Override
    public boolean containsAccount(String aEmail) {
        return false;
    }

    @Override
    public Account findAccountByEmail(String aEmail) {
        return account;
    }

    @Override
    public Account findAccountById(Long id) {
        return account;
    }

    @Override
    public boolean containsAdminAccount() {
        return false;
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return this.account;
    }

    @Override
    public void deleteAccount(Account account) {

    }
}
