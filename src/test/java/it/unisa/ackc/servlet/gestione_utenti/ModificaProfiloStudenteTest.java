package it.unisa.ackc.servlet.gestione_utenti;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountStudente;
import it.unisa.ackc.http.stub.ACKCStorageStub;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.util.reflection.FieldSetter.setField;

public class ModificaProfiloStudenteTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher rd;

    @Rule
    public ExpectedException expect = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException, NoSuchFieldException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put(AccountConvalida.PASSWORD_PARAMETRO, new String[]{"Ab123456"});
        values.put(AccountConvalida.TELEFONO_PARAMETRO, new String[]{"3451372297"});
        values.put(AccountConvalida.NOME_PARAMETRO, new String[]{"Mario"});
        values.put(AccountConvalida.COGNOME_PARAMETRO, new String[]{"Rossi"});
        values.put(AccountConvalida.SESSO_PARAMETRO, new String[]{"MASCHIO"});
        values.put(AccountStudente.LUOGO_DI_NASCITA_PARAMETRO, new String[]{"Roma"});
        values.put(AccountStudente.NUMERO_CIVICO_PARAMETRO, new String[]{"2"});
        values.put(AccountStudente.ANNO_DI_IMMATRICOLAZIONE_PARAMETRO, new String[]{"2011"});
        values.put(AccountStudente.CAP_PARAMETRO, new String[]{"22122"});
        values.put(AccountStudente.MATRICOLA_PARAMETRO, new String[]{"2678612345"});
        values.put(AccountStudente.CITTA_PARAMETRO, new String[]{"Salerno"});
        values.put(AccountStudente.PAESE_PARAMETRO, new String[]{"Italia"});
        values.put(AccountStudente.TIPOLOGIA_DI_LAUREA_PARAMETRO, new String[]{"Triennale"});
        values.put(AccountStudente.CORSO_DI_LAUREA_PARAMETRO, new String[]{"Informatica"});
        values.put(AccountStudente.DATA_DI_NASCITA_PARAMETRO, new String[]{"22/11/1998"});

        when(request.getParameterMap()).thenReturn(values);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ACKCStorageStub storage = new ACKCStorageStub();

        expect.expect(Error.class);
        expect.expectMessage("Il formato della data di nascita non è stato rispettato");
        ModificaProfiloStudente modificaProfiloStudente =
                new ModificaProfiloStudente();
        setField(modificaProfiloStudente,
                modificaProfiloStudente.getClass().getDeclaredField("ackStorage"),
                storage
        );
        modificaProfiloStudente.doPost(request, response);
    }
}
