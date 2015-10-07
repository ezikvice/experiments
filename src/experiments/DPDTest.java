/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import com.opencsv.CSVReader;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import experiments.CreateOrder;
import experiments.DpdOrdersData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 *
 * @author dimasik
 */
public class DPDTest {

    private final String HOUSE_REGEX = "([^а-я](д|дом)(\\.)*( )*(\\d)+(/\\d)*[а-я]?)";
    private final String HOUSE_CASE_FLAT_REGEX = "([\\d]+(/\\d+)?(-)[\\d]+(-[\\d]+)?)";
    private final String FLAT_REGEX = "((кв|квартира)(\\.)?( )*((\\d)+))";
    private final String HOUSECASE_REGEX = "([0-9 ,](к|кор|корп|корпус)(\\.)*( )*((\\d)+))";

    Boolean hasMatching(String requestString, String regex) {
        Pattern housePattern = Pattern.compile(regex.toLowerCase());
        Matcher m = housePattern.matcher(requestString);
        return m.find();
    }

    Boolean hasHouseCaseFlatString(String streetString) {
        return hasMatching(streetString, HOUSE_CASE_FLAT_REGEX);
    }

    Boolean hasHouseString(String streetString) {
        return hasMatching(streetString, HOUSE_REGEX);
    }

    Boolean hasFlatString(String streetString) {
        return hasMatching(streetString, FLAT_REGEX);
    }

    Boolean hasHouseCaseString(String streetString) {
        return hasMatching(streetString, HOUSECASE_REGEX);
    }

    Integer getMatchingIndex(String requestString, String regex) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(requestString);

        return m.start(1);
    }

    void splitStringByRegex(Map<String, String> splittedMap, String requestedString, String regex) {

        Integer index = getMatchingIndex(requestedString, regex);
        splittedMap.put("rawString", regex);
        splittedMap.put("before", regex.substring(0, index));
        splittedMap.put("after", regex.substring(index));
    }

    Integer getHouseStringIndex(String requestString) {
        return getMatchingIndex(requestString, HOUSE_REGEX);
    }

    Integer getHouseCaseStringIndex(String requestString) {
        return getMatchingIndex(requestString, HOUSECASE_REGEX);
    }

    Integer getFlatStringIndex(String requestString) {
        return getMatchingIndex(requestString, FLAT_REGEX);
    }

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

        // создание адреса
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
            System.out.println("\n\nStatus = " + result.getStatus() + "\n"
                    + "order = " + result.getOrderNum() + "\n"
                    + "message = " + result.getErrorMessage()
            );

        } catch (Exception ex) {
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

    Map<String, List<String>> makeStreetAbbrMap() {
        Map<String, List<String>> streetAbbrMap = new HashMap<String, List<String>>();

        streetAbbrMap.put("б-р", new ArrayList<String>(
                Arrays.asList("б-р", "бул", "бульвар")
        ));
        streetAbbrMap.put("вал", new ArrayList<String>(
                Arrays.asList("вал")
        ));
        streetAbbrMap.put("городок", new ArrayList<String>(
                Arrays.asList("городок")
        ));
        streetAbbrMap.put("д", new ArrayList<String>(
                Arrays.asList("деревня", "дер")
        ));
        streetAbbrMap.put("дор", new ArrayList<String>(
                Arrays.asList("дор", "дорога")
        ));
        streetAbbrMap.put("заезд", new ArrayList<String>( // нужен ли?
                Arrays.asList("заезд")
        ));
        streetAbbrMap.put("канал", new ArrayList<String>( // нужен ли?
                Arrays.asList("канал")
        ));
        streetAbbrMap.put("кв-л", new ArrayList<String>( // нужен ли?
                Arrays.asList("кв-л", "квартал")
        ));
        streetAbbrMap.put("км", new ArrayList<String>( // нужен ли?
                Arrays.asList("км", "километр")
        ));
        streetAbbrMap.put("кольцо", new ArrayList<String>( // нужен ли?
                Arrays.asList("кольцо")
        ));
        streetAbbrMap.put("линия", new ArrayList<String>( // нужен ли?
                Arrays.asList("линия")
        ));
        streetAbbrMap.put("мкр", new ArrayList<String>( // нужен ли?
                Arrays.asList("мкр", "мкрн", "микрорайон")
        ));
        streetAbbrMap.put("наб", new ArrayList<String>( // нужен ли?
                Arrays.asList("наб", "набережная")
        ));
        streetAbbrMap.put("остров", new ArrayList<String>( // нужен ли?
                Arrays.asList("остров")
        ));
        streetAbbrMap.put("п", new ArrayList<String>( // как обрабатывать "п" (например, большой проспект П.С.)
                Arrays.asList("поселок", "пос")
        ));
        streetAbbrMap.put("парк", new ArrayList<String>( // нужен ли?  и что делать, если например парк горького - как удалять?
                Arrays.asList("парк")
        ));
        streetAbbrMap.put("пер", new ArrayList<String>(
                Arrays.asList("пер", "переулок", "пер-ок")
        ));
        streetAbbrMap.put("пл", new ArrayList<String>(
                Arrays.asList("пл", "площадь")
        ));
        streetAbbrMap.put("проезд", new ArrayList<String>( // нужен ли?
                Arrays.asList("проезд", "пр-д")
        ));
        streetAbbrMap.put("пр-кт", new ArrayList<String>(
                Arrays.asList("пр-кт", "пр", "пр-т", "просп", "проспект")
        ));
        streetAbbrMap.put("с", new ArrayList<String>(
                Arrays.asList("село")
        ));
        streetAbbrMap.put("снт", new ArrayList<String>(
                Arrays.asList("снт") // ? является ли садоводство территорией?
        ));
        streetAbbrMap.put("ст", new ArrayList<String>(
                Arrays.asList("ст", "станция")
        ));
        streetAbbrMap.put("стр", new ArrayList<String>(
                Arrays.asList("строение", "стр")
        ));
        streetAbbrMap.put("тер", new ArrayList<String>(
                Arrays.asList("территория", "садоводство") // ? является ли садоводство территорией?
        ));
        streetAbbrMap.put("туп", new ArrayList<String>(
                Arrays.asList("туп", "тупик")
        ));
        streetAbbrMap.put("ул", new ArrayList<String>(
                Arrays.asList("ул", "улица") // ? надо ли "улицы"? может, это переулок 12й улицы или вход с улицы
        ));
        streetAbbrMap.put("уч-к", new ArrayList<String>(
                Arrays.asList("уч-к", "участок", "уч")
        ));
        streetAbbrMap.put("ш", new ArrayList<String>(
                Arrays.asList("ш", "шоссе", "ш-е")
        ));

        return streetAbbrMap;
    }

    public void parseAddresForDPD(Address dpdAddress, ClientRetailAddress clientRetailAddress) {

        Map<String, List<String>> streetAbbrMap = makeStreetAbbrMap();
        Map<String, String> addressMap = new HashMap<String, String>();
        
        String rawStreetString = clientRetailAddress.getClientRetailAddressStreet();
        
        // если в улице есть шаблон вида дом(-корпус)-квартира
        // в дпд адрес в поле "улица" запихиваем первую часть (до дома)
        //   и если в clientRetailAddress нет какого-либо из полей дом-корпус-квартира,
        //     то запихиваем соответствующее поле из второй части строки
        // все остальное во второй части - мусор, выкидываем
        if (hasHouseCaseFlatString(rawStreetString)) {
            splitStringByRegex(addressMap, rawStreetString, HOUSE_CASE_FLAT_REGEX);
            
            dpdAddress.setStreet(addressMap.get("before"));
            String[] afterString = addressMap.get("after").split("-");
            
            
            // может быть 2 формата: дом-квартира или дом-корпус-квартира
            // 
            if (afterString.length == 2) {
                dpdAddress.setHouse(afterString[0]);
                dpdAddress.setFlat(afterString[1]);
            } else if (afterString.length == 3) {
                dpdAddress.setHouse(afterString[0]);
                dpdAddress.setHouseKorpus(afterString[1]);
                dpdAddress.setFlat(afterString[2]);
            }
        }
        // дальше начинаем искать адрес начиная с квартиры
        else {
            if(hasFlatString(rawStreetString)){
                splitStringByRegex(addressMap, rawStreetString, FLAT_REGEX);
                dpdAddress.setStreet(addressMap.get("before"));
                String afterString = addressMap.get("after");

                // выцепляем квартиру, остальное все что справа - мусор
                Pattern p = Pattern.compile(FLAT_REGEX);
                Matcher m = p.matcher(afterString);
                dpdAddress.setFlat(m.group(4)); 
                rawStreetString = addressMap.get("before"); // TODO: проверить
            }
            if(hasHouseCaseString(rawStreetString)){
                splitStringByRegex(addressMap, rawStreetString, HOUSECASE_REGEX);
                
                
            }
            
        }
        
        

    }

    public void parseAddresForDPD1(Address dpdAddress, String rawStreetString) {

        Map<String, List<String>> streetAbbrMap = makeStreetAbbrMap();

        /* 
         строку с улицей бьем на токены (может быть, точки-запятые предварительно заменяем на пробелы)
         */
        String[] streetTokensArrStat = rawStreetString.split(" ");
        ArrayList<String> streetTokensList = new ArrayList<String>(Arrays.asList(streetTokensArrStat));

        // находим тип улицы
        for (String token : streetTokensArrStat) {
            String tokenToCompare = token.replaceAll("[\\.,]", "");
            for (Map.Entry<String, List<String>> entry : streetAbbrMap.entrySet()) {
                if (entry.getValue().contains(tokenToCompare)) {
                    dpdAddress.setStreetAbbr(entry.getKey());
                    streetTokensList.remove(token);

                }
            }
        }

        // собираем строку с улицей обратно
        StringBuilder buildedStreet = new StringBuilder();
        for (String token : streetTokensList) {
            buildedStreet.append(token).append(" ");
        }

        // ищем дома-квартиры-корпуса
        // дома
        Pattern housePattern = Pattern.compile(HOUSE_REGEX);
        Matcher m = housePattern.matcher(buildedStreet);
        String houseString;
        String allHouseString;
        if (m.find()) {
            houseString = m.group(1);
            Integer startIndex = m.start(1);
            allHouseString = buildedStreet.substring(startIndex);

            Pattern houseNumPattern = Pattern.compile("([\\d]+)");
            Matcher mn = houseNumPattern.matcher(houseString);
            String houseNumString = "";

            if (mn.find()) {
                houseNumString = mn.group(1);
            }

            if (dpdAddress.getHouse() == null || "".equals(dpdAddress.getHouse())) {
                dpdAddress.setHouse(houseNumString);
            }
            buildedStreet = new StringBuilder(m.replaceAll(""));
            System.out.println(buildedStreet);
        }

        // квартиры
        Pattern flatPattern = Pattern.compile(FLAT_REGEX);
        Matcher flatMatcher = flatPattern.matcher(buildedStreet);
        String flatString;
        if (flatMatcher.find()) {
            flatString = flatMatcher.group(1);
            Integer startIndex = flatMatcher.start(1);
            Pattern flatNumPattern = Pattern.compile("([\\d]+)");
            Matcher flatNumberMatcher = flatNumPattern.matcher(flatString);
            String flatNumString = "";

            if (flatNumberMatcher.find()) {
                flatNumString = flatNumberMatcher.group(1);
            }

            if (dpdAddress.getFlat() == null || "".equals(dpdAddress.getFlat())) {
                dpdAddress.setFlat(flatNumString);
            }
            buildedStreet = new StringBuilder(flatMatcher.replaceAll(""));
            System.out.println(buildedStreet);
        }

        dpdAddress.setStreet(buildedStreet.toString().replaceAll("[,]", "").trim());

//        return dpdAddress;
        return;
    }

    public void makeExcelFromAdressList() {

        
        //открываем файл
        InputStream inputStream;
        String path = "crm_client_retail_address.csv";

        List<String[]> lines = new ArrayList<String[]>();
        try {
            
//            BufferedReader reader = new BufferedReader(new FileReader(path));
            
            //http://opencsv.sourceforge.net/            
            CSVReader csvReader = new CSVReader(new FileReader(path),'|', '~');
            String [] nextLine;
//            String line;
            while ((nextLine = csvReader.readNext()) != null) {
                // nextLine[] is an array of values from the line
//                System.out.println(nextLine[0] + nextLine[1] + "etc...");
                lines.add(nextLine);
            }

        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }

        // записываем файл
        Workbook wb;
        wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("streetsAlex");
        Sheet sheet2 = wb.createSheet("streetsDimk");
        Row row;
        Row row2;
//            Iterator sheetIterator = sheet.iterator();
        Iterator listIterator = lines.iterator();
        Integer r = 0;
        while (listIterator.hasNext()) {
            try {
                
                ClientRetailAddress cra = new ClientRetailAddress();
                
                String[] currentAddress = (String[]) listIterator.next();
                
                cra.setClientRetailAddressCity(currentAddress[0]);
                cra.setClientRetailAddressStreet(currentAddress[1]);
                cra.setClientRetailAddressHouseNumber(currentAddress[2]);
                cra.setClientRetailAddressHouseCase(currentAddress[3]);
                cra.setClientRetailAddressApartment(currentAddress[4]);

                row = sheet.createRow(r);

                Map<String, String> alexMap = new HashMap<>();
                parseAddressFromString(alexMap, cra);

                
                CellStyle style = wb.createCellStyle();
                Short index = 0;
                if(alexMap.get("style")!=""){
                    index = Short.parseShort(alexMap.get("style"));
                }
                
                setCellString(row, 0, currentAddress[1], style, index);
                setCellString(row, 1, alexMap.get("street"), style, index);
                setCellString(row, 2, alexMap.get("house"), style, index);
                setCellString(row, 3, alexMap.get("houseCase"), style, index);
                setCellString(row, 4, alexMap.get("flat"), style, index);

                
                row2 = sheet2.createRow(r);
                Cell streetCell2 = row2.createCell(0);
                streetCell2.setCellType(Cell.CELL_TYPE_STRING);
                streetCell2.setCellValue(currentAddress[1]);

                r += 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
//            return null; // "Ошибка ввода-вывода";
        }

    }

    public void setCellString(Row row, Integer cellNum, String value, CellStyle style, Short colorIndex){
        style.setFillForegroundColor(colorIndex);
        style.setBorderBottom(CellStyle.BORDER_HAIR);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFillPattern(CellStyle.FINE_DOTS);
        
        Cell cell = row.createCell(cellNum);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellStyle(style);
        cell.setCellValue(value);
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
    public static void parseAddressFromString(Map<String, String> strMap, ClientRetailAddress addresses) {
        String result = "";
        Boolean hasFlat = false;
//        List<String> addresses = new ArrayList<String>();

        Pattern houseCaseFlatPattern = Pattern.compile("([\\d]+(/\\d+)?(-)[\\d]+(-[\\d]+)?)");
        Pattern housePattern = Pattern.compile("([^а-я](д|дом)[\\.]*[ ]*[\\d]+(/\\d+)?[а-я]?)");
        Pattern housePatternSlash = Pattern.compile("([\\d]+(/\\d+)[а-я]?)");
//        Pattern housePatternLiter = Pattern.compile("([\\d]+[а-я])");
        Pattern lastHouseHope = Pattern.compile("([\\d]+[, ]*)$");
        Pattern houseCasePattern = Pattern.compile("([0-9 ,](к|кор|корп|корпус)[\\.]?[ ]*[\\d]+)");
        Pattern flatPattern = Pattern.compile("((кв|квартира)[\\.]?[ ]*[\\d]+)");
        Pattern houseNumPattern = Pattern.compile("([\\d]+(/\\d+)?[а-я]?)");

        int counter = 0;
//        for (String address : addresses) {

        String street = addresses.getClientRetailAddressStreet();
        String house = "";
        String houseCase = "";
        String flat = "";
        String style = "1";
        

        Matcher houseCaseFlatMatcher = houseCaseFlatPattern.matcher(street.toLowerCase());
        if (houseCaseFlatMatcher.find()) {
            String houseCaseFlatMatcherString = houseCaseFlatMatcher.group(1);
            Integer houseCaseFlatMatcherIndex = houseCaseFlatMatcher.start(1);
            if (houseCaseFlatMatcherString.split("-").length == 2) {
                house = houseCaseFlatMatcherString.split("-")[0];
                flat = houseCaseFlatMatcherString.split("-")[1];
            } else if (houseCaseFlatMatcherString.split("-").length == 3) {
                house = houseCaseFlatMatcherString.split("-")[0];
                houseCase = houseCaseFlatMatcherString.split("-")[1];
                flat = houseCaseFlatMatcherString.split("-")[2];
            }
            
            street = street.substring(0, houseCaseFlatMatcherIndex);
            style="21";

        } else {
//            street = street.replaceAll(",", " ");
            Matcher flatMatcher = flatPattern.matcher(street.toLowerCase());

            if (flatMatcher.find()) {
                hasFlat = true;
                String flatString = flatMatcher.group(1);
                Integer flatIndex = flatMatcher.start(1);
                Pattern flatNumPattern = Pattern.compile("([\\d]+)");
                Matcher flatNumberMatcher = flatNumPattern.matcher(flatString.toLowerCase());

                if (flatNumberMatcher.find()) {
                    flat = flatNumberMatcher.group(1);
                }

                street = street.substring(0, flatIndex);
                style="22";
            }

            Matcher houseCaseMatcher = houseCasePattern.matcher(street.toLowerCase());

            if (houseCaseMatcher.find()) {
                String houseCaseString = houseCaseMatcher.group(1);
                Integer houseCaseIndex = houseCaseMatcher.start(1);
                Pattern houseCaseNumPattern = Pattern.compile("([\\d]+)");
                Matcher houseCaseNumberMatcher = houseCaseNumPattern.matcher(houseCaseString.toLowerCase());

                if (houseCaseNumberMatcher.find()) {
                    houseCase = houseCaseNumberMatcher.group(1);
                }

                street = street.substring(0, houseCaseIndex);
            }

            Matcher houseMatcher = housePattern.matcher(street.toLowerCase());
            if (true) {

                if (houseMatcher.find()) {
                    String houseString = houseMatcher.group();
                    Integer houseIndex = houseMatcher.start(1);
                    Matcher houseNumberMatcher = houseNumPattern.matcher(houseString.toLowerCase());

                    if (houseNumberMatcher.find()) {
                        house = houseNumberMatcher.group(1);
                    }
                    street = street.substring(0, houseIndex);
                } else {
                    houseMatcher = housePatternSlash.matcher(street.toLowerCase());
                    if (houseMatcher.find()) {
                        String houseString = houseMatcher.group();
                        Integer houseIndex = houseMatcher.start(1);
                        Matcher houseNumberMatcher = houseNumPattern.matcher(houseString.toLowerCase());

                        if (houseNumberMatcher.find()) {
                            house = houseNumberMatcher.group(1);
                        }
                        street = street.substring(0, houseIndex);
                    } else {
                        if (hasFlat) {
                            //lastHouseHope
                            houseMatcher = lastHouseHope.matcher(street.toLowerCase());
                            if (houseMatcher.find()) {
                                String houseString = houseMatcher.group();
                                Integer houseIndex = houseMatcher.start(1);

                                Matcher houseNumberMatcher = houseNumPattern.matcher(houseString.toLowerCase());

                                if (houseNumberMatcher.find()) {
                                    house = houseNumberMatcher.group(1);
                                }
                                street = street.substring(0, houseIndex);

                            } else {
                                //alert
                            }

                        }

                    }
                }
            }
        }
        street = street.trim();
        if(street.endsWith(",")){
            street = street.substring(0, street.length()-1);
        }
        if (street.split(",").length > 1) {
            street = street.split(",")[street.split(",").length - 1];
            style="25";
        }
//        }
        strMap.put("street", street);
        strMap.put("house", house);
        strMap.put("houseCase", houseCase);
        strMap.put("flat", flat);
        strMap.put("style", style);

//        return result;
    }

}
