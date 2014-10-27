import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
public class ShuduUI extends JFrame implements ActionListener{//��������������
	private JMenuBar bar=new JMenuBar();
	private JMenu[] menuArray={new JMenu("�ȼ�"),new JMenu("�Զ���"),new JMenu("����"),new JMenu("����"),new JMenu("��Ϸ")};
	private JMenuItem[] itemArray={new JMenuItem("����"),new JMenuItem("�м�"),new JMenuItem("�߼�"),new JMenuItem("�����ļ�"),
							new JMenuItem("������"),new JMenuItem("�����ٿ�"),new JMenuItem("�汾"),new JMenuItem("�˳�")};
	private JPanel options=new JPanel();
	private JButton[] jbArray={new JButton("��ʼ"),new JButton("��ͣ"),new JButton("����"),new JButton("����"),new JButton("����"),new JButton("�ύ")};
    private JLabel time=new JLabel();//����ʱ���
	private Grid grid=new Grid();//�����Ź��������
	private Shudu shudu=new Shudu();
	private Clock clock=new Clock();
	private JPanel jp=new JPanel();
	private FileDialog open=new FileDialog(this,"��",FileDialog.LOAD);
	private File file=new File("D:/shudu.txt");
	private boolean paused=false;
	private JSplitPane jsp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,options,jp);;
	public ShuduUI(){
		this.initialBar();
		this.initialTime();
		this.initialPanel();
		this.initialFrame();
		this.addListener();
		
	}
	
	
	public void initialBar(){
		menuArray[4].add(itemArray[7]);
		menuArray[0].add(itemArray[0]);//Ϊ��һ���˵�����������
		menuArray[0].addSeparator();
		menuArray[0].add(itemArray[1]);
		menuArray[0].addSeparator();
		menuArray[0].add(itemArray[2]);//Ϊ�ڶ����˵�����������
		menuArray[1].add(itemArray[3]);
		menuArray[1].addSeparator();
		menuArray[1].add(itemArray[4]);
		menuArray[2].add(menuArray[3]);
		menuArray[3].add(itemArray[5]);//Ϊ�������˵�����������
		menuArray[3].addSeparator();
		menuArray[3].add(itemArray[6]);
		bar.add(menuArray[4]);
		bar.add(menuArray[0]);//Ϊ�˵������Ӳ˵�
		bar.add(menuArray[1]);
		bar.add(menuArray[2]);
	}
	private void initialTime() {
		time.setFont(new Font("����", Font.BOLD,16)); 
		time.setForeground(new Color(0,0,0));
		time.setBackground(new Color(180,195,218));
		time.setOpaque(true);
        Thread thread = new Thread(new Runnable() {//--------------------------------------����һ��ʱ���߳�

            public void run() {
                clock.start();//-------------------------------------------��ʾ��ʼ��ʱ�����ص�������
                while (true) {
                    if (!paused) {//---------------------��pausedΪfalseʱ
                        final String timeString = new SimpleDateFormat("mm:ss:SSS").format(clock.getRuntime());
                        time.setText("" + timeString);//---------------------------------ʱ�ӱ�ǩ��Ҫ��ʾ���ַ���
                    }
                }
            }
        });
        thread.start();
    }             
	public void initialPanel(){
		options.setLayout(new GridLayout());
		options.add(jbArray[0]);options.add(jbArray[1]);
		options.add(jbArray[2]);options.add(jbArray[3]);
		options.add(jbArray[4]);options.add(jbArray[5]);
		options.add(time);
	}
	public void initialFrame(){
		jp.setLayout(new GridLayout());
		jp.add(grid);
		this.setJMenuBar(bar);
		jsp.setDividerLocation(30);
		jsp.setDividerSize(4);
		jsp.setEnabled(false);//���÷ָ������ܹ���
		
		this.add(jsp);
		
		//this.setIconImage(image);
		this.setTitle("������԰");
		this.setFont(new Font("����", Font.PLAIN, 18));
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=screenSize.width/2;
		int height=screenSize.height/2;
		int w=600;
		int h=600;
		this.setBounds(width-w/2, height-h/2, w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public void addListener(){
		
		for(int i=0;i<itemArray.length;i++){
			itemArray[i].addActionListener(this);
		}
		for(int i=0;i<jbArray.length;i++){
			jbArray[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==itemArray[7]){//�˳���Ϸ
			System.exit(0);
		}
		if(e.getSource()==itemArray[0]){//����
			JOptionPane.showMessageDialog(this, "�ȼ�ģ�����ڿ����У���������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==itemArray[1]){//�м�
			/*�ù������ڿ�����*/
		}
		if(e.getSource()==itemArray[2]){//�߼�
			/*�ù������ڿ�����*/
		}
		if(e.getSource()==itemArray[3]){//�����ļ�
			open.setVisible(true);
			String dirpath=open.getDirectory();
			String fileName=open.getFile();
			if(dirpath==null||fileName==null)
				return;
			try{
				file=new File(dirpath,fileName);
				shudu.setFile(file);
					jp.removeAll();
					jp.add(new Grid());
					jp.validate();
			}
			catch(Exception ea){
				jp.removeAll();
				JOptionPane.showMessageDialog(this, "����ʧ�ܣ��������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
				}	
				
			}
		
		if(e.getSource()==itemArray[4]){//�����ļ�
			shudu=new Shudu();
			shudu.ResultPrint();	//ԭ����������ˣ�������ע�������������
			try{
				
					JOptionPane.showMessageDialog(this, "��ϲ�����Ѿ��ɹ������𰸵�ԭ�����ļ���,\n�밴ȷ���鿴", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				java.awt.Desktop.getDesktop().open(file);
				
				}
			catch(Exception ea){}
		}
		if(e.getSource()==itemArray[5]){//�����ٿ�
			try{
				Runtime.getRuntime().exec("rundll32  url.dll,FileProtocolHandler "+"http://baike.baidu.com/" +
						"subview/961/10842669.htm?fr=aladdin" );//���������������������ӵ������ٿ���ҳ
			}
			catch(Exception ea){}
		}
		if(e.getSource()==itemArray[6]){//�汾
			JOptionPane.showMessageDialog(this, "�汾��1.0\n�Ѹ��������°汾", "�汾��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource()==jbArray[0]){//��ʼ�ŵ�����
			clock.start();
			/*�ù������ڿ�����*/
		}
		if(e.getSource()==jbArray[1]){//��ͣ
			 clock.pause();//-----------------------------------------------Ҫ�õ�����������Ķ����ڹ��캯���н��г�ʼ��
		        JOptionPane.showMessageDialog(this, "����ͣ", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==jbArray[2]){//����
			clock.resume();//-----------------------------------------------Ҫ�õ�����������Ķ����ڹ��캯���н��г�ʼ��
		}
		if(e.getSource()==jbArray[3]){//����,��ԭ��������������д
			clock.start();
			jp.removeAll();
			jp.add(new Grid());
			jp.validate();
		}
		
		if(e.getSource()==jbArray[4]){//����
			jp.removeAll();
			jp.add(new Grid(this));
			//		jp.repaint();
			//		this.setVisible(true);
			jp.validate();
			clock.pause();
		}
		if(e.getSource()==jbArray[5]){//�ύ
			clock.pause();
		}
	}
		
	public static void main(String[] args){
		new ShuduUI();
		
	}
}