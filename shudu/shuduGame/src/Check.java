
public class Check       //判断该数字能否填入该位置
{
        boolean boolcheck(int[][] data,int digit,int x,int y)//digit表示1-9的数值，x表示行,y表示列
        {
               for(int i=0;i<9;i++)
               {
                      if(data[x][i]==digit&&i!=y)          //同行遍历对比--------------------不等于是为了排除重叠
                            return false;
                      if(data[i][y]==digit&&i!=x)          //同列遍历对比
                            return false;
                      for(int n=x/3*3;n<x/3*3+3;n++)       //同宫遍历对比
                      {
                              for(int m=y/3*3;m<y/3*3+3;m++)
                              {
                                     if(x==n&&y==m)//-------------------x和y表示该盒子的位置，这里表示重叠了
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