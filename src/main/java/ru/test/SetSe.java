package ru.test;

public class SetSe {
    private String SMI = ".1.3.6.1.4.1.";

    String[][] getSe(String ifindex, String chindex, String ont, int i) {
        switch (i) {    // комманды
            case 1:
                return new String[][]{
                        {"|состояние:\t", SMI + "1286.1.3.9.2.1.1.1.7." + ifindex}, //состояние линии
                        {"|профиль:", SMI + "1286.1.3.9.1.5.1.1.1.2." + ifindex}, //тек. профиль
                        {"|инициализации:", SMI + "1286.1.3.9.1.4.1.2.1.6." + ifindex}, // инициализации
                        {"|сигнал / шум:\t", SMI + "1286.1.3.9.1.1.1.1.13." + ifindex}, // сигнал шум к клиента
                        {"-", SMI + "1286.1.3.9.1.1.1.1.14." + ifindex}, // сигнал шум от клиента
                        {"|затухан.линии:\t", SMI + "1286.1.3.9.1.1.1.1.9." + ifindex}, // затухание линии к клиент
                        {"-", SMI + "1286.1.3.9.1.1.1.1.10." + ifindex}, // затухание линии от клиента
                        {"|затух.сигнала:\t", SMI + "1286.1.3.9.1.1.1.1.11." + ifindex}, // затухание сигнала к клиента
                        {"-", SMI + "1286.1.3.9.1.1.1.1.12." + ifindex}, // затухание сигнала от клиента
                        {"|вых.мощность:\t", SMI + "1286.1.3.9.1.1.1.1.19." + ifindex}, // вых. мощность к клиента
                        {"-", SMI + "1286.1.3.9.1.1.1.1.20." + ifindex}, // вых. мощность от клиента
                        {"|пред.скорость:\t", SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".1"}, // v предыдущая к клиента
                        {"", SMI + "1286.1.3.9.1.1.2.1.4." + chindex + ".2"}, // v предыдущая от клиента
                        {"|тек.скорость:\t", SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".1"}, // v текущая к клиента
                        {"", SMI + "1286.1.3.9.1.1.2.1.3." + chindex + ".2"}, // v текущая от клиента
                        {"|Max.скорость:\t", SMI + "1286.1.3.9.1.1.1.1.15." + ifindex}, // v max к клиента
                        {"", SMI + "1286.1.3.9.1.1.1.1.16." + ifindex}, // v max от клиента
                };
            case 2:
                return new String[][]{ // комманды{
                        {"|состояние:\t", SMI + "1286.1.3.18.2.1.1.1.7." + ifindex},   //состояние линии
                        {"|профиль: ", SMI + "1286.1.3.18.1.5.1.1.1.2." + ifindex},   //тек. профиль
                        {"|инициализации: ", SMI + "1286.1.3.18.1.4.1.2.1.6." + ifindex},   // инициализации
                        {"|сигнал / шум:\t", SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".1.1"}, // сигнал шум к клиента
                        {"-", SMI + "1286.1.3.18.1.1.3.1.6." + ifindex + ".2.1"}, // сигнал шум от клиента
                        {"|затухан.линии:\t", SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".1.1"}, // затухание линии к клиента
                        {"-", SMI + "1286.1.3.18.1.1.3.1.4." + ifindex + ".2.1"}, // затухание линии от клиента
                        {"|затух.сигнала:\t", SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".1.1"}, // затухание сигнала к клиента
                        {"-", SMI + "1286.1.3.18.1.1.3.1.5." + ifindex + ".2.1"}, // затухание сигнала от клиента
                        {"|вых.мощность:\t", SMI + "1286.1.3.18.1.1.1.1.13." + ifindex}, // вых. мощность к клиента
                        {"-", SMI + "1286.1.3.18.1.1.1.1.14." + ifindex}, // вых. мощность от клиента
                        {"|пред.скорость:\t", SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".1"}, // v предыдущая к клиента
                        {"", SMI + "1286.1.3.18.1.1.2.1.4." + chindex + ".2"}, // v предыдущая от клиента
                        {"|тек.скорость:\t", SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".1"}, // v текущая к клиента
                        {"", SMI + "1286.1.3.18.1.1.2.1.3." + chindex + ".2"}, // v текущая от клиента
                        {"|Max.скорость:\t", SMI + "1286.1.3.18.1.1.1.1.9." + ifindex}, // v max к клиента
                        {"", SMI + "1286.1.3.18.1.1.1.1.10." + ifindex}, // v max от клиента
                };
            case 3:
                return new String[][]{
                        {"|состояние:\t", SMI + "2011.6.128.1.1.2.46.1.15." + ifindex + '.' + ont},
                        {"|описание :\t", SMI + "2011.6.128.1.1.2.43.1.9." + ifindex + '.' + ont},     //  описание
                        {"|Sn :\t", SMI + "2011.6.128.1.1.2.43.1.3." + ifindex + '.' + ont},           //  sn
                        {"|кодовое слово :\t", SMI + "2011.6.128.1.1.2.43.1.4." + ifindex + '.' + ont},    //  pass
                        {"|версия ПО ONT :\t", SMI + "2011.6.128.1.1.2.45.1.5." + ifindex + '.' + ont},    //  версия ont
                        {"|затухание(дБм):\t", SMI + "2011.6.128.1.1.2.51.1.4." + ifindex + '.' + ont},    //  RxPower
                        {"|расстояние(м.):\t", SMI + "2011.6.128.1.1.2.46.1.20." + ifindex + '.' + ont},    //  Distance
                        {"|Порт 1: ", SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".1"},  //состояние порта 1
                        {"speed", SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".1"},  // скорость порта 1
                        {"|Порт 2: ", SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".2"},  //состояние порта 2
                        {"speed", SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".2"},  //скорость порта 1
                        {"|Порт 3: ", SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".3"},  //состояние порта 3
                        {"speed", SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".3"},  //скорость порта 1
                        {"|Порт 4: ", SMI + "2011.6.128.1.1.2.62.1.22." + ifindex + '.' + ont + ".4"},  //состояние порта 4
                        {"speed", SMI + "2011.6.128.1.1.2.62.1.4." + ifindex + '.' + ont + ".4"},  //скорость порта 1
                };
            case 4:
                return new String[][] {
                        {"|Адм.состояние:\t", "1.3.6.1.2.1.2.2.1.7." + ont},
                        {"|Опер.состояние:\t", "1.3.6.1.2.1.2.2.1.8." + ont},
                        {"|Пакетов:\t", "1.3.6.1.2.1.16.1.1.1.5." + ont},
                        {"|CRC ошибок:\t", "1.3.6.1.2.1.16.1.1.1.8." + ont},
                        {"|InError:\t", "1.3.6.1.2.1.2.2.1.14." + ont},
                        {"|OutError:\t", "1.3.6.1.2.1.2.2.1.20." + ont},
                        {"|Internal MAC Rx Error :\t", "1.3.6.1.2.1.10.7.2.1.16." + ont},

                };
            default:
                return null;
        }
    }
}
