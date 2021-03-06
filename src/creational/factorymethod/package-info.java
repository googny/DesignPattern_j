/**
 * 工厂方法模式
 * @author mti1301
 * create date 2015/6/5.
 */
package creational.factorymethod;
/*
工厂方法模式：
定义：
    定义了一个创建对象的接口，但由子类“决定”要实例化的类是哪一个。
    工厂方法让类的实例化延迟到子类。
工厂方法封装具体类型的实例化，父类提供一个创建对象的接口（抽象方法），子类负责创建具体的对象

在编写创建者类时，不需要知道实际创建的产品的哪一个。
选择哪个子类，自然就选择了实际创建的产品是什么。
 */
