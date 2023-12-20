# Scrivi una funzione che, dato in ingresso un valore espresso in metri, mandi in print l'equivalente in miglia
# terrestri, iarde, piedi e pollici. Come risolverai questo esercizio?

import sys


def callback(metri):
    mappa = dict()
    mappa["miglia"] = metri / 1609.3440
    mappa["piedi"] = metri * 3.280840
    mappa["pollici"] = metri * 39.37008
    mappa["iarde"] = metri * 1.093613
    return mappa


def main():
    metri = int(input("Inserire una lunghezza in metri: "))
    for key, value in callback(metri).items():
        print(f"{key}: {value}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
