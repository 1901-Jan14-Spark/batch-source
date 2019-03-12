package com.revature.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.revature.models.Car;

public class ReflectDriver {

	public static void main(String[] args) {
		
		try {
			Class<?> c2 = Class.forName("com.revature.models.Car");
			System.out.println("Class: "+c2.getName());
			System.out.println("Superclass: "+c2.getSuperclass().getName());
			System.out.println();
			
			Class<?>[] interfaces = c2.getInterfaces();
			for(Class<?> interf : interfaces) {
				System.out.println(interf);
			}
			System.out.println();
			
			System.out.println("Fields: ");
			Field[] fields = c2.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field);
			}
			System.out.println();
			
			System.out.println("Methods: ");
			Method[] methods = c2.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method);
			}
			System.out.println("Superclass Methods:");
			Method[] superMethods = c2.getSuperclass().getDeclaredMethods();
			for(Method method : superMethods) {
				System.out.println(method);
			}
			System.out.println();
			
			Car car = (Car) c2.newInstance();
			System.out.println(car);
			System.out.println();
			
			Constructor<?>[] constructors = c2.getConstructors();
			for(Constructor<?> c : constructors) {
				if(c.getParameters().length == 4) {
					car = (Car) c.newInstance(new Object[] {3,5,"green",false});
				}
			}
			System.out.println(car);
			System.out.println();
			
			Field wheelsField = c2.getDeclaredField("numOfWheels");
			wheelsField.setAccessible(true);
			wheelsField.set(car, -200);
			wheelsField.setAccessible(false);
			System.out.println(car);
			System.out.println();
			
			Method wheelSetMethod = c2.getDeclaredMethod("setNumOfWheels", int.class);
			wheelSetMethod.invoke(car, 70);
			System.out.println(car);
			System.out.println();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("class name doesn't exist");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
