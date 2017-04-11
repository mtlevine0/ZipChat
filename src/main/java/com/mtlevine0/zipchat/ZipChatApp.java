package com.mtlevine0.zipchat;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//import com.mtlevine0.filter.*;
//import com.mtlevine0.resource.*;

@ApplicationPath("api")
public class ZipChatApp extends ResourceConfig{
	public ZipChatApp() {
		System.out.println("ZipChat is Running!");
	}
}
