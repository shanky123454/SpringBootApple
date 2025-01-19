package com.demo;
//import java.util.*;
//import java.lang.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
  
     
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.PACKAGE})
@interface player
{
    int run() default 100000;
    String country() default "india";
    // int run();
    // String country();
}

@player   //(country="india",run= 10000)
class virat
{
    public int innings;
    public String name;
    public int getInnings() {
        return innings;
    }
    public void setInnings(int innings) {
        this.innings = innings;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

 public class annot
{
    public static void main(String[] args)
    {
        virat v = new virat();
        v.setInnings(100);
        v.setName("VK");
        System.out.println(v.getInnings() + " " + v.getName()+ " " + v.getClass().getName());
        Class c = v.getClass();
        Annotation at = c.getAnnotation(player.class);
       
        player vt =(player) at;
        int runs = vt.run();
        System.out.println(runs);
        String c1 = vt.country();
        System.out.println(c1);
        
    }

}