package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/claims")
public class ClaimsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Claims</h1>");

        // Extract claims from the request
        Map<String, Object> claims = (Map<String, Object>) req.getAttribute("org.keycloak.json");

        if (claims != null) {
            for (Map.Entry<String, Object> claim : claims.entrySet()) {
                resp.getWriter().println("<p>" + claim.getKey() + ": " + claim.getValue() + "</p>");
            }
        } else {
            resp.getWriter().println("<p>No claims found</p>");
        }
    }
}
