package com.spring.simple.ioc;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class SimpleIOC {

    private HashMap beanMap = new HashMap();

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name){
        Object bean = beanMap.get(name);
        if(bean == null){
            throw new IllegalArgumentException("there is no bean with name : " + name);
        }
        return bean;
    }

    public void loadBeans(String location) throws IOException, ParserConfigurationException, SAXException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //加载xml配置文件
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        
        //遍历bean标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if(node instanceof Element){
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                //加载beanClass
                Class classBean = null;
                try {
                    classBean = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                //创建bean
                Object bean = classBean.getDeclaredConstructor().newInstance();

                //遍历property标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if(propertyNode instanceof Element){
                        Element propertyEle = (Element) propertyNode;
                        String name = propertyEle.getAttribute("name");
                        String value = propertyEle.getAttribute("value");

                        Field declareField = bean.getClass().getDeclaredField(name);
                        declareField.setAccessible(true);

                        if(StringUtils.hasText(value)){
                            //将内容进行赋值
                            declareField.set(bean,value);
                        }else{
                            String ref = propertyEle.getAttribute("ref");
                            if(ref == null || ref.length() == 0){
                                throw new IllegalArgumentException("ref config error");
                            }
                            //???将引用填充到相关字段中去
                            declareField.set(bean, getBean(ref));
                        }

                        registBean(id, bean);
                    }
                    
                }
            }
        }

    }

    public void registBean(String id , Object bean){
        beanMap.put(id, bean);
    }

}
