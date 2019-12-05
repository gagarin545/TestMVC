package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;
import java.io.IOException;

class SNMPManager {

    static Boolean snmp_get(ViewTest viewTest) throws IOException {
        Boolean status = false;
        System.out.println("ip=" + viewTest.getIp_address() + "sl=" + viewTest.getSlot() + "port=" + viewTest.getPort() +"ont=" + viewTest.getOnt() );
        String SMI = ".1.3.6.1.4.1.";
        SnmpCommand client = new SnmpCommand("udp:" + viewTest.getIp_address() + "/161") {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        if( !client.start()) {
            System.out.println("error");
            return false;
        }
        System.out.println("!!" + client.getAsString(new OID(".1.3.6.1.2.1.1.1.0")) + "  " + viewTest.getIp_address());
        Testing testing = new Testing(client, viewTest);
        System.out.println( "->>" +client.getAsString(new OID(".1.3.6.1.2.1.1.1.0")));
        switch (client.getAsString(new OID(".1.3.6.1.2.1.1.1.0"))) {
            case "ECI telecom HiFOCuS broadband access system":
                switch (client.getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072"))) {
                    case "IPNI_APP_2.52.35":
                          status = testing.test(String.valueOf(binary.Nport( viewTest.getPort(), viewTest.getSlot(), "00")), String.valueOf(binary.Nport( viewTest.getSlot(), viewTest.getPort(), "01")), viewTest.getOnt(), 2);   // комманды
                        break;
                    case "mini_ge_9.01.48":
                          status =testing.test(String.valueOf(binary.Nport( "7", viewTest.getPort(), "00")), String.valueOf(binary.Nport( "7", viewTest.getPort(), "01")), viewTest.getOnt(), 1);
                        break;
                    case "IPNI_HB_APP_2.00.73":
                    case "se_10.01.64":
                    case "se_10.01.65":
                       // System.out.println( "---------" + String.valueOf(binary.Nport( viewTest.getPort(), viewTest.getSlot(), "00")));
                        status = testing.test(String.valueOf(binary.Nport( viewTest.getPort(), viewTest.getSlot(), "00")), String.valueOf(binary.Nport( viewTest.getPort(), viewTest.getSlot(), "01")), viewTest.getOnt(), 1);  // комманды
                        break;
                    case "IPNI_HB_APP_5.61.59":

                    default:
                        status =false;
                        //sym.append("|").append(client.getAsString(new OID(SMI + "1286.1.3.3.1.1.2.131072"), typePdu));
                }
                break;

            case "Huawei Integrated Access Software":
                 status = testing.test(String.valueOf(4194304000L + 8192 * Integer.parseInt(viewTest.getSlot()) + 256 * Integer.parseInt(viewTest.getPort()) ), viewTest.getPort(), viewTest.getOnt(), 3);  // комманды;
                 //status = testing.test(String.valueOf(4194304000L + 8192 * Integer.parseInt(viewTest.getPort()) + 256 * Integer.parseInt(viewTest.getSlot()) ), viewTest.getSlot(), viewTest.getOnt(), 3);  // комманды;
                break;
            case "24-port 10/100 Ethernet Switch":
                   status = testing.test("", "", viewTest.getPort(), 4);     //комманды ont
                break;
        }
        return status;
    }
}