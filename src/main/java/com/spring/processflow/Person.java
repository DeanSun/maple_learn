//package com.spring.processflow;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.*;
//
///**
// * @author Dean
// */
//public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
//
//    private String name;
//    private String address;
//    private int phone;
//
//    private BeanFactory beanFactory;
//    private String beanName;
//
//    public Person() {
//        System.out.println("【构造器】调用Person的构造器实例化");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        System.out.println("【注入属性】注入属性name");
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        System.out.println("【注入属性】注入属性address");
//        this.address = address;
//    }
//
//    public int getPhone() {
//        return phone;
//    }
//
//    public void setPhone(int phone) {
//        System.out.println("【注入属性】注入属性phone");
//        this.phone = phone;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [address=" + address + ", name=" + name + ", phone="
//                + phone + "]";
//    }
//
//
//    /**
//     * 这是BeanFactoryAware接口方法
//     */
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
//        this.beanFactory = beanFactory;
//    }
//
//    /**
//     * 这是BeanNameAware接口方法
//     */
//    @Override
//    public void setBeanName(String name) {
//        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
//        this.beanName = name;
//    }
//
//    /**
//     * 这是InitializingBean接口方法
//     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
//    }
//
//    /**
//     * 这是DiposibleBean接口方法
//     */
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("【DisposableBean接口】调用DisposableBean.destroy()");
//    }
//
//    /**
//     * 通过<bean>的init-method属性指定的初始化方法
//     */
//    public void myInit(){
//        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
//    }
//
//    /**
//     * 通过<bean>的destroy-method属性指定的初始化方法
//     */
//    public void myDestroy(){
//        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
//    }
//
//}
