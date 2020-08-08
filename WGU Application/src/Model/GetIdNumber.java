package Model;

public class GetIdNumber {
    static int nextIdNumber = 1;
    public static int getNextIdNumber(){
        return nextIdNumber++;
    }
}
