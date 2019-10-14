package com.zlt.service;


import com.zlt.pojo.TbItem;
import com.zlt.utils.EasyUIDataGridResult;

public interface TbItemService{
    EasyUIDataGridResult<TbItem> getTbItemList(int page, int rows);
}
