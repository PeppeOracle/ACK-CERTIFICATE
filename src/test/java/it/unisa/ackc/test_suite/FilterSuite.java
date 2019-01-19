package it.unisa.ackc.test_suite;

import it.unisa.ackc.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountFilterTest.class,
        AmministratoreFilterTest.class,
        ConsumerFilterTest.class,
        ResponsabileUfficioFilterTest.class,
        StudenteFilterTest.class
})
public class FilterSuite {
}
