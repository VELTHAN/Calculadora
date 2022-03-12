import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Calculadora extends JFrame implements ActionListener {
   JButton btnC, btnDiv, btnMulti, btnResta, btnSuma, btnIgual;
   JTextField txtCasilla;

   public float primerNumero;
   public float segundoNumero;
   public String operador;
    
   public void Controles() {
      
      Container contenedor = getContentPane();
      contenedor.setLayout( new FlowLayout());
      
      txtCasilla = new JTextField(25);
      contenedor.add(txtCasilla);
      
      btnC = new JButton("C");
      contenedor.add(btnC);
      btnC.addActionListener(this);
      
      btnDiv = new JButton("/");
      contenedor.add(btnDiv);
      btnDiv.addActionListener(this);
      
      btnMulti = new JButton("*");
      contenedor.add(btnMulti);
      btnMulti.addActionListener(this);
      
      btnResta = new JButton("-");
      contenedor.add(btnResta);
      btnResta.addActionListener(this);
      
      btnSuma = new JButton("+");
      contenedor.add(btnSuma);
      btnSuma.addActionListener(this);
      
      btnIgual = new JButton("=");
      contenedor.add(btnIgual);
      btnIgual.addActionListener(this);
   }
  
   public Calculadora() {
      super("Calculadora");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Controles();
      setSize(300,150);
      setLocationRelativeTo(null);
      setVisible(true); 
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource()==btnSuma) {
         this.primerNumero=Float.parseFloat(this.txtCasilla.getText());
         this.operador = "+";
         this.txtCasilla.setText("");
      }
      
      if (e.getSource() == btnMulti) {
         this.primerNumero=Float.parseFloat(this.txtCasilla.getText());
         this.operador = "*";
         this.txtCasilla.setText("");
      }
      
      if (e.getSource() == btnDiv) {
         this.primerNumero = Float.parseFloat(this.txtCasilla.getText());
         this.operador = "/";
         this.txtCasilla.setText("");
      }
      if (e.getSource() == btnResta) {
         this.primerNumero = Float.parseFloat(this.txtCasilla.getText());
         this.operador = "-";
         this.txtCasilla.setText("");
      }
      if (e.getSource() == btnIgual) {
         this.segundoNumero = Float.parseFloat(this.txtCasilla.getText());
         switch(this.operador) {
            case "+": this.txtCasilla.setText(Float.toString(this.primerNumero + this.segundoNumero));
               break;
            case "*": this.txtCasilla.setText(Float.toString(this.primerNumero * this.segundoNumero));
               break;
            case "/": if(this.segundoNumero == 0) {
                        this.txtCasilla.setText("NO se divide entre 0");
                      } else {
                          this.txtCasilla.setText(Float.toString(this.primerNumero / this.segundoNumero));
                      }
               break;
            case "-": this.txtCasilla.setText(Float.toString(this.primerNumero - this.segundoNumero));
               break;
         }
      }
      if (e.getSource() == btnC) {
         txtCasilla.setText("");
      } 
   }
}