package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet
{

    public void doGet (
        HttpServletRequest request,
        HttpServletResponse response
    )
        throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // New location to be redirected
        String site = new String("http://www.photofuntoos.com");

        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader(
            "Location",
            site
        );
    }
}
