## Riassunto rapido
**Creo le fabbriche:**
1. Creazione interfacce:
   1. Fabbrica generica.
      1. Il tipo di ritorno dei metodi di tale interfaccia, corrisponderà alle interfacce dei prodotti.  
2. Creazione classi concrete:
   1. Fabbrica concreta di prodotto A
   2. Fabbrica concreta di prodotto B

**Creo i prodotti:**
1. Creazione interfacce:
   1. Prodotto
   2. Caratteristica del prodotto
2. Creazione classi concrete:
   1. Prodotto A con caratteristiche 1, 2, 3.
   2. Prodotto B con caratteristiche 1, 3, 7, 9.

**Utilizzo:**
1. Istanzia le fabbriche concrete.
2. Produci i prodotti concreti specifici (uno per fabbrica specializzata).

## Spiegazione

**Esempio pratico:** \
Devi costruire giocattoli con diverse caratteristiche, ma non sai ancora quali saranno. \
L'Abstract Factory ti consente di creare "fabbriche" di giocattoli, ognuna specializzata in un tipo specifico di giocattolo. \ 
In questo modo, puoi costruire giocattoli in modo flessibile senza conoscere in anticipo le loro caratteristiche.

**Problema:** \
Creare famiglie di oggetti correlati, senza specificare le classi concrete
di tali oggetti.
In altre parole, si vuole creare un insieme coeso e funzionante di oggetti,
mantenendo la flessibilità di cambiare famiglia di tali oggetti. 

**Soluzione:** \
L'Abstract Factory utilizza un'interfaccia astratta (l'Abstract Factory stessa) per definire metodi per la creazione di oggetti correlati. \
Questo consente la creazione di diverse implementazioni di questa interfaccia per gestire diverse famiglie di oggetti.

**Conseguenze:**
- Tale pattern, se non è giustificativo dalla complessità del sistema a cui è applicato, può portare a ulteriore complessità.
- Isola il client dalla conoscenza delle classi concrete.
- Supporta la creazione di famiglie di oggetti coesi.
- Facilita la sostituzione di famiglie di oggetti senza modificare il codice del client.
## Esempio
```Java
// Interfaccia astratta per la fabbrica di giocattoli
interface ToyFactory {
    Toy createToy();
    ToyPart createToyPart();
}

// Classe concreta per la fabbrica di puzzle
class PuzzleFactory implements ToyFactory {
    @Override
    public Toy createToy() {
        return new Puzzle();
    }

    @Override
    public ToyPart createToyPart() {
        return new PuzzlePiece();
    }
}

// Classe concreta per la fabbrica di mattoncini
class BrickFactory implements ToyFactory {
    @Override
    public Toy createToy() {
        return new Brick();
    }

    @Override
    public ToyPart createToyPart() {
        return new BrickPiece();
    }
}

// Interfaccia per i giocattoli e le loro parti
interface Toy {
    void play();
}

interface ToyPart {
    void assemble();
}

// Classi concrete per i giocattoli e le loro parti
class Puzzle implements Toy {
    @Override
    public void play() {
        System.out.println("Gioca con il puzzle");
    }
}

class PuzzlePiece implements ToyPart {
    @Override
    public void assemble() {
        System.out.println("Assembla il pezzo del puzzle");
    }
}

class Brick implements Toy {
    @Override
    public void play() {
        System.out.println("Gioca con i mattoncini");
    }
}

class BrickPiece implements ToyPart {
    @Override
    public void assemble() {
        System.out.println("Assembla il pezzo del mattoncino");
    }
}

public class Main {
    public static void main(String[] args) {
        // Utilizzo dell'Abstract Factory per creare giocattoli e parti di giocattoli
        ToyFactory puzzleFactory = new PuzzleFactory();
        ToyFactory brickFactory = new BrickFactory();

        Toy puzzle = puzzleFactory.createToy();
        ToyPart puzzlePiece = puzzleFactory.createToyPart();

        Toy brick = brickFactory.createToy();
        ToyPart brickPiece = brickFactory.createToyPart();

        // Gioca con i giocattoli
        puzzle.play();
        brick.play();

        // Assembla le parti dei giocattoli
        puzzlePiece.assemble();
        brickPiece.assemble();
    }
}
```