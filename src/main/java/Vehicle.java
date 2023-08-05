public class Vehicle extends VehicleUtility {
    public String _state;
    public String color;
    // Costruttore
    public Vehicle (String color) {
        this._state = "off";
        this.color = color;
    }

    public void aggiornaStato(){
        this._state = this.cambiaStato(this._state);
    }
}

class VehicleUtility {
    protected String cambiaStato(String stato){
        String nuovoStato = "";
        if (stato == "off")
            nuovoStato = "on";
        else if (stato == "on") {
            nuovoStato = "off";
        }
        return nuovoStato;
    }
}