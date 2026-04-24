def buat(baris, kolom):
    matriks = {}
    for i in range(baris):
        matriks[i] = [0] * kolom
    return matriks

def tampilkan(matriks):
    for i in matriks:
        print(matriks[i])

def ubah_nilai(matriks, baris, kolom, nilai_baru):
    if baris in matriks and 0 <= kolom < len(matriks[baris]):
        matriks[baris][kolom] = nilai_baru
    else:
        print("Masukkan baris dan kolom yang benar... ")

def menu():
    matriks = None
    while True:
        print("======== MENU ========")
        print("1. Buat Matriks ")
        print("2. Tampilkan Matriks ")
        print("3. Ubah Nilai Matriks ")
        print("4. Keluar ")
        pilihan = input("Pilih menu: ")

        if pilihan == "1":
            baris = int(input("Masukkan jumlah baris yang diinginkan: "))
            kolom = int(input("Masukkan jumlah kolom yang diinginkan: "))
            matriks = buat(baris, kolom)
            print("Matriks berhasil ditambahkan. ")
        elif pilihan == "2":
            if matriks:
                print("Matriks yang ada saat ini: ")
                tampilkan(matriks)
            else:
                print("Belum ada matriks yang dibuat ")
        elif pilihan == "3":
            if matriks:
                baris = int(input("Masukkan nomor baris yang ingin diubah: "))
                kolom = int(input("Masukkan nomor kolom yang ingin diubah: "))
                nilai_baru = int(input("Masukkan nilai yang baru: "))
                ubah_nilai(matriks, baris, kolom, nilai_baru)
                print("Nilai matriks berhasil diubah. ")
            else:
                print("Belum ada matriks yang dibuat ")
        elif pilihan == "4":
            print("Terima kasih telah menggunakan, program akan dihentikan... ")
            break
        else:
            print("Pilihan salah!! Silahkan coba lagi. ")

menu()