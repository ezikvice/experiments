/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

/**
 *
 * @author dimasik
 */
public class ParsedDPDAddress extends ClientAddress {

    private String style;
    private String warningCode;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public void setFieldByName(String fieldName, String value) {
        if (fieldName.equals("flat")) {
            this.flat = value;
        } else if (fieldName.equals("houseCase")) {
            this.houseKorpus = value;
        } else if (fieldName.equals("house")) {
            this.house = value;
        }
    }

}
