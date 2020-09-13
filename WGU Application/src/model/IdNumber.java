package model;

public class IdNumber {
    static int nextIdNumber = 8;
    public static int getNextIdNumber(){
        return nextIdNumber + 1;
    }
    public static int getNextIdNumberAndCommit(){
        return nextIdNumber++;
    }
    public static void commitIdNumber(){
        nextIdNumber++;
    }
}
