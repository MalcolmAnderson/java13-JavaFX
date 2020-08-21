package model;

public class ManageTestData {


    public static Inventory BuildInventory(){
        Inventory inv = new Inventory();

        Part osCase = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "Case", 2d, 2, 2,8, "Cases from Bob");
        inv.addPart(osCase);

        Part ihSimpleCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
                "Simple Circuit", 5d, 8, 2, 10, 200);
        inv.addPart(ihSimpleCircuit);

        Part ihLogicCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
                "Logic Circuit", 5d, 8, 2, 10, 201);
        inv.addPart(ihLogicCircuit);

        Part osLEDMatrix = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "LED Matrix", 15d, 2, 2,8, "Almost NVidia Inc");
        inv.addPart(osLEDMatrix);

        Part osSmRegisterBanks = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
                "Small Register Banks", 14d, 2, 2,8, "Anti-tel");
        inv.addPart(osSmRegisterBanks);

        Product prodPCMarkI = new Product(GetIdNumber.getNextIdNumber(),
                "PC Mark I", 800d, 4, 2, 5);
        prodPCMarkI.addAssociatedPart(osCase);
        prodPCMarkI.addAssociatedPart(ihSimpleCircuit);
        prodPCMarkI.addAssociatedPart(osLEDMatrix);
        inv.addProduct(prodPCMarkI);

        Product prodPCMarkII = new Product(GetIdNumber.getNextIdNumber(),
                "PC Mark II", 800d, 8, 4, 10);
        prodPCMarkII.addAssociatedPart(osCase);
        prodPCMarkII.addAssociatedPart(ihSimpleCircuit);
        prodPCMarkII.addAssociatedPart(ihLogicCircuit);
        prodPCMarkII.addAssociatedPart(osLEDMatrix);
        prodPCMarkII.addAssociatedPart(osSmRegisterBanks);
        inv.addProduct(prodPCMarkII);

        return inv;
    }
}
