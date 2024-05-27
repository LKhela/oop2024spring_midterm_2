public class Contract {
    private int contractId;
    private String clientName;
    private String startDate;
    private String endDate;
    private double contractValue;

    public Contract(int contractId, String clientName, String startDate, String endDate, double contractValue) {
        this.contractId = contractId;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractValue = contractValue;
    }

    public int getContractId() {
        return contractId;
    }

    @Override
    public String toString() {
        return contractId + "," + clientName + "," + startDate + "," + endDate + "," + contractValue;
    }

    public static Contract fromString(String str) {
        String[] parts = str.split(",");
        int contractId = Integer.parseInt(parts[0]);
        String clientName = parts[1];
        String startDate = parts[2];
        String endDate = parts[3];
        double contractValue = Double.parseDouble(parts[4]);
        return new Contract(contractId, clientName, startDate, endDate, contractValue);
    }
}
