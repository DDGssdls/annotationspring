package com.spring.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {
    // 这里的就是四种通知 一种就是 前置通知 一种就是后置通知 另一种就是异常通知 一种就是返回通知 最后的一种就是环绕通知
    // 前置通知就是在方法执行前进行通知
    @Pointcut("execution(* com.spring.calculator.MainCalculator.div(int, int))")
    public void pt1(){};// 这样的形式进行切入点表达式的设置 引入的使用就是用pt1() 需要带上 () 外部类上就加上 全类名就行
    @Before("pt1()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"开始运行了 " +
                "这就是前置通知...使用的参数是："+ Arrays.asList(joinPoint.getArgs()));
    }
    // 后置通知就是方法执行之后进行通知
    //@After("pt1()")
    public void logEnd(){
        System.out.println("除法结束了 这就是后置通知...");
    }
    // 返回通知就是方法执行完成 正常返回的时候通知
    @AfterReturning(value = "pt1()", returning = "result")
    public void logReturn(Object result){
        System.out.println("除法执行返回了了 这就是返回通知... 返回的结果是"+result);
    }
    // 异常通知就是方法执行的时候出现异常的时候进行通知
    @AfterThrowing(value = "pt1()", throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法出现异常了 异常通知...异常的信息"+exception.getMessage());
    }
    //@Around("pt1()")
    /*public Object around(ProceedingJoinPoint joinPoint){
        Object returnRes= null;
        try {
            // 使用环绕通知的步骤就是 使用的一个对象就是proceedingJoinPoint
            // 使用这个额对象的两种方法一种就是 getarges
            // 另一种方法就是 getproceed方法 这个方法就是执行被切面的方法 进行通知就行了
            Object[] args = joinPoint.getArgs();
            //logStart(joinPoint);
            returnRes = joinPoint.proceed();
            logEnd();
            return returnRes;
        } catch (Throwable throwable) {
            logException();
        }finally {
            logReturn();
        }
        return returnRes;
    }
*/
}
