package it.unisa.ackc.servlet.gestione_pratiche;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CreazioneDomandaAttivitaLavorativaTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletOutputStream servletOutputStream;

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put("ente", new String[] {"Bethesda"});
        values.put("indirizzoSede", new String[] {"Rockville, Maryland, Stati Uniti"});
        values.put("profilo", new String[] {"Videogiochi"});
        values.put("tipoContratto", new String[] {"Programmatore"});
        values.put("periodo", new String[] {"01-09-2018/12-01-2019"});
        values.put("oreSvolte", new String[] {"100"});
        values.put("numeroCfu", new String[] {"9"});
        when(request.getParameterMap()).thenReturn(values);
        when(request.getSession()).thenReturn(session);
        it.unisa.ackc.gestione_utenti.entity.AccountStudente accountStudente
                = new it.unisa.ackc.gestione_utenti.entity.AccountStudente();
        accountStudente.setDataDiNascita(new Date());
        when(session.getAttribute("account")).thenReturn(accountStudente);
        when(request.getSession(any(Boolean.class))).thenReturn(session);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(response.getOutputStream()).thenReturn(servletOutputStream);

        new CreazioneDomandaAttivitaLavorativa().doGet(request, response);
    }

    @Test
    public void test02() throws IOException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put("indirizzoSede", new String[] {"Rockville, Maryland, Stati Uniti"});
        values.put("profilo", new String[] {"Videogiochi"});
        values.put("tipoContratto", new String[] {"Programmatore"});
        values.put("periodo", new String[] {"01-09-2018/12-01-2019"});
        values.put("oreSvolte", new String[] {"100"});
        values.put("numeroCfu", new String[] {"9"});
        when(request.getParameterMap()).thenReturn(values);
        when(request.getSession()).thenReturn(session);
        it.unisa.ackc.gestione_utenti.entity.AccountStudente accountStudente
                = new it.unisa.ackc.gestione_utenti.entity.AccountStudente();
        accountStudente.setDataDiNascita(new Date());
        when(session.getAttribute("account")).thenReturn(accountStudente);
        when(request.getSession(any(Boolean.class))).thenReturn(session);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(response.getOutputStream()).thenReturn(servletOutputStream);

        expect.expect(Error.class);
        expect.expectMessage("L'ente non è stato indicato");
        new CreazioneDomandaAttivitaLavorativa().doGet(request, response);
    }
}