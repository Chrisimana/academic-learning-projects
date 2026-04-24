def proses_berkas(nama_berkas):
    try:
        with open(nama_berkas, 'r') as file:
            teks = file.read()
        kata_list = teks.split()
        posisi_kata = []
        for i, kata in enumerate(kata_list, start=1):
            posisi_kata.append((kata, i))
        print("Daftar kata sama posisi dalam berkas:")
        for kata, posisi in posisi_kata:
            print(f"{kata} - posisi {posisi}")
    except FileNotFoundError:
        print("Error: Berkas tidak ditemukan. Pastikan nama berkas dan lokasinya benar.")
    except Exception as e:
        print(f"Terjadi kesalahan: {e}")

nama_berkas = input("Masukkan nama berkas teks: ")
proses_berkas(nama_berkas)