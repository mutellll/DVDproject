import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class DVDAdministration{
	public static void main(String args[]) {
		jtxtfrm fm = new jtxtfrm(); 
	}
}
class jtxtfrm extends Frame implements ActionListener {
	FileDialog	op, sv;//�ļ��Ի���
	Button		btn1, btn2, btn3;
	TextArea	tarea;

	jtxtfrm() {
		super("DVDAdministration");
		setLayout(null);
		setBackground(Color.pink);
		setSize(600, 300);
		setVisible(true);
		btn1 = new Button("��");
		btn2 = new Button("����");
		btn3 = new Button("�ر�");
		tarea = new TextArea("");
		add(btn1);
		add(btn2);
		add(btn3);
		add(tarea);
		tarea.setBounds(30, 50, 460, 220);
		btn1.setBounds(520, 60, 50, 30);
		btn2.setBounds(520, 120, 50, 30);
		btn3.setBounds(520, 180, 50, 30);
		op = new FileDialog(this, "��", FileDialog.LOAD);
		sv = new FileDialog(this, "����", FileDialog.SAVE);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		addWindowListener(new WindowAdapter() {//�ر��¼�����
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);//����ر�
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {//��ť1�¼�����
			String str;
			op.setVisible(true);//���ÿɼ�
			try {
				File f1 = new File(op.getDirectory(), op.getFile());//���ļ�
				FileReader fr = new FileReader(f1);
				BufferedReader br = new BufferedReader(fr);//��ȡ�ļ�
				tarea.setText("");
				while ((str = br.readLine()) != null)
					tarea.append(str + '\n');//�ı�����Ӷ�ȡ���ļ�����
				fr.close();//�رն�ȡ
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
				String gt = tarea.getText();//��ȡ�ı�������
				bw.write(gt, 0, gt.length());//���ı�������д���ļ�
				bw.flush();//������д���ļ�
				fw.close();//�ر�д��
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (e.getSource() == btn3) {
			System.exit(0);
		}
	}
}