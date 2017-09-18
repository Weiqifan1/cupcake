package control;

import data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 4, 2017
 */
@WebServlet(name="Control", urlPatterns={"/Control"})
public class Control extends HttpServlet {
    UserMapper um = new UserMapper();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Control</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Control at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        //"<tr><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td></tr>";
        try (PrintWriter out = response.getWriter()) {
            try {
                String start = "<table><th>Username</th><th>Password</th>";
                String middle = um.getAllUsers().toString();
                        //.stream()
                        //.map(user->"<tr><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td></tr>")
                        //.reduce("", (x,y)->x+y);
                String end = "</table>";
                out.write(start+middle+end);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } 


    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
