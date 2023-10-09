---
title: Guida completa alle chiavi SSH su GitHub
author: Angelo Gambara
date: Lunedì 9 ottobre 2023
---

\newpage

# Guida completa alle chiavi SSH su GitHub

## Generare una chiave SSH su Windows e Linux

Copia-e-incollate il seguente comando nel terminale per generare una coppia di chiavi SSH, utilizzando il cifrario asimmetrico RSA di lunghezza 4096 bytes.

```
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

Una volta inserita la password due volte, create uno shell script con il seguente contenuto, e chiamatelo `ssh-login`. Dopodiché rendete lo script eseguibile dal terminale, usando il comando `chmod +x ssh-login`.

```
#!/bin/sh
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
```

Questo script si occuperà di inizializzare l'agente ssh, copiando il percorso del suo socket nell'apposita variabile d'ambiente così che altri processi possano farne buon uso. Per eseguire lo script, specificate il suo percorso relativo nel terminale in questo modo: `./ssh-login` ('.' significa questa cartella).

## Aggiungere la chiave pubblica su GitHub

Una volta loggati su GitHub, navigate nelle impostazioni tramite il bottone in alto a destra. Nella sezione "Accesso" troverete la voce "Chiavi GPG e SSH".

Da lì, cliccate su "Nuova chiave SSH", e copia-e-incollate il contenuto della vostra chiave pubblica. Per verificare che tutto funzioni correttamente, inserite il seguente comando nel terminale: `ssh -T git@github.com`.

Se tutto è andato a buon fine, GitHub vi comunicherà che siete riusciti ad autenticarvi ma che il loro servizio non prevede l'accesso tramite shell.

Se invece riscontrate problemi, la ragione può essere una delle seguenti:

1. L'agente ssh non è operativo (`pgrep ssh-agent`).
2. La variabile d'ambiente del socket non è definita (`echo $SSH_SOCK_AUTH`).
3. La chiave privata non è stata aggiunta all'agente ssh (`ssh-add -L`).

## Utilizzare SSH al posto di HTTP con git

Prima di poter usare comandi che si connettono online, come `git push` o `git pull`, dovete specificare lo URL del vostro repository remoto. Siccome è possibile avere più di un remoto configurato, a questi viene assegnato un nome: la convenzione è quella di chiamare il remoto principale `origin`.

Per ottenere lo URL del vostro remoto, navigate fino alla pagina del repository su GitHub. Ora, loggate se non l'avete ancora fatto, e cliccate sul bottone verde: vi uscirà scritta la voce SSH. Copiate lo URL e inseritelo nel seguente comando: `git remote add origin <remote>`
