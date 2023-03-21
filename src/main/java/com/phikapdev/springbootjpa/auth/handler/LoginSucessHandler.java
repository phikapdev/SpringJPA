package com.phikapdev.springbootjpa.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSucessHandler extends SimpleUrlAuthenticationSuccessHandler{

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
       
        SessionFlashMapManager sessionFlashMapManager = new SessionFlashMapManager();

        FlashMap flashMap = new FlashMap();
        flashMap.put("success", "Hola "+ authentication.getName()+" , Ha Iniciado sesion con exito");
        sessionFlashMapManager.saveOutputFlashMap(flashMap, request, response);

        if(authentication != null){
            logger.info("El Usuario '"+ authentication + "' ha Iniciado sesion con exito");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

    
    
}
