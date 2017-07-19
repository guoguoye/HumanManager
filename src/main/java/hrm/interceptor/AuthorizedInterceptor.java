package hrm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import hrm.domain.User;
import hrm.util.common.HrmConstants;

public class AuthorizedInterceptor implements HandlerInterceptor{

	/*url*/
	public static final String[] IGNORE_URLS = {"/login","/loginForm","/404.html"};
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		/***/
		boolean flag=false;
		/**
		 * ervletPath
		 */
		String servletPath = request.getServletPath();
		/***/
		for(String s:IGNORE_URLS){
			if(servletPath.contains(s)){
				flag=true;
				break;
			}
		}
		
		/***/
		if(!flag){
			/***/
			User user = (User) request.getSession().getAttribute(HrmConstants.USER_SESSION);
			if(user==null){
				request.setAttribute("message", "请重新登录");
				request.getRequestDispatcher(HrmConstants.LOGIN).forward(request, response);
				return flag;
			}else{
				flag=true;
			}
		}
		return flag;
	}

}
