package ru.test;

import ru.entity.IncidentEntity;
import ru.entity.ViewTest;
import java.io.IOException;

public class StoreTest {
    private ViewTest viewTest;
    private IncidentEntity incident;
    public StoreTest(IncidentEntity incident) {
        this.incident = incident;
    }

    public ViewTest test() throws IOException {
        final String[] slot = {""};
        final String[] ont = {""};
        ViewTest viewTest = new ViewTest();
        viewTest.setService(incident.getService());
        String s = incident.getTechdata();
        if( s.length() > 0 ) {
            switch ((int) incident.getTechnogyEntity().getIdTechnology()) {
                case 1:
                case 10:
                    System.out.println("PSTN " + incident.getTechdata() );
                    switch (incident.getTechdata().split(" ")[0]. replace("(" , "")) {
                        case "К62":
                        case "К62/1":
                        case "К65":
                            viewTest.setIp_address("192.168.12.1");
                            System.out.println( viewTest.getService());
                            TestRTS testRTS = new TestRTS( viewTest);
                            testRTS.test();
                            break;
                        case "К66":
                            viewTest.setIp_address("10.183.5.66");
                            TestMT20 testMT20 = new TestMT20(viewTest);
                            break;
                        case "К67":
                            viewTest.setIp_address("10.183.5.67");
                            TestMT20 testMT2 = new TestMT20(viewTest);
                            break;
                        case "К1":
                        case "К2":
                        case "К3":
                        case "К13":
                            viewTest.setIp_address("10.11.104.21");
                            TestPhone testPhone = new TestPhone(viewTest);
                            testPhone.test();
                            break;
                        case "К4":
                        case "К5":
                        case "К6":
                        case "К7":
                        case "К8":
                        case "К9":
                        case "К10":
                        case "К11":
                        case "К12":
                            viewTest.setIp_address("10.11.104.20");
                            TestPhone testPhon = new TestPhone(viewTest);
                            try {
                                testPhon.test();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
                case 5: // FTTx
                    System.out.println(incident.getTechnogyEntity().getMameTechnology() + "|" + incident.getTechdata());
                    viewTest.setIp_address( s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))); // ip address
                    viewTest.setPort( s.substring( s.lastIndexOf("]") + 1));
                    if( viewTest.getPort().contains("("))
                        viewTest.setPort( viewTest.getPort().substring(0, viewTest.getPort().indexOf("(")).replace("-", "").trim());
                    TestShpd testFttx = new TestShpd( viewTest);
                    testFttx.test();
                    break;
                case 6: // BshpD
                    System.out.println(incident.getTechnogyEntity().getMameTechnology() + "|" + incident.getTechdata());
                    viewTest.setIp_address( s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))); // ip address
                    break;
                case 2: // DSL
                case 4:
                case 8:
                    viewTest.setIp_address(s.substring(s.indexOf("[") + 1, s.indexOf("]"))); // ip address
                    viewTest.setPort(s.substring(s.indexOf("-", s.lastIndexOf("]")) + 1, s.indexOf("-", s.indexOf("-", s.lastIndexOf("]")) + 1)).trim()); //port
                    (s.substring(s.indexOf('-', s.indexOf('-', s.lastIndexOf(']')) + 1) + 1).split(" ")[1].chars().filter(w -> w >= '0' && w <= '9')).forEach(e -> slot[0] += (char) e); //slot
                    viewTest.setSlot(slot[0]);
                    TestShpd test = new TestShpd( viewTest);
                    test.test();
                    break;
                case 3: // PON
                    viewTest.setIp_address( s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))); // ip address
                    if (s.contains("|||")) s = s.substring(s.lastIndexOf("|||"));
                    String[] spo = (s.substring(s.lastIndexOf("]"))).split("-");
                    for (int k = 0; k < spo.length; k++) {
                        //  System.out.println(k + "|->" + spo[k]);
                        switch (k) {
                            case 1:
                                spo[k].chars().filter(w -> w >= '0' && w <= '9').forEach(e -> slot[0] += (char) e); //slot
                                viewTest.setSlot(slot[0]);
                                break;
                            case 2:
                                if (!spo[k].contains("ОП"))
                                    break;
                            case 3:
                                if (spo[k].contains("ОП")) {
                                    if (spo[k + 1].contains("/"))
                                        viewTest.setPort(spo[k + 1].split("/")[1]);
                                    else
                                        viewTest.setPort( spo[k + 1]);
                                    break;
                                }
                            default:
                                if (spo[k].contains("TS")) {
                                    spo[k].chars().filter(w -> w >= '0' && w <= '9').forEach(e -> ont[0] += (char) e);
                                    viewTest.setOnt( ont[0]);
                                }
                        }
                    }
                    TestShpd testpon = new TestShpd( viewTest);
                    testpon.test();
                    break;
                default:
                    System.out.println(incident.getTechnogyEntity().getMameTechnology() + " технология не тестируется.");
            }
            System.out.println(incident.getN_incident() + "|" +incident.getTechnogyEntity().getMameTechnology() + "|" + viewTest.getIp_address() + "|" + viewTest.getPort() + "|" + viewTest.getSlot() + "|" + viewTest.getOnt() + "|");
        }
        return viewTest;
    }
}
