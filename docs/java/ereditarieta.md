# Ereditarietà
***
In Java, l'**ereditarietà** è un concetto
fondamentale della programmazione
orientata agli oggetti (**OOP**) che
consente a una classe di ereditare
le caratteristiche (come campi e metodi)
da un'altra classe. \

Questo **significa** che una classe
può basarsi su una classe
esistente per r**iutilizzare
le sue funzionalità e aggiungerne di nuove.**
***
#### Perché abbiamo bisogno dell'ereditarietà in Java?

1. **Riutilizzo** del Codice: Il codice scritto nella superclasse è comune a tutte le sottoclassi. Le classi figlie possono utilizzare direttamente il codice della classe genitore.

2. **Sovrascrittura di Metodi**: La sovrascrittura di metodi è possibile solo attraverso l'ereditarietà. È uno dei modi con cui Java raggiunge la Polimorfismo a Run Time.

3. **Astrazione**: Il concetto di astrazione, in cui non è necessario fornire tutti i dettagli, è realizzato attraverso l'ereditarietà. L'astrazione mostra solo la funzionalità all'utente.
***
### Terminologia Importante Usata nell'Ereditarietà in Java

1. **Classe**: Una classe è un insieme di oggetti che condividono caratteristiche e proprietà comuni. Una classe non è un'entità del mondo reale, ma piuttosto un modello o uno schema da cui vengono creati gli oggetti.

2. **Superclasse/Classe Genitore**: La classe le cui caratteristiche vengono ereditate è nota come superclasse (o classe di base o classe genitore).

3. **Sottoclasse/Classe Figlia**: La classe che eredita da un'altra classe è detta sottoclasse (o classe derivata, estesa o classe figlia). La sottoclasse può aggiungere i propri campi e metodi oltre a quelli della superclasse.

4. **Riutilizzo**: L'ereditarietà supporta il concetto di "riutilizzo", cioè quando vogliamo creare una nuova classe e esiste già una classe che include parte del codice che desideriamo, possiamo derivare la nostra nuova classe dalla classe esistente. In questo modo, riutilizziamo i campi e i metodi della classe esistente.
***
### Come utilizzare l'ereditarietà in Java?

In Java, si utilizza la parola chiave "**extends**" per l'ereditarietà. L'uso della parola chiave "extends" indica che stai derivando da una classe esistente. In altre parole, "extends" si riferisce all'aumento della funzionalità.


Esempio: Nell'esempio di ereditarietà seguente, la classe Employee è una classe di base, la classe Engineer è una classe derivata che estende la classe Employee e la classe Test è una classe driver per eseguire il programma.
``` Java
// Java Program to illustrate Inheritance (concise)

import java.io.*;

// Base or Super Class
class Employee {
	int salary = 60000;
}

// Inherited or Sub Class
class Engineer extends Employee {
	int benefits = 10000;
}

// Driver Class
class Gfg {
	public static void main(String args[])
	{
		Engineer E1 = new Engineer();
		System.out.println("Salary : " + E1.salary
						+ "\nBenefits : " + E1.benefits);
	}
}

```
Output:
``` Java
Salary : 60000
Benefits : 10000
```
***
Consiglio di indagare autonomamente circa ai seguenti tipi di ereditarietà:

- Single Inheritance
- Multilevel Inheritance
- Hierarchical Inheritance
- Multiple Inheritance
- Hybrid Inheritance
***
### Conclusioni

Verifichiamo alcuni punti importanti dall'articolo, elencati di seguito:

1. **Superclasse predefinita**: Ad eccezione della classe Object, che non ha alcuna superclasse, ogni classe ha una e una sola superclasse diretta (ereditarietà singola). In assenza di qualsiasi altra superclasse esplicita, ogni classe è implicitamente una sottoclasse della classe Object.

2. Può esserci solo **una** **superclasse**: Una superclasse può avere qualsiasi numero di sottoclassi. Ma una sottoclasse può avere solo una superclasse. Ciò è dovuto al fatto che Java non supporta l'ereditarietà multipla con le classi. Tuttavia, con le interfacce, Java supporta l'ereditarietà multipla.

3. **Ereditarietà dei costruttori**: Una sottoclasse eredita tutti i membri (campi, metodi e classi nidificate) dalla sua superclasse. I costruttori non sono membri, quindi non vengono ereditati dalle sottoclassi, ma il costruttore della superclasse può essere invocato dalla sottoclasse.

4. **Ereditarietà dei membri privati**: Una sottoclasse non eredita i membri privati della sua classe genitore. Tuttavia, se la superclasse ha metodi pubblici o protetti (come i getter e i setter) per accedere ai suoi campi privati, questi possono essere utilizzati anche dalla sottoclasse.
***
Aggiunta da Fra:
Argomento enorme ed alquanto complicato ogni volta che si prova a studiarlo :(
***