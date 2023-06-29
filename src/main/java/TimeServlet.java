import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time/*")
public class TimeServlet extends HttpServlet {

     @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws IOException {
         String timezone = req.getParameter("timezone");

         ZoneId zoneId;
         if (timezone == null) {
             zoneId = ZoneId.of("UTC");
         } else {
             timezone = timezone.replace(" ", "+");
             zoneId = ZoneId.of(timezone);
         }
         ZonedDateTime now = ZonedDateTime.now(zoneId);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
         String formattedTime = now.format(formatter);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(formattedTime);
        resp.getWriter().close();
    }


}
