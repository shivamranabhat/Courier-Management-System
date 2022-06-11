
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Info-chip
 */
public class Report {
    private String oid;
    private String name;
    private String month;
    private String date;
    private String type;
    private String by;
    private String income;

    public Report(String oid, String name, String month, String date, String type, String by, String income) {
        this.oid = oid;
        this.name = name;
        this.month = month;
        this.date = date;
        this.type = type;
        this.by = by;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Report{" + "oid=" + oid + ", name=" + name + ", month=" + month + ", date=" + date + ", type=" + type + ", by=" + by + ", income=" + income + '}';
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOid() {
        return oid;
    }

    public String getName() {
        return name;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getBy() {
        return by;
    }

    public String getIncome() {
        return income;
    }
    public void createreport(){
        File file = new File("Report.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(oid+","+name+","+month+","+date+","+type+","+by+","+income+"\n");
            bw.flush();
            fw.close();
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
