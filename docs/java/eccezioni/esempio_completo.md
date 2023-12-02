```Java
/**
 * Custom exception
*/
class OrderNotFoundException extends Exception {
    // Custom message
    public OrderNotFoundException(String message) {
        super(message);
    }
    // Default message
    public OrderNotFoundException() {
        super("The order is not valid, or not present.");
    }
}

/**
 * Connessione a DB (esempio)
*/
class Database {
    private String nameOfDatabase;
    private String nameOfTable;

    public Database(String nameOfDatabase, String nameOfTable) {
        this.nameOfDatabase = nameOfDatabase;
        this.nameOfTable = nameOfTable;
    }

    public Order select(int id) {
        // ...
    }
}

/**
 * Classe che si occupa di trovare un ordine sulla base determinate
 * sue caratteristiche (es id, nome, etc).
 * */ 
class OrderFinder {
    private Database database = new Database("nameOfDatabase", "nameOfTable");

    /**
     * Propaga l'eccezione OrderNotFoundException in caso di ordine non trovato.
    */
    public void getOrderById(int id) throws OrderNotFoundException {
        Order order = database.select(id);
        if (!order){
            throw new OrderNotFoundException("The order '" + id + ' is not found.");
        } else {
            return database.select(id);
        }
    } 
}

/**
 * Gestisco l'eccezione (try, catch)
*/
class Main {
    public static void main(String[] args) {
        OrderFinder orderFinder = new OrderFinder();
        try {
            orderFinder.getOrderById(1);
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
```
