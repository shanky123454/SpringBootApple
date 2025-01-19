package com.demo;
class hello {
public static void main(String[] args) throws Exception{
	hello t = new hello() ;
    //System.out.println(p instanceof Thread);//C.E
      System.out.println(t instanceof Object);//true
      System.out.println(t instanceof hello);//true
      System.out.println(Class.forName(args[0]).isInstance(t));

}
}