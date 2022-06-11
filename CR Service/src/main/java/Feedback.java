
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
public class Feedback {
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String write;

    @Override
    public String toString() {
        return "Feedback{" + "fname=" + fname + ", lname=" + lname + ", email=" + email + ", address=" + address + ", write=" + write + '}';
    }

    public Feedback(String fname, String lname, String email, String address, String write) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.write = write;
    }
   

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getWrite() {
        return write;
    }
    public void addfeedback(){
        File f = new File("Feedback.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fname+","+lname+","+email+","+address+","+write+"\n");
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
