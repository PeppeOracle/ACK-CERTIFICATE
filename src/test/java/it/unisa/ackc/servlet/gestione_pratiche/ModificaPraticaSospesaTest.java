package it.unisa.ackc.servlet.gestione_pratiche;

import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.gestione_pratiche.entity.Attestato;
import it.unisa.ackc.gestione_pratiche.entity.Domanda;
import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.util.reflection.FieldSetter.setField;

public class ModificaPraticaSospesaTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletOutputStream servletOutputStream;
    @Mock
    private ServletContext servletContext;
    @Mock
    private Part domandaFile;
    @Mock
    private Part attestatoFile;
    @Mock
    private RequestDispatcher rd;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException, ServletException, NoSuchFieldException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put(GestionePratiche.PRATICA_PARAMETRO,
                new String[] {"1"});
        values.put("ente", new String[] {"Bethesda"});
        values.put(it.unisa.ackc.gestione_pratiche.control.CreazionePratica.MESSAGGIO_PARAMETRO,
                new String[] {"Attestato non riconosciuto"});
        values.put(it.unisa.ackc.gestione_pratiche.control.CreazionePratica.TIPO_PARAMETRO,
                new String[] { "LINGUA_INGLESE"});
        List<Part> parts = new ArrayList<>();
        when(domandaFile.getName()).thenReturn(
                it.unisa.ackc.gestione_pratiche.control.CreazionePratica.DOMANDA_PARAMETRO);
        when(domandaFile.getSubmittedFileName()).thenReturn("domanda.pdf");
        when(attestatoFile.getName()).thenReturn(
                it.unisa.ackc.gestione_pratiche.control.CreazionePratica.ATTESTATO_PARAMETRO);
        when(attestatoFile.getSubmittedFileName()).thenReturn("attestato.pdf");
        parts.add(domandaFile);
        parts.add(attestatoFile);
        when(request.getPart(it.unisa.ackc.gestione_pratiche.control.CreazionePratica.DOMANDA_PARAMETRO))
                .thenReturn(domandaFile);
        when(request.getPart(it.unisa.ackc.gestione_pratiche.control.CreazionePratica.ATTESTATO_PARAMETRO))
                .thenReturn(attestatoFile);
        when(request.getParts()).thenReturn(parts);
        when(request.getContentType()).thenReturn("multipart/form-data");
        when(request.getParameterMap()).thenReturn(values);
        when(request.getServletContext()).thenReturn(servletContext);
        it.unisa.ackc.gestione_utenti.entity.AccountStudente accountStudente
                = new it.unisa.ackc.gestione_utenti.entity.AccountStudente();
        when(session.getAttribute("account")).thenReturn(accountStudente);
        when(session.getAttribute("domanda")).thenReturn(new Domanda());
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(response.getOutputStream()).thenReturn(servletOutputStream);

        ModificaPraticaSospesa modificaPratica = new ModificaPraticaSospesa();
        ACKCStorageStub storage = new ACKCStorageStub();
        Pratica pratica = new Pratica();
        pratica.setStato(Pratica.Stato.SOSPESA);
        pratica.setDomanda(new Domanda());
        pratica.setAttestato(new Attestato());
        storage.setPratica(pratica);
        setField(modificaPratica,
                modificaPratica.getClass().getDeclaredField("ackStorage"),
                storage
        );
        modificaPratica.doGet(request, response);
    }
}
