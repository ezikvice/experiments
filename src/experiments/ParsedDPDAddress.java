/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import java.lang.reflect.Field;

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
        try {
            Class c = ClientAddress.class;
            Field f = c.getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(this, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

}
