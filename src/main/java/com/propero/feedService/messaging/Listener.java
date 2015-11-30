/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.propero.feedService.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.propero.feedService.domain.FeedData;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
//@EnableRabbit
@EnableScheduling
public class Listener {

	@Bean
	public Sender mySender() {
		return new Sender();
	}

	@Bean
	public Queue fooQueue() {
		return new Queue("foo");
	}

	private ObjectMapper mapper = new ObjectMapper();


	@RabbitListener(bindings = {
			@QueueBinding(value=@org.springframework.amqp.rabbit.annotation.Queue(value = "aaa",durable = "true"),
			exchange = @Exchange(value = "amq.direct",durable = "true"))})
	public void processA(Message msg, @Header("contentType") String contentType) throws IOException {

		if(contentType.equals("application/json")){
			FeedData feedData = mapper.readValue(msg.getBody(), FeedData.class);
			System.out.println(feedData);
		}


	}

	/*@RabbitHandler
	public void processB(@Payload  byte[] body, @Headers Map<String, String> headers, @Header("contentType") String contentType) {


		ObjectMapper mapper = new ObjectMapper();
		try {
			if(true *//*contentType.contains("json")*//*){
				Map map = mapper.readValue(body, Map.class);
				System.out.println("Map " + ": " + map);
			}else{
				System.out.println("Text " + ": " + new String(body,"UTF-8"));
			}

			System.out.println(headers);
			System.out.println(contentType);
		} catch (IOException e) {
			System.out.println(e+ "\n"+body);
		}


	}*/


	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}

	/*@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		factory.setMessageConverter(new MessageConverter() {
			@Override
			public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
				return null;
			}

			@Override
			public Object fromMessage(Message message) throws MessageConversionException {
					return message.getBody();
			}
		});
		return factory;
	}*/
}
