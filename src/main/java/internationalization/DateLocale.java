package internationalization;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//Locale Specific Dates

@WebServlet("/DateLocale")
public class DateLocale extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Get the client's Locale
        Locale locale = request.getLocale( );
        String date = DateFormat.getDateTimeInstance(DateFormat.FULL,
            DateFormat.SHORT, locale).format(new Date( ));

        String title = "Locale Specific Dates";
        String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<h1 align = \"center\">" + date + "</h1>\n" +
            "</body> </html>"
      );
    }
}
