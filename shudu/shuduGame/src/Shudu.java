import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JOptionPane;


public class Shudu {
		private int n=0;//��λ�ĸ��� 
		private Solver solver;		//����һ����������
		private int[][] data=new int[9][9];
		private static File file=new File("D:/shudu.txt");//��̬���������ڹ��캯��ִ��
		public Shudu(){
			this.setFile(file);
			this.reader();
			this.nullSpace();
			solver=new Solver(data, n);
			this.data=solver.checkFull();
		}
		public int[][] getData(){//-------------------------------------
			return this.data;
		}
		public void setFile(File file){
			Shudu.file=file;
		}
		public int[][] reader(){
			try{
				FileReader fir=new FileReader(file);
				@SuppressWarnings("resource")
				BufferedReader bufr=new BufferedReader(fir);
				String len=null;
				int loc=0;
		            //-------------------------------------------��һ��ȡÿһ���ַ���
		                while((len=bufr.readLine())!=null){//������԰��ж�ȡ�������Զ�ȡһ��,,,,�ﵽ���Ľ�β�򷵻�-1
		                	//String Regex="\\s|,";
		                	String Regex="\\D";
		                	String arr=len.replaceAll(Regex, "");
		                	char[] ch=arr.toCharArray();
		                	for(int i=0;i<9;i++){
		                	data[loc/9][loc%9]= ch[i]-'0';
		                	loc++;
		                	}
		                   if(loc>=81){
		                	   break;
		                   }
		                }
				
			}
			catch(Exception e){
				return data;
			}
			return data;
		}
		public void nullSpace(){
			 for(int i=0;i<9;i++)                //���ԭ����������ȡ�����п�λ����
	         {
	               for(int j=0;j<9;j++)
	              {
	                    if(data[i][j]==0)
	                   {
	                         n++;
	                   }
	             }
	       }
		}
		public void ResultPrint(){//����Ĵ���������solver�е�data��������ͬ��
			try{
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bufw=new BufferedWriter(fw);
			if(data==null){
				bufw.write("�޽⣿����");
				fw.close();
			}
			else{
				bufw.newLine();
				bufw.newLine();
				bufw.write("�����Ĵ����£�");
				bufw.newLine();
				bufw.flush();
			for(int i=0;i<9;i++)                //������
			{
				for(int j=0;j<9;j++)
				{
					bufw.write(data[i][j]+"");
					bufw.append(" ");
					bufw.flush();
				}
				bufw.newLine();
			}
			
			fw.close();
			}
			}
			catch(Exception e){}
	}
		public static void main(String[] args){
			new Shudu();
			
		}

}