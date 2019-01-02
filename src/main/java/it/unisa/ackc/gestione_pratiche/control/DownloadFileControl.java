package it.unisa.ackc.gestione_pratiche.control;

import it.unisa.ackc.HttpServletWithCheck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Permette il download di un file.
 *
 * @version 0.1.1
 */
public class DownloadFileControl  extends HttpServletWithCheck {
    /**
     * Macro del parametro file_name.
     */
    static final String FILE_PARAMETRO = "file_name";
    /**
     * Macro del parametro files-studenti.
     */
    static final String STUDENTI_PATH = "files-studenti";
    /**
     * Macro della size del buffer.
     */
    static final int BUFFER_SIZE = 4096;

    /**
     * Si occupa del download di un file.
     *
     * @since 0.0.1
     */
    @Override
    public void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) throws IOException {
        valida(request);
        String fileName = request.getParameter(FILE_PARAMETRO);

        String fileExt = ".pdf";
        response.setContentType("application/pdf");
        response.setHeader(
                "Content-disposition",
                "attachment; filename=" + fileName + fileExt
        );
        File file = new File(getServletContext().getRealPath("")
                + File.separator
                + STUDENTI_PATH + fileExt
        );
        if (file.exists()) {
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        } else {
            throw new IllegalArgumentException("Il file indicato non esiste");
        }
    }
    /**
     * Valida i parametri della richiesta.
     * @param request contenente i parametri da validare
     * @since 0.0.1
     */
    @Override
    public void valida(final HttpServletRequest request) {
        addCondizione(
                DownloadFileConvalida.VALIDA_FILE
        );
        super.valida(request);
    }
}
