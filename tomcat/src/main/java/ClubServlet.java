import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Project: tomcat
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 30.03.2023 00:56 |
 * Created with IntelliJ IDEA
 */
@WebServlet("/club")
public class ClubServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            req.getRequestDispatcher("signUp.jsp").forward(req, resp);
            visitCounter = 1;
        } else {
            req.getRequestDispatcher("success.jsp").forward(req, resp);
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);
    }
}
