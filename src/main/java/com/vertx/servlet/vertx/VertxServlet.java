package com.ntels.cep.vertx;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import com.ntels.cep.common.exception.HttpException;
import com.ntels.cep.common.exception.ResourceNotFoundException;
import com.ntels.cep.engine.controller.SendEventController;
import com.ntels.cep.vertx.wrapper.VertxHttpServletRequest;
import com.ntels.cep.vertx.wrapper.VertxHttpServletResponse;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;


@Component
public class VertxServlet extends AbstractVerticle{

	@Value("${server.port:7791}")
	int port;
	
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HandlerAdapter handlerAdapter;

    @Autowired
	private HandlerMapping handlerMapping;
    
    @Autowired
    private SendEventController sendEventController;
    

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(applicationContext.getBean(VertxServlet.class));
	}
	
    /**
     * vertx request route
     */
    @Override
	public void start() throws Exception {
		Router router = Router.router(vertx);
	
		router.route().handler(BodyHandler.create());
		
		 router.route("/send/event").handler(routingContext -> { // http request receive
//			 System.out.println("### 2: "+routingContext.getBodyAsString());
	         try {
//	            sendEventController.event(rule);
	        	 sendEventController.asyncevent(routingContext.getBodyAsJson());
	            routingContext.response().end();
	         }catch(Exception e) {
	            e.printStackTrace();
	         } 
	      });
		 
		router.route()
		.handler(BodyHandler.create()) // http body parsing
		.handler(routingContext -> {   // http request receive
			VertxHttpServletRequest request = new VertxHttpServletRequest(routingContext);
			VertxHttpServletResponse response = new VertxHttpServletResponse(routingContext);
					
			doService(request, response);

			routingContext.response().setChunked(true);
			routingContext.response().setStatusCode(response.getStatus());
			if(response.bufferBytes() != null && response.bufferBytes().length > 0)
				routingContext.response().write(Buffer.buffer(response.bufferBytes()));
			routingContext.response().end();
			routingContext.response().close();
		});
		
		vertx.createHttpServer().requestHandler(router).listen(port);
	}
	
    /**
     * springboot controller mapping
     * @param request
     * @param response
     */
    public void doService(HttpServletRequest request, HttpServletResponse response) {
    	try {
			HandlerExecutionChain chain = handlerMapping.getHandler(request);				
			if(chain == null) throw new ResourceNotFoundException(request.getRequestURI());
			handlerAdapter.handle(request, response, chain.getHandler());
		} catch (Exception e) {
			//e.printStackTrace();
			if(e instanceof HttpException) {
				response.setStatus(((HttpException)e).getErrorCode());
			} 
			response.setHeader("RSM", e.getMessage());
		}
    }
}