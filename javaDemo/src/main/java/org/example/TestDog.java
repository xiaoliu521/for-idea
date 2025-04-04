package org.example;

class Animal{
   public void move(){
       System.out.println("动物可以移动");
   }
}
class Dog extends Animal{
   public void move(){
       System.out.println("狗可以跑和走");
   }
   public void bark(){
       System.out.println("狗可以吠叫");
   }
}

/**
* 编译看左
* 运行看右
*/
public class TestDog{
   public static void main(String args[]){
       Animal a = new Animal();
       Animal b = new Dog();
       a.move();
       b.move();
       // 强制类型转换，将 Animal 类型的 b 转换为 Dog 类型
       ((Dog) b).bark();
   }
}
