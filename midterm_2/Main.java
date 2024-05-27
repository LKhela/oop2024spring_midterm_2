public class Main {
    public static void main(String[] args) {
        SecurityCompany securityCompany = new SecurityCompany("Security company");

        Contract contract1 = new Contract(1, "Client A", "2024-01-01", "2024-12-31", 100000);
        Contract contract2 = new Contract(2, "Client B", "2024-02-01", "2024-08-31", 50000);
        Contract contract3 = new Contract(3, "Client C", "2024-03-01", "2024-09-30", 75000);
        Contract contract4 = new Contract(4, "Client D", "2024-04-01", "2024-01-30", 75000);

        securityCompany.addContract(contract1);
        securityCompany.addContract(contract2);
        securityCompany.addContract(contract3);
        securityCompany.addContract(contract4);

        securityCompany.saveState();


        securityCompany.restoreState();
    }
}
