package library.filter;

import org.springframework.web.context.support.WebApplicationContextUtils;
import library.session.SessionObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {

    SessionObject sessionObject;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sessionObject = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext())
                .getBean(SessionObject.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("filter się odpalił");
        if (sessionObject.getUser() != null) {
            filterChain.doFilter(httpServletRequest, servletResponse);
            System.out.println("Ten użytkownik ma dostęp do tej strony");
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }
}
