print(" ")
print("\033[31mA. ")
print(" ")
n = 6
for i in range(n, 0, -1):
    print("X" * i)

print(" ")
print("\033[32mB. ")
print(" ")
n = 6
for i in range(n, 0, -2):
    print("X" * i)
    print("-" * (i - 1))

print(" ")
print("\033[33mC. ")
print(" ")
n = 6
for i in range(1, n + 1):
    for j in range(1, i + 1):
        print(j, end=" ")
    print()
for i in range(n - 1, 0, -1):
    for j in range(1, i + 1):
        print(j, end=" ")
    print()

print(" ")
print("\033[34mD. ")
print(" ")
n = 6
for i in range(1, n + 1):
    print("X" * i)
for i in range(n - 1, 0, -1):
    print("X" * i)

print(" ")
print("\033[35mE. ")
print(" ")
n = 6
for i in range(n, 0, -1):
    print("." * (i - 1) + str(i))

print("\033[37m")