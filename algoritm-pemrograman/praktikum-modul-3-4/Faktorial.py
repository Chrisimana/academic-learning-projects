angka = int(input("Masukkan angka : "))
faktorial = 1
penjabaran = ""
for i in range(angka, 0, -1):
    faktorial *= i
    if i == 1:
        penjabaran += str(i)
    else:
        penjabaran += str(i) + " x "
print(f"{angka}! = {penjabaran} = {faktorial}")