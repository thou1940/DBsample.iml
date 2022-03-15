import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ex4 extends JFrame{
    private JTextField myText;
    private JTextField myText2;
    private JTextField myText3;
    private JTextField myText4;
    private JButton myButton;
    private JPanel myPanel;


    public Ex4(String title){
        //generate Jframe
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        myPanel = new JPanel();

        // create a textfield and set the size to 10
        myText = new JTextField(10);
        myText2 = new JTextField(10);
        myText3 = new JTextField(10);
        myText4 = new JTextField(10);
        String location = myText.getText();
        String unit = myText2.getText();
        String lastV = myText3.getText();
        String maxV = myText4.getText();

        DBTest db = new DBTest();


        //create a button
        myButton = new JButton();
        myButton.setText("insert");

        //configure the actionlistener for the button
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                db.parseJSON(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/insertt/lo/un/lv/mv"));

            };


        });

        myPanel.add(myText);
        myPanel.add(myText2);
        myPanel.add(myText3);
        myPanel.add(myText4);
        myPanel.add(myButton);



        //add the Jpanel to the Jframe
        this.setContentPane(myPanel);



    }



    //Code always starts running at main
    public static void main(String[] args) {
        //generate my UI
        Ex4 ui= new Ex4("Thomas Goris");
        ui.setVisible(true);
        ui.pack();
    }


}

