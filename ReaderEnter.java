import java.awt.*;
import javax.swing.*;
public class ReaderEnter extends JFrame{
	JTextField jTextField;
	JPasswordField jPasswordField;
	JLabel jLabel1,jLabel2;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	public ReaderEnter(){
		jTextField=new JTextField(10);
		jPasswordField=new JPasswordField(11)��
		jLabel1=new JLabel("�û���");
		jLabel2=new JLabel("����");
		jb1=new JButton("ȷ��");
		jb2=new JButton("ȡ��");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		this.setLayout(new GridLayout(3,1));
		jp1.add(jLabel1);
		jp1.add(jTextField);
		jp2.add(jLabel2);
		jp2.add(jPasswordField);
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setBounds(400,100,300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("�û���¼");		
	}
	
	public static void main(String[] args){
		new ReaderEnter();
	}
}
