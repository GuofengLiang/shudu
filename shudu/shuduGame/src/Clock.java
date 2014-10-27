
public class Clock{//��������ʱ�ӵ���ʾ������
	 private long startTime = 0;//������ʼֵ
	    private long stopTime = 0;
	    private long pausedTime = 0;
	    private boolean running = false;//-------------------���ñ�־λ

	    public void start() {//----------------------------------------------------------------
	        this.startTime = System.currentTimeMillis();//���ص��Ǻ���
	        pausedTime = 0;//------------------------------����
	        this.running = true;
	    }

	    public void stop() {
	        this.stopTime = System.currentTimeMillis();
	        this.running = false;
	    }

	    public void pause() {
	        if(running) {//--------------------------------------------����ͣ��ť֮ǰ��Ҫ�и��жϣ�ʱ�ӱ��������е�
	            pausedTime = System.currentTimeMillis();
	            stop();
	        }
	    }

	    public void resume() {//---------------------------------------------������Ϸ��֮ǰҲҪ�и��жϣ�ʱ�ӱ�����ֹͣ��
	        if(!running){
	            long duration = System.currentTimeMillis() - pausedTime;//------------------��ͣ���Ƕ�ʱ��
	            startTime += duration;//-----------------------------------------�൱�ڰѿ�ʼ��ʱ���ӳ����Ƴ���
	            this.running = true;
	        }
	    }

	    //elaspsed time in milliseconds
	    public long getRuntime() {//--------------------------------------------���е�ʱ��
	        long runtime;
	        if (running) {//-------------------------------------------------------����������У�
	            runtime = (System.currentTimeMillis() - startTime);//-----------------�����¼�������������˶೤��ʱ��
	        } else {
	            runtime = (stopTime - startTime);//-------------------------------��Ϸ����ʱ�����˶೤ʱ��
	        }
	        return runtime;
	    }
    
}