E' utilizzato:
- come fondamenta per il design pattern **Builder**.
- per richiamare più metodi sulla medesima riga, rendendo il codice più elengate.

### Esempio:
```Java
public class MyClass {
    private int value;

    public MyClass setValue(int value) {
        this.value = value;
        return this;  
    }

    public MyClass add(int num) {
        this.value += num;
        return this;
    }

    public int getValue() {
        return this.value;
    }
}

public class Main {
public static void main(String[] args) {
MyClass myObj = new MyClass();

        int result = myObj.setValue(10).add(5).getValue();
        System.out.println("Il risultato è: " + result); // Stampa "Il risultato è: 15"
    }
}
```

Notare la catena:
1. setValue ===> Torna l'oggetto (`this`)
2. add =======> Torna l'oggetto (`this`) 
3. getValue ===> Torna il valore finale

Per poter quindi sfruttare il method chaining, è necessario ritornare 
l'oggetto stesso, fino al metodo finale (che ritornerà appunto il valore finito).
