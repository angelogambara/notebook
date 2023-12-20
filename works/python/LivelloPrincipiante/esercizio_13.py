# Scrivi una semplice funzione che converta un dato numero di giorni, ore e minuti, passati dall'utente tramite
# funzione input, in secondi.

import sys


def main():
    da_giorni = int(input("Inserire un numero di giorni: ")) * 24 * 3600
    da_ore = int(input("Inserire un numero di ore: ")) * 3600
    da_minuti = int(input("Inserire un numero di minuti: ")) * 60
    print(f"Data espressa in secondi: {da_giorni + da_ore + da_minuti}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
