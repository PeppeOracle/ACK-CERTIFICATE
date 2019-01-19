package it.unisa.ackc.servlet.gestione_pratiche;

import it.unisa.ackc.gestione_pratiche.control.convalida.GestionePratiche;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

public class MostraPraticaTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher rd;

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException, ServletException, NoSuchFieldException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);
        MostraPratica mostraPratica = new MostraPratica();
        HashMap<String, String[]> values = new HashMap<>();
        values.put(
                GestionePratiche.PRATICA_PARAMETRO, new String[]{"1"});
        values.put(
                it.unisa.ackc.gestione_pratiche.control.MostraPratica.TIPO_PARAMETRO,
                new String[]{
                        "" + it.unisa.ackc.gestione_pratiche.control.MostraPratica.PRATICA_RESPONSABILE_UFFICIO
                });

        when(request.getParameterMap()).thenReturn(values);
        setField(mostraPratica,
                mostraPratica.getClass().getDeclaredField("ackStorage"),
                new ACKCStorageStub()
        );
        mostraPratica.doGet(request, response);
    }

    @Test
    public void test02() throws IOException, ServletException, NoSuchFieldException {

        expect.expect(Error.class);
        expect.expectMessage("Il tipo di visualizzazione deve essere un numero");

        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);
        MostraPratica mostraPratica = new MostraPratica();
        HashMap<String, String[]> values = new HashMap<>();

        when(request.getParameterMap()).thenReturn(values);
        setField(mostraPratica,
                mostraPratica.getClass().getDeclaredField("ackStorage"),
                new ACKCStorageStub()
        );
        mostraPratica.doGet(request, response);


    }
}
