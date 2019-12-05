package ru.test;

import ru.entity.ViewTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestShpd {
    private ViewTest viewTest;
    private StringBuilder s;
    public TestShpd(ViewTest viewTest) {
        this.viewTest = viewTest;
    }


    public void test(){

        String url_get_page[] = {
                "http://10.183.116.238/cgi-bin/getTechData.php?svc=",   //  3513256145;PON;74-MIASS-AGG004-O6;10.228.36.197;3;7;5;;;;
                "http://10.183.116.238/cgi-bin/getline.cgi?uslogin="    //  ARGUS_port   : 74-MIASS-AGG004-O6(10.228.36.197)-3/7/5      ONT_distance : 0        Rx n/a
        };

        try {
            if( viewTest.getService() > 0) {
                form(getResultTest(url_get_page[0] + viewTest.getService()), ";");
                if(SNMPManager.snmp_get(viewTest))
                    System.out.println("ok");
                else
                    form(getResultTest(url_get_page[1] + viewTest.getService()), ":");
            }

        }catch (IOException e) {
            System.out.println( viewTest.getService() + "Повторите тест позже" + e + "|");
        }
    }

    private void form(BufferedReader rd, String c) throws IOException {

        if( c.equals(";"))
            viewTest.setVlans(Stream.of( rd.readLine().replace(";", " ;").split(c)).skip(7).reduce((x,y) -> x + y).get().trim());
        else {
            List<String> list = rd.lines().collect(Collectors.toList());
            for( String line: list)
                System.out.println( line);
            for( String line: list)
                switch (line.split(c)[0].trim()) {
                    case "ONT_SW_Version":
                        viewTest.setOntVersion(line.split(c)[1]);
                        break;
                    case "MAC Address":
                        viewTest.setMacAddress(line.split(c)[1]);
                        break;
                    case "SNR":
                        viewTest.setSnr_in(Float.parseFloat(line.split(c)[1].split(" ")[0]));
                        viewTest.setSnr_out(Float.parseFloat(line.split(c)[1].split(" ")[1]));
                        break;
                    case "Port_Profile":
                        viewTest.setProfil(line.split(c)[1]);
                    case "Attenuation":
                        viewTest.setL_Attenuation_in(Float.parseFloat(line.split(c)[1].split(" ")[0]));
                        viewTest.setL_Attenuation_out(Float.parseFloat(line.split(c)[1].split(" ")[1]));
                        break;
                    case "ONT_distance":
                        viewTest.setDistance(line.split(c)[1]);
                        break;
                    case "Rx":
                    case "Rx_Power":
                        if(line.split(c)[0].contains("inf"))
                            viewTest.setPower_in(1.0f);
                        else
                            viewTest.setPower_in(Float.parseFloat(line.split(c)[1]));
                        if( viewTest.getPower_in() != 0 ) viewTest.setStatus("1");
                        break;
                }

        }
    }
    private BufferedReader getResultTest(String url_page) throws IOException {
        URL url = new URL(url_page);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection != null) {
            connection.setReadTimeout(60 * 1000); // ожидание на 5 сек
            connection.setDoOutput(true); // соединение доступно для вывода
            connection.setUseCaches(false); // не использовать кэш
            connection.setRequestMethod("GET"); // метод post
            connection.setRequestProperty("connection", "keep-alive");
            connection.setRequestProperty("Charset", "UTF-8");
        }
        connection.connect();
        return new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
    }
}