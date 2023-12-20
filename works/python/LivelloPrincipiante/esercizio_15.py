# Un indirizzo MAC (Media Access Control address) è un indirizzo univoco associato dal produttore, a un chipset per
# comunicazioni wireless (es WiFi o Bluetooth), composto da 6 coppie di cifre esadecimali separate da due punti.

import random
import sys


def callback():
    mac = ''
    for j in range(6):
        for k in range(2):
            mac += random.choice('ABCDEF0123456789')
        if j < 5:
            mac += ':'
    return mac


def main():
    print(f"Indirizzo MAC generato: {callback()}")


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        sys.exit(130)
