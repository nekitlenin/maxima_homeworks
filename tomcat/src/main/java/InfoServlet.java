import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project: tomcat
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 30.03.2023 00:55 |
 * Created with IntelliJ IDEA
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }
}
