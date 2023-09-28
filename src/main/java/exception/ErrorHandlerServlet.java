package exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/erroHandler")
public class ErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(
      HttpServletRequest req, 
      HttpServletResponse resp) throws IOException {
 
        resp.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><head><title>Error description</title></head><body>");
            writer.write("<h2>Error description</h2>");
            writer.write("<ul>");
//            Arrays.asList(
//              ERROR_STATUS_CODE, 
//              ERROR_EXCEPTION_TYPE, 
//              ERROR_MESSAGE)
//              .forEach(e ->
//                writer.write("<li>" + e + ":" + req.getAttribute(e) + " </li>")
//            );
            writer.write("</ul>");
            writer.write("</html></body>");
        }
    }
}
