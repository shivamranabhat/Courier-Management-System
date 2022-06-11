
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class ManagingStaff {
    private String fname;
    private String lname;
    private String addr;
    private String phn;
    private String usrname;
    private String pass;
    

    public ManagingStaff(String fname, String lname, String addr, String phn, String usrname, String pass) {
        this.fname = fname;
        this.lname = lname;
        this.addr = addr;
        this.phn = phn;
        this.usrname = usrname;
        this.pass = pass;
    }

    

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }
    

    public String getPhn() {
        return phn;
    }
 
    public void setPhn(String phn) {
        this.phn = phn;
    }
    

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setLastName(String email) {
        this.lname = email;
    }

    public String getLastName() {
        return lname;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }


    @Override
    public String toString() {
        return "ManagingStaff{" + "name=" + fname + ", lname=" + lname + ", addr=" + addr + ", phn=" + phn + ", usrname=" + usrname + ", pass=" + pass + '}';
    }
    public void mgRegister() throws IOException{
    String line = null,word,username=null;  
    int i;
    StringTokenizer st = null;
    File file = new File("MgStaffReg.txt");
    try{      
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine())
        {
            
            line = scan.nextLine();
            st = new StringTokenizer(line,",");
            i = 0;
            while(st.hasMoreTokens())
            {
                
                word = st.nextToken();
                if(i == 5)
                {
                    username = word;
                }
                i++;
            }
            if(usrname.equals(username)){
                JOptionPane.showMessageDialog(null,"Username already exist");
                return;
            }
        }
        scan.close();
            
    }
    
    catch(FileNotFoundException ex){
        Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
        
    }  
    if(!file.exists()){
        file.createNewFile();
    }
    BufferedReader br = new BufferedReader(new FileReader(file));
    Object[] Lines = br.lines().toArray();
    int j =0;
    int id =100;
    for(j=0;j<Lines.length;j++){
        String Line = Lines[j].toString().trim();
        String[] Row = Line.split(",");
        id = Integer.parseInt(Row[0]);
    }
    int usrId = id+1;
    if(file.exists()){
    FileWriter fw = new FileWriter(file,true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(usrId+","+fname+","+lname+","+addr+","+phn+","+usrname+","+pass+"\n");
    bw.flush();
    fw.close();
    bw.close(); 
    JOptionPane.showMessageDialog(null,"Registerd successfully");
    
    }
  }

}