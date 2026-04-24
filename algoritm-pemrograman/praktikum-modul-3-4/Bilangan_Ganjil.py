G = int(input("Bilangan ganjil : "))
if G > 0:
    if G % 2 == 0:
        G -= 1
    while G > 0:
        print(G, end = " ")
        G -= 2