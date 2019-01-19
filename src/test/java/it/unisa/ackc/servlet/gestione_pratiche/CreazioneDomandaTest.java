package it.unisa.ackc.servlet.gestione_pratiche;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CreazioneDomandaTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher rd;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put(it.unisa.ackc.gestione_pratiche.control
                .CreazioneDomanda.TIPO_DI_DOMANDA_PARAMETRO,
                new String[] {"attivitaLavorativa"}
         );
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);
        when(request.getParameterMap()).thenReturn(values);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new CreazioneDomanda().doGet(request, response);
    }
}
