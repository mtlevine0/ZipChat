package com.mtlevine0.zipchat.resource;
 
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mtlevine0.zipchat.model.User;
import com.mtlevine0.zipchat.repository.UserDAO;
import com.mtlevine0.zipchat.filter.AuthSecured;
  
@Path("/auth")
public class UserResource
{
    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public User getAllUsers(User user) {
    	UserDAO udao = new UserDAO();
    	udao.addUser(user);
    	return user;
    }
    
    @POST
    @Path("/authenticate")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public User authenticate(User user) {
    	return user;
    }
    
    @GET
    @AuthSecured
    @Path("/getAllUsers")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public List<User> getAllUsers() {
    	UserDAO udao = new UserDAO();
    	return udao.getAllUsers();
    }
    
    @GET
    @AuthSecured
    @Path("/protected")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public User protectedEndpoint() {
    	User user = new User();
    	return user;
    }
}