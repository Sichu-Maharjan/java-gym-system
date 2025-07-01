import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

//import javax.swing.JSeparator;
public class GymGUI implements ActionListener
{
    ArrayList<GymMember> al1 = new ArrayList<GymMember>();
    public static void main(String[]args)
    {
        new GymGUI();
    }
    JFrame option, regularframe, premiumframe,displayframe,readframe;
    JTextArea displayta,readta;
    JLabel labelid, labelname, labellocation, labeldob, labelemail, 
    labelphone, labelgender, labelplan, labelmembershipsd,
    labelreferral, labelremoval,labeltrainer, labelprice, 
    title1,regular,premium;
    JTextField tfid,tflocation,tfemail, tfprice, tfname, tfphone, tfreferral,tfremoval;
    JComboBox dobyearcb,dobmonthcb,dobdatecb, plancb, msyearcb,msmonthcb, msdaycb;
    JRadioButton rdmale, rdfemale;
    ButtonGroup grp;
    JButton pre,reg,back1,back2;
    JButton addregular, activate, deactivate, attendance,revert, clear, display, upgradePlan, save, read;
    
    JLabel plabelid, plabelname, plabellocation, plabeldob, plabelemail, 
    plabelphone, plabelgender, plabelplan, plabelmembershipsd,
    plabelreferral, plabelpaid, plabelremoval,plabeltrainer, plabeldiscount;
    JTextField ptfid,ptflocation,ptfemail, ptfpaid, ptfname, ptfphone, ptfreferral,ptfremoval, ptfdiscount, ptftrainer;
    JComboBox pdobyearcb,pdobmonthcb,pdobdatecb, pplancb, pmsyearcb,pmsmonthcb, pmsdaycb;
    JRadioButton prdmale, prdfemale;
    ButtonGroup bg;
    
    JButton addpremium, pactivate, pdeactivate, pattendance,prevert, pclear, pdisplay,calculateDiscount,pay,psave,pread;
    public GymGUI()
    {
        //option gui
      option = new JFrame("");
      title1 = new JLabel("Apply for:");
      title1.setForeground(Color.WHITE);
      title1.setFont(new Font("Times New Roman",Font.BOLD,20));
      reg = new JButton("Regular Membership");
      pre = new JButton("Premium Membership");
      option.getContentPane().setBackground(Color.decode("#1c382c"));
      title1.setBounds(110,5,120,30);
      reg.setBounds(50,50,200,60);
      pre.setBounds(50,120,200,60);
      
      
      reg.setBackground(Color.decode("#f0e6d3"));
      pre.setBackground(Color.decode("#f0e6d3"));
      reg.setOpaque(true);
      reg.setBorderPainted(false);
      pre.setOpaque(true);//false=no bg color
      pre.setBorderPainted(false);//true=no custom color

      option.add(title1);
      option.add(reg);
      option.add(pre);
      
      
      
      option.setLayout(null);
      option.setVisible(true);
      option.setSize(300,250);
      
      //application member gui
      regularframe = new JFrame("");
      regularframe.getContentPane().setBackground(Color.decode("#ede7da"));
      
      regular = new JLabel("Regular Membership Application");
      regular.setFont(new Font("Times New Roman",Font.BOLD,24));
      labelid = new JLabel("ID");
      labelname = new JLabel("Name");
      labellocation = new JLabel("Location");
      labeldob = new JLabel("DOB");
      labelemail = new JLabel("Email");
      labelphone = new JLabel("Phone");
      labelgender = new JLabel("Gender");
      labelplan = new JLabel("Plan");
      labelmembershipsd = new JLabel("Membership Start Date");
      labelreferral = new JLabel("Referral Source");
      
      labelremoval = new JLabel("Removal Reason");
      labeltrainer = new JLabel("Trainer's Name");
      labelprice = new JLabel("Plan Price");
      
      
      
      tfid = new JTextField();
      tflocation = new JTextField();
      tfemail = new JTextField();
      
      tfprice = new JTextField("6500");
      tfname = new JTextField();
      tfphone = new JTextField();
      tfreferral = new JTextField();
      tfremoval = new JTextField();
      
      
      
      String y[]={"2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
      String m[]={"jan","feb","mar","apr","may","jun","jul","aug",
      "sept","oct","nov","dec"};
      String d[]={"1","2","3","4","5","6","7","8","9","10","11","12",
      "13","14","15","16","17","18","19","20","21","22","23","24",
      "25","26","27","28","29","30","31"};
      String p[]= {"basic","standard","deluxe"};
      dobyearcb = new JComboBox(y);
      dobmonthcb = new JComboBox(m);
      dobdatecb = new JComboBox(d);
      plancb = new JComboBox(p);
      msyearcb = new JComboBox(y);
      msmonthcb = new JComboBox(m);
      msdaycb = new JComboBox(d);
      
      rdmale = new JRadioButton("Male",true);
      rdfemale = new JRadioButton("Female");
      grp = new ButtonGroup();
      
      addregular = new JButton("Add Regular Member"); 
      addpremium = new JButton("Add Premium Member");
      activate  = new JButton("Activate Membership");
      deactivate = new JButton("Deactivate Membership");
      attendance = new JButton("Mark Attendance");
      revert = new JButton("Revert Membership");
      clear = new JButton("Clear");
      display = new JButton("Display");
      back1 = new JButton("Back");
      upgradePlan = new JButton("Upgrade Plan");
      save = new JButton("Save");
      read = new JButton("Read from file");
      
      tfprice.setEditable(false);
      
      
      regular.setBounds(465,15,400,50);
      
      
      labelid.setBounds(50,110,100,25);
      labellocation.setBounds(50,200,100,25);
      labeldob.setBounds(50,290,100,25);
      labelgender.setBounds(50,380,100,25);
      labelmembershipsd.setBounds(50,470,150,25);
      labelprice.setBounds(50,560,100,25);
      
      
      
      labelname.setBounds(640,110,100,25);
      labelemail.setBounds(640,200,100,25);
      labelphone.setBounds(640,290,100,25);
      labelplan.setBounds(640,380,100,25);
      labelreferral.setBounds(640,470,100,25);
      labelremoval.setBounds(640,560,150,25);
      
      
      addregular.setBounds(50,680,220,55);
      attendance.setBounds(350,680,220,55);
      activate.setBounds(670,680,220,55);
      deactivate.setBounds(970,680,220,55);
      revert.setBounds(350,760,220,55);
      clear.setBounds(670,760,220,55);
      display.setBounds(970,760,220,55);
      upgradePlan.setBounds(50,760,220,55);
      back1.setBounds(50,840,220,55);
      save.setBounds(350,840,220,55);
      read.setBounds(670,840,220,55);
      
      tfid.setBounds(48,140,550,40);
      tflocation.setBounds(48,230,550,40);
      tfemail.setBounds(638,230,550,40);
      tfprice.setBounds(48,590,550,40);
      
      
      tfname.setBounds(638,140,550,40);
      tfphone.setBounds(638,320,550,40);
      tfreferral.setBounds(638,500,550,40);
      tfremoval.setBounds(638,590,550,40);
      
      
      rdmale.setBounds(48,410,100,30);
      rdfemale.setBounds(150,410,100,30);
      
      plancb.setBounds(638,400,550,70);
      dobyearcb.setBounds(48,320,100,50);
      dobmonthcb.setBounds(148,320,100,50);
      dobdatecb.setBounds(248,320,100,50);
      msyearcb.setBounds(48,500,100,50);
      msmonthcb.setBounds(148,500,100,50);
      msdaycb.setBounds(248,500,100,50);
      
      
      
      regularframe.add(regular);
      regularframe.add(labelid);
      regularframe.add(labelname);
      regularframe.add(labellocation);
      regularframe.add(labelemail);
      regularframe.add(labelphone);
      regularframe.add(labelgender);
      regularframe.add(labelplan);
      regularframe.add(labeldob);
      regularframe.add(labelmembershipsd);
      regularframe.add(labelreferral);
      
      regularframe.add(labelremoval);
      
      regularframe.add(labelprice);
      
      regularframe.add(tfid);
      regularframe.add(tflocation);
      regularframe.add(tfemail);
      
      regularframe.add(tfprice);
      regularframe.add(tfname);
      regularframe.add(tfphone);
      regularframe.add(tfreferral);
      regularframe.add(tfremoval);
      
      
      regularframe.add(rdmale);
      regularframe.add(rdfemale);
      regularframe.add(dobyearcb);
      regularframe.add(dobmonthcb);
      regularframe.add(dobdatecb);
      regularframe.add(plancb);
      regularframe.add(msyearcb);
      regularframe.add(msmonthcb);
      regularframe.add(msdaycb);
      regularframe.add(addregular);
      regularframe.add(attendance);
      regularframe.add(activate);
      regularframe.add(deactivate);
      regularframe.add(clear);
      regularframe.add(display);
      regularframe.add(revert);
      regularframe.add(back1);
      regularframe.add(upgradePlan);
      regularframe.add(save);
      regularframe.add(read);
      grp.add(rdmale);
      grp.add(rdfemale);
      
      
      regularframe.setLayout(null);
      regularframe.setVisible(false);
      regularframe.setSize(1250,950);
      
      //premium frame
      
      premiumframe = new JFrame("");
      premiumframe.getContentPane().setBackground(Color.decode("#ede7da"));

      premium = new JLabel("Premium Membership Application");
      premium.setFont(new Font("Times New Roman",Font.BOLD,24));
      plabelid = new JLabel("ID");
      plabelname = new JLabel("Name");
      plabellocation = new JLabel("Location");
      plabeldob = new JLabel("DOB");
      plabelemail = new JLabel("Email");
      plabelphone = new JLabel("Phone");
      plabelgender = new JLabel("Gender");
      plabelplan = new JLabel("Plan");
      plabelmembershipsd = new JLabel("Membership Start Date");
      plabelreferral = new JLabel("Referral Source");
      plabelpaid = new JLabel("Paid Amount");
      plabelremoval = new JLabel("Removal Reason");
      plabeltrainer = new JLabel("Trainer's Name");
      
      plabeldiscount = new JLabel("Discount Amount");
      
      ptfid = new JTextField();
      ptflocation = new JTextField();
      ptfemail = new JTextField();
      ptfpaid = new JTextField();
      
      ptfname = new JTextField();
      ptfphone = new JTextField();
      ptfreferral = new JTextField();
      ptfremoval = new JTextField();
      ptfdiscount = new JTextField();
      ptftrainer = new JTextField();
      
      pdobyearcb = new JComboBox(y);
      pdobmonthcb = new JComboBox(m);
      pdobdatecb = new JComboBox(d);
      
      pmsyearcb = new JComboBox(y);
      pmsmonthcb = new JComboBox(m);
      pmsdaycb = new JComboBox(d);
      
      prdmale = new JRadioButton("Male",true);
      prdfemale = new JRadioButton("Female");
      bg = new ButtonGroup();
      
      
      addpremium = new JButton("Add Premium Member");
      pactivate  = new JButton("Activate Membership");
      pdeactivate = new JButton("Deactivate Membership");
      pattendance = new JButton("Mark Attendance");
      prevert = new JButton("Revert Membership");
      pclear = new JButton("Clear");
      pdisplay = new JButton("Display");
      back2 = new JButton("Back");
      psave = new JButton("Save");
      pread = new JButton("Read from file");
      calculateDiscount = new JButton("Discount");
      pay = new JButton("Pay");
      
      
      
      ptfdiscount.setEditable(false);
      
      premium.setBounds(465,15,500,50);
      plabelid.setBounds(50,110,100,25);
      plabellocation.setBounds(50,200,100,25);
      plabeldob.setBounds(50,290,100,25);
      plabelgender.setBounds(50,380,100,25);
      plabelmembershipsd.setBounds(50,470,150,25);
      plabeldiscount.setBounds(50,560,150,25);
      
      plabelpaid.setBounds(50,650,100,25);
      
      plabelname.setBounds(640,110,100,25);
      plabelemail.setBounds(640,200,100,25);
      plabelphone.setBounds(640,290,100,25);
      labeltrainer.setBounds(640,380,100,25);
      plabelreferral.setBounds(640,470,100,25);
      plabelremoval.setBounds(640,560,150,25);
      
      pay.setBounds(638,680,220,45);
      addpremium.setBounds(50,760,220,55);
      pattendance.setBounds(350,760,220,55);
      pactivate.setBounds(670,760,220,55);
      pdeactivate.setBounds(970,760,220,55);
      prevert.setBounds(350,835,220,55);
      pclear.setBounds(670,835,220,55);
      pdisplay.setBounds(970,835,220,55);
      calculateDiscount.setBounds(50,835,220,55);
      back2.setBounds(50,910,220,55);
      psave.setBounds(350,910,220,55);
      pread.setBounds(670,910,220,55);
      
      ptfid.setBounds(48,140,550,40);
      ptflocation.setBounds(48,230,550,40);
      ptfemail.setBounds(638,230,550,40);
      ptfdiscount.setBounds(48,590,550,40);
      ptfpaid.setBounds(48,680,550,40);
      ptfname.setBounds(638,140,550,40);
      ptfphone.setBounds(638,320,550,40);
      ptfreferral.setBounds(638,500,550,40);
      ptfremoval.setBounds(638,590,550,40);
      ptftrainer.setBounds(638,410,550,40);
      
      prdmale.setBounds(48,410,100,30);
      prdfemale.setBounds(150,410,100,30);
      
      
      pdobyearcb.setBounds(48,320,100,50);
      pdobmonthcb.setBounds(148,320,100,50);
      pdobdatecb.setBounds(248,320,100,50);
      pmsyearcb.setBounds(48,500,100,50);
      pmsmonthcb.setBounds(148,500,100,50);
      pmsdaycb.setBounds(248,500,100,50);
      
      
      premiumframe.add(premium);
      premiumframe.add(plabelid);
      premiumframe.add(plabelname);
      premiumframe.add(plabellocation);
      premiumframe.add(plabelemail);
      premiumframe.add(plabelgender);
      premiumframe.add(plabeldob);
      premiumframe.add(plabelphone);
      
      premiumframe.add(plabelmembershipsd);
      premiumframe.add(plabelreferral);
      premiumframe.add(plabelpaid);
      premiumframe.add(plabelremoval);
      premiumframe.add(labeltrainer);
      
      premiumframe.add(plabeldiscount);
      premiumframe.add(ptfid);
      premiumframe.add(ptflocation);
      premiumframe.add(ptfemail);
      premiumframe.add(ptfpaid);
      
      premiumframe.add(ptfname);
      premiumframe.add(ptfphone);
      premiumframe.add(ptfreferral);
      premiumframe.add(ptfremoval);
      premiumframe.add(ptfdiscount);
      premiumframe.add(ptftrainer);
      premiumframe.add(prdmale);
      premiumframe.add(prdfemale);
      premiumframe.add(pdobyearcb);
      premiumframe.add(pdobmonthcb);
      premiumframe.add(pdobdatecb);
      
      premiumframe.add(pmsyearcb);
      premiumframe.add(pmsmonthcb);
      premiumframe.add(pmsdaycb);
      premiumframe.add(addpremium);
      premiumframe.add(pattendance);
      premiumframe.add(pactivate);
      premiumframe.add(pdeactivate);
      premiumframe.add(pclear);
      premiumframe.add(pdisplay);
      premiumframe.add(prevert);
      premiumframe.add(back2);
      premiumframe.add(calculateDiscount);
      premiumframe.add(pay);
      premiumframe.add(psave);
      premiumframe.add(pread);
      bg.add(prdmale);
      bg.add(prdfemale);
      
      
      
      
      reg.addActionListener(this);
      pre.addActionListener(this);
      addregular.addActionListener(this);
      addpremium.addActionListener(this);
      activate.addActionListener(this);
      deactivate.addActionListener(this);
      attendance.addActionListener(this);
      revert.addActionListener(this);
      clear.addActionListener(this);
      display.addActionListener(this);
      save.addActionListener(this);
      read.addActionListener(this);
      upgradePlan.addActionListener(this);
      back1.addActionListener(this);
      back2.addActionListener(this);
      
      pactivate.addActionListener(this);
      pdeactivate.addActionListener(this);
      pattendance.addActionListener(this);
      prevert.addActionListener(this);
      pclear.addActionListener(this);
      pdisplay.addActionListener(this);
      calculateDiscount.addActionListener(this);
      pay.addActionListener(this);
      psave.addActionListener(this);
      pread.addActionListener(this);
      
      plancb.addActionListener(this);
      
      premiumframe.setLayout(null);
      premiumframe.setVisible(false);
      premiumframe.setSize(1250,1000);
      //display frame
      displayframe = new JFrame();
      displayta = new JTextArea();
      displayta.setBounds(5,5,890,890);
      displayframe.add(displayta);
      displayframe.setLayout(null);
      displayframe.setVisible(false);
      displayframe.setSize(900,900);
      
      //read frame
      readframe = new JFrame();
      readta = new JTextArea();
      readta.setBounds(5,5,1340,290);
      readframe.add(readta);
      readta.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
      //when the file is read, monospaced makes sure all letter, symbol take same amount of space
      //for format purpose
      readframe.setLayout(null);
      readframe.setVisible(false);
      readframe.setSize(1350,300);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==reg)
        {
            option.setVisible(false);
            regularframe.setVisible(true);
            premiumframe.setVisible(false);
        }
        
     else if(ae.getSource()==plancb)
      {
          String s= (String)plancb.getSelectedItem();
          if(s=="Basic")
          {
              tfprice.setText("6500");
          }
          else if(s=="Standard")
          {
              tfprice.setText("12500");
          }
          else
          {
              tfprice.setText("18500");
          }
          
      }
        else if(ae.getSource()==pre)
        {
            option.setVisible(false);
            premiumframe.setVisible(true);
            regularframe.setVisible(false);
        }
        else if(ae.getSource()==back1)
        {
            option.setVisible(true);
            regularframe.setVisible(false);
        }
        else if(ae.getSource()==back2)
        {
            option.setVisible(true);
            premiumframe.setVisible(false);
        }
        else if(ae.getSource()==addregular)
        {
            if(tfid.getText().isEmpty()|| tflocation.getText().isEmpty()|| tfemail.getText().isEmpty()||
            tfname.getText().isEmpty()||tfphone.getText().isEmpty()||tfreferral.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the application");
            }
            else
            {
                try{
                int regId = Integer.parseInt(tfid.getText());
                String regLocation = tflocation.getText();
                String regEmail = tfemail.getText();
                String regName = tfname.getText();
                String regPhone = tfphone.getText();
                String regReferral = tfreferral.getText();
                String regGender="";
                String regPlan= (String) plancb.getSelectedItem();
                if(rdmale.isSelected())
                {
                    regGender="male";
                }
                else if(rdfemale.isSelected())
                {
                    regGender="female";
                }
                String year= (String) dobyearcb.getSelectedItem();
                String month= (String) dobmonthcb.getSelectedItem(); //combo box creates object and (String) converts it into string
                String date= (String) dobdatecb.getSelectedItem();
                String regDob= date+"-"+month+"-"+year;
                String myear= (String) msyearcb.getSelectedItem();
                String mmonth= (String) msmonthcb.getSelectedItem(); //combo box creates object and (String) converts it into string
                String mdate= (String) msdaycb.getSelectedItem();
                String regMembershipsd= mdate+"-"+mmonth+"-"+myear;
                
                if(al1.isEmpty())
                {
                    //creating object
                    RegularMember regobj = new RegularMember(regId,regName,regLocation,regPhone,regEmail,
                    regGender,regDob, regMembershipsd, regReferral);
                    al1.add(regobj);
                    JOptionPane.showMessageDialog(regularframe,"Regular Member added succesfully");
                }
                else
                {
                    boolean idexistence=false;
                    for(GymMember mem : al1)
                    {
                        //not displaying message in it because otherwise it is add same id again
                        if(mem.getId()==regId) //for each loop le array ma vako id haru tanera bhakhar input gareko id sanga same xa xaina check garxa
                        {
                            idexistence=true;
                            break;//loop bata baira niskinxa
                        }
                    }
                    if(idexistence)
                    {
                        JOptionPane.showMessageDialog(regularframe,"Member with this id already exists. please choose another ID.","Duplication",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        RegularMember regobj = new RegularMember(regId,regName,regLocation,regPhone,regEmail,
                        regGender,regDob, regMembershipsd, regReferral);
                        al1.add(regobj);
                        JOptionPane.showMessageDialog(regularframe,"Regular Member added succesfully");
                    }
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(regularframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        
        else if(ae.getSource()==attendance)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the id");
            }
            else
            {
                try{
                int regId=Integer.parseInt(tfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        
                        if(member.getId()==regId) 
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()){
                        memberexistence.markAttendance();
                        JOptionPane.showMessageDialog(regularframe,"Attendance marked","Attendance",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regularframe,"member is not activate","Attendance",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(regularframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(regularframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        
        else if(ae.getSource()==activate)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the id");
            }
            else
            {
                try{
                int regId=Integer.parseInt(tfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        if(member.getId()==regId) 
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()){
                        JOptionPane.showMessageDialog(regularframe,"Membership is already activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        memberexistence.activateMembership();//calling method to activate membership
                        JOptionPane.showMessageDialog(regularframe,"Membership activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(regularframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(regularframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        }
        
        else if(ae.getSource()==deactivate)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the id");
            }
            else
            {
                try{
                int regId=Integer.parseInt(tfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        //not displaying message in it because otherwise it is add same id again
                        if(member.getId()==regId) //for each loop le array ma vako id haru tanera bhakhar input gareko id sanga same xa xaina check garxa
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;//loop bata baira niskinxa
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()==false){
                        JOptionPane.showMessageDialog(regularframe,"Membership is already deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        memberexistence.deactivateMembership();//calling method to activate membership
                        JOptionPane.showMessageDialog(regularframe,"Membership deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(regularframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(regularframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        
        else if(ae.getSource()==revert)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the id");
            }
            else if(tfremoval.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(regularframe,"please fill in the removal reason");
            }
            else
            {
                try{
                int regId=Integer.parseInt(tfid.getText());
                String regRemoval=tfremoval.getText();
                boolean idexistence=false;
                RegularMember memberexistence = null;
                for(GymMember member : al1)
                {
                    if (member instanceof RegularMember)
                    {
                        RegularMember regMember = (RegularMember) member;
                    if(regMember.getId()==regId) 
                    {
                        idexistence=true;
                        memberexistence  = regMember;
                        break;
                    }
                    }
                }
                if(idexistence)
                {
                        memberexistence.revertRegularMember(regRemoval);
                        JOptionPane.showMessageDialog(regularframe,"Membership Reset","Reset",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(regularframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(regularframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        
        else if(ae.getSource()==display) 
        {
            displayframe.setVisible(true);
            displayta.setText("");
            if(al1.isEmpty())
            {
                
                displayta.append("NO MEMBER REGISTERED!!!");
            }
            else
            {
                displayta.append("\nREGULAR MEMBERS: \n\n ");
                boolean memberExistence=false;
                //checking if there are regular members
                for(GymMember member : al1)
                {
                    if(member instanceof RegularMember)
                    {
                        memberExistence= true;
                        break;
                    }
                }
                if(memberExistence)
                {
                    for(GymMember member:al1)
                    {
                        if(member instanceof RegularMember)
                        {
                            RegularMember regular = (RegularMember) member;
                            displayta.append("\nMember ID: "+regular.getId()+"\n");
                            displayta.append("Name: "+regular.getName()+"\n");
                            displayta.append("Location: "+regular.getLocation()+"\n");
                            displayta.append("Email: "+regular.getEmail()+"\n");
                            displayta.append("Phone: "+regular.getPhone()+"\n");
                            displayta.append("Date of Birth: "+regular.getDOB()+"\n");
                            displayta.append("Gender: "+regular.getGender()+"\n");
                            displayta.append("Plan: "+regular.getPlan()+"\n");
                            displayta.append("Price: "+regular.getPrice()+"\n");
                            displayta.append("Membership Start Date: "+regular.getMembershipStartDate()+"\n");
                            displayta.append("Attendance: "+regular.getAttendance()+"\n");
                            displayta.append("Loyalty Points: "+regular.getLoyaltyPoints()+"\n");
                            displayta.append("Active Status: "+regular.getActiveStatus()+"\n");
                            if(regular.getRemovalReason()!="")
                            {
                                displayta.append("Removal Reason: "+regular.getRemovalReason()+"\n");
                            }
                            displayta.append("===============================================================================");
                        }
                    }
                }
                else
                {
                    displayta.append("NO REGULAR MEMBER REGISTERED!!!");
                }
            }
            
        }
    
        else if(ae.getSource()==clear || ae.getSource()==pclear)
        {
            tfid.setText("");
            tflocation.setText("");
            tfemail.setText("");
            
            tfprice.setText("");
            tfname.setText("");
            tfphone.setText("");
            tfreferral.setText("");
            tfremoval.setText("");
            
            
            ptfid.setText("");
            ptflocation.setText("");
            ptfemail.setText("");
            ptfpaid.setText("");
            
            ptfname.setText("");
            ptfphone.setText("");
            ptfreferral.setText("");
            ptfremoval.setText("");
            ptfdiscount.setText("");
            ptftrainer.setText("");
            
            
            dobmonthcb.setSelectedItem("January");
            dobyearcb.setSelectedItem("2006");
            dobdatecb.setSelectedItem("1");
            msdaycb.setSelectedItem("1");
            msmonthcb.setSelectedItem("January");
            msyearcb.setSelectedItem("2006");
            
            plancb.setSelectedItem("basic");
        }
        
        else if(ae.getSource()==addpremium)
        {
            try{
            if(ptfid.getText().isEmpty()|| ptflocation.getText().isEmpty()|| ptfemail.getText().isEmpty()||
            ptfname.getText().isEmpty()||ptfphone.getText().isEmpty()||ptfreferral.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the application");
            }
            else
            {
                int preId = Integer.parseInt(ptfid.getText());
                String preLocation = ptflocation.getText();
                String preEmail = ptfemail.getText();
                String preName = ptfname.getText();
                String prePhone = ptfphone.getText();
                String preTrainer = ptftrainer.getText();
                String preGender="";
                if(prdmale.isSelected())
                {
                    preGender="male";
                }
                else if(prdfemale.isSelected())
                {
                    preGender="female";
                }
                String year= (String) pdobyearcb.getSelectedItem();
                String month= (String) pdobmonthcb.getSelectedItem(); //combo box creates object and (String) converts it into string
                String date= (String) pdobdatecb.getSelectedItem();
                String preDob= date+"-"+month+"-"+year;
                String myear= (String) pmsyearcb.getSelectedItem();
                String mmonth= (String) pmsmonthcb.getSelectedItem(); //combo box creates object and (String) converts it into string
                String mdate= (String) pmsdaycb.getSelectedItem();
                String preMembershipsd= mdate+"-"+mmonth+"-"+myear;
                
                if(al1.isEmpty())
                {
                    //creating object
                    PremiumMember preobj = new PremiumMember(preId,preName,preLocation,prePhone,preEmail,
                    preGender,preDob, preMembershipsd, preTrainer);
                    al1.add(preobj);
                    JOptionPane.showMessageDialog(premiumframe,"Premium Member added succesfully");
                }
                else
                {
                    boolean idexistence=false;
                    for(GymMember mem : al1)
                    {
                        //not displaying message in it because otherwise it is add same id again
                        if(mem.getId()==preId) //for each loop le array ma vako id haru tanera bhakhar input gareko id sanga same xa xaina check garxa
                        {
                            idexistence=true;
                            break;//loop bata baira niskinxa
                        }
                    }
                    if(idexistence)
                    {
                        JOptionPane.showMessageDialog(premiumframe,"Member with this id already exists. please choose another ID.","Duplication",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        PremiumMember preobj = new PremiumMember(preId,preName,preLocation,prePhone,preEmail,
                        preGender,preDob, preMembershipsd, preTrainer);
                        al1.add(preobj);
                        JOptionPane.showMessageDialog(premiumframe,"Premium Member added succesfully");
                    }
                }
            }
        }
        catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(premiumframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
    }
    }
        else if (ae.getSource()==pattendance)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            else
            {
                try{
                int preId=Integer.parseInt(ptfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        if(member.getId()==preId) 
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()){
                        memberexistence.markAttendance(); //calling to mark attendance
                        JOptionPane.showMessageDialog(premiumframe,"Attendance marked","Attendance",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(premiumframe,"member is not activate","Attendance",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(premiumframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(premiumframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
    }
        }
        }
        else if(ae.getSource()==prevert)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            else if(ptfremoval.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(premiumframe,"please fill in the removal reason");
            }
            else
            {
                try{
                int preId=Integer.parseInt(ptfid.getText());
                String preRemoval=ptfremoval.getText();
                boolean idexistence=false;
                PremiumMember memberexistence = null;
                for(GymMember member : al1)
                {
                    if(member instanceof PremiumMember)
                    {
                        PremiumMember preMember = (PremiumMember) member;
                        if(preMember.getId()==preId) 
                        {
                            idexistence=true;
                            memberexistence  = preMember;
                            break;
                        }
                    }
                }
                if(idexistence)
                {
                        memberexistence.revertPremiumMember();
                        JOptionPane.showMessageDialog(premiumframe,"Membership Reset","Reset",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(premiumframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(premiumframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        else if(ae.getSource()==pactivate)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            else
            {
                try{
                int preId=Integer.parseInt(ptfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        //not displaying message in it because otherwise it is add same id again
                        if(member.getId()==preId) //for each loop le array ma vako id haru tanera bhakhar input gareko id sanga same xa xaina check garxa
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;//loop bata baira niskinxa
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()){
                        JOptionPane.showMessageDialog(premiumframe,"Membership is already activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        memberexistence.activateMembership();//calling method to activate membership
                        JOptionPane.showMessageDialog(premiumframe,"Membership activated","Activated",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(premiumframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(premiumframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        else if(ae.getSource()==pdeactivate)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            else
            {
                try{
                int preId=Integer.parseInt(ptfid.getText());
                boolean idexistence=false;
                GymMember memberexistence = null;
                    for(GymMember member : al1)
                    {
                        //not displaying message in it because otherwise it is add same id again
                        if(member.getId()==preId) //for each loop le array ma vako id haru tanera bhakhar input gareko id sanga same xa xaina check garxa
                        {
                            idexistence=true;
                            memberexistence  = member;
                            break;//loop bata baira niskinxa
                        }
                    }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus()==false){
                        JOptionPane.showMessageDialog(premiumframe,"Membership is already deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        memberexistence.deactivateMembership();//calling method to activate membership
                        JOptionPane.showMessageDialog(premiumframe,"Membership deactivated","Deactivated",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(premiumframe, "Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(premiumframe,"ID can only have number values!","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }
        else if(ae.getSource()==pdisplay)
        {
            displayframe.setVisible(true);
            displayta.setText("");
            if(al1.isEmpty())
            {
                displayta.append("NO MEMBER REGISTERED!!!");
            }
            else
            {
                displayta.append("\nPREMIUM MEMBERS: \n\n ");
                boolean memberExistence=false;
                //checking if there are premium members
                for(GymMember member : al1)
                {
                    if(member instanceof PremiumMember)
                    {
                        memberExistence= true;
                        break;
                    }
                }
                if(memberExistence)
                {
                    for(GymMember member:al1)
                    {
                        if(member instanceof PremiumMember)
                        {
                            PremiumMember premium = (PremiumMember) member;
                            displayta.append("\nMember ID: "+premium.getId()+"\n");
                            displayta.append("Name: "+premium.getName()+"\n");
                            displayta.append("Location: "+premium.getLocation()+"\n");
                            displayta.append("Email: "+premium.getEmail()+"\n");
                            displayta.append("Phone: "+premium.getPhone()+"\n");
                            displayta.append("Date of Birth: "+premium.getDOB()+"\n");
                            displayta.append("Gender: "+premium.getGender()+"\n");
                            displayta.append("Membership Start Date: "+premium.getMembershipStartDate()+"\n");
                            displayta.append("Attendance: "+premium.getAttendance()+"\n");
                            displayta.append("Loyalty Points: "+premium.getLoyaltyPoints()+"\n");
                            displayta.append("Personal Trainer: "+premium.getPersonalTrainer()+"\n");
                            displayta.append("Payment of Rs."+premium.getPaidAmount()+" has been made\n");
                            displayta.append("Active Status: "+premium.getActiveStatus()+"\n");
                            displayta.append(premium.getIsFullPayment()?"Full payment has been done":"Full payment has not been done"+"\n");
                            if(premium.getIsFullPayment()==false)
                            {
                                double remainingAmount=premium.getPremiumCharge()-premium.getPaidAmount();
                                displayta.append("Payment of Rs."+remainingAmount+" is left to be paid.\n");
                            }
                            else
                            {
                                displayta.append("\nDiscount: Rs."+premium.getDiscountAmount()+"\n");
                            }
                            displayta.append("===============================================================================");
                        }
                    }
                }
                else
                {
                    displayta.append("NO PREMIUM MEMBER REGISTERED!!!");
                }
            }
        
        }
        else if(ae.getSource()==calculateDiscount)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            try
            {
                int preId=Integer.parseInt(ptfid.getText());
                boolean idexistence=false;
                PremiumMember memberexistence = null; 
                for(GymMember member: al1)
                {
                    if(member instanceof PremiumMember)
                    {
                        PremiumMember preMember = (PremiumMember) member;
                        if(member.getId()==preId)
                        {
                            idexistence=true;
                            memberexistence = preMember;
                            break;
                        }
                    }
                }
                if(idexistence)
                {
                    if(memberexistence.getActiveStatus())
                    {
                        if(memberexistence.getIsFullPayment())
                        {
                            memberexistence.calculateDiscount();
                            ptfdiscount.setText(String.valueOf(memberexistence.getDiscountAmount()));
                            JOptionPane.showMessageDialog (premiumframe,""+memberexistence.getName()+" has successfully received 10% discount");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog (premiumframe,"Member is not eligible for discount.");
                        }
                    }
                    else
                    {
                            JOptionPane.showMessageDialog (premiumframe,"Membership not activated.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(premiumframe,"Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(premiumframe,"ID can only have number values.","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==pay)
        {
            if(ptfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the id");
            }
            else if(ptfpaid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(premiumframe,"please fill in the paid amount.");
            }
            else
            {
                try
                {
                    int preId=Integer.parseInt(ptfid.getText());
                    double paidAmount=Double.parseDouble(ptfpaid.getText());
                    boolean idexistence=false;
                    PremiumMember memberexistence = null; 
                    for(GymMember member: al1)
                    {
                        if(member instanceof PremiumMember)
                        {
                            PremiumMember preMember = (PremiumMember) member;
                            if(member.getId()==preId)
                            {
                                idexistence=true;
                                memberexistence = preMember;
                                break;
                            }
                        }
                    }
                    if(idexistence)
                    {
                        if(memberexistence.getActiveStatus())
                        {
                            String message = memberexistence.payDueAmount(paidAmount);
                            JOptionPane.showMessageDialog(premiumframe,message);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog (premiumframe,"Membership not activated.");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(premiumframe,"Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(premiumframe,"ID can only have number values.","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==upgradePlan)
        {
            if(tfid.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"please fill in the id");
            }
            else
            {
                try
                {
                    int regId=Integer.parseInt(tfid.getText());
                    String plan = (String) plancb.getSelectedItem();
                    boolean idexistence=false;
                    RegularMember memberexistence = null; 
                    for(GymMember member: al1)
                    {
                        if(member instanceof RegularMember)
                        {
                            RegularMember regMember = (RegularMember) member;
                            if(regMember.getId()==regId)
                            {
                                idexistence=true;
                                memberexistence = regMember;
                                break;
                            }
                        }
                    }
                    if(idexistence)
                    {
                        if(memberexistence.getActiveStatus())
                        {
                            if(memberexistence.getIsEligibleForUpgrade())
                            {
                                String message = memberexistence.upgradePlan(plan);
                                JOptionPane.showMessageDialog(regularframe,message);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(regularframe,"Member is not eligible for upgrade. Attendance is low.");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog (regularframe,"Membership not activated.");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(regularframe,"Member with this ID does not exist.","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(regularframe,"ID can only have number values.","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if(ae.getSource()==save || ae.getSource()==psave)
        {
            try{
                if(al1.isEmpty())
            {
                JOptionPane.showMessageDialog(regularframe,"NO MEMBER REGISTERED!","Error",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                File file = new File("MemberDetails.txt");
                FileWriter writer = new FileWriter(file);
                
                writer.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~INFORMATION OF THE MEMBERS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
                writer.write("===============================================================================================================================================================================================\n");
                String header = String.format("%-5s %-10s %-10s %-10s %-13s %-23s %-10s %-10s %-11s %-15s %-14s %-13s %-16s %-16s \n", 
                "ID", "Name", "Location", "Phone", "Email","Membership Start Date", "Plan",
                "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", 
                "Discount Amount", "Net Amount Paid");
                //s- string d-int f-float/double
                //% begining
                //- left align
                //.2 for 2 decimal place
                writer.write(header);
                writer.write("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for(GymMember member:al1)
                {
                    if(member instanceof RegularMember)
                    {
                        RegularMember regMember = (RegularMember) member;
                        String line = String.format("%-5d %-10s %-10s %-10s %-13s %-23s %-10s %-10s %-11s %-15s %-14s %-13s %-16s %-16s \n", 
                        regMember.getId(),
                        regMember.getName(),
                        regMember.getLocation(),
                        regMember.getPhone(),
                        regMember.getEmail(),
                        regMember.getMembershipStartDate(),
                        regMember.getPlan(),
                        regMember.getPrice(),
                        regMember.getAttendance(),
                        regMember.getLoyaltyPoints(),
                        regMember.getActiveStatus()?"active":"inactive",
                        "NONE","NONE","NONE");
                        
                        writer.write(line);
                        
                        writer.write("===============================================================================================================================================================================================\n");
                        
                    }
                    else if(member instanceof PremiumMember)
                    {
                        PremiumMember preMember = (PremiumMember) member;
                        String line = String.format("%-5d %-10s %-10s %-10s %-13s %-23s %-10s %-10s %-11s %-15s %-14s %-13s %-16.2f %-16.2f \n", 
                        preMember.getId(),
                        preMember.getName(),
                        preMember.getLocation(),
                        preMember.getPhone(),
                        preMember.getEmail(),
                        preMember.getMembershipStartDate(),
                        "PREMIUM",
                        preMember.getPremiumCharge(),
                        preMember.getAttendance(),
                        preMember.getLoyaltyPoints(),
                        preMember.getActiveStatus()?"active":"inactive",
                        preMember.getIsFullPayment()?"complete":"incomplete",
                        preMember.getDiscountAmount(),
                        preMember.getPaidAmount());
                        
                        writer.write(line);
                        writer.write("===============================================================================================================================================================================================\n");
                    }
                }
                writer.close();
                JOptionPane.showMessageDialog(regularframe,"member details added");
                //JOptionPane.showMessageDialog(premiumframe,"member details added");
            }
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(regularframe, "An error has occured."+e.getMessage()) ;
            }
        }
        else if(ae.getSource()==read || ae.getSource()==pread)
        {
            readframe.setVisible(true);
            readta.setText("");
            try
            {
                FileReader fileRead = new FileReader("MemberDetails.txt");
                int ch;
                while((ch = fileRead.read())!= -1)
                {
                    char cha=(char) ch; //converting ascii values into character
                    readta.append(String.valueOf(cha));
                }
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(regularframe,"FILE NOT FOUND.","Error",JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(regularframe,"FILE NOT READING"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        }
    }



   
