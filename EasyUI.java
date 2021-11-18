import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class EasyUI extends JFrame implements ActionListener {
public EasyUI() {
setLocationByPlatform(true);
setSize(1000, 700);
setLayout(null);
initUI();
setVisible(true);
}
JButton mBtn0,mBtn1;
private void initUI(){
mBtn0= new JButton("Button2");
mBtn0.setSize(90,50);
mBtn0.setLocation(97,274);
mBtn0.addActionListener(this);
add(mBtn0);

mBtn1= new JButton("Button1");
mBtn1.setSize(90,50);
mBtn1.setLocation(243,274);
mBtn1.addActionListener(this);
add(mBtn1);

}
@Override
public void actionPerformed(ActionEvent e) {
Object source = e.getSource();
if(source == mBtn0){
}else if(source == mBtn1){
}}
public static void main(String[] args) {
new EasyUI();
}
}
