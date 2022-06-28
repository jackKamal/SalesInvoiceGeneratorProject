package com.model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


    public class InvoiceLine extends JDialog{
        private String itemName;
        private double itemPrice;
        private int itemCount;
        private InvoiceHeader header;
        private JTextField itemNameField;
        private JTextField itemCountField;
        private JTextField itemPriceField;
        private JLabel itemNameLbl;
        private JLabel itemCountLbl;
        private JLabel itemPriceLbl;
        private JButton okBtn;
        private JButton cancelBtn;

        public InvoiceLine(String itemName, double itemPrice, int itemCount, InvoiceHeader header) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemCount = itemCount;
            this.header = header;
        }

        public InvoiceLine(Frame frame) {
            itemNameField = new JTextField(20);
            itemNameLbl = new JLabel("Item Name");

            itemCountField = new JTextField(20);
            itemCountLbl = new JLabel("Item Count");

            itemPriceField = new JTextField(20);
            itemPriceLbl = new JLabel("Item Price");

            okBtn = new JButton("OK");
            cancelBtn = new JButton("Cancel");

            okBtn.setActionCommand("createLineOK");
            cancelBtn.setActionCommand("createLineCancel");

            okBtn.addActionListener((ActionListener) frame);
            cancelBtn.addActionListener((ActionListener) frame);
            setLayout(new GridLayout(4, 2));

            add(itemNameLbl);
            add(itemNameField);
            add(itemCountLbl);
            add(itemCountField);
            add(itemPriceLbl);
            add(itemPriceField);
            add(okBtn);
            add(cancelBtn);

            pack();
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public int getItemCount() {
            return itemCount;
        }

        public void setItemCount(int itemCount) {
            this.itemCount = itemCount;
        }

        public InvoiceHeader getHeader() {
            return header;
        }

        public void setHeader(InvoiceHeader header) {
            this.header = header;
        }

        public double getLineTotal() {
            return itemCount * itemPrice;
        }

        public String getDataAsCSV() {
            return "" + getHeader().getInvNum() + "," + getItemName() + "," + getItemPrice() + "," + getItemCount();
        }
    }
