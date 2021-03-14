package demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/23 4:58 PM
 */
public class Pizza {
    private PizzaStatus status;

    public boolean isDeliverable(){
        return getStatus() == PizzaStatus.READY;
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivered());
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.setStatus(PizzaStatus.READY);
        pizza.printTimeToDeliver();
        System.out.println(pizza.isDeliverable());

    }
}
