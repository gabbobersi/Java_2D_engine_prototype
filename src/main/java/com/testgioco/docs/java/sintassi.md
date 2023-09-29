### Modificatori di accesso
```Java
class Test(){
    private int a;      // PRIVATO      Visibile a classe.
    int b;              // DEFAULT      Visibile a classe + stesso package.
    protected int c;    // PROTETTO     Visibile a classe + stesso package + sotto classi (anche in altri package).
    public int d;       // PUBBLICO     Visibile a tutti.
}
```