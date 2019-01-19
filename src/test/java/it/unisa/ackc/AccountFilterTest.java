package it.unisa.ackc;

import it.unisa.ackc.gestione_utenti.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountFilterTest {
    @Mock
    private FilterChain chain;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01() throws IOException, ServletException {
        AccountFilter filter = new AccountFilter();

        filter.doFilter(request, response, chain);
        verify(response).sendRedirect(request.getContextPath() +AccountFilter.LOGIN_JSP);
    }

    @Test
    public void test02() throws IOException, ServletException {
        AccountFilter filter = new AccountFilter();

        when(session.getAttribute("account")).thenReturn(new Account());
        when(request.getSession(any(Boolean.TYPE))).thenReturn(session);
        filter.doFilter(request, response, chain);
        verify(response, never()).sendRedirect(request.getContextPath() + AccountFilter.LOGIN_JSP);
    }
}
