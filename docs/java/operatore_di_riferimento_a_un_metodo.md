`ClassName::methodName`

### Generale
In Java, l'operatore di riferimento a un metodo (o operatore di riferimento a un metodo di classe, oppure "double colon")\
permette di riferirsi a un metodo, direttamente tramite la sua classe.

Il suo funzionamento è il medesimo delle lambda:
```Java
// Lambda
stream.forEach(s -> System.out.println(s));

// Operatore di riferimento a un metodo
stream.forEach(System.out::println);
```

### Come usarlo
Può essere utilizzare per referenziare:
- Metodi statici
- Metodi di istanza
- Costruttori

### Esempi
#### Costruttore
Notare l'utilizzo del `new` come riferimento al metodo.
```Java
class Test { 
    public Test(String s) { 
        System.out.println("Ciao " + s); 
    } 

    // main applicazione
    public static void main(String[] args) 
    { 
        List<String> list = new ArrayList<String>(); 
        list.add("Giamma"); 
        list.add("Gabri"); 
        list.add("Alessio"); 

        // Chiamo il metodo costruttore di "Test" per ogni elemento della lista.
        list.forEach(Test::new); 
    } 
}
```
#### Super
Notare l'utilizzo del `super` come riferimento alla classe padre.
```Java
class Padre { 
    String print(String str) 
    { 
        return ("Hello " + str + "\n"); 
    } 
} 
  
class Test extends Padre { 
    @Override
    String print(String s) 
    { 
  
        // Chiamo il metodo "print" della classe padre
        Function<String, String> func = super::print; 
  
        String newValue = func.apply(s); 
        newValue += "Bye " + s + "\n"; 
        System.out.println(newValue); 
  
        return newValue; 
    } 
  
    // main applicazione
    public static void main(String[] args) 
    { 
  
        List<String> list = new ArrayList<String>(); 
        list.add("Geeks"); 
        list.add("For"); 
        list.add("GEEKS"); 
  
        // call the instance method 
        // using double colon operator 
        list.forEach(new GFG()::print); 
    } 
} 
```
#### Metodo statico
```Java
list.forEach(GFG::someFunction); 
```
#### Metodo di istanza
```Java
list.forEach((new GFG())::someFunction);
```
