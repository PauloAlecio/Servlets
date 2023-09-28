package internationalization;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Languages Setting

@WebServlet("/DisplaySpanish")
public class DisplaySpanish extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Set spanish language code.
        response.setHeader("Content-Language", "es");

        String title = "En Espa&ntilde;ol";
        String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" +
            "<h1>" + "&iexcl;Hola Mundo!" + "</h1>\n" +
            "</body> </html>"
      );
    }
}
