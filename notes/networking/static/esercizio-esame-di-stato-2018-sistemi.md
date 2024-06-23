# Esame di Stato 2018 Sistemi e Reti

## PRIMA PARTE - 2

Questo punto è riguardante la sicurezza delle varie risorse di rete di ciascuna start-up. Rispondiamo alla tematica con ordine:

Come proteggere una start-up da attacchi esterni?

Nulla di più semplice, il firewall interno è fatto per questo. Ne installiamo uno per interfaccia, escludendo quelle per i server, con la regola ACL `deny any`. Questa regola non bloccherà le risposte alle richieste provenienti dalle suddette sottoreti private (Piccola precisazione).

Come proteggere i server da attacchi esterni?

Ora, configurare un firewall esterno richiede più considerazioni. In particolare, dobbiamo permettere al server web, collocato nella DMZ (il confine tra rete privata e pubblica), di poter comunicare con la nostra base di dati. È necessario inoltre limitare il traffico proveniente dal mondo esterno ai servizi offerti dalle nostre startup. Le ACL saranno simili alle seguenti:

```
access-list 140 permit tcp 192.168.1.0 0.0.0.15 any eq 3306
access-list 150 permit tcp any 192.168.1.0 0.0.0.15 eq 0443
```

Come proteggere una start-up e i sui server da attacchi interni?
La sicurezza di una LAN viene spesso erroneamente trascurata, ma con le giuste precauzioni è possibile arginare anche il più riuscito attacco d'ingenieria sociale (L'attacco preferito dai film, dove l'hacker elude il personale di sicurezza fingendosi di essere una figura importante per l'azienda, vedi CEO).

1. Educazione del personale => Documenti sensibili, password, disconnessione
2. Crittografia postazioni  => BitLocker
3. Autenticazione degli utenti => RADIUS Server
4. Comunicazioni con lo switch => MACSec (Richiede RADIUS)
5. Comunicazioni con il router => WPA2-Enterprise (Richiede RADIUS)

## SECONDA PARTE - 2

Oggigiorno le aziende che offrono un servizio in cloud e che mantengono software fisicamente sono considerate l'eccezzione. I vantaggi della virtualizzazione sono molteplici, ben oltre la riduzione dei costi. In primis, la possibilità di sviluppare software in un ambiente indipendente dal sistema operativo sottostante, in due parole: scalabilità e flessibilità. Questo particolare approccio al cloud computing permette inoltre di ospitare in sicurezza più aziende sullo stesso server fisico, essendo le macchine virtuali isolate (Non molto indicato nel caso delle nostre due start-up, in quanto essendo innovative per definizione si occuperanno di siti ecommerce o applicazioni web, le quali richiedono le piene risorse di un server dedicato. Preciso che, ciò non significa che non potranno utilizzare macchine virtuali, anzi senz'ombra di dubbio ne faranno uso, ma non per "affitare casa".).

Infine, il vantaggio più grande della virtualizzazione è decisamente quello del ripristino di un database dopo una violazione di dati o un disastro naturale: infatti, grazie alla funzionalità di snapshotting, dove viene fatto un backup dell'imagine di una macchina virtuale, è possibile sopravvivere sul mercato come azienda (E ti pare poco?!).

## SECONDA PARTE - 3

L'ottimizzazione della banda di rete è il compito principale di un server proxy. Questo server esegue il caching (e il load balancing) delle richieste web, siano esse esterne o interne, risparmiando ai server di ricalcolare un risultato o agli host di re-inviare richieste già risposte. Il server proxy, essendo posizionato prima del router, viene spesso utilizzato anche per monitorare il traffico: si parla in questo caso di proxy-firewall.

Un'altra soluzione molto più efficace sarebbe l'utilizzo di un CDN di terze parti, come Cloudflare (Molto vantaggioso perché risparmi banda di rete e guadagni in velocità, sicurezza ed affidabilità). In poche parole, un CDN altro non è che una rete distribuita di server presente su scala globale e raggiungibile in un batter d'occhio.
