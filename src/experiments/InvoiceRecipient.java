package experiments;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceRecipient {

    private String recipientName;
    private String recipientPhone;
    private String recipientEmail;

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public InvoiceRecipient() {
    }

    public InvoiceRecipient(Integer invoiceId, String recipientName, String recipientPhone, String recipientEmail) {
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientEmail = recipientEmail;
    }
}
