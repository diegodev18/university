import javax.swing.JOptionPane;

public class JavaLibsPractice {

    public static void main(String[] args) {
        // TODO code application logic here
        String name = JOptionPane.showInputDialog("Enter your name");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight"));

        
    }
}