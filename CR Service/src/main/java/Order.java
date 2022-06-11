
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Order {
    private String name;
    private String date;
    private String qnt;
    private String pickup;
    private String dropoff;
    private String type;
    private String amount;

    @Override
    public String toString() {
        return "Order{" + "name=" + name + ", date=" + date + ", qnt=" + qnt + ", pickup=" + pickup + ", dropoff=" + dropoff + ", type=" + type + ", amount=" + amount + '}';
    }
        public Order(String name, String date, String qnt, String pickup, String dropoff, String type, String amount) {
        this.name = name;
        this.date = date;
        this.qnt = qnt;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.type = type;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getQnt() {
        return qnt;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDropoff() {
        return dropoff;
    }

    public String getType() {
        return type;
    }

    public String getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public void createOrder(){
    File f = new File("Order.txt");
    if(!f.exists()){
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    try{
        BufferedReader br = new BufferedReader(new FileReader(f));
        Object[] Lines = br.lines().toArray();
        int i=0;
        int id=200;
        for(i=0; i<Lines.length;i++){
            String Line = Lines[i].toString().trim();
            String[] Row = Line.split(",");
            id = Integer.parseInt(Row[0]);
            }
            int orderId=id+1;
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(orderId+","+name+","+date+","+qnt+","+pickup+","+dropoff+","+type+","+amount+"\n");
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
