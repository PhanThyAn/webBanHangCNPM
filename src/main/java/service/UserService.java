package service;

import dao.UserDAO;
import model.UserModel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

public class UserService {

    public static UserModel checkLogin(String username, String password)throws Exception{
        return UserDAO.findLogin(username,hashPassword(password));
    }

    public static UserModel findById(int id)throws Exception{
        return UserDAO.findById(id);
    }
    public static UserModel findByUserAndEmail(String username, String email)throws Exception{
        return UserDAO.findByUserAndEmail(username,email);
    }

    public static void changePassword(int id ,String newPassword)throws Exception{
        UserDAO.changePassword(id,hashPassword(newPassword));
    }

    public static void updateUserWeb(int id, String full_name, String phone_num, String email, String address, String gender)throws Exception{
        UserDAO.updateUserWeb(id,full_name,phone_num,email,address,gender);
    }

    public static void register(String username, String password,String email, String full_name, String gender)throws Exception {
        UserDAO.addUser(username,hashPassword(password),full_name,email,gender);
    }

    public static boolean checkUserName(String username)throws Exception{
        return UserDAO.checkUserName(username);
    }

    public static boolean checkEmail(String email)throws Exception{
        return UserDAO.checkUserName(email);
    }

    public static String randomPassword(){
        int min = 100;
        int max = 1000;
        int password = (int)(Math.random() * (max - min + 1) + min);
        return String.valueOf(password);
    }

    public static List<UserModel> findAll()throws Exception {
        return UserDAO.findAll();
    }

    public static void save(UserModel user)throws Exception {
        user.setPassWord(hashPassword(user.getPassWord()));
        UserDAO.save(user);
    }

    public static void updateAdmin(UserModel user,String enable) throws Exception{
        if(enable.equals("on")){
            user.setEnable(1);
        } else{
            user.setEnable(0);
        }
        UserDAO.updateUserAdmin(user);
    }

    public static void delete(int id)throws Exception {
        UserDAO.detele(id);
    }


    public static String hashPassword(String password) {
        try {
            MessageDigest sha256 = null;
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes());
            BigInteger number = new BigInteger(1, hash);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String createToken() {
        SecureRandom secureRandom = new SecureRandom();
        Base64.Encoder base64Encoder = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static void addToken(int id, String token)throws Exception{
        Long currentTime = getTimeNowInMillis();
        Timestamp token_expiry = getTokenExpiry(currentTime);
        Timestamp create_date = new Timestamp(currentTime);
        UserDAO.addToken(id,token, create_date,token_expiry);
    }

    private static long getTimeNowInMillis(){
        return Calendar.getInstance().getTimeInMillis();
    }

    private static Timestamp getTokenExpiry(Long timeNow){
        return new Timestamp(timeNow + 600000);
    }

    public static boolean checkTokenExpiry(int id, String token)throws Exception{
        return UserDAO.checkTokenExpiry(id,token);
    }

    public static UserModel findByToken(String token)throws Exception {
        return UserDAO.findByToken(token);
    }

    public static boolean checkToken(String token)throws Exception{
        return UserDAO.checkToken(token);
    }

    public static void deleteToken(int id, String token)throws Exception {
        UserDAO.deleteToken(id,token);
    }

    public static void main(String[] args) {
        System.out.println(hashPassword("123"));
    }
}

