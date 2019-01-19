package it.unisa.ackc.servlet.gestione_utenti;

import it.unisa.ackc.gestione_pratiche.entity.Pratica;
import it.unisa.ackc.gestione_utenti.control.convalida.AccountConvalida;
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

public class RegistrazioneAccountResponsabileUfficioTest {
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
        values.put(AccountConvalida.EMAIL_PARAMETRO, new String[]{"v.santoro21@unisa.it"});
        values.put(AccountConvalida.PASSWORD_PARAMETRO, new String[]{"ab123456"});
        values.put(AccountConvalida.TELEFONO_PARAMETRO, new String[]{"3451372297"});
        values.put(AccountConvalida.NOME_PARAMETRO, new String[]{"Mario"});
        values.put(AccountConvalida.COGNOME_PARAMETRO, new String[]{"Rossi"});
        values.put(AccountConvalida.SESSO_PARAMETRO, new String[]{"MASCHIO"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO,
                new String[]{"Fisciano"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.EDIFICIO_PARAMETRO,
                new String[]{"F"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO,
                new String[]{"33"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO,
                new String[]{"2"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.TIPOLOGIA_PRATICHE_PARAMETRO,
                new String[]{Pratica.Tipo.ATTIVITA_LAVORATIVA.name(), Pratica.Tipo.LINGUA_INGLESE.name()});
        when(request.getParameterMap()).thenReturn(values);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ACKCStorageStub storage = new ACKCStorageStub();
        RegistrazioneAccountResponsabileUfficio registrazioneAccount =
                new RegistrazioneAccountResponsabileUfficio();
        setField(registrazioneAccount,
                registrazioneAccount.getClass().getDeclaredField("ackStorage"),
                storage
        );
        registrazioneAccount.doPost(request, response);
    }

    @Test
    public void test02() throws IOException, NoSuchFieldException {
        HashMap<String, String[]> values = new HashMap<>();
        values.put(AccountConvalida.PASSWORD_PARAMETRO, new String[]{"Ab123456"});
        values.put(AccountConvalida.TELEFONO_PARAMETRO, new String[]{"3451372297"});
        values.put(AccountConvalida.NOME_PARAMETRO, new String[]{"Mario"});
        values.put(AccountConvalida.COGNOME_PARAMETRO, new String[]{"Rossi"});
        values.put(AccountConvalida.SESSO_PARAMETRO, new String[]{"MASCHIO"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.CAMPUS_PARAMETRO,
                new String[]{"Fisciano"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.EDIFICIO_PARAMETRO,
                new String[]{"F"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.NUMERO_STANZA_PARAMETRO,
                new String[]{"33"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.PIANO_PARAMETRO,
                new String[]{"2"});
        values.put(it.unisa.ackc.gestione_utenti.control.RegistrazioneAccountResponsabileUfficio.TIPOLOGIA_PRATICHE_PARAMETRO,
                new String[]{Pratica.Tipo.ATTIVITA_LAVORATIVA.name(), Pratica.Tipo.LINGUA_INGLESE.name()});
        when(request.getParameterMap()).thenReturn(values);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(any(Boolean.class))).thenReturn(session);
        when(request.getRequestDispatcher(any(String.class))).thenReturn(rd);

        ACKCStorageStub storage = new ACKCStorageStub();

        expect.expect(Error.class);
        expect.expectMessage("La mail non è stato indicato");
        RegistrazioneAccountResponsabileUfficio registrazioneAccount =
                new RegistrazioneAccountResponsabileUfficio();
        setField(registrazioneAccount,
                registrazioneAccount.getClass().getDeclaredField("ackStorage"),
                storage
        );
        registrazioneAccount.doPost(request, response);
    }
}
