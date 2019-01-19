package it.unisa.ackc.servlet.gestione_pratiche;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CreazioneDomandaLinguaIngleseTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletOutputStream servletOutputStream;

    private HashMap<String, String[]> values;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        values = new HashMap<>();
        values.put("ente", new String[] {"Bethesda"});
        values.put("grade", new String[] {"4"});
        values.put("numeroCfu", new String[] {"9"});
        values.put("enteCertificatore", new String[] {"Trinity"});
        values.put("cefr", new String[] {"A2.2"});
        when(request.getSession()).thenReturn(session);
        it.unisa.ackc.gestione_utenti.entity.AccountStudente accountStudente
                = new it.unisa.ackc.gestione_utenti.entity.AccountStudente();
        accountStudente.setTipologiaDiLaurea("Triennale");
        when(session.getAttribute("account")).thenReturn(accountStudente);
        when(request.getSession(any(Boolean.class))).thenReturn(session);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(response.getOutputStream()).thenReturn(servletOutputStream);
    }

    @Test
    public void test01() {
        when(request.getParameterMap()).thenReturn(values);
        new CreazioneDomandaLinguaInglese().doGet(request, response);
    }

    @Test(expected = Error.class)
    public void test02() {
        values.put("enteCertificatore", new String[] {});
        when(request.getParameterMap()).thenReturn(values);

        new CreazioneDomandaLinguaInglese().doGet(request, response);
    }
}
