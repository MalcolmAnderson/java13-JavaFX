package WGUApplication;

public class Part_Outsourced extends Part {

    private String companyName;

    public Part_Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(id, name, price, stock, min, max);
        setCompanyName(companyName);
    }

    public Part_Outsourced(){} // should throw not implemented exception


    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return companyName;
    }

}
