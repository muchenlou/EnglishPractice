package com.english.practice.config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author  lixiaolong
 * @version  [版本号, 2019年5月21日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@WebFilter(filterName = "PracticeFilter",urlPatterns = {"/*"})
public class PracticeFilter implements Filter {

    String NO_LOGIN = "无权限请先登录";

    /**
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        //是否需要过滤
        boolean needFilter = false;
        //不需要登录就可以访问的路径(比如:注册登录等)
        List<String> list = new ArrayList<String>(Arrays.asList("/login","/submit","/demo"));
        if(list.contains(uri)){
            needFilter = false;
        }
        if (!needFilter) {
            //不需要过滤直接传给下一个过滤器
            chain.doFilter(servletRequest, servletResponse);
        } else {
            // session中包含loginUser对象,则是登录状态
            if(session!=null&&session.getAttribute("user") != null){
                chain.doFilter(request, response);
            }else{
                request.getRequestDispatcher("/index").forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

}
