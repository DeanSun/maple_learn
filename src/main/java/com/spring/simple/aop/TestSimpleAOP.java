package com.spring.simple.aop;

import com.spring.simple.aop.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;

public class TestSimpleAOP {

    @Test
    public void getProxy(){
        //1. 创建methodInvocation实现类
        MethodInvocation logTask = () -> System.out.println("log task start！");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        //2. 创建advice切面
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        //3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
