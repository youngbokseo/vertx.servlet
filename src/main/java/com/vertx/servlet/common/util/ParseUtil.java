package com.ntels.cep.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntels.cep.engine.vo.InputEvent;
import com.ntels.cep.engine.vo.Rule;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import kr.co.ntels.iot.domain.oneM2M.ContentInstance;
import kr.co.ntels.iot.domain.oneM2M.Notification;
import kr.co.ntels.iot.domain.oneM2M.converter.JsonMessageConverter;

public class ParseUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ParseUtil.class);
	private static JsonMessageConverter jsonconverter = new JsonMessageConverter();
	private static ObjectMapper om = new ObjectMapper();
	
	public static JsonObject parseSendData2(String params) {
//		logger.info("####nmas param : " +params);
			Notification nivo = null;
//	        try {
//	        	nivo = (Notification)jsonconverter.read(params);
//	        }catch(Exception e) {
//	        	logger.error(null,e);
//	        }
////	        logger.info("####nmas nivo : " +nivo.toString());
//	         
//	        JsonObject pr = new JsonObject();
//	        if(!nivo.getSubscriptionReference().isEmpty()) {
//	        	String eventname = nivo.getSubscriptionReference();
////	        	logger.info("####nmas name : " +eventname);
//	        	String[] nameArr = eventname.split("/");
//	        	String lastName = Character.toUpperCase(nameArr[3].charAt(0))+nameArr[3].toLowerCase().substring(1)
//	        			+Character.toUpperCase(nameArr[4].charAt(0))+nameArr[4].toLowerCase().replace("_", "").substring(1)
//	        			+Character.toUpperCase(nameArr[5].charAt(0))+nameArr[5].toLowerCase().replace("-", "").substring(1);
////	        	logger.info("####nmas last name : " +lastName);
//	        	pr.put("event_name", lastName);
//	        }else {
			JsonObject pr = new JsonObject(params);
	        	return pr;
//	        }
//	        if( nivo.getNotificationEvent().getRepresentation() instanceof ContentInstance ) {
//	           ContentInstance cin = (ContentInstance)nivo.getNotificationEvent().getRepresentation();
//	           
////	           logger.info("####nmas con : " +cin.getContent());
//	           
//	           JsonObject levent;
//	           if((cin.getContent() instanceof String) == false) {
//	        	   try {
////	        		   logger.info("####nmas con22222 : " +om.writeValueAsString(cin.getContent()).toString());
//	        		   levent= new JsonObject(om.writeValueAsString(cin.getContent()).toString());
////	        		   logger.info("####nmas event : " +levent.toString());
//			           pr.put("event", levent);
//	        	   } catch (JsonProcessingException e) {
//	        		   // TODO Auto-generated catch block
//	        		   e.printStackTrace();
//	        	   }
//	           }else {
//	        	   levent= new JsonObject(cin.getContent().toString());
////	        	   logger.info("####nmas event : " +levent.toString());
//		           pr.put("event", levent);
//	           }
//	        }
////jsonobject를 map으로 변환해서 return 하며[ㄴ됨
////	        logger.info("####nmas last jo  : " +pr.toString());
//	        return pr;
		
	}
	public static JsonObject parseSendData(Map<String, Object> params) {
		if(params.get("event_name") == null || params.get("event_name").toString().equals("")) {
			JsonObject event = JsonObject.mapFrom(params);
			logger.info("####nmas param : " +event.toString());
			Notification nivo = null;
	        try {

	        	nivo = (Notification)jsonconverter.read(event.toString());
	        }catch(Exception e) {
	        	logger.error(null,e);
	        }
	        logger.info("####nmas nivo : " +nivo.toString());
	         
	        JsonObject pr = new JsonObject();
	        if(!nivo.getSubscriptionReference().isEmpty()) {
	        	String eventname = nivo.getSubscriptionReference();
	        	logger.info("####nmas name : " +eventname);
	        	String[] nameArr = eventname.split("/");
	        	String lastName = Character.toUpperCase(nameArr[3].charAt(0))+nameArr[3].toLowerCase().substring(1)
	        			+Character.toUpperCase(nameArr[4].charAt(0))+nameArr[4].toLowerCase().substring(1)
	        			+Character.toUpperCase(nameArr[5].charAt(0))+nameArr[5].toLowerCase().replace("-", "").substring(1);
	        	logger.info("####nmas last name : " +lastName);
	        	pr.put("event_name", lastName);
	        }
	        if( nivo.getNotificationEvent().getRepresentation() instanceof ContentInstance ) {
	           ContentInstance cin = (ContentInstance)nivo.getNotificationEvent().getRepresentation();
	           
	           logger.info("####nmas con : " +cin.getContent());
	           JsonObject levent = new JsonObject(cin.getContent().toString());
	           logger.info("####nmas event : " +levent.toString());
	           pr.put("event", levent);
	        }
//jsonobject를 map으로 변환해서 return 하며[ㄴ됨
	        logger.info("####nmas last jo  : " +pr.toString());
	        return pr;
		}else {
			return JsonObject.mapFrom(params);
		}
		
	}
	
	
	public static InputEvent parseEventFromMap(Map<String, Object> params) {
		
		InputEvent vo = new InputEvent();
        JsonArray arr = new JsonArray();
        String str = params.get("event_name_order").toString();
        String[] a = str.replace("[", "").replace("]", "").replace(" ", "").split(",");
        
        for(String x : a) {
        	arr.add(x);
        }
        vo.setEventName(StringUtils.defaultString(params.get("event_name").toString()));
        vo.setEvent_name_order(arr.encode());
        vo.setEvent_query(StringUtils.defaultString(params.get("event_query").toString()));
        vo.setEvent_type(StringUtils.defaultString(params.get("event_type").toString()));
        vo.setEvent_descp(StringUtils.defaultString(params.get("event_descp")==null?"":params.get("event_descp").toString()));
        vo.setInit_value_yn(StringUtils.defaultString(params.get("init_value_yn").toString()));
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setInsert_date(sdf.format(today));
        vo.setUpdate_date(sdf.format(today));
		
		return vo;
	}
	
	
	public static JsonObject parseJsonObectFromMap(Map<String, Object> params) {
		JsonObject vo = new JsonObject();
    
	    vo.put("rule_name", params.get("rule_name"));
	    vo.put("rule_descp",params.get("rule_descp"));
	    vo.put("send_method",params.get("send_method"));
	    vo.put("send_type", params.get("send_type"));
	    vo.put("send_info", params.get("send_info"));
	    vo.put("send_content", params.get("send_content"));
	    vo.put("rule_query", params.get("rule_query"));
	    vo.put("event_info", params.get("event_info"));
		
		return vo;
	}

	public static JsonObject parseJsonObectFromEvent(InputEvent vo) {
		
		JsonObject event = new JsonObject();
        event.put("event_id", vo.getEventId());
        event.put("event_name", vo.getEventName());
        event.put("event_descp", vo.getEvent_descp());
        event.put("event_type", vo.getEvent_type());
        event.put("init_value_yn", vo.getInit_value_yn());
        event.put("init_value", vo.getInit_value());
        event.put("event_query", vo.getEvent_query());
        event.put("insert_date", vo.getInsert_date());
		
		return event;
	}
	
	public static JsonObject parseJsonObectFromRule(Rule vo) {
		
		JsonObject rule = new JsonObject();
		rule.put("rule_id", vo.getRuleId());
        rule.put("rule_name", vo.getRule_name());
        rule.put("rule_descp", vo.getRule_descp());
        rule.put("rule_query", vo.getRule_query());
        rule.put("callback_name", vo.getCallback_name());
        rule.put("send_type", vo.getSend_type());
        rule.put("send_info", vo.getSend_info());
        rule.put("send_content", vo.getSend_content());
        rule.put("send_method", vo.getSend_method());
        rule.put("last_send_time", vo.getLast_send_time());
		
		return rule;
	}
}
