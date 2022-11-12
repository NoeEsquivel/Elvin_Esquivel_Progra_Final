/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import Clases.Computadora;
import Clases.ComputadoraController;
import Clases.ConexionBaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/NewServlet1"})
public class NewServlet1 extends HttpServlet {
    Computadora computadora;
    ComputadoraController registroComputadora;
     Computadora[] computadoraRegistrados;
     StringBuffer objetoRespuesta = new StringBuffer();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try ( PrintWriter respuesta = response.getWriter()) {            
           
           registroComputadora=new ComputadoraController();
           String control = request.getParameter("control");
           
           if(control.toUpperCase().equals("GUARDAR")){
               computadora=new Computadora(
                Integer.parseInt(request.getParameter("marca_codigo")),
                request.getParameter("modelo"),
                request.getParameter("tamaño_pantalla"),        
                request.getParameter("cantidad_ram"),
                request.getParameter("almacenamiento"),
                request.getParameter("sistema_operativo"),
                request.getParameter("grado"),
                request.getParameter("nivel"),
                request.getParameter("fecha"),
                Integer.parseInt(request.getParameter("telefono")));                
                registroComputadora.guardarAlumno2(computadora);//almacenarlo en BD                 
       
           }
                        
            
            //registroAlumno.guardarAlumno(computadora);//almacenarlo en el array
            //alumnosRegistrados= registroComputadora.getAlumnos();// consultar alumnos en el array                       
                    
       
            
          
           
           
           
           
            
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
