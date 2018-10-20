package com.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	
	  private static ApplicationContext applicationContext; // SpringӦ�������Ļ���

      /*

       * ʵ����ApplicationContextAware �ӿڣ�����ʵ�ָ÷�����

       *ͨ������applicationContext������ʼ����Ա����applicationContext

       */

      public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	  System.out.println("��ʼ��  SpringContextUtil");
            SpringContextUtil.applicationContext = applicationContext;
      }

      public static Object getBeanById(String id){
          return applicationContext.getBean(id);
      }


      public static ApplicationContext getApplicationContext() {
             return applicationContext;
      }


       @SuppressWarnings("unchecked")
       public static <T> T getBean(String name) throws BeansException {
                  return (T) applicationContext.getBean(name);
        }
       
       /**
        * 根据bean的class来查找对象
        * @param c
        * @return
        */
       public static <T> T getBeanByClass(Class c){
           return (T)applicationContext.getBean(c);
       }
	

}
