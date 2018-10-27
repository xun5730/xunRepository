package com.demo.service;

import redis.clients.jedis.JedisPubSub;

public class MyJedisPubSub  extends JedisPubSub {

	@Override
	public void onMessage(String channel, String message) {
		System.out.println("channel:"+channel+",message "+message);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {

		System.out.println("channel"+channel+",subscribedChannels: "+subscribedChannels);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("pattern:"+pattern+",subscribedChannels"+subscribedChannels);
	}
	
	

	
	
}
