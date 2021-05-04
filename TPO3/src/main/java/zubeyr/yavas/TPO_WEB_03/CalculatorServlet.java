package zubeyr.yavas.TPO_WEB_03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CalculatorServlet extends HttpServlet {

    // Routing

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printHeader(response);
        printForms(response);
        printResult(request, response);
        printFooter(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printHeader(response);
        printForms(response);
        printResult(request, response);
        printFooter(response);
    }

    // Printing

    private void printHeader(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>Calculator</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Calculator</h1>");
    }

    private void printForms(HttpServletResponse response) throws IOException {
        printForm(response, "get");
        printForm(response, "post");
    }

    private void printForm(HttpServletResponse response, String method) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<form acton=\"/\" method=\"" + method.toLowerCase() + "\">");
        out.println("<fieldset>");
        out.println("<legend>" + method.toUpperCase() + "</legend>");
        out.println("<input type=\"text\" name=\"x\" />");
        out.println(" + ");
        out.println("<input type=\"text\" name=\"y\" />");
        out.println(" = ");
        out.println("<input type=\"submit\" value=\"Submit using " + method.toUpperCase() + "\" />");
        out.println("</fieldset>");
        out.println("</form>");
    }

    private void printResult(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String xString = request.getParameter("x");
        String yString = request.getParameter("y");

        if (xString == null && yString == null) {
            return;
        }

        if (xString == null) {
            printError(response, "Please provide a valid first number.");
            return;
        }

        if (yString == null) {
            printError(response, "Please provide a valid second number.");
            return;
        }

        Integer xInt = null;
        Integer yInt = null;

        try {
            xInt = Integer.parseInt(xString);
        } catch (NumberFormatException e) {
            printError(response, "Please provide a valid first number.");
            return;
        }

        try {
            yInt = Integer.parseInt(yString);
        } catch (NumberFormatException e) {
            printError(response, "Please provide a valid second number.");
            return;
        }

        printSuccess(response, xInt + yInt);

    }

    private void printSuccess(HttpServletResponse response, int value) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<fieldset>");
        out.println("<legend class=\"success\">RESULT</legend>");
        out.println(value);
        out.println("</fieldset>");
    }

    private void printError(HttpServletResponse response, String value) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<fieldset>");
        out.println("<legend class=\"error\">ERROR</legend>");
        out.println(value);
        out.println("</fieldset>");
    }

    private void printFooter(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("</body>");
        out.println("</html>");
    }

}
