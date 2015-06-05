package creational.simplefactory;

/**
 * @author mti1301
 * create date 2015/6/5.
 */
public class Pizza {
    String pizzaName;
    public void prepare(){
        System.out.println("prepare "+pizzaName);
    }
    public void bake(){
        System.out.println("bake "+pizzaName);
    }
    public void cut(){
        System.out.println("cut "+pizzaName);
    }
    public void box(){
        System.out.println("box "+pizzaName);
    }
}
