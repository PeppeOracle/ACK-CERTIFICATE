package it.unisa.ackc.test_suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GestionePraticheTestSuite.class,
        GestioneUtentiTestSuite.class,
        ServletSuite.class,
        FilterSuite.class
})
public class AllTest {
}
