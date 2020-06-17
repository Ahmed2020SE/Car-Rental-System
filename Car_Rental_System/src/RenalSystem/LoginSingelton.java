/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenalSystem;

/**
 *
 * @author Admin
 */
public class LoginSingelton {
    private static LoginSingelton instance;
    private final static String username="ahmed";
    private final static String pass="123";
    private LoginSingelton(){}
    public static LoginSingelton getInstance(){
        return instance;
    }
    public static boolean authentication(String username,String pass){
        if(username.equalsIgnoreCase(LoginSingelton.username)&&pass.equals(LoginSingelton.pass))
            return true;
        return false;
    }
}
