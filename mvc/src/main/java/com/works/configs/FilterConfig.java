
package com.works.configs;


import com.works.entities.Customer;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig implements Filter{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        
        String url = req.getRequestURI();
        String[] freeUrls = {"/", "/login", "/productSave"};
        boolean loginStatus = true;
        for(String item : freeUrls) {
            if(item.equals(url)) {
                loginStatus = false;
                break;
            }
        }
        
        if(loginStatus) {
            // session control
            Object objCustomer = req.getSession().getAttribute("customer");
            if(objCustomer == null) {
                res.sendRedirect("/");
            }else {
                Customer customer = (Customer) objCustomer;
                req.setAttribute("customer", customer);
                fc.doFilter(req, res); 
            }
        }else {
           fc.doFilter(req, res); 
        }
        
        
    }
    
    
    
}
