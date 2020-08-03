public class Outsourced extends Part {

    private int companyName;

    public Outsourced(int id, String name, double price, int stock, int min, int max, int companyName){
        super(id, name, price, stock, min, max);
        setCompanyName(companyName);
    }

    public Outsourced(){} // should throw not implemented exception


    public void setCompanyName(int companyName){
        this.companyName = companyName;
    }

    public int getCompanyName(){
        return companyName;
    }

}
