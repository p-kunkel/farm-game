package Exception;
public class CustomException extends Exception  
{  
    String Message;
    public CustomException(String message){
        this.Message = message;
    }

    public String toString() {
        return this.Message;
    }
}  
