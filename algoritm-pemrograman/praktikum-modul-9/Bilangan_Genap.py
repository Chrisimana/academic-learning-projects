def genap(a, b):
    if a > b:
        return 0
    elif a % 2 == 0:
        return a + genap(a + 2, b)
    else:
        return genap(a + 1, b)

a = int(input("Masukkan batas atas: "))
b = int(input("Masukkan batas bawah: "))
hasil = genap(a, b)
print(f"Jumlah bilangan genap dari {a} sampai {b} adalah {hasil}.")