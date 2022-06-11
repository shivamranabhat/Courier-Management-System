
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
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
public class User {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void verifyDelStaff(){
    String line = null, word,usrname=null,pass = null;
    int i;
    String id = null;
    StringTokenizer st = null;
    String unInput = username;
    String pwInput = password;
        try {
            Scanner scan = new Scanner(new File("DelStaffReg.txt"));
            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                st = new StringTokenizer(line,",");
                i = 0;
                while(st.hasMoreTokens())
                {

                    word = st.nextToken();
                    if(i==0){
                        id = word;
                    }
                    if(i == 5)
                    {
                        usrname = word;
                    }
                    if(i == 6){
                        pass = word;
                    }
                    i++;
                }

                if(unInput.equals(usrname) && (pwInput.equals(pass)))
                {
                    DelStaffMenu dsm = new DelStaffMenu();
                    dsm.jText_id.setText(id);
                    dsm.setVisible(true);
                    dsm.setLocationRelativeTo(null);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null,"Incorrect username/password");
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public void verifyMgStaff(){
    String line = null, word,usrname=null,pass = null;
    int i;
    String id = null;
    StringTokenizer st = null;
    String unInput = username;
    String pwInput = password;
        try {
            Scanner scan = new Scanner(new File("MgStaffReg.txt"));
            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                st = new StringTokenizer(line,",");
                i = 0;
                while(st.hasMoreTokens())
                {

                    word = st.nextToken();
                    if(i==0){
                        id = word;
                    }
                    if(i == 5)
                    {
                        usrname = word;
                    }
                    if(i == 6){
                        pass = word;
                    }
                    i++;
                }
                if(unInput.equals(usrname) && (pwInput.equals(pass)))
                {
                    MgstaffProfile msp = new MgstaffProfile();
                    msp.jText_id.setText(id);
                    msp.setVisible(true);
                    msp.setLocationRelativeTo(null);
                    return;
                }

            }
            JOptionPane.showMessageDialog(null,"Incorrect username/password");
            scan.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
