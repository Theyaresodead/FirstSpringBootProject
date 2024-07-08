package com.example.todoapispring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint)  {
        long start = System.currentTimeMillis(); // start time of the code

        // execution of the joint point
        try{
             joinPoint.proceed();
        }catch (Throwable e){
           System.out.println("Something went wrong");
        }
        finally{
            long end=System.currentTimeMillis();
            long totalTime=end-start;
            System.out.println("Total time to execute the method: "+totalTime + "ms..");
        }

    }
}
