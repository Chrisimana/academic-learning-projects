import math
a = float(input("Masukkan a: "))
b = float(input("Masukkan b: "))
c = float(input("Masukkan c: "))
D = b**2 - 4*a*c
if D < 0:
    print("Termasuk akar imajiner.")
elif D == 0:
    x = -b / (2*a)
    print("Maka nilai x1 sama x2 adalah ", x)
else:
    x1 = (-b + math.sqrt(D)) / (2*a)
    x2 = (-b - math.sqrt(D)) / (2*a)
    print("Nilai x1 = ", x1)
    print("Nilai x2 = ", x2)