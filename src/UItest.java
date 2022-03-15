
import javax.swing.*;

public class UItest extends JFrame{

    private JLabel myLabel;
    private JPanel myPanel;


    public UItest(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new JPanel();
        myLabel = new JLabel();
        myLabel.setText("This is placeholder text");
        myPanel.add(myLabel);

        this.setContentPane(myPanel);

    }


    public static void main(String[] args) {
        UItest ui= new UItest("Mytitle");
        ui.setVisible(true);
        ui.pack();
    }


}

