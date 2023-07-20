

 package servletclass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class HomePage extends HttpServlet {
	     
    public HomePage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }

}
