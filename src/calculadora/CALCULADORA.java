package calculadora;

public class CALCULADORA {
    
    public static void main(String[] args) {
        ventana inicio = new ventana();
        inicio.setTitle("Calculadora basica");
        inicio.setBounds(500, 100, 400, 600); //posicion y dimensiones
        inicio.setResizable(false); //desactivar redimensión
        inicio.insertarPanel();
        inicio.insertarEtiquetas();
        inicio.insertarTexto();
        inicio.insertarBotones();
    }
    
}
