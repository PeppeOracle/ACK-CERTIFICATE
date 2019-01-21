package it.unisa.ackc.servlet;

import it.unisa.ackc.http.Risposta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Implementazione della risposta per le servlet.
 */
public class RispostaServlet extends Risposta {
    /**
     * Risposta della servlet.
     */
    private HttpServletResponse risposta;
    /**
     * Richiesta della servlet.
     */
    private HttpServletRequest richiesta;

    /**
     * Permette di instanziare un oggetto di tipo <code>RispostaServlet</code>.
     *
     * @param aRichiesta della servlet
     * @param aRisposta della servlet
     */
    public RispostaServlet(final HttpServletRequest aRichiesta,
                           final HttpServletResponse aRisposta) {
        this.risposta = aRisposta;
        this.richiesta = aRichiesta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void impostaTipoContenuto(final TipoDiContenuto contenuto) {
        switch (contenuto) {
            case PDF:
                risposta.setContentType("application/pdf");
                break;
            default:
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void impostaHeader(final String chiave, final String valore) {
        risposta.setHeader(chiave, valore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aggiungiAttributo(final String chiave, final Object valore) {
        richiesta.setAttribute(chiave, valore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redirect(final String url) {
        try {
            risposta.sendRedirect(url);
        } catch (IOException e) {
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void inoltra(final String url) {
        try {
            richiesta.getRequestDispatcher(url).forward(richiesta, risposta);
        } catch (ServletException | IOException e) {
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void scriviFile(final String file, final String path) {
        Part part = null;
        try {
            part = richiesta.getPart(file);
            if (part != null) {
                part.write(path);
            } else {
                throw new IllegalArgumentException("File non inviato");
            }
        } catch (ServletException | IOException e) {
            // ignora
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String ottieniUploadPath(final String path) {
        String rPath = richiesta.getServletContext().getRealPath(path);
        File dir = new File(rPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return rPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getOutput() {
        try {
            return risposta.getOutputStream();
        } catch (IOException e) {
            return null;
        }
    }
}
