package com.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class HeaderTable extends AbstractTableModel {
    private List<InvoiceHeader> invoiceList;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    public HeaderTable(List<InvoiceHeader> List) {
        this.invoiceList = List;

    }

    @Override
    public int getRowCount() {
        return invoiceList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Invoice No.";
            case 1:
                return "Customer Name";
            case 2:
                return "Invoice Date";
            case 3:
                return "Invoice Total";
            default:
                return"";

        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return Object.class;

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader row = invoiceList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return row.getInvNum();
            case 1:
                return row.getCutomerName();
            case 2:
                return df.format(row.getinvDate());
            case 3:
                return row.getInvTotal();
            default:
                return "";
        }
    }

    public List<InvoiceHeader> getInvoicesList() {
        return invoiceList;
    }
}
