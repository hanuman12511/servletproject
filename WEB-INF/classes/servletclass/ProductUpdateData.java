package servletclass;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class ProductUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		System.out.println("In do post method of Add Image servlet.");
		Part file=request.getPart("image");
		String n= request.getParameter("name");
		String id= request.getParameter("id");
		int rate= Integer.parseInt(request.getParameter("rate"));
		System.out.print(n);
		String imageFileName=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+imageFileName);
		String path=request.getServletContext().getRealPath("images");
		System.out.print(path);
		String uploadPath=path+"/"+imageFileName;  // upload path where we have to upload our actual image
		System.out.println("Upload Path : "+uploadPath);
		
		// Uploading our selected image into the images folder
		
		try
		{
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		}
		
		catch(Exception e)
		{
			pw.print("62"+e);
		}
		
		Connection connection=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			PreparedStatement stmt;
			String query="update  product set name=?,rate=?,imagename=? where id =?;";
		
			stmt=connection.prepareStatement(query);
			stmt.setString(1,n);
			stmt.setInt(2,rate);
			stmt.setString(3,imageFileName);
			stmt.setString(4,id);
			
			int row=stmt.executeUpdate(); 
			if(row>0)
			
			{
				System.out.println("Image added into database successfully.");
				 request.setAttribute("message", "Image added into database successfully.");

	              // forwards to the message page
	          getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
			}
			
			else
			{
				System.out.println("Failed to upload image.");
                pw.print("Failed to upload image.");
			}
			
			
		}
		catch (Exception e)
		{
			pw.print("99"+e);

		}
		
	}

}