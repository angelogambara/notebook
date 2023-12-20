# Scrivi una funzione che data in ingresso una lista A contenente n parole, restituisca in output una lista B di
# interi che rappresentano la lunghezza delle parole contenute in A.

import sys


def oneline(parole):
    return [len(w) for w in parole]


def callback(parole):
    lunghezza = []
    for w in parole.split():
        lunghezza.append(len(w))
    return lunghezza


def main():
    parole = input("Inserire una lista di parole: ")
    print(f"Lunghezza delle parole: {callback(parole)}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
