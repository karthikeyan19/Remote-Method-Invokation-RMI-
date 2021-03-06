import javax.swing.*;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.awt.*;
import java.awt.event.*;
public class convertor extends JFrame
{
   private String[] countries={"Indian ruppee","US Dollar","Euro"} ;
   private String[] symbols={"INR","USD","EUR"};
   private JLabel fromJLabel,toJLabel;
   private IConventorService convertor;
   private JComboBox toJComboBox,fromJComboBox;
   private int fromIndex=0,toIndex=0;
   private JLabel resultJLabel,radianJLabel;
  
     
   private JTextField toJTextField,fromJTextField,celicusJTextField,degreeJTextField;
   private double amt;
   public static void main(String arg[])
    {
        String message = "blank";

         new convertor();         
        
        
    }


   public convertor(){
     try
        {
          convertor = (IConventorService) Naming.lookup("rmi://localhost:5000/ConventorService1");  
          
        }
        catch (Exception e)
        {
           System.out.println("HelloClient exception: " + e.getMessage());
           e.printStackTrace();
        }  
     setSize(500,500);
     setVisible(true); 
     JTabbedPane convertorJTab=new JTabbedPane();
     convertorJTab.setBounds(50,50,200,200);  
     JPanel currencyJPanel=new JPanel();
     currencyJPanel.setLayout(new GridBagLayout());
     GridBagConstraints gc=new GridBagConstraints();
     gc.gridx=0;
     gc.gridy=0; 
     fromJLabel=new JLabel("Values");
     currencyJPanel.add(fromJLabel,gc);
     gc.gridx=1;
     toJLabel=new JLabel("Countries"); 
     currencyJPanel.add(toJLabel,gc);  
     
     gc.gridx=0;
     gc.gridy+=1;  
     fromJTextField=new JTextField(15); 
     currencyJPanel.add(fromJTextField,gc);     
     gc.gridx=1;
     fromJComboBox=new JComboBox(countries);
     currencyJPanel.add(fromJComboBox,gc);
     fromJComboBox.addItemListener(new ItemListener(){
       
       public void itemStateChanged(ItemEvent ie){
          amt=Double.parseDouble(fromJTextField.getText());
          fromIndex=fromJComboBox.getSelectedIndex();
          try{
          	toJTextField.setText(""+convertor.currencyConvertor(symbols[fromIndex],symbols[toIndex],amt));
          }catch(Exception e){} 
       }
     }); 
     
     gc.gridx=0;
     gc.gridy+=1;
     toJTextField=new JTextField(15);
     currencyJPanel.add(toJTextField,gc);   
     gc.gridx=1;
     JComboBox toJComboBox=new JComboBox(countries);
     currencyJPanel.add(toJComboBox,gc);
     toJComboBox.addItemListener(new ItemListener(){
       
       public void itemStateChanged(ItemEvent ie){
          amt=Double.parseDouble(fromJTextField.getText());
          toIndex=toJComboBox.getSelectedIndex();
          try{
           	toJTextField.setText(""+convertor.currencyConvertor(symbols[fromIndex],symbols[toIndex],amt));
          }catch(Exception e){} 
       }
     }); 
     gc.gridx=0;
     gc.gridy+=1;
     JButton curButton = new JButton("Convert");
     curButton.addActionListener(new ActionListener(){
       
       public void actionPerformed(ActionEvent ie){
          amt=Double.parseDouble(fromJTextField.getText());
          fromIndex=fromJComboBox.getSelectedIndex();
          toIndex=toJComboBox.getSelectedIndex();
          try{
          	toJTextField.setText(""+convertor.currencyConvertor(symbols[fromIndex],symbols[toIndex],amt));
          }catch(Exception e){} 
       }
     }); 
     currencyJPanel.add(curButton,gc);
     convertorJTab.addTab("Currency Convertor",currencyJPanel);
     
     
     add(convertorJTab);
     
     JPanel cTofJPanel = new JPanel();
     
     cTofJPanel.setLayout(new GridBagLayout());
     gc.gridx=0;
     gc.gridy=0; 
     JLabel celicusJLabel=new JLabel("Enter Celcious");
     cTofJPanel.add(celicusJLabel,gc);
     gc.gridy=1;
     celicusJTextField=new JTextField(15);
     cTofJPanel.add(celicusJTextField,gc);
     gc.gridy+=1;
     JButton convertJButton = new JButton("convert");
    
     convertJButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       
         
               
               try{
               
                  double cel = Double.parseDouble(celicusJTextField.getText()+"");
                  resultJLabel.setText(cel+"°c"+" is "+convertor.celicusToFahrenheit(cel)+"°F");
                  
               }catch(Exception e2){
                
                  JOptionPane.showMessageDialog(null,"Enter correct value","Error!!",JOptionPane.ERROR_MESSAGE);
               
               }
            
       
       }
     });
     cTofJPanel.add(convertJButton,gc);
     gc.gridy += 1;
     resultJLabel = new JLabel();
     cTofJPanel.add(resultJLabel, gc);
   
     convertorJTab.addTab("°C TO °F Convertor",cTofJPanel);
     
     JPanel dTorJPanel = new JPanel();
     
     dTorJPanel.setLayout(new GridBagLayout());
     gc.gridx=0;
     gc.gridy=0; 
     JLabel degreeJLabel=new JLabel("Enter Degree");
     dTorJPanel.add(degreeJLabel,gc);
     gc.gridy=1;
     degreeJTextField=new JTextField(15);
     dTorJPanel.add(degreeJTextField,gc);
     gc.gridy+=1;
     JButton degreeJButton = new JButton("convert");
    
     degreeJButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       
         
               try{
               
                  double deg = Double.parseDouble(degreeJTextField.getText()+"");
                  radianJLabel.setText(deg+"°"+" is "+convertor.degreeToRadian(deg)+"rad");
                  
               }catch(Exception e1){
                
                  JOptionPane.showMessageDialog(null,"Enter correct value","Error!!",JOptionPane.ERROR_MESSAGE);
               
               }
       
       }
     });
     dTorJPanel.add(degreeJButton,gc);
     gc.gridy += 1;
     radianJLabel = new JLabel();
     dTorJPanel.add(radianJLabel, gc);
     convertorJTab.addTab("° TO rad Convertor",dTorJPanel);
  }




}
