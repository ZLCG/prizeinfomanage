package com.xlhb.service.impl;

import com.xlhb.mapper.PrizeinfoMapper;
import com.xlhb.pojo.Prizeinfo;
import com.xlhb.pojo.PrizeinfoExample;
import com.xlhb.service.PrizeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeinfoServiceImpl implements PrizeinfoService {

    @Autowired
    private PrizeinfoMapper prizeinfoMapper;

    //以学生ID为参数返回奖惩信息列表
    @Override
    public List<Prizeinfo> getPrizeinfo(Integer studentid) {
        PrizeinfoExample prizeinfoExample = new PrizeinfoExample();
        PrizeinfoExample.Criteria prizeinfoExampleCriteria = prizeinfoExample.createCriteria();

        prizeinfoExampleCriteria.andStudentidEqualTo(studentid);
        List<Prizeinfo> prizeinfos = prizeinfoMapper.selectByExample(prizeinfoExample);
        return prizeinfos;
    }

    @Override
    public Prizeinfo findPrizeinfo(Integer id) {
        PrizeinfoExample prizeinfoExample = new PrizeinfoExample();
        PrizeinfoExample.Criteria prizeinfoExampleCriteria = prizeinfoExample.createCriteria();

        prizeinfoExampleCriteria.andIdEqualTo(id);
        List<Prizeinfo> prizeinfos = prizeinfoMapper.selectByExample(prizeinfoExample);
        return prizeinfos.get(0);
    }

    //添加一条奖惩信息
    @Override
    public void insertPrizeinfo(Prizeinfo prizeinfo) {
        prizeinfoMapper.insertSelective(prizeinfo);
    }

    //以奖惩ID为参数删除奖惩条目
    @Override
    public void deletePrizeinfo(Integer id) {
        PrizeinfoExample prizeinfoExample = new PrizeinfoExample();
        PrizeinfoExample.Criteria prizeinfoExampleCriteria = prizeinfoExample.createCriteria();

        prizeinfoExampleCriteria.andIdEqualTo(id);
        prizeinfoMapper.deleteByExample(prizeinfoExample);
    }

    //修改指定ID的奖惩信息
    @Override
    public void updatePrizeinfo(Prizeinfo prizeinfo, Integer id) {
        PrizeinfoExample prizeinfoExample = new PrizeinfoExample();
        PrizeinfoExample.Criteria prizeinfoExampleCriteria = prizeinfoExample.createCriteria();

        prizeinfoExampleCriteria.andIdEqualTo(id);
        prizeinfoMapper.updateByExampleSelective(prizeinfo, prizeinfoExample);
    }

}
