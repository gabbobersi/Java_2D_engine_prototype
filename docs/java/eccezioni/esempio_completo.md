```Java
/**
 * Custom exception
*/
class OrderNotFoundException extends Exception {
    public OrderNotFoundException() {
        super("Order not found");
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
            throw new OrderNotFoundException();
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
