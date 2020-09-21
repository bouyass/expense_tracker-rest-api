package com.example.expensetrackerapi.filters;

import com.example.expensetrackerapi.Contants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;
import org.yaml.snakeyaml.scanner.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest =  (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String authHeader = httpRequest.getHeader("Authorization");
        if(authHeader != null){
            String[] authHeaderArr = authHeader.split("Bearer");
            if(authHeaderArr.length > 1 && authHeaderArr[1] != null){
                String token = authHeaderArr[1];
                try{
                    Claims claims = Jwts.parser().setSigningKey(Contants.API_SECRET_KEY)
                            .parseClaimsJws(token).getBody();
                    httpRequest.setAttribute("userId",Integer.parseInt(claims.get("userId").toString()));
                }catch (Exception e){
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid or expired token");
                    return;
                }
            }else{
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer [token]");
            }
        }else{
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided ");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
