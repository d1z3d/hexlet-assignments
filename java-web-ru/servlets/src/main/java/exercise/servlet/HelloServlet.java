package exercise.servlet;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var queryPath = Optional.ofNullable(req.getQueryString());
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        if (queryPath.isPresent()) {
            var queries = queryPath.get().split("&");
            for (var query : queries) {
                var data = query.split("=");
                var key = data[0];
                var value = data[1];
                if (key.equalsIgnoreCase("name")) {
                    resp.getWriter().write(String.format("Hello, %s!", value));
                } else {
                    resp.getWriter().write("Hello, Guest!");
                }
            }
        } else {
            resp.getWriter().write("Hello, Guest!");
        }
    }

    // END
}
