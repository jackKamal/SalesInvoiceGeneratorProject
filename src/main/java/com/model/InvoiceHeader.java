package com.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {

    int invNum;
    String customerName;
    Date invDate;
    ArrayList<InvoiceLine> lines;

    public InvoiceHeader (int invNum, String customerName, Date invDate)
    {
        this.invNum = invNum;
        this.customerName = customerName;
        this.invDate = invDate;
    }

    public InvoiceHeader() {

    }

    public Date getinvDate()
    {
        return invDate;
    }

    public void setinvDate(Date invDate)
    {
        this.invDate = invDate;
    }

    public void setcustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCutomerName()
    {
        return customerName;
    }

    public void setinvNum(int invNum)
    {
        this.invNum = invNum;
    }

    public int getInvNum()
    {
        return invNum;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null)
            lines = new ArrayList<>();  // lazy creation
        return lines;
    }

    public double getInvTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }

    public void addInvLine(InvoiceLine line) {
        getLines().add(line);
    }

    public void deleteInvLine(int i) {
        getLines().remove(i);    }


    public String getDataAsCSV() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvNum() + "," + df.format(getinvDate()) + "," + getCutomerName();
    }
}
