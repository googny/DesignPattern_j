package creational.simplefactory;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class SimplePizzaFactory {

    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }else if(type.equals("clam")){
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
