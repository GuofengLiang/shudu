
public class Check       //�жϸ������ܷ������λ��
{
        boolean boolcheck(int[][] data,int digit,int x,int y)//digit��ʾ1-9����ֵ��x��ʾ��,y��ʾ��
        {
               for(int i=0;i<9;i++)
               {
                      if(data[x][i]==digit&&i!=y)          //ͬ�б����Ա�--------------------��������Ϊ���ų��ص�
                            return false;
                      if(data[i][y]==digit&&i!=x)          //ͬ�б����Ա�
                            return false;
                      for(int n=x/3*3;n<x/3*3+3;n++)       //ͬ�������Ա�
                      {
                              for(int m=y/3*3;m<y/3*3+3;m++)
                              {
                                     if(x==n&&y==m)//-------------------x��y��ʾ�ú��ӵ�λ�ã������ʾ�ص���
                                     continue;
                                    if(data[n][m]==digit)
                                    {
                                               return false;
                                    }
                            }
                     }
              }
              return true;
       }
}