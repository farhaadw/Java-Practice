package Intermediate.BankSystem.models;

/**
 *
 * @author farhaad
 */
public class Branch {
    
    private String branchId;
    private String bankName;
    private String bankAddress;

    public Branch(String branchId, String bankName, String bankAddress) {
        this.branchId = branchId;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }
    
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    @Override
    public String toString() {
        return "Branch{" + "branchId=" + branchId + ", bankName=" + bankName + ", bankAddress=" + bankAddress + '}';
    }
    
}
