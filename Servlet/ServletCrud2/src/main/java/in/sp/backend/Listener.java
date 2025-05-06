package in.sp.backend;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class Listener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String method = req.getMethod();
        String uri = req.getRequestURI();

        if (uri.contains("/create") && method.equals("POST")) {
            System.out.println("Create operation detected");
        } else if (uri.contains("/read") && method.equals("GET")) {
            System.out.println("Read operation detected");
        } else if (uri.contains("/update") && method.equals("POST")) {
            System.out.println("Update operation detected");
        } else if (uri.contains("/delete") && method.equals("DELETE")) {
            System.out.println("Delete operation detected");
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        
    }
}
