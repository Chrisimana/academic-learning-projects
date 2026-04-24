kode_protein = {
    'AUG': 'Methionine',
    'UUU': 'Phenylalanine', 'UUC': 'Phenylalanine',
    'UUA': 'Leucine', 'UUG': 'Leucine',
    'UCU': 'Serine', 'UCC': 'Serine', 'UCA': 'Serine', 'UCG': 'Serine',
    'UAU': 'Tyrosine', 'UAC': 'Tyrosine',
    'UGU': 'Cysteine', 'UGC': 'Cysteine',
    'UGG': 'Tryptophan',
    'UAA': 'STOP', 'UAG': 'STOP', 'UGA': 'STOP'
}

def rna_protein(rna):
    protein = []
    for i in range(0, len(rna), 3):
        kodon = rna[i:i+3]
        if kodon in kode_protein:
            if kode_protein[kodon] == 'STOP':
                break
            protein.append(kode_protein[kodon])
    return protein

if __name__ == "__main__":
    rna = input("Masukkan RNA: ").upper()
    hasil_protein = rna_protein(rna)
    if hasil_protein:
        print("Nama protein:", ", ".join(hasil_protein))
    else:
        print("Tidak ada protein yang diterjemahkan.")