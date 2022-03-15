import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class TestUIInCode extends JFrame{
    private JTextField myText;
    private JButton myButton;
    private JLabel myLabel;
    private JLabel myLabel1;
    private JLabel myLabel2;
    private JLabel myLabel3;
    private JLabel myLabel4;
    private JPanel myPanel;


    public TestUIInCode(String title){
        //generate Jframe
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a JPanel
        myPanel = new JPanel();

        // create a JLabel and add some placeholder text
        myLabel = new JLabel();
        myLabel1 = new JLabel();
        myLabel2 = new JLabel();
        myLabel3 = new JLabel();
        myLabel.setText("???");
        myLabel1.setText("???");
        myLabel2.setText("???");
        myLabel3.setText("???");
        myLabel4 = new JLabel();
        myLabel4.setText("fill in 1 to 8");


        // create a textfield and set the size to 10
        myText = new JTextField(10);

        DBTest db = new DBTest();

        //create a button
        myButton = new JButton();
        myButton.setText("Get Info");

        //configure the actionlistener for the button
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number = myText.getText();
                ArrayList<String> array = db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/allfinal/1" ));
                String text  = array.get(1);
                myLabel.setText(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/allfinal/1")).get(0));
                myLabel1.setText(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/allfinal/1")).get(1));
                myLabel2.setText(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/allfinal/1")).get(2));
                myLabel3.setText(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/allfinal/1")).get(3));

            };


        });

        myPanel.add(myLabel);
        myPanel.add(myLabel1);
        myPanel.add(myLabel2);
        myPanel.add(myLabel3);
        myPanel.add(myText);
        myPanel.add(myLabel4);
        myPanel.add(myButton);

        //add the Jpanel to the Jframe
        this.setContentPane(myPanel);


    }
    public void setLabel(String theText){
        myLabel.setText(theText);

    }


    //Code always starts running at main
    public static void main(String[] args) {
        //generate my UI
        TestUIInCode ui= new TestUIInCode("Thomas Goris");
        ui.setVisible(true);
        ui.pack();
    }


}
