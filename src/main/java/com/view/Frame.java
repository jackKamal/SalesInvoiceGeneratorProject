/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.model.HeaderTable;
import com.model.InvoiceHeader;
import com.model.InvoiceLine;
import com.model.LineTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Frame extends javax.swing.JFrame implements ActionListener, ListSelectionListener {
    // Variables declaration
    private int index;
    private javax.swing.JButton cancelChangesBtn;
    private javax.swing.JButton createInvBtn;
    private javax.swing.JTextField customerNameTxt;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotal;
    private javax.swing.JTextField invoiceDateTxt;
    private javax.swing.JTable invoiceItemsTable;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;

    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JButton saveFile;
    private javax.swing.JMenuItem saveMenuItem;
// End of variables declaration

    public Frame() {
        super("Design Preview [NewJFrame]");
        initComponents();
        // adjust panels in main frame using grid layout
        setLayout(new GridLayout(1,2));
        add(jPanel1);
        add(jPanel2);
        pack();
    }

    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);
        jLabel6 = new javax.swing.JLabel();
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        invoiceDateTxt = new javax.swing.JTextField();
        customerNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceItemsTable = new javax.swing.JTable();
        saveFile = new javax.swing.JButton();
        saveFile.addActionListener(this);
        cancelChangesBtn = new javax.swing.JButton();
        cancelChangesBtn.addActionListener(this);
        invNumLbl = new javax.swing.JLabel();
        invTotal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        jMenuItem1.setText("jMenuItem1");
        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //table with default headers
        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {{"","","",""},{"","","",""}, {"","","",""}},
                new String [] {"No.","Date","Customer","Total"}
        ));
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoicesTable);

        deleteInvBtn.setText("Delete Iinvoice");
        deleteInvBtn.setActionCommand("DeleteIinvoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Invoices Table");

        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("CreateNewInvoice");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvBtnActionPerformed(evt);
            }
        });
        //adjust alignment of the components at the left panel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(createInvBtn)
                                                .addGap(30, 30, 30)
                                                .addComponent(deleteInvBtn))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteInvBtn)
                                        .addComponent(createInvBtn))
                                .addGap(120, 120, 120))
        );

        jLabel1.setText("invoice number");
        jLabel2.setText("Invoice Date");
        jLabel3.setText("Cutomer Name");
        jLabel4.setText("invoice Total");
        jLabel5.setText("Invoices Items");

        invoiceItemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {{"","","","",""}, {"","","","",""}, {"","","","",""}},
                new String [] {"No.","Item Name","Item Price","Count","Item Total"}
        ));

        jScrollPane2.setViewportView(invoiceItemsTable);
        saveFile.setText("Save");
        saveFile.setActionCommand("saveChangesInvoice");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });

        cancelChangesBtn.setText("Cancel");
        cancelChangesBtn.setActionCommand("cancelChangesInvoice");

        invTotal.setToolTipText("");
        //adjust alignment of the components at the right panel

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(invoiceDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                        .addComponent(customerNameTxt)
                                                        .addComponent(invNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(invTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGap(120, 120, 120)
                                                .addComponent(saveFile)
                                                .addGap(50, 50, 50)
                                                .addComponent(cancelChangesBtn))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel5)))
                                .addContainerGap(564, Short.MAX_VALUE))
                        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(invNumLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(invoiceDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(invTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                               .addComponent(jLabel5)
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saveFile)
                                        .addComponent(cancelChangesBtn))
                                .addContainerGap(39, Short.MAX_VALUE))
        );


        jMenu1.setText("File");
        jMenu1.addActionListener(evt -> jMenu1ActionPerformed(evt));

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        loadMenuItem.addActionListener(evt -> loadMenuItemActionPerformed(evt));
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);


    }

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {
        DeleteInvoice();
    }

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {
        TableModel dtm = invoicesTable.getModel();

        String invNumStr = dtm.getValueAt(invoicesTable.getSelectedRow(),0).toString();
        String custName = dtm.getValueAt(invoicesTable.getSelectedRow(),1).toString();
        String invDateStr = dtm.getValueAt(invoicesTable.getSelectedRow(),2).toString();
        String invoiceTotal = dtm.getValueAt(invoicesTable.getSelectedRow(),3).toString();

        invNumLbl.setText(invNumStr);
        invoiceDateTxt.setText(invDateStr);
        customerNameTxt.setText(custName);
        invTotal.setText(invoiceTotal);


    }

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
    }


    public static void main(String args[]) {
    //handling exceptions
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private List<InvoiceHeader> invoicesList = new ArrayList<>();
    private List<InvoiceLine> invoiceItem = new ArrayList<>();
    private HeaderTable invoiceHeaderTableModel;
    private LineTable invoiceLinesTableModel;
// buttons actions
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LoadFile":
                loadFile();
                break;
            case "SaveFile":
                saveData();
                break;
            case "CreateNewInvoice":
            {
                //handling exceptions
                try {
                    createNewInvoice();
                } catch (ParseException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case "DeleteIinvoice":
                DeleteInvoice();
                break;
            case "saveChangesInvoice":
                saveChangesInvoice();
            case "cancelChangesInvoice":
                cancelChangesInvoice();

            default:
                System.out.println("No Action Selected");
        }
    }
// loading the File
    private void loadFile() {
        JOptionPane.showMessageDialog(this, "Please, select header file!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            //handling exceptions
            try{
                FileReader fr = new FileReader(headerFile);
                BufferedReader br = new BufferedReader(fr);
                String headerLine = null;
                while((headerLine  = br.readLine())!= null){
                    String[] headerParts = headerLine.split(",");
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];
                    int invNum = Integer.parseInt(invNumStr);
                    Date invDate = df.parse(invDateStr);
                    InvoiceHeader inv = new InvoiceHeader(invNum, custName, invDate);
                    invoicesList.add(inv);
                }
                JOptionPane.showMessageDialog(this, "Please, select lines file!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;

                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];

                        int invNum =Integer.parseInt(invNumStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int itemCount = Integer.parseInt(itemCountStr);
                        InvoiceHeader header = findInvoiceByNum(invNum);
                        InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                    invoiceHeaderTableModel = new HeaderTable(invoicesList);
                    invoicesTable.setModel(invoiceHeaderTableModel);
                    invoicesTable.validate();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private InvoiceHeader findInvoiceByNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : invoicesList) {
            if (invNum == inv.getInvNum()) {
                header = inv;
                break;
            }
        }
        return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        invoicesTableRowSelected();
    }
//invoices Table Row Selected
    private void invoicesTableRowSelected() {
        int index = invoicesTable.getSelectedRow();
        if (index >=0)
        {
            InvoiceHeader row = invoiceHeaderTableModel.getInvoicesList().get(index);
            invNumLbl.setText("" +row.getInvNum());
            invoiceDateTxt.setText(df.format(row.getinvDate()));
            customerNameTxt.setText(row.getCutomerName());
            invTotal.setText(""+row.getInvTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            invoiceLinesTableModel = new LineTable(lines);
            invoiceItemsTable.setModel(invoiceLinesTableModel);
            invoiceLinesTableModel.fireTableDataChanged();
        }
    }
//create New Invoice
    private void createNewInvoice() throws ParseException
    {

        JTextField customerName = new JTextField();
        JTextField invDatefield = new JTextField();
        Object[] fields = new Object[]
                {
                        new JLabel("customer Name"),
                        customerName,
                        new JLabel("invoice Date"),
                        invDatefield
                };
        JOptionPane.showConfirmDialog(null,fields,
                "Please enter invoice Details", JOptionPane.OK_CANCEL_OPTION);

        String custName = customerName.getText();
        String invoiceDate = invDatefield.getText();
        int invNum = getNextInvoiceNum();
        Date invDate = df.parse(invoiceDate);
        InvoiceHeader inv = new InvoiceHeader(invNum, custName, invDate);
        invoicesList.add(inv);
        invoiceHeaderTableModel.fireTableDataChanged();
    }
 //getting the Next Invoice Number
    private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceHeader header : invoicesList) {
            if (header.getInvNum() > max) {
                max = header.getInvNum();
            }
        }
        return max + 1;
    }
// Deleting the Invoice
    public void DeleteInvoice()
    {
        int invIndex = invoicesTable.getSelectedRow();
        InvoiceHeader header = invoiceHeaderTableModel.getInvoicesList().get(invIndex);
        invoiceHeaderTableModel.getInvoicesList().remove(invIndex);
        invoiceHeaderTableModel.fireTableDataChanged();
        invoiceLinesTableModel = new LineTable(new ArrayList<InvoiceLine>());
        invoiceItemsTable.setModel(invoiceLinesTableModel);
        invoiceLinesTableModel.fireTableDataChanged();
        customerNameTxt.setText("");
        invoiceDateTxt.setText("");
        invNumLbl.setText("");
        invTotal.setText("");
    }
//saving Changes at the Invoice
    private void saveChangesInvoice() {
        JTextField itemName= new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField itemCount = new JTextField();
        Object[] fields = new Object[]
                {
                        new JLabel("item Name"),
                        itemName,
                        new JLabel("item Price"),
                        itemPrice,
                        new JLabel("item Count"),
                        itemCount
                };
        JOptionPane.showConfirmDialog(null,fields,
                "Please enter Details", JOptionPane.OK_CANCEL_OPTION);
        String ItemName = itemName.getText();
        String itemprice = itemPrice.getText();
        String  itemcount  = itemCount.getText();
        double ItemPrice = Double.parseDouble(itemprice);
        int ItemCount = Integer.parseInt(itemcount);

        int headerIndex = invoicesTable.getSelectedRow();
        InvoiceHeader invoice = invoiceHeaderTableModel.getInvoicesList().get(headerIndex);

        InvoiceLine invLines = new InvoiceLine(ItemName, ItemPrice, ItemCount, invoice);
        invoice.addInvLine(invLines);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invTotal.setText("" + invoice.getInvTotal());
    }
// saving Data
    private void saveData() {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : invoicesList) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }

        JOptionPane.showMessageDialog(this, "Please, select file to save header data", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        try {
            File headerFile = fileChooser.getSelectedFile();
            FileWriter fw = new FileWriter(headerFile);
            fw.write(headers);
            fw.flush();
            fw.close();

            JOptionPane.showMessageDialog(this, "Please, select file to save lines data", "Attension", JOptionPane.WARNING_MESSAGE);
            result = fileChooser.showSaveDialog(this);
            File LinesFile = fileChooser.getSelectedFile();
            FileWriter lfw = new FileWriter(LinesFile);
            lfw.write(lines);
            lfw.flush();
            lfw.close();

        } catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
// cancel Changes at the Invoice
    private void cancelChangesInvoice() {
        int lineIndex =  invoiceItemsTable.getSelectedRow();
        InvoiceLine line = invoiceLinesTableModel.getInvoiceLines().get(lineIndex);
        invoiceLinesTableModel.getInvoiceLines().remove(lineIndex);
        invoiceLinesTableModel.fireTableDataChanged();
        invoiceHeaderTableModel.fireTableDataChanged();
        invTotal.setText("" + line.getHeader().getInvTotal());
    }



}
