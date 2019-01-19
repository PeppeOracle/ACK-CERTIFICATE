package it.unisa.ackc.servlet.gestione_utenti;

import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
import it.unisa.ackc.gestione_utenti.entity.Account;
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

public class AutenticazioneUtenteTest {
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
        values.put(AccountConvalida.EMAIL_PARAMETRO,
                new String[]{"v.santoro21@personale.unisa.it"}
        );
        values.put(AccountConvalida.PASSWORD_PARAMETRO,
                new String[]{"abc123"}
        );
        when(request.getParameterMap()).thenReturn(values);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ACKCStorageStub storage = new ACKCStorageStub();
        Account account = new Account();
        account.setEmail("v.santoro21@personale.unisa.it");
        account.setPassword("abc123");
        account.setRuolo(Account.Ruolo.STUDENTE);
        storage.setAccount(account);
        AutenticazioneUtente autenticazioneUtente = new AutenticazioneUtente();
        setField(autenticazioneUtente,
                autenticazioneUtente.getClass().getDeclaredField("ackStorage"),
                storage
        );
        autenticazioneUtente.doPost(request, response);
    }

    @Test
    public void test02() throws IOException, NoSuchFieldException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put(AccountConvalida.EMAIL_PARAMETRO,
                new String[]{"v.santoro21@personale.unisa.it"}
        );

        when(request.getParameterMap()).thenReturn(values);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ACKCStorageStub storage = new ACKCStorageStub();
        Account account = new Account();
        account.setEmail("v.santoro21@personale.unisa.it");
        account.setPassword("abc123");
        account.setRuolo(Account.Ruolo.STUDENTE);
        storage.setAccount(account);

        expect.expect(Error.class);
        expect.expectMessage("La password non è stata indicata");
        AutenticazioneUtente autenticazioneUtente = new AutenticazioneUtente();
        setField(autenticazioneUtente,
                autenticazioneUtente.getClass().getDeclaredField("ackStorage"),
                storage
        );
        autenticazioneUtente.doPost(request, response);
    }
}
