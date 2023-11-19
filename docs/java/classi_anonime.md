## Classi anonime
```Java
Interfaccia_o_Classe myObj = new Interfaccia_o_Classe() {
    @Override
    public void metodo() {
        // Fai qualcosa
    }
};
```

#### Premessa - Classi anonime vs Espressioni lambda
- Dopo l'introduzione delle espressioni lambda in Java 8, l'utilizzo delle classi anonime, quale
versione più verbosa delle lambda, è decrementato nel tempo.
- Le espressioni lambda forniscono una sintassi generalmente più concisa e leggibile.
- Nei casi di implementazione di interfacce funzionali, hanno totalmente prevalso le espressioni lambda.
- In pre Java-8, le classi anonime venivano utilizzate per la gestione di eventi, o implementare callback in framework come Swing.
****
#### Spiegazione
- Le classi anonime si utilizzano per sovrascrivere "al bisogno" un metodo di una classe esistente.
- Ciò è vero anche nel caso delle interfacce funzionali, in cui grazie alle classi anonime, è
possibile fornire una vera e propria implementazione del loro unico metodo astratto.
- Non è possibile modificare la classe che ospita la classe anonima, con quest'ultima. La classe da modificare 
dovrà quindi esser definita altrove.

#### Overhead delle classi anonime
Una classe anonima aggiunge un certo overhead in quanto richiede
la creazione di una classe vera e propria.\
Le espressioni lambda invece no.

#### Interfacce con più di un metodo
Una classe anonima può essere utilizzata per implementare una interfaccia con più di un metodo astratto.\
Le espressioni lambda al contrario, possono implementare solo interfacce funzionali.

#### this
Nelle classi anonime, il `this` fa riferimento alla classe anonima.\
Nelle lambda invece, il `this` fa riferimento alla classe che la ospita.

#### Quando usarle
- In situazioni più complesse in cui le lambda risultano poco chiare.
- Quando vuoi implementare interfacce con più di un metodo astratto.

### Esempio classe anonima vs espressione lambda
```Java
class Main {
    public static void main(String[] args){
        // Classe anonima
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Esempio");
            }
        };
        myRunnable.run();

        // Espressione lambda
        Runnable myRunnableLambda = () -> System.out.println("Esempio");

    }
}
```
L'eleganza delle espressioni lambda è chiara, rispetto alla classe anonima...

### Una cosa che ti scorderai sicuro
Le classi anonime terminano con il **punto e virgola**.
