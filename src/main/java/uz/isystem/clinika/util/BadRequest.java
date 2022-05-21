package uz.isystem.clinika.util;

public class BadRequest extends RuntimeException{
    public  BadRequest(String message){
        super(message);
    }
}
