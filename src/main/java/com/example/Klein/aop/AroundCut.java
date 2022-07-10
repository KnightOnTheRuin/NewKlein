package com.example.Klein.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundCut {
    /*public static final String POINT_CUT = "execution(* com.test.demo.controller.CategoryController.*(..)) || " +
            "execution(* com.test.demo.controller.DocController.*(..))";

    @Around(AroundCut.POINT_CUT)
    public DataResult checkSession(ProceedingJoinPoint pjp) throws Throwable {
        //获取session
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return (DataResult) pjp.proceed();
    }*/
}
