package it.unisa.ackc.test_suite;

import it.unisa.ackc.gestione_utenti.control.AutenticazioneUtenteTest;
import it.unisa.ackc.gestione_utenti.control.ModificaProfiloStudenteTest;
import it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficioTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ModificaProfiloStudenteTest.class,
        AutenticazioneUtenteTest.class,
        RegistrazioneAccountResponsabileUfficioTest.class
})
public class GestioneUtentiTestSuite {
}