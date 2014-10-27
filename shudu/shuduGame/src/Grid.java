import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Grid extends JPanel{//用来创建9*9的网格布局面板
	private Shudu shudu=new Shudu();
	private int[][] data=new int[9][9];
	private JButton[][] jb=new JButton[9][9];
	public Grid(){
		data=shudu.reader();
		this.initialPanel();
	}
	public Grid(ShuduUI shuduUI){
		this.data=shudu.getData();
		this.initialPanel();
	}
	public void initialPanel(){
		this.setLayout(new GridLayout(9,9));
		String str=null;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(data[i][j]==0){
					str="";
				}
				else{
					str=data[i][j]+"";
				}
				jb[i][j]=new JButton(str);//将每次创建的按钮添加到存放按钮的数组中
				this.add(jb[i][j]);
	                jb[i][j].setFont(new Font("宋体", Font.PLAIN, 24));// 设置按钮上的字体
	                if (((0 <= i && i < 3) || (6 <= i && i < 9)) && (3 <= j && j < 6)) {//-----------------对宫格进行染色
	                    jb[i][j].setBackground(new Color(204, 204, 204));
	                } else if ((3 <= i && i < 6) && ((0 <= j && j < 3) || (6 <= j && j < 9))) {
	                    jb[i][j].setBackground(new Color(204, 204, 204));
	                } else {
	                    jb[i][j].setBackground(new Color(255, 255, 255));
	                }
			}
		}
	}
}
