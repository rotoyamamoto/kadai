package chap10;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class Mondai9 implements Filter {

	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("サーブレットの前の処理");
		chain.doFilter(request, response);
		System.out.println("サーブレットの後の処理");
		
	}
	
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}

}
