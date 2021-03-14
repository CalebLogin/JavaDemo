package demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/23 4:59 PM
 */
public enum PizzaStatus {
    ORDERED (5){
        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY (2) {
        @Override
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED (0){
        @Override
        public boolean isDelivered() {
            return true;
        }
    };

    public int getTimeToDelivered() {
        return timeToDelivered;
    }

    private int timeToDelivered;

    public boolean isOrdered(){return false;}

    public boolean isReady(){return false;}

    public boolean isDelivered(){return false;}

    PizzaStatus(int timeToDelivered) {
        this.timeToDelivered = timeToDelivered;
    }

}
