//package com.ntels.cep.vertx.aop;
//
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.json.JsonObject;
//import io.vertx.kafka.client.consumer.KafkaConsumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.log4j.Logger;
//
//import java.util.Properties;
//
//public class KafkaInVerticle extends AbstractVerticle {
//
//    private Logger logger = Logger.getLogger(getClass());
////    private ProcessFilter pf;
//    private static JsonObject cf;
////    private CommonQueue commonQueue = new CommonQueue();
//    private int i =0;
//
//    public void initFilter() {
//    	cf = config();
//        String site = config().getString("site");
//
//        if ("NIPA".equals(site)) {
////            pf = new NipaFilter(config().getJsonObject("ncep.db"));
////        } else {
////            pf = new DefaultFilter();
//        }
//    }
//
//    private static Properties createProperties() {
//        Properties props = new Properties();
//        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, cf.getJsonObject("kafka.db").getInteger("MAX_POLL_RECORDS_CONFIG"));
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, cf.getJsonObject("kafka.db").getString("GROUP_ID_CONFIG"));
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, cf.getJsonObject("kafka.db").getString("BOOTSTRAP_SERVERS_CONFIG"));
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, cf.getJsonObject("kafka.db").getString("AUTO_OFFSET_RESET_CONFIG"));
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, cf.getJsonObject("kafka.db").getString("ENABLE_AUTO_COMMIT_CONFIG"));
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        return props;
//    }
//
//    @Override
//    public void start() throws Exception {
//        initFilter();
////    	pf = new DefaultFilter();
//        kafkaRouter kafkaRouter = new KafkaRouter(vertx);
//
////        System.out.println("Kafka Consumer Set Property");
//        Properties props = createProperties();
//
//        // use consumer for interacting with Apache Kafka
////        System.out.println("Create the consumer using props.");
//        KafkaConsumer<String, String> consumer = KafkaConsumer.create(vertx, props);
//
////        System.out.println("Set Topic 'hist'");
//        
//        //hist 의 이름을 구독
//        consumer.subscribe("hist", ar -> {
//            if (ar.succeeded()) {
////                logger.debug("Success Subscribed");
//            } else {
////                logger.debug("Could not subscribe " + ar.cause().getMessage());
//            }
//        });
//        
//        //실제로 값을 받음
//        consumer.handler(record -> {
//        	if(i ==0) {
////            	commonQueue.setBeforeTime(System.currentTimeMillis());
//            	i=1;
//            }
//            //값은 json으로 받는다 value가 값
//            JsonObject jsonObject = new JsonObject(record.value());
//            jsonObject.put("protocol", "Kafka");
////            JsonObject param = pf.beforeProcess(jsonObject);
//
////            kafkaRouter.sendEvent(param);
//            kafkaRouter.sendEvent(jsonObject);
//
//        }).exceptionHandler(e -> {
//            logger.debug("Kafka Consumer Exception");
//            logger.debug("Error: " + e.getMessage());
//        });
//
//        //consumer.close(res -> {
//        //    if (res.succeeded()) {
//        //        logger.debug("Consumer is now closed");
//        //    } else {
//        //        logger.debug("Close failed");
//        //    }
//        //});
//    }
//}
