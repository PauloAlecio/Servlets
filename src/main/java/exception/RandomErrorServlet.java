package exception;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/randomError")
public class RandomErrorServlet extends HttpServlet {

    @Override
    protected void doGet(
      HttpServletRequest req, 
      HttpServletResponse resp) {
        throw new IllegalStateException("Random error");
    }
}
