def bilangan_prima(P):
    if P <= 1:
        return False
    for i in range(2, int(P**0.5) + 1):
        if P % i == 0:
            return False
    return True

P = int(input("Masukkan angka: "))
if bilangan_prima(P):
    print(f"{P} adalah bilangan prima.")
else:
    print(f"{P} bukan bilangan prima.")