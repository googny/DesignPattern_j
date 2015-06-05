package creational.simplefactory;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class PizzaStore {
    public Pizza orderPizza(String type){
        // 从工厂获取对象，创建对象的职责被放在工厂类中
        Pizza pizza = SimplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("==================");
        return pizza;
    }
}
