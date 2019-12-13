package com.ty.bb.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

@Component
@Intercepts({
        @Signature(method = "update", type = Executor.class, args = {MappedStatement.class, Object.class})
})
public class UpdateMethodInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args[0] instanceof MappedStatement) {
            MappedStatement ms = (MappedStatement) args[0];
            SqlCommandType sqlCommandType = ms.getSqlCommandType();
            if ((SqlCommandType.UPDATE).equals(sqlCommandType)) {
                //过滤掉使用自定义参数的insert方法（用@Param注解声明的参数，会处理为Map）
                if (!(args[1] instanceof Map)) {
                    Field[] fields = args[1].getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("remark".equals(field.getName())) {
                            Method method = args[1].getClass().getDeclaredMethod("setRemark", String.class);
                            method.invoke(args[1], "20191212");
                        }
                    }
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
