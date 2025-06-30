package com.seyitkoc.security;

import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtTokenService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtTokenService jwtTokenService, UserDetailsService userDetailsService) {
        this.jwtTokenService = jwtTokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String header = request.getHeader("Authorization");
            String token;
            String email;
            if(header == null || !header.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            token = header.substring("Bearer ".length()).trim();
            if(token.isEmpty()){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(
                        """
                        {
                          "code": "TOKEN_EMPTY",
                          "message": "Token boş olamaz!"
                        }
                        """
                );
                return;
            }
            email = jwtTokenService.findEmailFromToken(token);

            if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
                try{
                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                    if(userDetails != null && jwtTokenService.tokenControl(token, userDetails)){
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }catch (SignatureException e){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write(
                            """
                            {
                              "code": "INVALID_TOKEN_SIGNATURE",
                              "message": "Geçersiz token imzası!"
                            }
                            """
                    );
                    return;
                }

            }
            filterChain.doFilter(request, response);
        }catch (ExpiredJwtException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "TOKEN_EXPIRED",
                      "message": "Token süresi dolmuş!"
                    }
                    """
            );
        }catch (SignatureException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "INVALID_TOKEN_SIGNATURE",
                      "message": "Geçersiz token imzası!"
                    }
                    """
            );
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    """
                    {
                      "code": "TOKEN_PROCESSING_ERROR",
                      "message": "Token işlenirken hata oluştu: %s"
                    }
                    """.formatted(e.getMessage())
            );
        }
    }
}
