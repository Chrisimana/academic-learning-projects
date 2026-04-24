def kalimat_vokal(kalimat):
    vokal = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
    kalimat_terbalik = kalimat[::-1]
    jumlah_vokal = sum(1 for huruf in kalimat if huruf in vokal)
    return kalimat_terbalik, jumlah_vokal

kalimat = input("Masukkan kalimat: ")
kalimat_terbalik, jumlah_vokal = kalimat_vokal(kalimat)
print("Kalimat terbalik: ", kalimat_terbalik)
print("Jumlah huruf vokal: ", jumlah_vokal)