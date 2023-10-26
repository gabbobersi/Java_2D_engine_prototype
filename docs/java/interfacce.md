## Interfacce Java
Un'interfaccia in Java è un **contratto** che definisce un insieme di metodi che una classe deve implementare. 

Può contenere metodi astratti e attributi che sono implicitamente pubblici, statici, final (quindi costanti vere e proprie), senza implementazioni concrete.

Le classi che implementano un'interfaccia devono fornire l'implementazione concreta di tutti i metodi definiti dall'interfaccia.


*NB:il termine "**contratto**" si riferisce ad un accordo o un insieme di regole che definiscono le condizioni che devono essere rispettate da chiunque utilizzi una determinata parte di codice, come una classe, un modulo o un'interfaccia.*
********************************

Ecco un esempio di interfaccia in Java:
```Java
public interface Shape {
    // Notare l'attr. AREA_DI_INTERESSE, che è implicitamente pubblico, statico,
    // final (quindi è una costante, e come tale viene scritta in maiuscolo).
    String AREA_DI_INTERESSE = "Geometria";

    double calculateArea();  // Metodo per calcolare l'area della forma
    double calculatePerimeter();  // Metodo per calcolare il perimetro della forma
}

```
****************

Nel codice sopra, abbiamo definito un'interfaccia chiamata **Shape** che ha due metodi,**calculateArea**  e _**calculatePerimeter**_, senza fornire l'implementazione. 

**Le [classi](classe_istanza.md) che implementano l'interfaccia Shape devono fornire un'implementazione per questi metodi.**
********************************
Ecco un esempio di come una classe può implementare l'interfaccia Shape:

```Java
public class Circle implements Shape {
    private double radius;
    //Il costruttore Circle accetta il 
    // raggio del cerchio come parametro e lo memorizza nella variabile radius.
    public Circle(double radius) {
        this.radius = radius;
    }
    //Il metodo calculateArea calcola e restituisce l'area del cerchio
    // utilizzando la formula π×r2π×r2, dove rr è il raggio del cerchio.
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    //Il metodo calculatePerimeter calcola e restituisce il perimetro del cerchio 
    //utilizzando la formula 2×π×r2×π×r, dove rr è il raggio del cerchio.
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}


```

Nel codice sopra, la [classe](classe_istanza.md) **Circle** implementa l'interfaccia **Shape** e fornisce 
un'implementazione per i
metodi _calculateArea e calculatePerimeter_ specifici per un cerchio.
********************************
