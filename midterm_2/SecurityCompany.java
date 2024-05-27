import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityCompany {
    private String companyName;
    private List<Contract> contracts;

    public SecurityCompany(String companyName) {
        this.companyName = companyName;
        this.contracts = new ArrayList<>();
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }

    public void removeContract(int contractId) {
        contracts.removeIf(contract -> contract.getContractId() == contractId);
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Contract contract : contracts) {
                writer.write(contract.toString());
                writer.newLine();
            }
            System.out.println("State saved to state.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        contracts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            System.out.println("Contracts loaded from state.csv:");
            while ((line = reader.readLine()) != null) {
                contracts.add(Contract.fromString(line));
                System.out.println(line);
            }
            System.out.println("State restored from state.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SecurityCompany{" +
                "companyName='" + companyName + '\'' +
                ", contracts=" + contracts +
                '}';
    }
}
