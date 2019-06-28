package com.xlhb.service;

import com.xlhb.pojo.Prizeinfo;

import java.util.List;

public interface PrizeinfoService {
    public List<Prizeinfo> getPrizeinfo(Integer studentid);
    public Prizeinfo findPrizeinfo(Integer id);
    public void deletePrizeinfo(Integer id);
    public void insertPrizeinfo(Prizeinfo prizeinfo);
    public void updatePrizeinfo(Prizeinfo prizeinfo, Integer id);
}
