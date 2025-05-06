package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter
public class InputFilter implements Filter {
	 public void init(FilterConfig filterConfig) {}

	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {

	        String gender = request.getParameter("gender1");
	        String city = request.getParameter("city1");

	        
	        if (!("male".equalsIgnoreCase(gender) || "female".equalsIgnoreCase(gender))) {
	            request.setAttribute("error", "Invalid gender selected.");
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	            return;
	        }

	        if (!(city != null && (city.equals("Rajasthan") || city.equals("Delhi")
	                || city.equals("Mumbai") || city.equals("Chennai")))) {
	            request.setAttribute("error", "Invalid city selected.");
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	            return;
	        }

	        chain.doFilter(request, response);
	    }

	    public void destroy() {}
}
