package com.zlt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlt.dao.TbItemMapper;
import com.zlt.pojo.TbItem;
import com.zlt.pojo.TbItemExample;
import com.zlt.service.TbItemService;
import com.zlt.utils.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "tbItemService")
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    TbItemMapper tbItemMapper;

    public EasyUIDataGridResult<TbItem> getTbItemList(int page, int rows) {

        PageHelper.startPage(page,rows);
        TbItemExample tbItemExample = new TbItemExample();
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemMapper.selectByExample( tbItemExample ));
        EasyUIDataGridResult<TbItem> easy = new EasyUIDataGridResult(pageInfo.getTotal(),pageInfo.getList());
        return easy;
    }
}
