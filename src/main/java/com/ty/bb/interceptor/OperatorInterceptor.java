package com.ty.bb.interceptor;

import com.ty.bb.bean.base.OperatorNo;
import com.ty.bb.bean.base.WritableCreateAndModifyOperator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class OperatorInterceptor {
    @Around("execution(* com.ty.bb.service..*.insert*(..))" + " || "
            + "execution(* com.ty.bb.service..*.update*(..))" + " || "
            + "execution(* com.ty.bb.service..*.list*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("interceptor in");
        Integer operator = 0;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        Method method = methodSignature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotations = parameterAnnotations[i];
            Object arg = args[i];
            if (null != arg) {
                Class clazz = arg.getClass();
                if ((OperatorNo.class).isAssignableFrom(clazz)) {
                        /*OperatorNo multipleOperatorNo = (OperatorNo) arg;
                        operator = multipleOperatorNo.getOperatorNo();*/
                    operator = 1001;
                }
                if ((WritableCreateAndModifyOperator.class).isAssignableFrom(clazz)) {
                    WritableCreateAndModifyOperator writableCreateAndModifyOperator =
                            (WritableCreateAndModifyOperator) arg;
                    if (methodSignature.getName().indexOf("insert") >= 0) {
                        writableCreateAndModifyOperator.setCreateOperator(operator);
                    }
                    writableCreateAndModifyOperator.setModifyOperator(operator);
                }
            }
        }
        return joinPoint.proceed();
    }
}
