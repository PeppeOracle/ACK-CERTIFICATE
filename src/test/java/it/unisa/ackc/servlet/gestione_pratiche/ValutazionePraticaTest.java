package it.unisa.ackc.servlet.gestione_pratiche;

import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.util.reflection.FieldSetter.setField;

public class ValutazionePraticaTest {
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
    public void test01() throws IOException, ServletException, NoSuchFieldException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ValutazionePratica valutazionePratica = new ValutazionePratica();
        HashMap<String, String[]> values = new HashMap<>();

        values.put(
                it.unisa.ackc.gestione_pratiche.control.ValutazionePratica.STATO_PARAMETRO, new String[]{Pratica.Stato.APPROVATA.name()});
        values.put(
                it.unisa.ackc.gestione_pratiche.control.ValutazionePratica.MESSAGGIO_PARAMETRO, new String[] {"Complimenti!"});
        values.put(
                GestionePratiche.PRATICA_PARAMETRO, new String[] {"1"});


        when(request.getParameterMap()).thenReturn(values);

        ACKCStorageStub storage = new ACKCStorageStub();
        storage.setPratica(new Pratica());

        setField(valutazionePratica,
                valutazionePratica.getClass().getDeclaredField("ackStorage"),
                storage
        );

        valutazionePratica.doGet(request, response);
    }
}
