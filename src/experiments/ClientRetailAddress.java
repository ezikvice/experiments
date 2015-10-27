package experiments;

public class ClientRetailAddress {

    private Integer clientRetailAddressId;
    private Integer clientRetailId;
    private String clientRetailAddressRegion;
    private String clientRetailAddressCity;
    private String clientRetailAddressZipCode;
    private String clientRetailAddressStreet;
    private String clientRetailAddressHouseNumber;
    private String clientRetailAddressHouseCase;
    private String clientRetailAddressApartment;
    private String clientRetailAddressComment;
    private Integer undergroundId;
    private Integer clientRetailAddressIsDel;
    private String clientRetailAddressCreationDate;
    private String clientRetailAddressCreationTime;
    private String clientRetailAddressCreationUser;
    private String clientRetailAddressModifiedDate;
    private String clientRetailAddressModifiedTime;
    private String clientRetailAddressModifiedUser;
    private String clientRetailAddressFull;

    public String getClientRetailAddressFull() {
        return (clientRetailAddressCity == null ? "" : clientRetailAddressCity)
                + (clientRetailAddressStreet == null ? "" : ", " + clientRetailAddressStreet)
                + (clientRetailAddressHouseNumber == null ? "" : ", д." + clientRetailAddressHouseNumber)
                + (clientRetailAddressHouseCase == null ? "" : ", кор." + clientRetailAddressHouseCase)
                + (clientRetailAddressApartment == null ? "" : ", кв." + clientRetailAddressApartment)
                + (clientRetailAddressComment == null ? "" : " " + clientRetailAddressComment);
    }

    public String getClientRetailAddressRegion() {
        return clientRetailAddressRegion;
    }

    public void setClientRetailAddressRegion(String clientRetailAddressRegion) {
        this.clientRetailAddressRegion = clientRetailAddressRegion;
    }

    
    public String getClientRetailAddressCity() {
        return clientRetailAddressCity;
    }

    public void setClientRetailAddressCity(String clientRetailAddressCity) {
        this.clientRetailAddressCity = clientRetailAddressCity;
    }

    public String getClientRetailAddressComment() {
        return clientRetailAddressComment;
    }

    public void setClientRetailAddressComment(String clientRetailAddressComment) {
        this.clientRetailAddressComment = clientRetailAddressComment;
    }

    public Integer getClientRetailAddressIsDel() {
        return clientRetailAddressIsDel;
    }

    public void setClientRetailAddressIsDel(Integer clientRetailAddressIsDel) {
        this.clientRetailAddressIsDel = clientRetailAddressIsDel;
    }

    public Integer getClientRetailAddressId() {
        return clientRetailAddressId;
    }

    public void setClientRetailAddressId(Integer clientRetailAddressId) {
        this.clientRetailAddressId = clientRetailAddressId;
    }

    public Integer getClientRetailId() {
        return clientRetailId;
    }

    public void setClientRetailId(Integer clientRetailId) {
        this.clientRetailId = clientRetailId;
    }

    public String getClientRetailAddressZipCode() {
        return clientRetailAddressZipCode;
    }

    public void setClientRetailAddressZipCode(String clientRetailAddressZipCode) {
        this.clientRetailAddressZipCode = clientRetailAddressZipCode;
    }

    public String getClientRetailAddressStreet() {
        return clientRetailAddressStreet;
    }

    public void setClientRetailAddressStreet(String clientRetailAddressStreet) {
        this.clientRetailAddressStreet = clientRetailAddressStreet;
    }

    public String getClientRetailAddressHouseNumber() {
        return clientRetailAddressHouseNumber;
    }

    public void setClientRetailAddressHouseNumber(String clientRetailAddressHouseNumber) {
        this.clientRetailAddressHouseNumber = clientRetailAddressHouseNumber;
    }

    public String getClientRetailAddressHouseCase() {
        return clientRetailAddressHouseCase;
    }

    public void setClientRetailAddressHouseCase(String clientRetailAddressHouseCase) {
        this.clientRetailAddressHouseCase = clientRetailAddressHouseCase;
    }

    public String getClientRetailAddressApartment() {
        return clientRetailAddressApartment;
    }

    public void setClientRetailAddressApartment(String clientRetailAddressApartment) {
        this.clientRetailAddressApartment = clientRetailAddressApartment;
    }

    public Integer getUndergroundId() {
        return undergroundId;
    }

    public void setUndergroundId(Integer undergroundId) {
        this.undergroundId = undergroundId;
    }

    public String getClientRetailAddressCreationDate() {
        return clientRetailAddressCreationDate;
    }

    public void setClientRetailAddressCreationDate(String clientRetailAddressCreationDate) {
        this.clientRetailAddressCreationDate = clientRetailAddressCreationDate;
    }

    public String getClientRetailAddressCreationTime() {
        return clientRetailAddressCreationTime;
    }

    public void setClientRetailAddressCreationTime(String clientRetailAddressCreationTime) {
        this.clientRetailAddressCreationTime = clientRetailAddressCreationTime;
    }

    public String getClientRetailAddressCreationUser() {
        return clientRetailAddressCreationUser;
    }

    public void setClientRetailAddressCreationUser(String clientRetailAddressCreationUser) {
        this.clientRetailAddressCreationUser = clientRetailAddressCreationUser;
    }

    public String getClientRetailAddressModifiedDate() {
        return clientRetailAddressModifiedDate;
    }

    public void setClientRetailAddressModifiedDate(String clientRetailAddressModifiedDate) {
        this.clientRetailAddressModifiedDate = clientRetailAddressModifiedDate;
    }

    public String getClientRetailAddressModifiedTime() {
        return clientRetailAddressModifiedTime;
    }

    public void setClientRetailAddressModifiedTime(String clientRetailAddressModifiedTime) {
        this.clientRetailAddressModifiedTime = clientRetailAddressModifiedTime;
    }

    public String getClientRetailAddressModifiedUser() {
        return clientRetailAddressModifiedUser;
    }

    public void setClientRetailAddressModifiedUser(String clientRetailAddressModifiedUser) {
        this.clientRetailAddressModifiedUser = clientRetailAddressModifiedUser;
    }

    public void setClientRetailAddressFull(String clientRetailAddressFull) {
        this.clientRetailAddressFull = clientRetailAddressFull;
    }

}
