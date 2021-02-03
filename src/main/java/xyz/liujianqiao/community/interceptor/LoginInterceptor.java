package xyz.liujianqiao.community.interceptor;

import xyz.liujianqiao.community.model.Tourist;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // URL:除了登录请求外，其他的URL都进行拦截控制
        if (url.indexOf("/login.action") >= 0) {
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        Tourist user = (Tourist) session.getAttribute("touriat");
        // 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if (user != null) {
            return true;
        }
        // 不符合条件的给出提示信息，并转发到登录页面
        return false;
    }
}
