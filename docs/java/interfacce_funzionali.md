## Interfacce funzionali
E' un'interfaccia che ha un solo metodo astratto, ed è solitamente indicata con l'annotazione
opzionale `@FunctionalInterface`.

```Java
@FunctionalInterface
interface Calcolatore {
    int operazione(int a, int b);
}
```

Le interfacce funzionali **sono istanziabili**, e si istanziano tramite:
- [Espressioni lambda](funzioni_lambda.md)
- [Classi anonime](classi_anonime.md)

**Nota importante**\
Classi anonime ed espressioni lambda, possono essere utilizzate anche senza interfacce funzionali.

### Istanziamento lambda
```Java
public class Main {
    public static void main(String[] args) {
        Calcolatore somma = (a, b) -> a + b;
        System.out.println("Somma: " + somma.opera(5, 3));

        Calcolatore moltiplicazione = (a, b) -> a * b;
        System.out.println("Moltiplicazione: " + moltiplicazione.opera(4, 7));
    }
}
```
### Istanziamento classe anonima
```Java
public class Main {
    public static void main(String[] args) {
        Calcolatore sottrazione = new Calcolatore() {
            @Override
            public int opera(int a, int b) {
                return a - b;
            }
        };

        System.out.println("Sottrazione: " + sottrazione.opera(8, 3));
    }
}
```
