/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Entities.Ingredient;
import Entities.Recipe;
import data.RecipeMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
@WebServlet(name = "UpdateRecipeServlet", urlPatterns = {"/UpdateRecipeServlet"})
public class UpdateRecipeServlet extends HttpServlet {

    
    //private static final Map<String, Recipe> recipes = new HashMap();
    private RecipeMapper Putter = new RecipeMapper();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("recname");
            String instruction = request.getParameter("description");
            String imageUrl = request.getParameter("imagelink");

            ArrayList<Ingredient> ingredients = new ArrayList();
            String ingredientString = request.getParameter("ingredients");
            String[] iList = ingredientString.split(";");
            for (String s : iList) {
                ingredients.add(new Ingredient(s));
            }

            Recipe newRecipe = new Recipe(name, ingredients, instruction, imageUrl);
            Putter.updateRecipe(newRecipe, id);
            //recipes.put(name, newRecipe);

                        String output = newRecipe.toString();
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Order Viewer:</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div align=\"center\">");
                out.println(output);
                out.println("<br><br>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
