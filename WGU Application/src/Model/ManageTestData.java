package Model;

public class ManageTestData {


    public static void BuildInventory(){
        //Inventory inventory = new Inventory();

        Part_Outsourced osCase = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "Case", 2d, 2, 2,8, "Cases from Bob");

        Part_InHouse ihSimpleCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
                "Simple Circuit", 5d, 8, 2, 10, 200);

        Part_InHouse ihLogicCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
                "Logic Circuit", 5d, 8, 2, 10, 201);


        Part_Outsourced osLEDMatrix = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "LED Matrix", 15d, 2, 2,8, "Almost NVidia Inc");

        Part_Outsourced osSmRegisterBanks = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "Small Register Banks", 14d, 2, 2,8, "Anti-tel");

        Product prodPCMarkII = new Product(GetIdNumber.getNextIdNumber(),
                "PC Mark II", 800d, 8, 2, 10);

        prodPCMarkII.addAssociatedPart(osCase);
        prodPCMarkII.addAssociatedPart(ihSimpleCircuit);
        prodPCMarkII.addAssociatedPart(ihLogicCircuit);
        prodPCMarkII.addAssociatedPart(osLEDMatrix);
        prodPCMarkII.addAssociatedPart(osSmRegisterBanks);

        Inventory.getInstance().addPart(osCase);
        Inventory.getInstance().addPart(ihSimpleCircuit);
        Inventory.getInstance().addPart(ihLogicCircuit);
        Inventory.getInstance().addProduct(prodPCMarkII);

        return;
    }
}
