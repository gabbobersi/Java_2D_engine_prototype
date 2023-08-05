
public class Main {
    public static void main (String[] args){
        // new Game();
        System.out.println("PIPPO E UN CANE");

        Vehicle veicolo1 = new Vehicle("blue");
        veicolo1.aggiornaStato();
        System.out.println("Lo stato del veicolo " + veicolo1.color + " è " + veicolo1._state);

        Vehicle veicolo2 = new Vehicle("red");
        System.out.println("Lo stato del veicolo " + veicolo2.color + " è " + veicolo2._state);


        String x = "Ciao";
        System.out.println(x + " Alessio");
    }
}
