package com.ntels.cep.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorServer implements Runnable{
    
	private CommonQueue commonQueue;
	
	public MonitorServer(CommonQueue commonQueue) {
		this.commonQueue = commonQueue;
		logger.info("MonitorServer start");
//		commonQueue.setBeforeTime(System.currentTimeMillis());
	}
	private Logger logger = LoggerFactory.getLogger(MonitorServer.class);

    public void run(){
    	while(true) {
    		try{    		
        		long totalInputCnt = commonQueue.getTotCnt().get();
        		long cutInputCnt = commonQueue.getCurCnt().get();
        		long tps3 =  cutInputCnt / 3;
        		long bt = commonQueue.getBeforeTime();
        		long at = commonQueue.getAfterTime();
        		int rt = commonQueue.getReCnt();	
        		int secDiffTime = (int)(at - bt)/1000;
        		long tpst = secDiffTime!=0?totalInputCnt / secDiffTime:0;
        		
        		
        		logger.info("### monitor ST ["+bt+"] INPUT_TOTAL:[" + totalInputCnt + "] receTOTAL:[" + rt + "] 3sCnt:[" + cutInputCnt + "]  3sTPS:[" + tps3 + "] time:[" + secDiffTime + "] total TPS:[" + tpst + "] ");
        		commonQueue.getCurCnt().set(0L);

        		
        		Thread.sleep(3000L);
        		
        	}catch(Exception e){
        		e.printStackTrace();
        		logger.error(null, e);
        	}
    	}
    	
    }
}
