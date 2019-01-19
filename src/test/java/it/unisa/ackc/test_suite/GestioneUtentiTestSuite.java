package it.unisa.ackc.test_suite;

import it.unisa.ackc.gestione_utenti.control.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ModificaProfiloStudenteTest.class,
        AutenticazioneUtenteTest.class,
        RegistrazioneAccountResponsabileUfficioTest.class,
        RegistrazioneAccountStudenteTest.class
})
public class GestioneUtentiTestSuite {
}