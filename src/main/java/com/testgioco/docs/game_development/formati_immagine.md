Le immagini possono essere caricate in due tipi di dato:
- BufferedImage
- InputStream

### BufferedImage
- E' la classica per i videogiochi.
- Rappresenta un'immagine bitmap in memoria.
- E' ottima se occorre disegnare o manipolare l'immagine.
- L'accesso ai pixel è molto semplice e rapido.

### InputStream
- Può includere più formati.
- Utile solo per la lettura (è più efficiente di BufferedImage) ma non per la manipolazione.

### RECAP
BufferedImage è ok per leggere, manipolare, disegnare un'immagine.\
InputStream è ok per la sola lettura dell'immagine.