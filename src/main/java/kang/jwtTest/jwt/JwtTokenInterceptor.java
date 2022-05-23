//package kang.jwtTest.jwt;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class JwtTokenInterceptor implements HandlerInterceptor {
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException{
//        System.out.println("JwtToken 호출");
//        String accesToken = request.getHeader("ACCESS_TOKEN");
//        System.out.println("AccessToken:"+accesToken);
//        String refreshToken = request.getHeader("REFRESH_TOKEN");
//        System.out.println("RefreshToken:"+refreshToken);
//
//        if (accesToken!=null && jwtTokenProvider.isValidAccessToken(accesToken)){
//            return true;
//        }
//
//        response.setStatus(401);
//        response.setHeader("ACCESS_TOKEN",accesToken);
//        response.setHeader("REFRESH_TOKEN",refreshToken);
//        response.setHeader("msg","Check the tokens.");
//        return false;
//    }
//}
