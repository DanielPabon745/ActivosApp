package com.activos.activos_fijos.aspect;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
@Aspect
public class Logs
{

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void allResources() {
    }

    @Before("allResources()")
    public void apiRequestLog(JoinPoint jp) {
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info("------------------------- Inciando Controlador -------------------------");
        StringBuilder log = new StringBuilder("Metodo: ");
        log.append(jp.getSignature().getName());
        log.append(" >>>");

        int i = 1;
        for (Object arg : jp.getArgs()) {
            log.append("\n");
            log.append("Parametro ");
            log.append(i);
            log.append(": ");
            if (arg != null && arg.toString().contains("com.activos.activos_fijos."))
            {
                Gson gson = new Gson();
                String resultado = gson.toJson(arg);
                log.append(resultado);
            }else {
                log.append(arg);
            }

            i++;
        }
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log.toString());
    }

    @AfterReturning(pointcut = "allResources()", returning = "result")
    public void apiResponseLog(JoinPoint jp, Object result) {
        StringBuilder log = new StringBuilder("<<< Respuesta (");
        log.append(jp.getSignature().getName());
        log.append("): \n");
        Gson gson = new Gson();
        String resultado = gson.toJson(result); 
        log.append(resultado);

        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log);
    }

    @AfterThrowing(pointcut = "allResources()", throwing = "exception")
    public void apiResponseExceptionLog(JoinPoint jp, Exception exception) {
        StringBuilder log = new StringBuilder("<<< Respuesta ("); 
        log.append(jp.getSignature().getName());
        log.append("): lanza excepcion ");
        log.append(exception.getClass().getSimpleName());

        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info(log);
    }

    @Around("allResources()")
    public Object processTimeLog(ProceedingJoinPoint pjp) throws Throwable {
        Calendar before = Calendar.getInstance();
        Object obj = pjp.proceed();
        Calendar now = Calendar.getInstance();

        Long tiempo = now.getTimeInMillis() - before.getTimeInMillis();

        StringBuilder log = new StringBuilder("Duración de proceso: ");
        log.append(tiempo);
        log.append(" ms");

        LogManager.getLogger(pjp.getSignature().getDeclaringTypeName()).info(log);

        return obj;
    }
}