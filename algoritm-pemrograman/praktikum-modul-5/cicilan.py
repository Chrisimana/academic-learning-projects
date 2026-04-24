harga_asal = float(input("Masukkan harga rumah asal: "))
harga_jual = float(input("Masukkan harga rumah yang dijual ke klien: "))
lama_cicilan = {1: 20, 2: 15, 3: 10, 4: 5}
pilihan = int(input("Pilih lama cicilan (1: 20 thn, 2: 15thn, 3: 10 thn, 4: 5thn): "))
if pilihan in lama_cicilan:
    cicilan_per_tahun = harga_jual / lama_cicilan[pilihan]
    print(f"\ncicilan rumah per tahun: {cicilan_per_tahun}")
else:
    print("pilihan tidak valid")