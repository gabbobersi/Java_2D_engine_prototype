### Strategy Pattern


Il Pattern Strategy è un design pattern 
comportamentale
che consente di definire una famiglia di algoritmi, 
incapsularli e renderli intercambiabili. 
**In altre parole, consente di definire diversi comportamenti e di sceglierli dinamicamente a runtime.**

Per implementare il Pattern Strategy:


- **Definisci un'interfaccia o una classe astratta** (detta solitamente "Strategia") che dichiara un metodo comune a tutti gli algoritmi.

- **Crea diverse classi concrete che implementano l'interfaccia** o estendono la classe astratta e forniscono implementazioni specifiche per ciascun algoritmo.

- **Nella classe che utilizza il pattern Strategy (il "Context"), dichiara un riferimento alla strategia (l'interfaccia) e un metodo per impostare la strategia desiderata.**


#### Esempio Rilevante
```Java
// Passo 1: Definisci un'interfaccia Strategia
interface Strategia {
    void eseguiOperazione(int a, int b);
}

// Passo 2: Crea diverse classi concrete che implementano l'interfaccia
class Addizione implements Strategia {
    @Override
    public void eseguiOperazione(int a, int b) {
        System.out.println("Somma: " + (a + b));
    }
}

class Sottrazione implements Strategia {
    @Override
    public void eseguiOperazione(int a, int b) {
        System.out.println("Differenza: " + (a - b));
    }
}

// Passo 3: Crea il contesto
class Calcolatrice {
    private Strategia strategia;

    public void setStrategia(Strategia strategia) {
        this.strategia = strategia;
    }

    public void eseguiOperazione(int a, int b) {
        strategia.eseguiOperazione(a, b);
    }
}

// Passo 4: Utilizza il pattern Strategy
public class Main {
    public static void main(String[] args) {
        Calcolatrice calcolatrice = new Calcolatrice();

        calcolatrice.setStrategia(new Addizione());
        calcolatrice.eseguiOperazione(5, 3);  // Output: Somma: 8

        calcolatrice.setStrategia(new Sottrazione());
        calcolatrice.eseguiOperazione(5, 3);  // Output: Differenza: 2
    }
}
```
***

