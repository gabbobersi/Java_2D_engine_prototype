# Ereditarietà
***
L'ereditarietà in Java è un concetto fondamentale che consente a una classe di ereditare caratteristiche da un'altra. È utile nei giochi 2D per riutilizzare il codice, supportare la sovrascrittura di metodi e fornire astrazione. Si usa la parola chiave "extends" per creare sottoclassi. La comprensione dei tipi di ereditarietà è importante. Inoltre, tieni presente che una classe può avere una sola superclasse e che i costruttori non vengono ereditati. 
I membri privati non sono ereditati, 
ma i metodi pubblici o protetti per accedere a tali membri possono essere utilizzati nelle sottoclassi.
***
### Come utilizzare l'ereditarietà in Java?

Ecco un esempio di ereditarietà in Java per un progetto di gioco 2D. Supponiamo che tu abbia una classe Personaggio come superclasse e due sottoclassi Eroe e Nemico che ereditano da Personaggio. 
In questo esempio, Personaggio contiene attributi comuni, mentre Eroe e Nemico aggiungono attributi specifici:
```Java
class Personaggio {
    String nome;
    int puntiVita;

    public Personaggio(String nome, int puntiVita) {
        this.nome = nome;
        this.puntiVita = puntiVita;
    }

    public void attacca() {
        System.out.println(nome + " attacca!");
    }
}

class Eroe extends Personaggio {
    int puntiEsperienza;

    public Eroe(String nome, int puntiVita, int puntiEsperienza) {
        super(nome, puntiVita);
        this.puntiEsperienza = puntiEsperienza;
    }

    public void usaPoteriSpeciali() {
        System.out.println(nome + " usa i suoi poteri speciali!");
    }
}

class Nemico extends Personaggio {
    boolean ostile;

    public Nemico(String nome, int puntiVita, boolean ostile) {
        super(nome, puntiVita);
        this.ostile = ostile;
    }

    public void fuggi() {
        System.out.println(nome + " cerca di fuggire!");
    }
}

public class Gioco2D {
    public static void main(String[] args) {
        Eroe eroe = new Eroe("Eroe1", 100, 50);
        Nemico nemico = new Nemico("Nemico1", 80, true);

        eroe.attacca();
        eroe.usaPoteriSpeciali();

        nemico.attacca();
        nemico.fuggi();
    }
}


```
***
