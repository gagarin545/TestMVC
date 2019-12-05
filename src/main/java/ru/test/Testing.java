package ru.test;

import org.snmp4j.smi.OID;
import ru.entity.ViewTest;

import java.io.IOException;

public class Testing {
    private SnmpCommand client;
    private ViewTest viewTest;
    public Testing(SnmpCommand client, ViewTest viewTest) {
        this.client = client;
        this.viewTest = viewTest;
    }

    Boolean test(String ifindex, String chindex, String ont, int i)  {
        String SMI = ".1.3.6.1.4.1.";
        try {
            switch (i) {
                case 1:
                    viewTest.setStatus(client.getAsString(new OID(SMI + "1286.1.3.9.2.1.1.1.7." + ifindex))); //состояние линии
                    viewTest.setProfil(client.getAsString(new OID(SMI + "1286.1.3.9.1.5.1.1.1.2." + ifindex))); //тек. профиль
                    viewTest.setInit_count(client.getAsString(new OID(SMI + "1286.1.3.9.1.4.1.2.1.6." + ifindex))); // инициализации
                    viewTest.setSnr_out(Float.valueOf(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.13." + ifindex))) / 10); // сигнал шум к клиент
                    viewTest.setSnr_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.14." + ifindex))) / 10); // сигнал шум от клиента
                    viewTest.setL_Attenuation_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.9." + ifindex))) / 10); // затухание линии к клиент
                    viewTest.setL_Attenuation_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.10." + ifindex))) / 10); // затухание линии от клиента
                    viewTest.setS_Attenuation_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.11." + ifindex))) / 10); // затухание сигнала к клиента
                    viewTest.setS_Attenuation_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.12." + ifindex))) / 10); // затухание сигнала от клиента
                    viewTest.setPower_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.19." + ifindex))) / 10); // вых. мощность к клиента
                    viewTest.setPower_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.20." + ifindex))) / 10); // вых. мощность от клиента
                    viewTest.setV_previous_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".1"))) / 1000); // v предыдущая к клиента
                    viewTest.setV_previous_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".2"))) / 1000); // v предыдущая от клиента
                    viewTest.setV_current_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".1"))) / 1000); // v текущая к клиента
                    viewTest.setV_current_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".2"))) / 1000); // v текущая от клиента
                    viewTest.setV_max_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.15." + ifindex))) / 1000); // v max к клиента
                    viewTest.setV_max_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.9.1.1.1.1.16." + ifindex))) / 1000); // v max от клиента
                    break;
                case 2:
                    viewTest.setStatus(client.getAsString(new OID(SMI + "1286.1.3.18.2.1.1.1.7." + ifindex)));   //состояние линии
                    viewTest.setProfil(client.getAsString(new OID(SMI + "1286.1.3.18.1.5.1.1.1.2." + ifindex)));   //тек. профиль
                    viewTest.setInit_count(client.getAsString(new OID(SMI + "1286.1.3.18.1.4.1.2.1.6." + ifindex)));   // инициализации
                    viewTest.setSnr_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".1.1")))); // сигнал шум к клиента
                    viewTest.setSnr_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".2.1")))); // сигнал шум от клиента
                    viewTest.setL_Attenuation_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".1.1")))); // затухание линии к клиента
                    viewTest.setL_Attenuation_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".2.1")))); // затухание линии от клиента
                    viewTest.setS_Attenuation_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".1.1")))); // затухание сигнала к клиента
                    viewTest.setS_Attenuation_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".2.1")))); // затухание сигнала от клиента
                    viewTest.setPower_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.13." + ifindex)))); // вых. мощность к клиента
                    viewTest.setPower_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.14." + ifindex)))); // вых. мощность от клиента
                    viewTest.setV_previous_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".1")))); // v предыдущая к клиента
                    viewTest.setV_previous_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".2")))); // v предыдущая от клиента
                    viewTest.setV_previous_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".1")))); // v текущая к клиента
                    viewTest.setV_current_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".2")))); // v текущая от клиента
                    viewTest.setV_max_out(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.9." + ifindex)))); // v max к клиента
                    viewTest.setV_max_in(Float.parseFloat(client.getAsString(new OID(SMI + "1286.1.3.18.1.1.1.1.10." + ifindex)))); // v max от клиента
                    break;
                case 3:
                    System.out.println(" start" +  ifindex);
                    viewTest.setStatus(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.46.1.15." + ifindex + '.' + ont)));
                    viewTest.setDescription(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.9." + ifindex + '.' + ont)));     //  описание
                    viewTest.setSn(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.3." + ifindex + '.' + ont)));           //  sn
                    viewTest.setPasswd(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.43.1.4." + ifindex + '.' + ont)));    //  pass
                    viewTest.setOntVersion(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.45.1.5." + ifindex + '.' + ont)));    //  версия ont
                    viewTest.setPower_out(Float.parseFloat(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.51.1.4." + ifindex + '.' + ont)))/100);    //  RxPower
                    viewTest.setDistance(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.46.1.20." + ifindex + '.' + ont)));    //  Distance
                    viewTest.setStatus_port1(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".1")));  //состояние порта 1
                    viewTest.setV_port1(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".1")));  // скорость порта 1
                    viewTest.setStatus_port2(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".2")));  //состояние порта 2
                    viewTest.setV_port2(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".2")));  //скорость порта 1
                    viewTest.setStatus_port3(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".3")));  //состояние порта 3
                    viewTest.setV_port3(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".3")));  //скорость порта 1
                    viewTest.setStatus_port4(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".4")));  //состояние порта 4
                    viewTest.setV_port4(client.getAsString(new OID(SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".4")));  //скорость порта 1
                    break;
                case 4:
                    viewTest.setStatus(client.getAsString(new OID("1.3.6.1.2.1.2.2.1.7." + ont))); //Состояние
                    viewTest.setDescription(client.getAsString(new OID("1.3.6.1.2.1.2.2.1.8." + ont))); // Адм состояние
                    viewTest.setSn(client.getAsString(new OID("1.3.6.1.2.1.16.1.1.1.5." + ont)));   // Пакетов
                    viewTest.setInit_count(client.getAsString(new OID("1.3.6.1.2.1.16.1.1.1.8." + ont)));    // CRC ошибки
                    viewTest.setStatus_port1(client.getAsString(new OID("1.3.6.1.2.1.2.2.1.14." + ont)));  // InError
                    viewTest.setStatus_port2(client.getAsString(new OID("1.3.6.1.2.1.2.2.1.20." + ont)));    // outError
                    viewTest.setMacAddress(client.getAsString(new OID("1.3.6.1.2.1.10.7.2.1.16." + ont)));   // Mac address
                    break;
            }
        }catch (IOException e) {  return false;}
        return true;
    }
}
