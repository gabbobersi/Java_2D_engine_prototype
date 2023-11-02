# Regular expressions in Java (Regex)

Le espressioni regolari (regex) in Java sono rappresentate da classi del package **java.util.regex**. Queste classi consentono di cercare, estrarre e manipolare stringhe in base a modelli specifici.

_NOTA: Uno dei successi non particolarmente celebrati nei processi di standardizzazione in Computer Science sono state le regular expressions. 
Una regular expression è una formula che specifica classi di stringhe e che viene realizzata utilizzando un particolare linguaggio._

Una regular expression è una notazione algebrica per caratterizzare insiemi di stringhe. Definiscono un vero e proprio linguaggio formale che viene utilizzato 
per effettuare ricerche specifiche all'interno di un testo.

Da un punto di vista pratico, definire una regular expression, consiste nello specificare un pattern, ovvero il formato di ciò che vogliamo cercare all'interno di un testo. 
L'esecuzione della regular expression restituirà come output le occorrenze di stringhe contenute all'interno del testo stesso che sono in match con il pattern definito.

## Pattern
**Creare un Pattern**: Per iniziare a utilizzare regex in Java, devi creare un oggetto Pattern che rappresenti il modello da cercare. Puoi farlo utilizzando il metodo **Pattern.compile()**:
```Java
import java.util.regex.Pattern;
Pattern pattern = Pattern.compile("abc");
```
**Match**: Puoi utilizzare il Pattern per cercare corrispondenze in una stringa utilizzando l'oggetto **Matcher**. Ecco un esempio:
```Java
import java.util.regex.Matcher;
Matcher matcher = pattern.matcher("abcxyzabc");
while (matcher.find()) {
    System.out.println("Trovato: " + matcher.group());
}
```
_Questo codice cercherà tutte le occorrenze di "abc" nella stringa e stamperà ogni corrispondenza trovata._

| Espressione | Descrizione                                                         |
|-------------|---------------------------------------------------------------------|
| [abc]       | Trovare un singolo carattere tra le opzioni tra le parentesi quadre |
| [^abc]      | Trovare un singolo carattere NON tra le parentesi quadre            |
| [0-9]       | Trovare un singolo carattere nell'intervallo da 0 a 9               |

## Flags
Le **Flags** nel metodo compile() cambiano il modo in cui viene eseguita la ricerca. Ecco alcune di esse:

- **Pattern.CASE_INSENSITIVE** - Il caso delle lettere verrà ignorato durante la ricerca.
- **Pattern.LITERAL** - I caratteri speciali nel modello non avranno alcun significato speciale e saranno trattati come caratteri ordinari durante la ricerca.
- **Pattern.UNICODE_CASE** - Usalo insieme al flag **CASE_INSENSITIVE** per ignorare anche il caso delle lettere al di fuori dell'alfabeto inglese.

## Metacaratteri
| Metacarattere | Descrizione                                                                                                               |
|---------------|---------------------------------------------------------------------------------------------------------------------------|
| \|            | Trova una corrispondenza per una qualsiasi delle sequenze separate da \|, come ad esempio: gatto\|cane\|pesce             |
| .             | Trova solo un'istanza di qualsiasi carattere                                                                              |
| ^             | Trova una corrispondenza all'inizio di una stringa, come ad esempio: ^Ciao                                                |
| $             | Trova una corrispondenza alla fine di una stringa, come ad esempio: Mondo$                                                |
| \d            | Trova una cifra                                                                                                           |
| \s            | Trova un carattere di spazio bianco                                                                                       |
| \b            | Trova una corrispondenza all'inizio di una parola come questa: \bPAROLA, o alla fine di una parola come questa: PAROLA\b  |
| \uxxxx        | Trova il carattere Unicode specificato dal numero esadecimale xxxx                                                        |

## Quantificatori
| Quantificatore | Descrizione                                                             |
|----------------|-------------------------------------------------------------------------|
| n+             | Corrisponde a qualsiasi stringa che contiene almeno una n               |
| n*             | Corrisponde a qualsiasi stringa che contiene zero o più occorrenze di n |
| n?             | Corrisponde a qualsiasi stringa che contiene zero o una occorrenza di n |
| n{x}           | Corrisponde a qualsiasi stringa che contiene una sequenza di X n        |
| n{x,y}         | Corrisponde a qualsiasi stringa che contiene una sequenza di X a Y n    |
| n{x,}          | Corrisponde a qualsiasi stringa che contiene una sequenza di almeno X n |

```Java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("youtube", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Questo e' il mio canale YouTube!");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
```
Questo è solo un'introduzione alle regex in Java. Si possono creare espressioni regolari più complesse e utili in base alle tue esigenze specifiche.

_N.d.A: Le espressioni regolari sono estremamente utili in un contesto aziendale per diverse applicazioni._

_In sintesi, le regex sono uno strumento potente per gestire e manipolare dati testuali in diversi contesti aziendali, migliorando l'efficienza, l'accuratezza e l'automazione delle operazioni legate ai dati._



