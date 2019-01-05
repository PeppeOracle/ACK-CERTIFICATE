package it.unisa.ackc_v2.servlet;

import it.unisa.ackc_v2.http.Risposta;

import javax.servlet.http.HttpServletResponse;

public class RispostaServlet extends Risposta {
    private HttpServletResponse risposta;

    public RispostaServlet(final HttpServletResponse risposta) {
        this.risposta = risposta;
    }

    @Override
    public void impostaTipoContenuto(final TIPO_CONTENUTO contenuto) {
        switch (contenuto) {
            case PDF:
                risposta.setContentType("application/pdf");
                break;
        }
    }

    @Override
    public void impostaHeader(final String chiave, final String valore) {
        risposta.setHeader(chiave, valore);
    }
}
