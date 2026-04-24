with open("teks", "w") as file:
    file.write("Python adalah bahasa yang serbaguna,\n")
    file.write("bahasa mendukung pengembangan aplikasi dan analisis data. \n")
    file.write("Sintaks Python yang sederhana membuatnya populer di kalangan pemula. \n")
    file.write("Komunitas Python yang besar menyediakan banyak sumber daya gratis.\n")

def ubahjadikalimat(nama_berkas):
    try:
        with open(nama_berkas, "r") as file:
            isi = file.read()
        kalimat = isi.replace("\n", " ")
        with open("kalimat test", "w") as file_hasil:
            file_hasil.write(kalimat)
        print("Berkas berhasil dibikin jadi kalimat.")

    except FileNotFoundError:
        print("Error: Berkas tidak ditemukan. Pastikan nama berkas sudah benar.")
    except IOError:
        print("Error: Terjadi masalah saat membaca atau menulis berkas.")
    except Exception as e:
        print(f"Error yang tidak terduga: {e}")

ubahjadikalimat("teks")