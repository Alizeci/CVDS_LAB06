package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    urlPatterns = "/LJServlet"
)
public class Servlet extends HttpServlet{

    static final long serialVersionUID = 35L;
    private ArrayList<Todo> todoList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	Writer responseWriter = resp.getWriter();
    	resp.setContentType("text/html");
    	
    	String reqId = req.getParameter("id");
    	
    	try {
    		Integer idInt = (Integer.parseInt(reqId));
        	todoList.add(Service.getTodo(idInt)); //Consulta del item de la lista de cosas por hacer (todoList)
        	
	    	resp.setStatus(HttpServletResponse.SC_OK);
	    	responseWriter.write(Service.todosToHTMLTable(todoList));
	    	responseWriter.write("<br> <br/>");
	    	responseWriter.flush();
	    	
        } catch (FileNotFoundException e) {
        	resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        	responseWriter.write("<html>");
        	responseWriter.write("<body>");
        	responseWriter.write("<h1>NO EXISTE UN ITEM CON EL IDENTIFICADOR DADO</h1>");
        	responseWriter.write("</body></html>");
        	
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
        } catch (MalformedURLException e) {
        	resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	
        } catch (Exception e) {
        	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    	responseWriter.write("<b>HTTP STATUS CODE: "+ String.valueOf(resp.getStatus())+"</b>");
        
   }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	Writer responseWriter = resp.getWriter();
    	resp.setContentType("text/html");
    	
    	String reqId = req.getParameter("id");
    	
    	try {
    		Integer idInt = (Integer.parseInt(reqId));
        	todoList.add(Service.getTodo(idInt)); //Consulta del item de la lista de cosas por hacer (todoList)
        	
	    	resp.setStatus(HttpServletResponse.SC_OK);
	    	responseWriter.write(Service.todosToHTMLTable(todoList));
	    	responseWriter.write("<br> <br/>");
	    	responseWriter.flush();
	    	
        } catch (FileNotFoundException e) {
        	resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        	responseWriter.write("<html>");
        	responseWriter.write("<body>");
        	responseWriter.write("<h1>NO EXISTE UN ITEM CON EL IDENTIFICADOR DADO</h1>");
        	responseWriter.write("</body></html>");
        	
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
        } catch (MalformedURLException e) {
        	resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	
        } catch (Exception e) {
        	resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    	responseWriter.write("<b>HTTP STATUS CODE: "+ String.valueOf(resp.getStatus())+"</b>");
        
   }
    
}
