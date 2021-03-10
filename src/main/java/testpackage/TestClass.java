package testpackage;


import com.dealership.services.UserService;
import com.enterprise.annotations.TestMethod;

@com.enterprise.annotations.TestClass
public class TestClass {
   UserService us = new UserService();
   @TestMethod(expected = "true")
    public boolean testexample(){
       try{
           String username = "noel";
           boolean u = us.doesUsernameExist(username);
           return u;
       }catch (Exception e){
           e.printStackTrace();
       }

       return false;
   }

}
