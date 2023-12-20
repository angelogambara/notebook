# Scrivi una funzione che, data una stringa come parametro, restituisca un dizionario rappresentante la "frequenza di
# comparsa" di ciascun carattere componente la stringa.

import sys


def callback(testo):
    mappa = {}
    for c in testo:
        if c in mappa:
            mappa[c] += 1
        else:
            mappa[c] = 1
    return mappa


def main():
    testo = input("Inserire una linea di testo: ")
    print(f"Occorrenza dei caratteri: {callback(testo)}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
