package hkins.baseplatfrom.jdbc.paging;

public class TotalCountHandler {
    private static ThreadLocal<Integer> countHolder = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return Integer.valueOf(0);
        }
    };
    
    public static void set(int value) {
        countHolder.set(Integer.valueOf(value));
    }
    
    public static int get() {
        return ((Integer)countHolder.get()).intValue();
    }
    
    public static void remove() {
        countHolder.remove();
    }
}
