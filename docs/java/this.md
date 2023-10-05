In Java l'utilizzo del "this" serve a chiarificare in modo esplicito che si sta facendo
riferimento a un **attributo di istanza**.

Esso **non è obbligatorio** in caso di non ambiguità tra attributi di istanza e variabili locali:
```Java
class Test(){
    private int testNumber = 0;
    
    public void printTestNumber(){
        System.out.println(testNumber);
    }
}
```

Esso invece **è obbligatorio** in caso di ambiguità:
```Java
class Test(){
    private int testNumber = 0;
    
    public void compareTestNumber(int testNumber){
        // Notare che chiamandosi uguali, devo specificare "this" per riferimenti all'attr. dell'istanza.
        return this.testNumber == testNumber;
    }
}
```