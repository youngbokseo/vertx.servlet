//package com.ntels.cep.vertx.aop;
//
//import com.ntels.engine.common.NCEPException;
//import com.ntels.engine.router.rest.BaseRouter;
//import com.ntels.engine.rule.RuleService;
//import io.vertx.core.Vertx;
//import io.vertx.core.json.JsonArray;
//import io.vertx.core.json.JsonObject;
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//
//public class KafkaRouter extends BaseRouter {
//    protected Logger logger = Logger.getLogger(getClass());
//    private Vertx vertx;
//
//    public KafkaRouter(Vertx vertx) {
//        this.vertx = vertx;
//    }
//
//    public void sendEvent(JsonObject param) {
//        try {
////            checkMandatoryValue(param, "event_name", "event");
//
//            // 들어오는 Event Log 적재
////            vertx.eventBus().send("log.event.history.insert", param);
//
//            String eventName = StringUtils.defaultString(param.getString("event_name"));
//            JsonObject event = param.getJsonObject("event");
////            String isSimulator = param.getString("isSimulator");
////
////            if ("true".equals(isSimulator)) {
////                JsonObject sendObj = new JsonObject();
////                sendObj.put("msg", "Send Event Success!!\n" + event.encode());
////                sendObj.put("isSimulator", "true");
////                vertx.eventBus().send("out.websocket", sendObj);
////            }
//
//            // event_name으로 모든 Rule을 조회해서 해당되는 룰 모두에게 sendEvent 전송
//            String sql = "SELECT b.rule_id, a.event_name_order FROM InputEvent as a, \"rule_input_event\".RuleInputEvent as b ";
//            sql += " WHERE a.event_id = b.event_id and a.event_name = ?";
//            JsonObject cache = new JsonObject();
//            cache.put("cache", "input_event");
//            cache.put("sql", sql);
//            cache.put("args", new JsonArray().add(eventName));
//            vertx.eventBus().send("cache.select", cache ,result -> {
//                if (result.failed()) {
//                    logger.error("sendEvent error : ", result.cause());
//                } else {
//                    try {
//                        JsonArray ruleList = (JsonArray) result.result().body();
//                        for (int i = 0; i < ruleList.size(); i++) {
//                            Long ruleId = ruleList.getJsonArray(i).getLong(0);
//                            String eventNameOrder = ruleList.getJsonArray(i).getString(1);
//
//                            RuleService.sendEvent("rule_" + ruleId, eventName, event, new JsonArray(eventNameOrder));
//                        }
//
////                        System.out.println("sendEvent Success");
//                    } catch (Exception e) {
//                        logger.error("Error : ", e);
//                    }
//
//                }
//            });
//
//        } catch (NCEPException ne) {
//            logger.error("Error : ", ne);
//        } catch (Exception e) {
//            logger.error("Error : ", e);
//        }
//    }
//}
