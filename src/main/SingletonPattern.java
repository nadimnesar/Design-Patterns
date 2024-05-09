package main;

public class SingletonPattern {
    public static void main(String[] args) {
        /**
         * For first time call to .getInstance() method, a new object will be created.
         * For subsequent call to .getInstance() method, no new object will be created.
         * Previously created object will be re-used here.
         */
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstanceByDraconianSynchronization();

        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
    }
}

/**
 * Lazy initialization approach of singleton design pattern
 */
class LazySingleton {
    /**
     * Declare the instance, but do not create new instance now
     */
    private static LazySingleton instance = null;

    /**
     * Private constructor to prevent instantiation outside this class
     */
    private LazySingleton() {
        System.out.println("LazySingleton object created");
    }

    /**
     * Get the singleton instance. If the instance is null, create it within a synchronized block.
     */

    /**
     * Draconian synchronization
     */
    public static synchronized LazySingleton getInstanceByDraconianSynchronization() {
        if (instance == null) {
            if (instance == null) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    /**
     * Double-checked locking is used to reduce the overhead of draconian synchronization.
     */
    public static LazySingleton getInstance() {
        /**
         * The first null check (if (instance == null)) outside the synchronized block is to avoid the expensive
         * synchronization overhead once the instance has been created. If the instance is not null, it means that it has
         * already been created, and there's no need to enter the synchronized block.
         */
        if (instance == null) {
            synchronized (LazySingleton.class) {
                /**
                 * The second null check inside the synchronized block is necessary to prevent race conditions in
                 * multi-threaded environments. Even though we checked for null outside the synchronized block, multiple
                 * threads could still enter this block simultaneously. Therefore, we need to perform another null check
                 * inside the synchronized block to ensure that only one thread initializes the instance.
                 */
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * Eager initialization is generally considered thread-safe in standard Java environments, it's essential to be cautious
 * in advanced scenarios involving custom class loaders or exception handling to ensure the singleton pattern's
 * correctness.
 */

/**
 * Eager initialization approach of singleton design pattern
 */
class EagerSingleton {
    /**
     * Create the instance of the class during class loading.
     * Static initialization in Java is thread-safe by default.
     */
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * Private constructor to prevent instantiation outside this class
     */
    private EagerSingleton() {
        System.out.println("EagerSingleton object created");
    }

    /**
     * Returns the instance of the object
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}