package WGUApplication;

public class Part_InHouse extends Part {

    private int machineId;

    public Part_InHouse(int id, String name, double price, int stock, int min, int max, int machineId){
        super(id, name, price, stock, min, max);
        setMachineId(machineId);
    }

    public Part_InHouse(){} // should throw not implemented exception


    public void setMachineId(int machineId){
        this.machineId = machineId;
    }

    public int getMachineId(){
        return machineId;
    }

}
