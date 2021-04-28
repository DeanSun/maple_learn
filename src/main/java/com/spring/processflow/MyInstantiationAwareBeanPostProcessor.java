//package com.spring.processflow;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.PropertyValues;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
//
//public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
//
//    public MyInstantiationAwareBeanPostProcessor() {
//        super();
//        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器!!");
//    }
//
//    /**
//     * 接口方法，实例化Bean之前调用
//     * @param bean
//     * @param beanName
//     * @return
//     * @throws BeansException
//     */
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInitialization方法");
//        return null;
//    }
//
//    /**
//     * 接口方法，实例化Bean之后调用
//     */
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInstantiation方法");
//        return bean;
//    }
//
//    /**
//     * 设置某个属性时进行调用
//     * @param pvs
//     * @param bean
//     * @param beanName
//     * @return
//     * @throws BeansException
//     */
//    @Override
//    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessProperties方法");
//        return pvs;
//    }
//
//
//}
