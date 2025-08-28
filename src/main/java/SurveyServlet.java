// SurveyServlet.java
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url = "/index.html"; // default redirect page

        // Get action parameter (hidden input in form)
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }

        if (action.equals("join")) {
            // User just wants to see the form
            url = "/index.html";
        } 
        else if (action.equals("add")) {
            // Get all form parameters
            String firstName = request.getParameter("firstName");
            String lastName  = request.getParameter("lastName");
            String email     = request.getParameter("email");
            String dobStr    = request.getParameter("dob");
            String heardFrom = request.getParameter("heardFrom");
            String wantsUpdates = request.getParameter("wantsUpdates"); // checkbox
            String emailOK      = request.getParameter("emailOK");      // checkbox
            String contactVia   = request.getParameter("contactVia");

            // Safety check: required fields
            if (firstName == null || firstName.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() ||
                email == null || email.trim().isEmpty()) {
                // Missing required fields → redirect to index
                response.sendRedirect(request.getContextPath() + "/index.html");
                return;
            }

            // Parse Date of Birth
            Date dob = null;
            if (dobStr != null && !dobStr.isEmpty()) {
                try {
                    dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Populate User object
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setDob(dob);
            user.setHeardFrom(heardFrom);
            user.setWantsUpdates(wantsUpdates != null ? "Yes" : "No");
            user.setEmailOK(emailOK != null ? "Yes" : "No");
            user.setContactVia(contactVia);

            // Save User in request and set URL to thanks.jsp
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        // Forward request to the appropriate page
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        // If user directly visits /survey → doPost
        doPost(request,response);
    }
}
