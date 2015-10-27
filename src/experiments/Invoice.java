package experiments;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Invoice {

    private Integer invoiceId;
    private Integer count;
    private Double invoiceWeight;
    private Double invoiceVolume;
    private Double invoiceVolumeToShow;
    private Integer companyId;
    private Integer invoiceStatusDeliveryId;
    private Integer invoiceStatusPaymentId;
    private Integer invoiceOriginId;
    private Integer invoiceIsVirtual;
    private Integer invoiceIsReserved;
    private Integer invoiceTypeId;
    private Integer paymentTypeId;
    private Integer invoiceDeliveryTCId;
    private Integer transportCompanyId;
    private Integer invoiceSelfDeliveryId;
    private Integer tcPriceParameterId;
    private Integer clientRetailId;
    private Integer clientRetailAddressId;
    private String clientAddressFull;
    private String clientRetailCardNumber;
    private String undergroundName;
    private String clientRetailNameFull;
    private String clientRetailContact;
    private String clientRetailContactTel;
    private String clientRetailContactEmail;
    private String invoiceDeliveryDate;
    private String invoiceDeliveryTime;
    private BigDecimal invoiceDeliveryCost;
    private BigDecimal invoicePrice;
    private BigDecimal invoiceCash;
    private String invoiceComment;
    private Integer invoiceIsDel;
    private String invoiceIsDelComment;
    private String invoiceProcessedComment;
    private Boolean invoiceIsBlock;
    private Integer invoiceIsSalt;
    private Integer invoiceIsLegalAddress;
    private Integer invoiceReceiverRequisite;
    private String invoiceCreationDate;
    private String invoiceCreationTime;
    private String invoiceCreationUser;
    private String invoiceModifiedDate;
    private String invoiceModifiedTime;
    private String invoiceModifiedUser;
    private String invoiceReserveExpiredDate;
    private String siteName;
    private String siteOriginName;
    private String siteBanner;
    private String siteComment;
    private String siteContact;
    private String paymentTypeName;
    private Integer userCheckerId;
    private Integer userShipperId;
    private Integer invoicePlaceAmount;
    private String invoiceStatusDeliveryName;
    private String invoiceStatusPaymentName;
    private String invoiceStatusTypeName;
    private String invoicePresenceName;
    private String companyName;
    private String dpdNumber;
    private String mnogoRuCardNumber;
    private Integer mnogoRuCardGiven;
    private boolean vipClient;
    private Integer invoiceResponsibleUserId;
    private Integer invoiceProcessedId;
    private Integer feedbackModeId;
    private String clientRetailFirstName;
    private String clientRetailMiddleName;
    private String clientRetailLastName;
    private String clientName;

    private BigDecimal totalPrice;

    private ClientRetailAddress clientRetailAddress;

    
    private Boolean invoiceRetailIsFirstShipping;
    private Integer shippingNumber;

    private InvoiceRecipient invoiceRecipient;
    
    public Invoice() {

    }

    public String getClientAddressFull() {
        return clientAddressFull;
    }

    public void setClientAddressFull(String clientAddressFull) {
        this.clientAddressFull = clientAddressFull;
    }

    public Integer getInvoiceDeliveryTCId() {
        return invoiceDeliveryTCId;
    }

    public void setInvoiceDeliveryTCId(Integer invoiceDeliveryTCId) {
        this.invoiceDeliveryTCId = invoiceDeliveryTCId;
    }

    public Integer getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Integer transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public String getSiteBanner() {
        return siteBanner;
    }

    public void setSiteBanner(String siteBanner) {
        this.siteBanner = siteBanner;
    }

    public String getClientRetailCardNumber() {
        return clientRetailCardNumber;
    }

    public void setClientRetailCardNumber(String clientRetailCardNumber) {
        this.clientRetailCardNumber = clientRetailCardNumber;
    }

    public BigDecimal getInvoiceCash() {
        return invoiceCash;
    }

    public void setInvoiceCash(BigDecimal invoiceCash) {
        this.invoiceCash = invoiceCash;
    }

    public String getSiteOriginName() {
        return siteOriginName;
    }

    public void setSiteOriginName(String siteOriginName) {
        this.siteOriginName = siteOriginName;
    }

    public String getSiteComment() {
        return siteComment;
    }

    public void setSiteComment(String siteComment) {
        this.siteComment = siteComment;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getSiteContact() {
        return siteContact;
    }

    public void setSiteContact(String siteContact) {
        this.siteContact = siteContact;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUndergroundName() {
        return undergroundName;
    }

    public void setUndergroundName(String undergroundName) {
        this.undergroundName = undergroundName;
    }

    public Integer getInvoiceIsLegalAddress() {
        return invoiceIsLegalAddress;
    }

    public void setInvoiceIsLegalAddress(Integer invoiceIsLegalAddress) {
        this.invoiceIsLegalAddress = invoiceIsLegalAddress;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getClientRetailId() {
        return clientRetailId;
    }

    public void setClientRetailId(Integer clientRetailId) {
        this.clientRetailId = clientRetailId;
    }

    public Integer getClientRetailAddressId() {
        return clientRetailAddressId;
    }

    public void setClientRetailAddressId(Integer clientRetailAddressId) {
        this.clientRetailAddressId = clientRetailAddressId;
    }

    public String getClientRetailNameFull() {
        return clientRetailNameFull;
    }

    public void setClientRetailNameFull(String clientRetailNameFull) {
        this.clientRetailNameFull = clientRetailNameFull;
    }

//    public void setClientRetailAddressFull(String clientRetailAddressFull) {
//        this.clientRetailAddressFull = clientRetailAddressFull;
//    }
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getInvoiceWeight() {
        return invoiceWeight;
    }

    public void setInvoiceWeight(Double invoiceWeight) {
        this.invoiceWeight = invoiceWeight;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getInvoiceStatusDeliveryId() {
        return invoiceStatusDeliveryId;
    }

    public void setInvoiceStatusDeliveryId(Integer invoiceStatusDeliveryId) {
        this.invoiceStatusDeliveryId = invoiceStatusDeliveryId;
    }

    public Integer getInvoiceStatusPaymentId() {
        return invoiceStatusPaymentId;
    }

    public void setInvoiceStatusPaymentId(Integer invoiceStatusPaymentId) {
        this.invoiceStatusPaymentId = invoiceStatusPaymentId;
    }

    public Integer getInvoiceOriginId() {
        return invoiceOriginId;
    }

    public void setInvoiceOriginId(Integer invoiceOriginId) {
        this.invoiceOriginId = invoiceOriginId;
    }

    public Integer getInvoiceIsVirtual() {
        return invoiceIsVirtual;
    }

    public void setInvoiceIsVirtual(Integer invoiceIsVirtual) {
        this.invoiceIsVirtual = invoiceIsVirtual;
    }

    public Integer getInvoiceTypeId() {
        return invoiceTypeId;
    }

    public void setInvoiceTypeId(Integer invoiceTypeId) {
        this.invoiceTypeId = invoiceTypeId;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }


    public String getInvoiceDeliveryDate() {
        return invoiceDeliveryDate;
    }

    public void setInvoiceDeliveryDate(String invoiceDeliveryDate) {
        this.invoiceDeliveryDate = invoiceDeliveryDate;
    }

    public String getInvoiceDeliveryTime() {
        return invoiceDeliveryTime;
    }

    public void setInvoiceDeliveryTime(String invoiceDeliveryTime) {
        this.invoiceDeliveryTime = invoiceDeliveryTime;
    }

    public BigDecimal getInvoiceDeliveryCost() {
        return invoiceDeliveryCost;
    }

    public void setInvoiceDeliveryCost(BigDecimal invoiceDeliveryCost) {
        this.invoiceDeliveryCost = invoiceDeliveryCost;
    }

    public BigDecimal getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(BigDecimal invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getInvoiceComment() {
        return invoiceComment;
    }

    public void setInvoiceComment(String invoiceComment) {
        this.invoiceComment = invoiceComment;
    }

    public Integer getInvoiceIsDel() {
        return invoiceIsDel;
    }

    public void setInvoiceIsDel(Integer invoiceIsDel) {
        this.invoiceIsDel = invoiceIsDel;
    }

    public String getInvoiceIsDelComment() {
        return invoiceIsDelComment;
    }

    public void setInvoiceIsDelComment(String invoiceIsDelComment) {
        this.invoiceIsDelComment = invoiceIsDelComment;
    }

    public String getInvoiceProcessedComment() {
        return invoiceProcessedComment;
    }

    public void setInvoiceProcessedComment(String invoiceProcessedComment) {
        this.invoiceProcessedComment = invoiceProcessedComment;
    }

    public Boolean getInvoiceIsBlock() {
        return invoiceIsBlock;
    }

    public void setInvoiceIsBlock(Boolean invoiceIsBlock) {
        this.invoiceIsBlock = invoiceIsBlock;
    }

    public Integer getInvoiceIsSalt() {
        return invoiceIsSalt;
    }

    public void setInvoiceIsSalt(Integer invoiceIsSalt) {
        this.invoiceIsSalt = invoiceIsSalt;
    }

    public String getInvoiceCreationDate() {
        return invoiceCreationDate;
    }

    public void setInvoiceCreationDate(String invoiceCreationDate) {
        this.invoiceCreationDate = invoiceCreationDate;
    }

    public String getInvoiceCreationTime() {
        return invoiceCreationTime;
    }

    public void setInvoiceCreationTime(String invoiceCreationTime) {
        this.invoiceCreationTime = invoiceCreationTime;
    }

    public String getInvoiceCreationUser() {
        return invoiceCreationUser;
    }

    public void setInvoiceCreationUser(String invoiceCreationUser) {
        this.invoiceCreationUser = invoiceCreationUser;
    }

    public String getInvoiceModifiedDate() {
        return invoiceModifiedDate;
    }

    public void setInvoiceModifiedDate(String invoiceModifiedDate) {
        this.invoiceModifiedDate = invoiceModifiedDate;
    }

    public String getInvoiceModifiedTime() {
        return invoiceModifiedTime;
    }

    public void setInvoiceModifiedTime(String invoiceModifiedTime) {
        this.invoiceModifiedTime = invoiceModifiedTime;
    }

    public String getInvoiceModifiedUser() {
        return invoiceModifiedUser;
    }

    public void setInvoiceModifiedUser(String invoiceModifiedUser) {
        this.invoiceModifiedUser = invoiceModifiedUser;
    }

    public Integer getUserCheckerId() {
        return userCheckerId;
    }

    public void setUserCheckerId(Integer userCheckerId) {
        this.userCheckerId = userCheckerId;
    }

    public Integer getUserShipperId() {
        return userShipperId;
    }

    public void setUserShipperId(Integer userShipperId) {
        this.userShipperId = userShipperId;
    }

    public Integer getInvoicePlaceAmount() {
        return invoicePlaceAmount;
    }

    public void setInvoicePlaceAmount(Integer invoicePlaceAmount) {
        this.invoicePlaceAmount = invoicePlaceAmount;
    }

    public String getInvoiceStatusDeliveryName() {
        return invoiceStatusDeliveryName;
    }

    public void setInvoiceStatusDeliveryName(String invoiceStatusDeliveryName) {
        this.invoiceStatusDeliveryName = invoiceStatusDeliveryName;
    }

    public String getInvoiceStatusPaymentName() {
        return invoiceStatusPaymentName;
    }

    public void setInvoiceStatusPaymentName(String invoiceStatusPaymentName) {
        this.invoiceStatusPaymentName = invoiceStatusPaymentName;
    }

    public String getInvoiceStatusTypeName() {
        return invoiceStatusTypeName;
    }

    public void setInvoiceStatusTypeName(String invoiceStatusTypeName) {
        this.invoiceStatusTypeName = invoiceStatusTypeName;
    }

    public String getInvoicePresenceName() {
        return invoicePresenceName;
    }

    public void setInvoicePresenceName(String invoicePresenceName) {
        this.invoicePresenceName = invoicePresenceName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getInvoiceSelfDeliveryId() {
        return invoiceSelfDeliveryId;
    }

    public void setInvoiceSelfDeliveryId(Integer invoiceSelfDeliveryId) {
        this.invoiceSelfDeliveryId = invoiceSelfDeliveryId;
    }

    public Integer getTcPriceParameterId() {
        return tcPriceParameterId;
    }

    public void setTcPriceParameterId(Integer tcPriceParameterId) {
        this.tcPriceParameterId = tcPriceParameterId;
    }

    /*
     * Выводится в шаблонах под названием "Всего на сумму"
     */
//    public void calculateTotalPrice() {
//        totalPrice = this.invoicePrice.add(this.invoiceDeliveryCost).subtract(this.invoiceCash);
//    }
    public BigDecimal getTotalPrice() {
        if (invoiceDeliveryCost == null || invoiceCash == null) {
            return null;
        } else {
            return invoicePrice.add(invoiceDeliveryCost).subtract(invoiceCash);
        }
    }

    public String getDpdNumber() {
        return dpdNumber;
    }

    public void setDpdNumber(String dpdNumber) {
        this.dpdNumber = dpdNumber;
    }

    public Double getInvoiceVolume() {
        return invoiceVolume;
    }

    public void setInvoiceVolume(Double invoiceVolume) {
        this.invoiceVolume = invoiceVolume;
    }

    public Double getInvoiceVolumeToShow() {
        return invoiceVolumeToShow;
    }

    public void setInvoiceVolumeToShow(Double invoiceVolumeToShow) {
        this.invoiceVolumeToShow = invoiceVolumeToShow;
    }

    public static List<Invoice> batchSetInvoiceVolumeToShow(List<Invoice> invoices) {
        List<Invoice> invoicesWithVolumeToShow = new ArrayList<Invoice>();
        for (Invoice invoice : invoices) {
            if (invoice.invoiceVolume != null) {
                Double invoiceVolumeToShow = (invoice.invoiceVolume / 100) * 130;
                invoice.setInvoiceVolumeToShow(invoiceVolumeToShow);
            }
            invoicesWithVolumeToShow.add(invoice);
        }
        return invoicesWithVolumeToShow;
    }

    public String getMnogoRuCardNumber() {
        return mnogoRuCardNumber;
    }

    public void setMnogoRuCardNumber(String mnogoRuCardNumber) {
        this.mnogoRuCardNumber = mnogoRuCardNumber;
    }

    public Integer getMnogoRuCardGiven() {
        return mnogoRuCardGiven;
    }

    public void setMnogoRuCardGiven(Integer mnogoRuCardGiven) {
        this.mnogoRuCardGiven = mnogoRuCardGiven;
    }

    public boolean isVipClient() {
        return vipClient;
    }

    public void setIsVipClient(boolean vipClient) {
        this.vipClient = vipClient;
    }

    public Integer getInvoiceResponsibleUserId() {
        return invoiceResponsibleUserId;
    }

    public void setInvoiceResponsibleUserId(Integer invoiceResponsibleUserId) {
        this.invoiceResponsibleUserId = invoiceResponsibleUserId;
    }

    public Integer getInvoiceProcessedId() {
        return invoiceProcessedId;
    }

    public void setInvoiceProcessedId(Integer invoiceProcessedId) {
        this.invoiceProcessedId = invoiceProcessedId;
    }

    public boolean isInvoiceProcessed() {
        boolean invoiceProcessed;
        if (invoiceProcessedId == null) {
            invoiceProcessed = false;
        } else if (invoiceProcessedId.equals(1)) {
            invoiceProcessed = true;
        } else {
            invoiceProcessed = false;
        }
        return invoiceProcessed;
    }

    public Integer getFeedbackModeId() {
        return feedbackModeId;
    }

    public void setFeedbackModeId(Integer feedbackModeId) {
        this.feedbackModeId = feedbackModeId;
    }

    public ClientRetailAddress getClientRetailAddress() {
        return clientRetailAddress;
    }

    public void setClientRetailAddress(ClientRetailAddress clientRetailAddress) {
        this.clientRetailAddress = clientRetailAddress;
    }

    public String getClientRetailAddressFull() {
        return clientRetailAddress == null ? "" : clientRetailAddress.getClientRetailAddressFull();
    }

    public Integer getInvoiceIsReserved() {
        return invoiceIsReserved;
    }

    public void setInvoiceIsReserved(Integer invoiceIsReserved) {
        this.invoiceIsReserved = invoiceIsReserved;
    }

    public String getInvoiceReserveExpiredDate() {
        return invoiceReserveExpiredDate;
    }

    public void setInvoiceReserveExpiredDate(String invoiceReserveExpiredDate) {
        this.invoiceReserveExpiredDate = invoiceReserveExpiredDate;
    }

    public String getClientRetailFirstName() {
        return clientRetailFirstName;
    }

    public void setClientRetailFirstName(String clientRetailFirstName) {
        this.clientRetailFirstName = clientRetailFirstName;
    }

    public String getClientRetailMiddleName() {
        return clientRetailMiddleName;
    }

    public void setClientRetailMiddleName(String clientRetailMiddleName) {
        this.clientRetailMiddleName = clientRetailMiddleName;
    }

    public String getClientRetailLastName() {
        return clientRetailLastName;
    }

    public void setClientRetailLastName(String clientRetailLastName) {
        this.clientRetailLastName = clientRetailLastName;
    }

    public String getCreateFullClientRetailName() {
        String fullClientRetailName = (clientRetailFirstName != null ? clientRetailFirstName + " " : "")
                + (clientRetailMiddleName != null ? clientRetailMiddleName + " " : "")
                + (clientRetailLastName != null ? clientRetailLastName + " " : "");
        return fullClientRetailName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getInvoiceReceiverRequisite() {
        return invoiceReceiverRequisite;
    }

    public void setInvoiceReceiverRequisite(Integer invoiceReceiverRequisite) {
        this.invoiceReceiverRequisite = invoiceReceiverRequisite;
    }


    public String getClientRetailContactTel() {
        return clientRetailContactTel;
    }

    public void setClientRetailContactTel(String clientRetailContactTel) {
        this.clientRetailContactTel = clientRetailContactTel;
    }

    public String getClientRetailContactEmail() {
        return clientRetailContactEmail;
    }

    public void setClientRetailContactEmail(String clientRetailContactEmail) {
        this.clientRetailContactEmail = clientRetailContactEmail;
    }

    public InvoiceRecipient getInvoiceRecipient() {
        return invoiceRecipient;
    }

    public void setInvoiceRecipient(InvoiceRecipient invoiceRecipient) {
        this.invoiceRecipient = invoiceRecipient;
    }
    
}
