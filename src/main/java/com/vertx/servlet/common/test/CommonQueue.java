package com.ntels.cep.common.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;


public class CommonQueue {

	
	public CommonQueue() {
//		logger.info("CommonQueue start");
	}
	
	
	private Logger logger = Logger.getLogger(getClass());

	public static AtomicLong curCnt = new AtomicLong(0L);
    public static AtomicLong totCnt = new AtomicLong(0L);
    public static int reCnt=0;


	public static long beforeTime;
    public static long afterTime;
    
    public static int getReCnt() {
    	return reCnt;
    }
    
    public static void setReCnt(int reCnt) {
    	CommonQueue.reCnt = reCnt;
    }
    
    public AtomicLong getCurCnt() {
        return curCnt;
    }

	public long getBeforeTime() {
		return beforeTime;
	}

	public void setBeforeTime(long beforeTime) {
		this.beforeTime = beforeTime;
	}

	public long getAfterTime() {
		return afterTime;
	}

	public void setAfterTime(long afterTime) {
		this.afterTime = afterTime;
	}

	public AtomicLong getTotCnt() {
        return totCnt;
    }
    
    private BlockingQueue<byte[]> transferOutQueue = new LinkedBlockingQueue<byte[]>();
    
    // Queue Method
 	public boolean addTransferOutQueue(byte[] data){
 		try{
 			transferOutQueue.add(data);
 		}catch(Exception e){
 			logger.error("@@@ CommonQueue - addSocketRawOutQueue ERROR!!" + e.getMessage());
 			logger.error(null, e);
 			return false;
 		}
 		return true;
 	}
 	public List<byte[]> getTransferOutQueue(){
 		List<byte[]> datalist = new ArrayList<byte[]>();
 		try{
 			transferOutQueue.drainTo(datalist);
 			if( datalist.size() > 0){
 				return datalist;
 			}else{
 				datalist.add(transferOutQueue.take());
 			}
 		}catch(Exception e){
 			logger.error("@@@ CommonQueue - getSocketRawOutQueue ERROR!!" + e.getMessage());		
 			logger.error(null, e);
 		}
 		return datalist;
 	}
 	
 	public int getTransferQueueCnt(){
 		return transferOutQueue.size();
 	}
}
