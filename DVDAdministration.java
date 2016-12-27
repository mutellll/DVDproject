import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class DVDAdministration{
	public static void main(String args[]) {
		jtxtfrm fm = new jtxtfrm(); 
	}
}
class jtxtfrm extends Frame implements ActionListener {
	FileDialog	op, sv;//文件对话框
	Button		btn1, btn2, btn3;
	TextArea	tarea;

	jtxtfrm() {
		super("DVDAdministration");
		setLayout(null);
		setBackground(Color.pink);
		setSize(600, 300);
		setVisible(true);
		btn1 = new Button("打开");
		btn2 = new Button("保存");
		btn3 = new Button("关闭");
		tarea = new TextArea("");
		add(btn1);
		add(btn2);
		add(btn3);
		add(tarea);
		tarea.setBounds(30, 50, 460, 220);
		btn1.setBounds(520, 60, 50, 30);
		btn2.setBounds(520, 120, 50, 30);
		btn3.setBounds(520, 180, 50, 30);
		op = new FileDialog(this, "打开", FileDialog.LOAD);
		sv = new FileDialog(this, "保存", FileDialog.SAVE);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		addWindowListener(new WindowAdapter() {//关闭事件处理
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);//程序关闭
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {//按钮1事件处理
			String str;
			op.setVisible(true);//设置可见
			try {
				File f1 = new File(op.getDirectory(), op.getFile());//打开文件
				FileReader fr = new FileReader(f1);
				BufferedReader br = new BufferedReader(fr);//读取文件
				tarea.setText("");
				while ((str = br.readLine()) != null)
					tarea.append(str + '\n');//文本框添加读取的文件内容
				fr.close();//关闭读取
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btn2) {
			sv.setVisible(true);
			try {
				File f1 = new File(sv.getDirectory(), sv.getFile());
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bw = new BufferedWriter(fw);
				String gt = tarea.getText();//获取文本框内容
				bw.write(gt, 0, gt.length());//将文本框内容写入文件
				bw.flush();//真正的写入文件
				fw.close();//关闭写入
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (e.getSource() == btn3) {
			System.exit(0);
		}
	}
}