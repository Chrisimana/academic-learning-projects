def buat(baris, kolom):
    matriks = {}
    for i in range(baris):
        matriks[i] = [0] * kolom
    return matriks

def input_matriks(matriks, baris, kolom):
    for i in range(baris):
        for j in range(kolom):
            matriks[i][j] = int(input(f"Masukkan angka [{i}][{j}]: "))

def tampilkan(matriks):
    for i in matriks:
        print(matriks[i])

def perkalian(A, B, baris_A, kolom_A, kolom_B):
    hasil = buat(baris_A, kolom_B)
    for i in range(baris_A):
        for j in range(kolom_B):
            total = 0
            for k in range(kolom_A):
                total += A[i][k] * B[k][j]
            hasil[i][j] = total
    return hasil

def menu():
    A = None
    B = None
    baris_A = kolom_A = baris_B = kolom_B = 0
    while True:
        print("======== MENU ========")
        print("1. Buat Matriks A")
        print("2. Buat Matriks B")
        print("3. Tampilkan Matriks")
        print("4. Perkalian Matriks")
        print("5. Keluar")
        pilihan = input("Pilih menu: ")
        
        if pilihan == "1":
            baris_A = int(input("Masukkan jumlah baris: "))
            kolom_A = int(input("Masukkan jumlah kolom: "))
            A = buat(baris_A, kolom_A)
            print("Angka untuk matriks: ")
            input_matriks(A, baris_A, kolom_A)
            print("Matriks A berhasil dibuat.")
        elif pilihan == "2":
            baris_B = int(input("Masukkan jumlah baris: "))
            kolom_B = int(input("Masukkan jumlah kolom: "))
            if kolom_A != baris_B:
                print("Jumlah kolom A dan baris B harus sama!")
            else:
                B = buat(baris_B, kolom_B)
                print("Angka untuk matriks:")
                input_matriks(B, baris_B, kolom_B)
                print("Matriks B berhasil dibuat.")
        elif pilihan == "3":
            if A is not None:
                print("Matriks A: ")
                tampilkan(A)
            else:
                print("Matriks A belum dibuat!")
            if B is not None:
                print("Matriks B: ")
                tampilkan(B)
            else:
                print("Matriks B belum dibuat!")
        elif pilihan == "4":
            if A is not None and B is not None:
                if kolom_A != baris_B:
                    print("Jumlah kolom A dan baris B harus sama!")
                else:
                    hasil = perkalian(A, B, baris_A, kolom_A, kolom_B)
                    print("Hasil perkalian matriks A dan B: ")
                    tampilkan(hasil)
            else:
                print("Harap masukkan matriks A dan B terlebih dahulu!")
        elif pilihan == "5":
            print("Terima kasih telah menggunakan, program akan dihentikan...")
            break
        else:
            print("Pilihan salah!! Silahkan coba lagi.")

menu()