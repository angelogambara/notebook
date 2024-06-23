---
title: Teorema del valore medio di Lagrange
date: Sunday 8 October, 2023
author:
  - Marco Pellini
  - Angelo Gambara
  - \st{Rayan Bechir}
header-includes: |
    \usepackage{soul}
---

\tableofcontents

# Teorema del valore medio di Lagrange

## Spiegazione enunciato

> Se una funzione $f(x)$ è continua in un intervallo chiuso $[a;b]$ ed è
> derivabile in ogni punto interno a esso, esiste almeno un punto $c$ interno
> ad $[a;b]$ per cui vale la relazione: $\frac{f(b)-f(a)}{b-a} = f'(c)$.

Per la spiegazione dell'enunciato, fare riferimento al libro `4A Matematica.verde` a pagina 1062. Lì potete trovare anche un controesempio dove le ipotesi del teorema rimangono non verificate.

\newpage

## Significato geometrico

![Se le ipotesi del teorema sono soddisfatte, l'enunciato essenzialmente garantisce l'esistenza di almeno un punto nel quale la retta tangente è parallela alla retta secante. Ovvero, hanno lo stesso coefficiente angolare.](../assets/teorema-di-lagrange.svg){width=75%}

Come ora mai abbiamo a cuore, il significato grafico della derivata di una funzione è **il coefficiente angolare della retta tangente** in un suo punto generico. Se volessimo scrivere la funzione della retta tangente in quel punto scriveremmo: $y-y_0 = f'(x_0)\cdot(x-x_0)$. E che dire della retta secante?

Innanzitutto, ricordiamo che $f'(c)$ è in realtà un'abbreviazione per $\lim\limits_{h\to0} \frac{f(c+h)-f(c)}{h}$. In teoria dovremmo già sapere come calcolare il coefficiente angolare di una retta secante, ma siccome trattiamo di argomenti di quinta tenterò di essere più inclusivo.

Il coefficiente angolare della retta secante è dato **dal rapporto incrementale** di $f$ nel punto $c$ (o relativo a $c$). Qui è la stessa cosa, solo che al posto di $c$ il teorema usa $a$ e $b$, e al posto di $\frac{f(c+h)-f(c)}{h}$ usa $\frac{f(b)-f(a)}{b-a}$. Ancora confuso?

Consideriamo il triangolo $\overline{ABH}$, dove il punto H si trova all'intersezione dei punti $A$ e $B$. Grazie all'acronimo inglese SOH-CAH-TOA, siamo in grado di calcolare il coefficiente angolare della retta secante:

> $\tan\alpha = \frac{\overline{HB}}{\overline{AH}} = \frac{\Delta{y}}{\Delta{x}} = \frac{f(b)-f(a)}{b-a}$

Oppure, possiamo semplicemente ricordarci la formula “rise over the run”, che ci insegna che la pendenza si calcola mettendo a numeratore l'incremento verticale e a denominatore quello orizzontale.

\newpage

## Dimostrazione pratica

Data una funzione $f(x)=\sqrt[3]{x}$, verifichiamo che nell'intervallo $[0;27]$ valgano le ipotesi del teorema di Lagrange e troviamo i punti la cui esistenza è assicurata dal teorema.

### Verifichiamo le ipotesi

1. La funzione $f(x)=\sqrt[3]{x}$ è irrazionale con indice dispari: il dominio di $x$ è $\mathbb{R}$, quindi è continua nell'intervallo $[0;27]$;
2. La sua derivata è $f'(x) = \frac{1}{3} x^{\frac{1}{3}-1} = \frac{1}{3\sqrt[3]{x^2}}$: la funzione è derivabile in $]0;27[$.

### Troviamo i punti

> $\frac{1}{3\sqrt[3]{c^2}} = \frac{f(27)-f(0)}{27} = \frac{3}{27} = \frac{1}{9} \rightarrow \sqrt[3]{c^2} = 3 \rightarrow c^2 = 27 \rightarrow c = \pm\sqrt{27}$

Solo $c=\sqrt{27}$ è accettabile, perché interno all'intervallo $[0;27]$.

Per verificare, reinseriamo $c=\sqrt{27}$ in $\frac{1}{3\sqrt[3]{c^2}}$ e troviamo che è uguale a $\frac{1}{9}$.

### Otteniamo la secante e la tangente

> $s(x) = \frac{1}{9}(x-0)+0 = \frac{x}{9}$

> $f(c) = \sqrt[3]{\sqrt{27}} = (27^{\frac{1}{2}})^{\frac{1}{3}} = 27^{\frac{1}{6}} = \sqrt[6]{27} \rightarrow P(\sqrt{27};\sqrt[6]{27})$

> $t(x) = \frac{1}{9}(x-\sqrt{27})+\sqrt[6]{27} = \frac{x-\sqrt{27}}{9}+\sqrt[6]{27}$

### Grafico della soluzione

![Rappresentazione grafica dell'esercizio svolto.](../assets/esempio-di-lagrange.png)
