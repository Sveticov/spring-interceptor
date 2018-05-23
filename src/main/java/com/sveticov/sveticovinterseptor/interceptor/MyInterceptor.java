package com.sveticov.sveticovinterseptor.interceptor;

import com.sveticov.sveticovinterseptor.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MyInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.getHeaderNames().stream().forEach(s -> logger.info(s.toString()));
        logger.info("response ");
        logger.info("request " + request.getMethod());
        logger.info(handler.toString());



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
     //   logger.info(modelAndView.getViewName());

        if(request.getRequestURI().contains("user")){
            logger.info("user 111");
//            if(handler.toString().contains("User")){
                logger.info("user 222");

                User user=(User) modelAndView.getModel().get("user");
                logger.info(user.toString());
                if(user!=null){
                    try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("C://Users//Sveticov//IdeaProjects//sveticov-interseptor//src//main//resources//file//text.txt"))){
                        outputStream.writeObject(user);
                    }catch (Exception ex){}
                }
//            }
        }

    }
}
