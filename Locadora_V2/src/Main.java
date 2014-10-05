
import Forms.JFrmAutor;
import Forms.JFrmCliente;
import Forms.JFrmDiretor;
import Forms.JFrmFornecedor;
import Forms.JFrmLocacao;
import Forms.JFrmMenu;
import Forms.JFrmMidia;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        }catch(Exception ex){}
        
        //JFrmMenu dialog = new JFrmMenu();
        JFrmLocacao dialog = new JFrmLocacao();
        dialog.setVisible(true);
     }
}
