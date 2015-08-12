/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import experiments.CreateOrder;
import experiments.DpdOrdersData;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author dimasik
 */
public class DPDTest {

    public static void run() {

        DpdOrdersData orderData = new DpdOrdersData();

        Auth auth = new Auth();
        auth.setClientNumber(1002017631);
        auth.setClientKey("B84F9A71593C7A830014C297E7FF14A2502CC7FB");
        orderData.setAuth(auth);

        Header header = new Header();

        XMLGregorianCalendar date = new XMLGregorianCalendarImpl();
        date.setYear(2015);
        date.setMonth(9);
        date.setDay(8);

        header.setDatePickup(date);
        header.setPayer(new Long(1002017631));

        Address senderAddr = new Address();
        senderAddr.setName("Бэггинс Фродо Бильбович");
        senderAddr.setTerminalCode("187850978"); // УЗНАТЬ где брать коды терминалов
        senderAddr.setCountryName("Россия");
        senderAddr.setCity("Нижнекамск");
        senderAddr.setStreet("Чеширский холм");
        senderAddr.setStreetAbbr("ул.");
        senderAddr.setHouse("23");
        senderAddr.setHouseKorpus("3");
        senderAddr.setFlat("34");
        senderAddr.setContactFio("Бэггинс Фродо Бильбович");
        senderAddr.setContactPhone("89112345678");
        senderAddr.setContactEmail("test@test.com");
        senderAddr.setInstructions("подъезд со стороны двора");

        header.setSenderAddress(senderAddr);
        header.setPickupTimePeriod("9-18");

        orderData.setHeader(header);

        Order order = new Order();

        order.setOrderNumberInternal("PS-12345");
        order.setServiceCode("ECN");
        order.setServiceVariant("ТД");
        order.setCargoNumPack(1); // количество грузомест в отправке
        order.setCargoWeight(3);
        order.setCargoVolume(0.05); // объем в кубометрах
        order.setCargoRegistered(false); // ценный груз
        order.setCargoValue(Double.parseDouble("2500")); // сумма объявленной ценности
        order.setCargoCategory("товары для животных"); // TODO: выяснить что пихать в этот параметр
        // возсожные формы оплаты ОУО (оплата у отправителя), ОУП (оплата у получателя)
        order.setPaymentType("ОУО");
        order.setDeliveryTimePeriod("9-18");  // TODO: выяснить для чего нужен этот параметр

        Address receiverAddr = new Address();
        receiverAddr.setName("Бэггинс Фродо Бильбович");
        receiverAddr.setTerminalCode("187850978"); // УЗНАТЬ где брать коды терминалов
        receiverAddr.setCountryName("Россия");
        receiverAddr.setCity("Нижнекамск");
        receiverAddr.setStreet("Чеширский холм");
        receiverAddr.setStreetAbbr("ул.");
        receiverAddr.setHouse("23");
        receiverAddr.setHouseKorpus("3");
        receiverAddr.setFlat("34");
        receiverAddr.setContactFio("Бэггинс Фродо Бильбович");
        receiverAddr.setContactPhone("89112345678");
        receiverAddr.setContactEmail("test@test.com");
        receiverAddr.setInstructions("подъезд со стороны двора");

        order.setReceiverAddress(receiverAddr);

        orderData.getOrder().add(order);

        // создание заказа
//        try {
//            DPDOrderService service = new DPDOrderService();
//            DPDOrder port = service.getDPDOrderPort();
//            // TODO process result here
//            java.util.List<DpdOrderStatus> resultList = port.createOrder(orderData);
//            DpdOrderStatus result = resultList.get(0);
//            System.out.println("Status = "+result.getStatus()+"\n"
//                    + "order = " + result.getOrderNum() + "\n"
//                    + "message = " + result.getErrorMessage()
//            );
//            } 
//        catch (Exception ex) {
//                 ex.printStackTrace();
//            }

        // получение статуса заказа
        try {
            DpdGetOrderStatus orderParam = new DpdGetOrderStatus();
            orderParam.setAuth(auth);
            
            InternalOrderNumber invoiceId = new InternalOrderNumber();
            invoiceId.setOrderNumberInternal("PS-12345");
            orderParam.getOrder().add(invoiceId);
            
            DPDOrderService service = new DPDOrderService();
            DPDOrder port = service.getDPDOrderPort();
            java.util.List<DpdOrderStatus> resultStatusList = port.getOrderStatus(orderParam);
            DpdOrderStatus result = resultStatusList.get(0);
            System.out.println("\n\nStatus = "+result.getStatus()+"\n"
                    + "order = " + result.getOrderNum() + "\n"
                    + "message = " + result.getErrorMessage()
            );
            
            
        }
        catch (Exception ex) {
                 ex.printStackTrace();
            }
    }

    public List<DpdOrderStatus> getResult(DPDOrder service, DpdOrdersData ordersData) {
        try {
            final List<DpdOrderStatus> orderStatusList = service.createOrder(ordersData);
            return orderStatusList;
        } catch (WSFault_Exception e) {
            System.err.println("WSFault: " + e.getFaultInfo().getCode() + " / " + e.getFaultInfo().getMessage());
        } catch (Throwable e) {
            System.err.println("Fatal error: " + e);
        }
        return null;
    }

//    public List<DpdOrderStatus> getOrderStatus(DPDOrder service, String invoiceId) {
//        try {
//            final List<DpdOrderStatus> orderStatusList = service.createOrder(ordersData);
//            return orderStatusList;
//        } catch (WSFault_Exception e) {
//            System.err.println("WSFault: " + e.getFaultInfo().getCode() + " / " + e.getFaultInfo().getMessage());
//        } catch (Throwable e) {
//            System.err.println("Fatal error: " + e);
//        }
//        return null;
//    }
    
    

}

