import sys
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QLabel, QLineEdit, QPushButton, QTableWidget, QTableWidgetItem

class BarangApp(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Data Barang Beserta Harganya")
        self.setGeometry(200, 200, 400, 400)
        self.initUI()
    
    def initUI(self):
        main_layout = QVBoxLayout()
        input_layout = QHBoxLayout()
        self.barang_input = QLineEdit(placeholderText="Nama Barang")
        self.harga_input = QLineEdit(placeholderText="Harga Barang")
        input_layout.addWidget(QLabel("Barang:"))
        input_layout.addWidget(self.barang_input)
        input_layout.addWidget(QLabel("Harga:"))
        input_layout.addWidget(self.harga_input)
        self.tambah_button = QPushButton("Tambahkan")
        self.tambah_button.clicked.connect(self.tambah_barang)
        self.table = QTableWidget(0, 2)
        self.table.setHorizontalHeaderLabels(["Barang", "Harga"])
        main_layout.addLayout(input_layout)
        main_layout.addWidget(self.tambah_button)
        main_layout.addWidget(self.table)
        self.setLayout(main_layout)
    
    def tambah_barang(self):
        barang = self.barang_input.text()
        harga = self.harga_input.text()
        if barang and harga:
            row_position = self.table.rowCount()
            self.table.insertRow(row_position)
            self.table.setItem(row_position, 0, QTableWidgetItem(barang))
            self.table.setItem(row_position, 1, QTableWidgetItem(harga))
            self.barang_input.clear()
            self.harga_input.clear()

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = BarangApp()
    window.show()
    sys.exit(app.exec_())