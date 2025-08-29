import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class shopping {
    JFrame f1;
    JLabel l1, l2, l3, l4, l5, l6, resultLabel;
    JTextField t1, t2;
    JList<String> listHousehold, listEatables;
    JRadioButton rb1, rb2;
    JCheckBox b1;
    JButton calcBtn;
    Container c;

    shopping() {
        f1 = new JFrame("SHOPPING MART: SHOPPING CALC");
        f1.setVisible(true);
        f1.setSize(650, 650);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = f1.getContentPane();
        c.setBackground(Color.PINK);

        l1 = new JLabel("Enter Customer Name");
        l1.setBounds(20, 40, 180, 20);
        t1 = new JTextField();
        t1.setBounds(180, 40, 200, 20);

        l2 = new JLabel("Enter mobile number");
        l2.setBounds(20, 100, 150, 20);
        t2 = new JTextField();
        t2.setBounds(180, 100, 180, 20);

        l3 = new JLabel("Select items");
        l3.setBounds(20, 160, 100, 20);

        // Household materials
        String s1[] = {"BathSoap", "SurfExcel", "Tide", "VimBar", "Lizol", "Harpic", "Shampoo", "Cinthol","Handwash", "Shaving blades",};
        listHousehold = new JList<>(s1);
        listHousehold.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listHousehold.setSelectionModel(new DefaultListSelectionModel() {
    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (isSelectedIndex(index0)) {
            removeSelectionInterval(index0, index1);
        } else {
            addSelectionInterval(index0, index1);
        }
    }
});
        JScrollPane sp1 = new JScrollPane(listHousehold);
        sp1.setBounds(120, 160, 120, 100);

        // Eatable materials
        String s2_items[] = {"Parle-G","GoodDay","Oreo","Coconut biscuit", "Haldiram Namkeen", "Chips", "Juice", "Chocolate", "Bread", "Frooti"};
        listEatables = new JList<>(s2_items);
        listEatables.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listEatables.setSelectionModel(new DefaultListSelectionModel() {
    @Override
    public void setSelectionInterval(int index0, int index1) {
        if (isSelectedIndex(index0)) {
            removeSelectionInterval(index0, index1);
        } else {
            addSelectionInterval(index0, index1);
        }
    }
});
        JScrollPane sp2 = new JScrollPane(listEatables);
        sp2.setBounds(260, 160, 120, 100);

        l5 = new JLabel("Select discount");
        l5.setBounds(20, 300, 180, 20);
        String s2[] = {"0%","10%", "20%", "30%", "40%", "50%"};
        JComboBox<String> cb2 = new JComboBox<>(s2);
        cb2.setBounds(120, 300, 100, 20);

        l6 = new JLabel("Select Gender");
        l6.setBounds(20, 360, 180, 20);
        rb1 = new JRadioButton("Male");
        rb1.setBounds(220, 360, 80, 20);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(320, 360, 80, 20);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        b1 = new JCheckBox("NEO Card Special customer (5% extra discount)");
        b1.setBounds(180, 400, 320, 20);

        calcBtn = new JButton("Calculate Total");
        calcBtn.setBounds(220, 440, 150, 30);

        resultLabel = new JLabel("Final Price: ");
        resultLabel.setBounds(20, 500, 600, 100);

        // Add components
        c.add(l1); c.add(t1);
        c.add(l2); c.add(t2);
        c.add(l3); c.add(sp1); c.add(sp2);
        c.add(l5); c.add(cb2);
        c.add(l6); c.add(rb1); c.add(rb2);
        c.add(b1); c.add(calcBtn); c.add(resultLabel);

        calcBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Declare variables outside try
        List<String> selectedHousehold = listHousehold.getSelectedValuesList();
        List<String> selectedEatables = listEatables.getSelectedValuesList();
        double totalMRP = 0.0;
        double finalPrice = 0.0;
        int discount = 0;

        String phone = t2.getText().trim();

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(f1, "Please enter a valid 10-digit phone number!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // stop further calculation
        }


        try {
            // Ask prices
            for (String item : selectedHousehold) {
                String priceStr = JOptionPane.showInputDialog(f1, "Enter price for " + item + ":");
                if (priceStr != null && !priceStr.isEmpty()) {
                    totalMRP += Double.parseDouble(priceStr);
                }
            }

            for (String item : selectedEatables) {
                String priceStr = JOptionPane.showInputDialog(f1, "Enter price for " + item + ":");
                if (priceStr != null && !priceStr.isEmpty()) {
                    totalMRP += Double.parseDouble(priceStr);
                }
            }

            // Discount
            String discountStr = (String) cb2.getSelectedItem();
            discount = Integer.parseInt(discountStr.replace("%", ""));
            finalPrice = totalMRP - (totalMRP * discount / 100);

            if (b1.isSelected()) {
                finalPrice -= (finalPrice * 5 / 100);
            }

            // Show result
            resultLabel.setText("<html>Total MRP: ₹" + String.format("%.2f", totalMRP)
                + "<br>After Discount: ₹" + String.format("%.2f", finalPrice)
                + "<br>Household: " + selectedHousehold
                + "<br>Eatables: " + selectedEatables + "</html>");

        } catch (Exception ex) {
            resultLabel.setText("Error: Please enter valid prices.");
            return; // stop if error
        }

        // -------- BILL PREVIEW --------
        StringBuilder bill = new StringBuilder();
        bill.append("******** SHOPPING MART ********\n");
        bill.append("Customer: ").append(t1.getText()).append("\n");
        bill.append("Mobile: ").append(t2.getText()).append("\n\n");

        bill.append("Selected Household Items:\n");
        for (String item : selectedHousehold) {
            bill.append(" - ").append(item).append("\n");
        }

        bill.append("\nSelected Eatables:\n");
        for (String item : selectedEatables) {
            bill.append(" - ").append(item).append("\n");
        }

        bill.append("\n---------------------------------\n");
        bill.append("Total MRP: ₹").append(String.format("%.2f", totalMRP)).append("\n");
        bill.append("Discount Applied: ").append(discount).append("%\n");
        if (b1.isSelected()) bill.append("Extra NEO Discount: 5%\n");
        bill.append("Final Price: ₹").append(String.format("%.2f", finalPrice)).append("\n");
        bill.append("*********************************\n");

        // Show Bill in new Window
        JFrame billFrame = new JFrame("Customer Bill");
        billFrame.setSize(400, 500);
        billFrame.setLocationRelativeTo(f1);

        JTextArea billArea = new JTextArea(bill.toString());
        billArea.setEditable(false);

        // Add Print Option
        int choice = JOptionPane.showConfirmDialog(f1, "Do you want to print the bill?", "Print", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                billArea.print();
            } catch (Exception printEx) {
                JOptionPane.showMessageDialog(f1, "Printing failed!");
            }
        }

        billFrame.add(new JScrollPane(billArea));
        billFrame.setVisible(true);
    }
});
    }
     

    public static void main(String[] args) {
        new shopping();
    }
}
