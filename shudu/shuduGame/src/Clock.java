
public class Clock{//用来控制时钟的显示的内容
	 private long startTime = 0;//给定初始值
	    private long stopTime = 0;
	    private long pausedTime = 0;
	    private boolean running = false;//-------------------设置标志位

	    public void start() {//----------------------------------------------------------------
	        this.startTime = System.currentTimeMillis();//返回的是毫秒
	        pausedTime = 0;//------------------------------？？
	        this.running = true;
	    }

	    public void stop() {
	        this.stopTime = System.currentTimeMillis();
	        this.running = false;
	    }

	    public void pause() {
	        if(running) {//--------------------------------------------按暂停按钮之前，要有个判断，时钟必须是运行的
	            pausedTime = System.currentTimeMillis();
	            stop();
	        }
	    }

	    public void resume() {//---------------------------------------------继续游戏，之前也要有个判断，时钟必须是停止的
	        if(!running){
	            long duration = System.currentTimeMillis() - pausedTime;//------------------暂停的那段时间
	            startTime += duration;//-----------------------------------------相当于把开始的时间延长，推迟了
	            this.running = true;
	        }
	    }

	    //elaspsed time in milliseconds
	    public long getRuntime() {//--------------------------------------------运行的时间
	        long runtime;
	        if (running) {//-------------------------------------------------------如果还在运行，
	            runtime = (System.currentTimeMillis() - startTime);//-----------------这里记录的是正在运行了多长的时间
	        } else {
	            runtime = (stopTime - startTime);//-------------------------------游戏结束时共花了多长时间
	        }
	        return runtime;
	    }
    
}
