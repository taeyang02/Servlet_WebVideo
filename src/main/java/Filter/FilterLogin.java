package Filter;

import Model.User;
import constant.SessionAttr;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/favorite" ,"/admin/*"})
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        String urlPartenGo = httpReq.getServletPath();
        String pathCx = httpReq.getContextPath();
        HttpSession session =  httpReq.getSession();
          User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
          if (user == null){
              httpResp.sendRedirect(pathCx+"/user/login");
          }
          if (user!= null){
              if (user.isAdmin() == true){
                  chain.doFilter(request,response);
              }else {
                  httpResp.sendRedirect(pathCx+"/index");
              }


          }
    }


}
