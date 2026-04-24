import sys
from PyQt5.QtWidgets import QApplication, QWidget, QGridLayout, QLineEdit, QPushButton, QVBoxLayout
from PyQt5.QtCore import Qt

class Calculator(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Calculator")
        self.setGeometry(100, 100, 300, 400)
        self.initUI()
    
    def initUI(self):
        main_layout = QVBoxLayout()
        self.display = QLineEdit()
        self.display.setAlignment(Qt.AlignRight)
        self.display.setReadOnly(True)
        self.display.setFixedHeight(50)
        main_layout.addWidget(self.display)
        
        grid_layout = QGridLayout()
        tombol = {
            '7': (0, 0), '8': (0, 1), '9': (0, 2), '/': (0, 3),
            '4': (1, 0), '5': (1, 1), '6': (1, 2), '*': (1, 3),
            '1': (2, 0), '2': (2, 1), '3': (2, 2), '-': (2, 3),
            '0': (3, 0), '.': (3, 1), '^': (3, 2), '+': (3, 3),
            'C': (4, 0), '=': (4, 1, 1, 3),
        }
        
        for teks, pos in tombol.items():
            tombol = QPushButton(teks)
            tombol.setFixedSize(60, 60)
            if len(pos) == 2:
                grid_layout.addWidget(tombol, pos[0], pos[1])
            else:
                grid_layout.addWidget(tombol, pos[0], pos[1], pos[2], pos[3])
            tombol.clicked.connect(self.on_tombol)
        
        main_layout.addLayout(grid_layout)
        self.setLayout(main_layout)
    
    def on_tombol(self):
        tombol = self.sender()
        text = tombol.text()
        if text == 'C':
            self.display.clear()
        elif text == '=':
            try:
                ekspresi = self.display.text().replace('^', '')
                hasil = eval(ekspresi)
                self.display.setText(str(hasil))
            except Exception as e:
                self.display.setText("Error")
        else:
            self.display.setText(self.display.text() + text)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    calc = Calculator()
    calc.show()
    sys.exit(app.exec_())