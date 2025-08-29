# 🛒 Mega Mart - Shopping Bill Calculator  

A **Java Swing GUI Project** that simulates a real-world shopping billing system.  
Customers can select items, apply discounts, and generate a final bill with ease.  

---

## 📌 Table of Contents  
- [Overview](#overview)  
- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Installation](#installation)  
- [Screenshots](#screenshots)  
- [Future Improvements](#future-improvements)  
- [Author](#author)  

---

## 🔹 Overview  
This project is a **desktop application built in Java using Swing and AWT**.  
It allows users to:  
- Enter their details (Name, Gender, and Mobile Number).  
- Select items from two categories (Household & Eatable).  
- Apply discounts and calculate the final bill automatically.  
- Print a formatted bill at the end.  

This was developed as a **learning project** to practice GUI development, event handling, and object-oriented programming concepts in Java.  

---

## ✨ Features  
- ✅ Customer detail input (Name, Gender, Mobile Number with validation – must be **10 digits only**).  
- ✅ Item selection from two categories:  
  - 🏠 Household Materials (Soap, Surf, Tide, etc.)  
  - 🍪 Eatable Materials (Biscuits, Namkeen, etc.)  
- ✅ Multiple item selection supported (using JList).  
- ✅ Apply discounts (0% – 50%).  
- ✅ Extra **5% discount for NEO card holders**.  
- ✅ Automatic total calculation of the bill.  
- ✅ Print final bill (displays neatly formatted bill with all items and prices).  
- ✅ Clean and user-friendly **Java Swing GUI**.  

---

## 🛠 Tech Stack  
- **Java** (Core Java, Swing, AWT)  
- **GUI Components**: JFrame, JLabel, JTextField, JList, JComboBox, JCheckBox, JRadioButton, JButton  
- **IDE**: (Eclipse / IntelliJ / VS Code – whichever you used)  

---

## 🚀 Installation  

Follow these steps to run the project on your system:  

```bash
# Clone this repository
git clone https://github.com/your-username/mega-mart-java.git  

# Navigate to the project folder
cd mega-mart-java  

# Compile the Java file
javac shopping.java  

# Run the program
java shopping
