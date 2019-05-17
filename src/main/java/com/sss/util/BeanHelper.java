package com.sss.util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * BeanHelper class
 *
 * @author Sss
 * @date 2019/3/26
 */
public class BeanHelper {

    private static final String CREATE_DATE = "createdDate";
    private static final String UPDATE_DATE = "updatedDate";



    public static <T> void setDefaultProp(T target,Class<T> clazz) {
        PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
        for (PropertyDescriptor propertyDescriptor : descriptors) {
            String fieldName = propertyDescriptor.getName();
            Object value;
            try {
                value = PropertyUtils.getProperty(target,fieldName );
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("can not set property  when get for "+ target +" and clazz "+clazz +" field "+ fieldName);
            }
            if (String.class.isAssignableFrom(propertyDescriptor.getPropertyType()) && value == null) {
                try {
                    PropertyUtils.setProperty(target, fieldName, "");
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException("can not set property when set for "+ target +" and clazz "+clazz + " field "+ fieldName);
                }
            }else if (Number.class.isAssignableFrom(propertyDescriptor.getPropertyType()) && value == null) {
                try {
                    BeanUtils.setProperty(target, fieldName, "0");
                } catch (Exception e) {
                    throw new RuntimeException("can not set property when set for "+ target +" and clazz "+clazz + " field "+ fieldName);
                }
            }
        }
    }

    public static <T> void onInsert(T target){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);

        try{
            PropertyUtils.setProperty(target,CREATE_DATE,date);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static <T> void onUpdate(T target){
        try{

            PropertyUtils.setProperty(target,UPDATE_DATE,System.currentTimeMillis());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
