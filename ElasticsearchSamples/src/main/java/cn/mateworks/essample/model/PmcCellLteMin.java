package cn.mateworks.essample.model;


import java.util.Date;

/**
 * Created by James Cheung on 2017/7/24.
 */

public class PmcCellLteMin {

    String enodebid;
    Date starttime;
    int localcellid;
    String clname;
    float pdcp_cpoctul;
    float pdcp_cpoctdl;
    float max_user;
    float prb_utilization_ul;
    float prb_utilization_dl;
    float rrc_connestab_rate;
    float erab_connestab_rate;
    float drop_call_rate;
    float drop_call_num;
    float prb_utilization;

    public String getEnodebid() {
        return enodebid;
    }

    public void setEnodebid(String enodebid) {
        this.enodebid = enodebid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public int getLocalcellid() {
        return localcellid;
    }

    public void setLocalcellid(int localcellid) {
        this.localcellid = localcellid;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public float getPdcp_cpoctul() {
        return pdcp_cpoctul;
    }

    public void setPdcp_cpoctul(float pdcp_cpoctul) {
        this.pdcp_cpoctul = pdcp_cpoctul;
    }

    public float getPdcp_cpoctdl() {
        return pdcp_cpoctdl;
    }

    public void setPdcp_cpoctdl(float pdcp_cpoctdl) {
        this.pdcp_cpoctdl = pdcp_cpoctdl;
    }

    public float getMax_user() {
        return max_user;
    }

    public void setMax_user(float max_user) {
        this.max_user = max_user;
    }

    public float getPrb_utilization_ul() {
        return prb_utilization_ul;
    }

    public void setPrb_utilization_ul(float prb_utilization_ul) {
        this.prb_utilization_ul = prb_utilization_ul;
    }

    public float getPrb_utilization_dl() {
        return prb_utilization_dl;
    }

    public void setPrb_utilization_dl(float prb_utilization_dl) {
        this.prb_utilization_dl = prb_utilization_dl;
    }

    public float getRrc_connestab_rate() {
        return rrc_connestab_rate;
    }

    public void setRrc_connestab_rate(float rrc_connestab_rate) {
        this.rrc_connestab_rate = rrc_connestab_rate;
    }

    public float getErab_connestab_rate() {
        return erab_connestab_rate;
    }

    public void setErab_connestab_rate(float erab_connestab_rate) {
        this.erab_connestab_rate = erab_connestab_rate;
    }

    public float getDrop_call_rate() {
        return drop_call_rate;
    }

    public void setDrop_call_rate(float drop_call_rate) {
        this.drop_call_rate = drop_call_rate;
    }

    public float getDrop_call_num() {
        return drop_call_num;
    }

    public void setDrop_call_num(float drop_call_num) {
        this.drop_call_num = drop_call_num;
    }

    public float getPrb_utilization() {
        return prb_utilization;
    }

    public void setPrb_utilization(float prb_utilization) {
        this.prb_utilization = prb_utilization;
    }
}
