package ru.entity;

import java.util.Arrays;

public class ViewTest {
    private long service;
    private String ip_address;
    private String port;
    private String slot ;
    private String ont;
    private String status = "0";
    private String profil;
    private String init_count;
    private float snr_out;
    private float snr_in;
    private float l_Attenuation_out;
    private float l_Attenuation_in;
    private float s_Attenuation_out;
    private float s_Attenuation_in;
    private float power_out;
    private float power_in;
    private float v_previous_out;
    private float v_previous_in;
    private float v_current_out;
    private float v_current_in;
    private float v_max_out;
    private float v_max_in;
    private String description;
    private String sn;
    private String passwd;
    private String ontVersion;
    private String distance;
    private String status_port1 = "0";
    private String status_port2 = "0";
    private String status_port3 = "0";
    private String status_port4 = "0";
    private String V_port1;
    private String V_port2;
    private String V_port3;
    private String V_port4;
    private String macAddress;
    private String vlans;

    public ViewTest() {}

    public String getVlans() {        return vlans;    }
    public void setVlans(String vlans) {        this.vlans = vlans;    }
    public long getService() {        return service;    }
    public void setService(long service) {        this.service = service;    }
    public String getIp_address() {        return ip_address;    }
    public void setIp_address(String ip_address) {        this.ip_address = ip_address;    }
    public String getPort() {        return port;    }
    public void setPort(String port) {        this.port = port;    }
    public String getSlot() {        return slot;    }
    public void setSlot(String slot) {        this.slot = slot;    }
    public String getOnt() {        return ont;    }
    public void setOnt(String ont) {        this.ont = ont;    }
    public String getStatus() {        return status;    }
    public void setStatus(String status) {        this.status = status;    }
    public String getProfil() {        return profil;    }
    public void setProfil(String profil) {        this.profil = profil;    }
    public String getInit_count() {        return init_count;    }
    public void setInit_count(String init_count) {        this.init_count = init_count;    }
    public float getSnr_out() {        return snr_out;    }
    public void setSnr_out(float snr_out) {        this.snr_out = snr_out;    }
    public float getSnr_in() {        return snr_in;    }
    public void setSnr_in(float snr_in) {        this.snr_in = snr_in;    }
    public float getL_Attenuation_out() {        return l_Attenuation_out;    }
    public void setL_Attenuation_out(float l_Attenuation_out) {        this.l_Attenuation_out = l_Attenuation_out;    }
    public float getL_Attenuation_in() {        return l_Attenuation_in;    }
    public void setL_Attenuation_in(float l_Attenuation_in) {        this.l_Attenuation_in = l_Attenuation_in;    }
    public float getS_Attenuation_out() {        return s_Attenuation_out;    }
    public void setS_Attenuation_out(float s_Attenuation_out) {        this.s_Attenuation_out = s_Attenuation_out;    }
    public float getS_Attenuation_in() {        return s_Attenuation_in;    }
    public void setS_Attenuation_in(float s_Attenuation_in) {        this.s_Attenuation_in = s_Attenuation_in;    }
    public float getPower_out() {        return power_out;    }
    public void setPower_out(float power_out) {        this.power_out = power_out;    }
    public float getPower_in() {        return power_in;    }
    public void setPower_in(float power_in) {        this.power_in = power_in;    }
    public float getV_previous_out() {        return v_previous_out;    }
    public void setV_previous_out(float v_previous_out) {        this.v_previous_out = v_previous_out;    }
    public float getV_previous_in() {        return v_previous_in;    }
    public void setV_previous_in(float v_previous_in) {        this.v_previous_in = v_previous_in;    }
    public float getV_current_out() {        return v_current_out;    }
    public void setV_current_out(float v_current_out) {        this.v_current_out = v_current_out;    }
    public float getV_current_in() {        return v_current_in;    }
    public void setV_current_in(float v_current_in) {        this.v_current_in = v_current_in;    }
    public float getV_max_out() {        return v_max_out;    }
    public void setV_max_out(float v_max_out) {        this.v_max_out = v_max_out;    }
    public float getV_max_in() {        return v_max_in;    }
    public void setV_max_in(float v_max_in) {        this.v_max_in = v_max_in;    }
    public String getDescription() {        return description;    }
    public void setDescription(String description) {        this.description = description;    }
    public String getSn() {        return sn;    }
    public void setSn(String sn) {        this.sn = sn;    }
    public String getPasswd() {        return passwd;    }
    public void setPasswd(String passwd) {
        if( passwd.contains("ff"))
            this.passwd = passwd.replace(":00", "");
        else
            this.passwd = Arrays.stream(passwd.split(":")).map(w-> (char) (Integer.valueOf(w) + 18)).filter(x-> x >= '0' && x <= '9').map(x-> Character.toString(x)).reduce(String::concat).get();
    }
    public String getOntVersion() {        return ontVersion;    }
    public void setOntVersion(String ontVersion) {        this.ontVersion = ontVersion;    }
    public String getDistance() {        return distance;    }
    public void setDistance(String distance) {        this.distance = distance;    }
    public String getStatus_port1() {        return status_port1;    }
    public void setStatus_port1(String status_port1) {        this.status_port1 = status_port1;    }
    public String getStatus_port2() {        return status_port2;    }
    public void setStatus_port2(String status_port2) {        this.status_port2 = status_port2;    }
    public String getStatus_port3() {        return status_port3;    }
    public void setStatus_port3(String status_port3) {        this.status_port3 = status_port3;    }
    public String getStatus_port4() {        return status_port4;    }
    public void setStatus_port4(String status_port4) {        this.status_port4 = status_port4;    }
    public String getV_port1() {        return V_port1;    }
    public void setV_port1(String v_port1) {        V_port1 = v_port1;    }
    public String getV_port2() {        return V_port2;    }
    public void setV_port2(String v_port2) {        V_port2 = v_port2;    }
    public String getV_port3() {        return V_port3;    }
    public void setV_port3(String v_port3) {        V_port3 = v_port3;    }
    public String getV_port4() {        return V_port4;    }
    public void setV_port4(String v_port4) {        V_port4 = v_port4;    }
    public String getMacAddress() {        return macAddress;    }
    public void setMacAddress(String macAddress) {        this.macAddress = macAddress;    }

    @Override
    public String toString() {
        return "ViewTest{" +
                "service=" + service +
                ", ip_address='" + ip_address + '\'' +
                ", port='" + port + '\'' +
                ", slot='" + slot + '\'' +
                ", ont='" + ont + '\'' +
                ", status='" + status + '\'' +
                ", profil='" + profil + '\'' +
                ", init_count='" + init_count + '\'' +
                ", snr_out=" + snr_out +
                ", snr_in=" + snr_in +
                ", l_Attenuation_out=" + l_Attenuation_out +
                ", l_Attenuation_in=" + l_Attenuation_in +
                ", s_Attenuation_out=" + s_Attenuation_out +
                ", s_Attenuation_in=" + s_Attenuation_in +
                ", power_out=" + power_out +
                ", power_in=" + power_in +
                ", v_previous_out=" + v_previous_out +
                ", v_previous_in=" + v_previous_in +
                ", v_current_out=" + v_current_out +
                ", v_current_in=" + v_current_in +
                ", v_max_out=" + v_max_out +
                ", v_max_in=" + v_max_in +
                ", description='" + description + '\'' +
                ", sn='" + sn + '\'' +
                ", passwd='" + passwd + '\'' +
                ", ontVersion='" + ontVersion + '\'' +
                ", distance='" + distance + '\'' +
                ", status_port1='" + status_port1 + '\'' +
                ", status_port2='" + status_port2 + '\'' +
                ", status_port3='" + status_port3 + '\'' +
                ", status_port4='" + status_port4 + '\'' +
                ", V_port1='" + V_port1 + '\'' +
                ", V_port2='" + V_port2 + '\'' +
                ", V_port3='" + V_port3 + '\'' +
                ", V_port4='" + V_port4 + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", vlans='" + vlans + '\'' +
                '}';
    }
}
