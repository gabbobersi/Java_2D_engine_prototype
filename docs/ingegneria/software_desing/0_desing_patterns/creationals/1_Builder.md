**Riassunto pratico**\
ho un costruttore con mille mila parametri.\
Ecco la situazione ideale per "costruire" (build) il mio oggetto, gestendo i parametri come
"step" di costruzione, eventualmente skippabili.

## Spiegazione con esempio
Immaginate di avere un oggetto, che richiede **molti parametri** in fase di inizializzazione
(quindi nel **costruttore**) per essere correttamente creato.
```Java
Car car = new Car(id, brand, model, color, numberOfDors, screenType, weight, heigth);
```
A tutto ciò, aggiungete che alcuni tra questi parametri non sono sempre 
richiesti, ma sono **opzionali**. \
Valutiamo a questo punto diversi design:

1.  Passare gli argomenti che non mi servono, come `null` (orribile).
```Java
Car car = new Car(id, null, model, color, null, null, weight, heigth);
```
Il controllo dei parametri passati come `null` lo lasciamo al codice interno della classe.

2. Creare un costruttore per ogni combinazione di argomenti necessari (ok ma poco flessibile) .
```Java
new Car(id, brand, model);
new Car(id, screenType, weight, height);
new CAr(id, brand, model, color, numberOfDors);
// ... e così via ...
```
E' facile intuire che questa seconda soluzione può sfuggire di mano facilmente...

3. Builder

Nel pattern builder, "estraggo" i parametri dal costruttore della classe in questione, e li sposto in una classe a parte chiamata "QualcosaBuilder". \
Creo poi un costruttore per ognuno di questi parametri.
```Java
public class CarBuilder {
    private int id;
    private String brand;
    private String model;
    private String color;
    // ....
    
    public CarBuilder id (int id){
        this.id = id;
        return this;        // Ritorno l'oggetto
    }

    public CarBuilder brand (int brand){
        this.brand = brand;
        return this;        // Ritorno l'oggetto
    }
    
    public CarBuilder model (int model){
        this.model = model;
        return this;        // Ritorno l'oggetto
    }
    
    public CarBuilder color (int color){
        this.color = color;
        return this;        // Ritorno l'oggetto
    }

    // ...
    
    public Car build(){
        return new Car(id, brand, model, color);        // Ritorno il prodotto finito.
    }
}

// Utilizzo del builder
public class Test{
    public createMultipleCars(){
        Car car1 = new CarBuilder()
                .id(2122)
                .brand("Bugatti")
                .model("Chiron")
                .color("Blue")
                .numberOfDoors(2)
                .engine("8L")
                .height(115)
                .build();
            
        // Note that we have differents steps now. 
        Car car2 = new CarBuilder()
                .id(2123)
                .brand("Ferrari")
                .model("Purosangue")
                .color("Grey")
                .numberOfDoors(4)
                .height(160)
                .weight(320)
                .build();
    }
    Car car3 = new CarBuilder()
            .id(2125)
            .brand("Lamborghini")
            .model("Aventador")
            .color("Yellow")
            .height(160)
            .build();
}
```
Ok ora abbiamo un modo flessibile e conciso per creare differenti classi...\
Aspetta un attimo però. \
Dopo aver costruito 1000 macchine, mi sono reso conto che ci sono step di costruzione che si ripetono
in modo uguale. \
Tali step formano quindi delle **configurazioni** riutilizzabili:
```Java
// esempio

MACCHINA 1
        .brand("Bugatti")
        .model("Chiron")
        .color("Blue")
        .numberOfDoors(2)
        ...
MACCHINA 2
        .brand("Bugatti")
        .model("Chiron")
        .color("Blue")
        .numberOfDoors(2)
        ...
// e così via
```

Il builder pattern ci suggerisce di creare, a questo punto, un sistema per salvarci
queste configurazioni comuni a più oggetti. \
Questo sistema viene chiamato **director**.
## Director
E' una figura opzionale nel builder pattern. \
Ci consente di salvare configurazioni specifiche di un prodotto, per riutilizzarle. \
Ciò _nasconde_ a i dettagli di costruzione del prodotto, dal client.

Esempio:
```Java
public class Director {
    // Configurazione "base" per tutte le Bugatti.
    public void buildBugatti(CarBuilder builder){
        builder.brand("Bugatti")
                .color("Blue")
                .numberOfDoors(2)
                .engine("8L")
    }

    // Configurazione "base" per tutte le Lamborghini.
    public void buildLamborghini(CarBuilder builder){
        builder.brand("Lamborghini")
                .color("Yellow")
                .numberOfDoors(2)
                .engine("4L")
    }
}


Director director = new Director();
CarBuilder builder = new CarBuilder();
director.buildBugatti(builder);
Car car = builder.build();
```

Ok, adesso abbiamo anche un modo per salvarci configurazioni comuni e riutilizzarle... \
Problema finale, in tutta questa complessità, dobbiamo assicurarci che tutti
gli eventualmente diversi builder, accettino la medesima interfaccia.

L'interfaccia definirà **tutti gli step** necessari a costruire una macchina.
```Java
// Notare che adesso è l'interfaccia a chiamarsi "Builder".
public interface Builder {
    Builder id(int id);
    Builder brand(String brand);
    Builder model(String model);
    Builder color(String color);
    // ...
}
```

Ora tutti i builder vari, condivideranno gli stessi step di costruizione:

```Java
public class CarBuilder implements Builder {
    // ...
}

public class CarSchemaBuilder implements Builder {
    // ...
}

public class CarEmptyBuilder implements Builder {
    // ...
}
// e così via
```

Alla fine del giro, anche il director accetterà tale interfaccia `Builder`:
```Java
public class Director {
    // Notare il tipo "Builder".
    // Una volta, al posto di Builder, utilizzavamo il tipo esatto del builder,
    // ora invece possiamo passare qualsiasi builder che condivida l'interfaccia Builder.

    public void buildBugatti(Builder builder){
        builder.brand("Bugatti")
                .color("Blue")
                .numberOfDoors(2)
                .engine("8L")
    }

    public void buildLamborghini(Builder builder){
        builder.brand("Lamborghini")
                .color("Yellow")
                .numberOfDoors(2)
                .engine("4L")
    }
}
```
