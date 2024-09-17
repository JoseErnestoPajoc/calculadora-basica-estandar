package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ventana extends JFrame {

    JPanel panelInicio = new JPanel();
    JTextField txtValor1 = new JTextField();
    JTextField txtValor2 = new JTextField();
    JLabel lblResultado = new JLabel("Total");
    int valor1 = 0;
    char simbolo = ' ';

    public ventana() {
        this.setVisible(true);  //Hacer visible la ventana
        //finalizar ejecución al dar clic en cerrar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //crear panel
    public void insertarPanel() {
        this.getContentPane().add(panelInicio);
        //panelInicio.setBackground(Color.orange); aplica color de fondo al panel
        panelInicio.setLayout(null); //desactivar la organización automática
    }

    public void insertarEtiquetas() {
        JLabel lblValor1 = new JLabel("Ingrese el primer valor");
        lblValor1.setBounds(20, 10, 200, 15);
        panelInicio.add(lblValor1);

        JLabel lblValor2 = new JLabel("Ingrese el segundo valor");
        lblValor2.setBounds(20, 80, 200, 15);
        panelInicio.add(lblValor2);

        lblResultado.setBounds(20, 180, 200, 25);
        panelInicio.add(lblResultado);
    }

    public void insertarTexto() {
        txtValor1.setBounds(190, 10, 150, 25);
        panelInicio.add(txtValor1);
        txtValor1.repaint();

        txtValor2.setBounds(190, 80, 150, 25);
        panelInicio.add(txtValor2);
        txtValor2.repaint();
    }

    public void insertarBotones() {
        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBounds(120, 130, 80, 30);
        panelInicio.add(btnSumar);
        btnSumar.repaint();

        ActionListener sumando = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (txtValor1.getText().equals("") || txtValor2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                } else {
                    int resultadoSuma = Integer.parseInt(txtValor1.getText()) + Integer.parseInt(txtValor2.getText());
                    lblResultado.setText("Total: " + String.valueOf(resultadoSuma));
                }
            }
        };
        btnSumar.addActionListener(sumando);
        
        JButton btnSum = new JButton("+");
        panelInicio.add(btnSum);
        btnSum.setBounds(230, 130, 60, 30);
        ActionListener suma2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtValor1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
                }else{
                    valor1 += Integer.parseInt(txtValor1.getText());
                    simbolo = '+';
                    txtValor1.setText("");
                }
            }
        };
        btnSum.addActionListener(suma2);
        
        JButton btnRes = new JButton("-");
        panelInicio.add(btnRes);
        btnRes.setBounds(230, 180, 60, 30);
        ActionListener res2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtValor1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
                }else{
                    if(valor1 == 0){
                        valor1 = Integer.parseInt(txtValor1.getText());
                    }else{
                        valor1 -= Integer.parseInt(txtValor1.getText());
                    }
                    simbolo = '-';
                    txtValor1.setText("");
                }
            }
        };
        btnRes.addActionListener(res2);
        
        JButton btnIgual = new JButton("=");
        panelInicio.add(btnIgual);
        btnIgual.setBounds(300, 130, 60, 30);
        ActionListener resultado = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = 0;
                if (simbolo == '+') {
                    resultado = valor1 + Integer.parseInt(txtValor1.getText());  
                }else if(simbolo == '-'){
                    resultado = valor1 - Integer.parseInt(txtValor1.getText());   
                }
                txtValor1.setText(String.valueOf(resultado));
                valor1 = 0;
                
            }
        };
        btnIgual.addActionListener(resultado);
        
        
        JButton btnRaiz = new JButton("√");
        panelInicio.add(btnRaiz);
        btnRaiz.setBounds(280, 180, 60, 30);
        ActionListener resRaiz = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtValor1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
                }else{
                    if(Double.parseDouble(txtValor1.getText()) >= 0){
                        double total = Math.sqrt(Double.parseDouble(txtValor1.getText()));
                        txtValor1.setText(String.valueOf(total));
                        valor1 = 0;
                    }else{
                        JOptionPane.showMessageDialog(null, "Math Error");
                    }
                }
            }
        };
        btnRaiz.addActionListener(resRaiz);
        

        JButton btn1 = new JButton("1");
        btn1.setBounds(120, 180, 50, 30);
        panelInicio.add(btn1);
        btn1.repaint();

        ActionListener agregar1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String union = txtValor1.getText() + "1";
                txtValor1.setText(union);
            }
        };
        btn1.addActionListener(agregar1);
        
        JButton btn2 = new JButton("2");
        btn2.setBounds(180, 180, 50, 30);
        panelInicio.add(btn2);
        btn2.repaint();
        
        ActionListener agregar2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String union = txtValor1.getText() + "2";
                txtValor1.setText(union);
            }
        };
        btn2.addActionListener(agregar2);
        
        JButton btnBorrar = new JButton("<");
        panelInicio.add(btnBorrar);
        btnBorrar.setBounds(180, 230, 50, 30);
        
        ActionListener borrarUno = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                                
                String union = "";
                for (int i = 0; i < txtValor1.getText().length() - 1; i++) {
                    union = union + txtValor1.getText().charAt(i);
                }
                
                txtValor1.setText(union);
                
            }
        };
        
        btnBorrar.addActionListener(borrarUno);
        
    }
}
