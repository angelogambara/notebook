# Scrivi una funzione che, a scelta dell'utente, calcoli l'area di: un cerchio, un quadrato, un rettangolo,
# un triangolo.

import math
import sys

from pick import pick


def callback(indice):
    if indice == 0:
        return (int(input("Inserire raggio: ")) ** 2) * math.pi
    if indice >= 1:
        valore = int(input("Inserire base: ")) * int(input("Inserire altezza: "))
        if indice != 3:
            return valore
        if indice == 3:
            return valore / 2


def main():
    options = ['Cerchio', 'Quadrato', 'Rettangolo', 'Triangolo']
    figura, indice = pick(options, 'Seleziona una delle seguenti opzioni')
    print(f"L'area del {figura.lower()} risulta {callback(indice)}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
