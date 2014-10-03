
import Forms.JFrmAutor;
import Forms.JFrmCliente;
import Forms.JFrmDiretor;
import Forms.JFrmMenu;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        }catch(Exception ex){}
        
        //JFrmMenu dialog = new JFrmMenu();
        JFrmDiretor dialog = new JFrmDiretor();
        dialog.setVisible(true);
     }
}
