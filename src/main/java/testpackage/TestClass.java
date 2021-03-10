package testpackage;


import com.dealership.model.User;
import com.dealership.services.UserService;
import com.enterprise.annotations.TestMethod;

@com.enterprise.annotations.TestClass
public class TestClass {
   UserService us = new UserService();
   @TestMethod(expected = "dealershipuser@test.com")
    public String testexample(){
       try{
           String username = "";
           User u = us.findUserByUsername(username);
           return u.getUsername();
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }

}
