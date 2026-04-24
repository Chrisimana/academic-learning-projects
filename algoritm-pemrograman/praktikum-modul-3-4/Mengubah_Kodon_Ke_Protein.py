kodon = input("nama kodon : ")
if kodon == "AUG":
    print("Nama Protein : Methionine")
elif kodon == "UUU" or kodon == "UUC":
    print("Nama Protein : Phenylalanine")
elif kodon == "UUA" or kodon == "UUG":
    print("Nama Protein : Leucine")
elif kodon == "UCU" or kodon == "UCC" or kodon == "UCA" or kodon == "UCG":
    print("Nama Protein : Serine")
elif kodon == "UAU" or kodon == "UAC":
    print("Nama Protein : Tyrosine")
elif kodon == "UGU" or kodon == "UGC":
    print("Nama Protein : Cysteine")
elif kodon == "UGG":
    print("Nama Protein : Tryptophan")
else:
    print("Nama kodon tidak ditemukan :(")