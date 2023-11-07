# Cloud computing

Il **Cloud** è un **modello** che consente di accedere tramite una rete ad un **pool condiviso** di risorse di calcolo (reti, server, storage, applicazioni etc...)

Le risorse sono fornite dal Cloud Services Provider.

E' un modo innovativo di utilizzare l'ICT, dove servizi flessibili e scalabili possono essere forniti on demand. Quindi, i dati, le applicazioni, le piattaforme e le infrastrutture hardware sono alla portata di tutti attraverso internet.

Il **Cloud Computing** consisente nell'esecuzione del carico di lavoro in ambiente cloud.

Internet come **estensione del computer** visto che non solo i dati, ma anche i software risiedono online, i dati non risiedono presso server locali, ma presso server remoti collegati via internet.

Gli utenti acquisiscono e utilizzano risorse in base alle esigenze, quindi pagano i servizi a consumo.

- **Pro**: alta accessibilità, no manutenzione server
- **Contro**: bassa configurabilità

## Diversi livelli di cloud
- **SaaS (Software as a Service)** -> tutta la gestione è delegata al fornitore
- **PaaS (Platform as a Service)** -> si può gestire il tipo di ambiente di programmazione
- **IaaS (Infrastructure as a Service)** -> si può gestire il tipo di ambiente di programmazione

## Ambiente Multitenant
Il cloud è un ambiente **multitenant**.

**Architettura Software** -> Più istanze di una o più applicazioni operando in modo indipendente in un ambiente condiviso.

Le istante sono chiamate "**tenant**". Sono separate logicamente pur rimanendo fisicamente sullo stesso HW.

**TRUSTED MULTITENANT CLOUD** -> Robustezza e sicurezza

In base alla sicurezza bisogna:
- **Gestire e controllare l'identià deglo utenti**
- **Allocare le risorse in base alle ricerche degli utenti**
- **Garantire l'accesso eslusivo alle risorse di ciascun utente**
- **Eslcudere le possibilità che un utente possa interferire con le attività di altri utenti**

Un'app multitenant può soddisfare le esigenze di più tenant condividendo risorse.

Un'app tradizionale "**single tenant**" richiede un set di risorse (hw, sw, network etc...) per soddisfare le esigenze di una singola organizzazione.

Quali sono i vantaggi di una architettura multitenant

**Risparmio di denaro**: per un singolo utente, pagare per l'accesso a un servizio cloud o a un'applicazione SaaS è spesso più conveniente rispetto all'esecuzione di HW e SW a tenant singolo

**Flessibilità**: allocare pool di risorse per gli utenti quando ne hanno bisogno

**Efficenza**: singoli utenti non si devono preoccupare di gestire la menutenzione, gli aggiornamenti e l'infrastruttura

## Sistemi On-premise

Letteralmente "**in sede**", fornitura di software installati e gestiti su pc locali. Il sistema è installato/erogato nel luogo dove è utilizzato.

In contrapposizione al software come servizio (SaaS).

Lavoro aggiuntivo in termini di aggiornamenti, bug fixing.

I dati rimangono in possesso dall'utente. A differenza del cloud dove le informazioni vengono trasmesse su server remoti.

- **Pro**: totalmente configurabile ed espandibile
- **Contro**: costi di manutenzione, aggiornamento, sicurezza

## Da On-premise al Cloud

![cloud.png](cloud_resources%2Fcloud.png)

## IaaS (Infrastructure as a Service) - Host
Fornisce all'azienda server, reti, spazio di archiviazione, backup in genere con pagamento a consumo.

L'utente (software house) non gestisce l'infrastruttra hardware sottostante, ma ha il controllo dei sistemi operativi, dei dati, delle applicazioni etc...

Può installare, gestire e configurare il software.

Esempi di provider Iaas: **Microsoft Azure, Amazon AWS, Google Compute Engine**.

## PaaS (Platform as a Service) - Build
E' rivolto agli sviluppatori.

Consente agli sviluppatori e agli utenti delle aziende di sviluppare e distribuire applicazioni.

Non serve prepccuparsi della configurazione e manutenzione del server.

Il cloud provider fornisce la "**solution stack**" contenente i linguaggi di programmazione, i servezi, le librerie etc.. per consentire lo sviluppo di applicazioni da parte delle software house.

## SaaS (Software as a Service) - Consume

Prevede che il **software** sia erogato come servizio da un Cloud Provider.

Gli utenti possono usufruire pagando un corrispettivo mensile/annuale.
Esistono anche SaaS gratuiti come Google Gmail, Microsoft Office 356, Business Central etc...

Invece di acquistare, installare ed aggiornare il software sul proprio computer, è possibile utilizzare un servizio cloud tramite browser.

L'utente non gestisce e controlla l'infrastruttura inclusa la rete, i sitemi operativi etc...

## Riepilogo
![riepilogo.png](cloud_resources%2Friepilogo.png)






