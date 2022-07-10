package com.example.Klein.utils;

import com.github.pagehelper.Page;

import java.util.List;

/*
 * 支持分页功能
 * */
public class PageUtil {

	
	/*返回分页封装数据 total  rows*/
	public static DataGridResult convertToResult(List<?> gridList){
		DataGridResult dataGrid = null;
		
		if(gridList != null){
			if(gridList instanceof Page){
				Page<?> page = (Page<?>) gridList;
				dataGrid = new DataGridResult(page.getTotal(),page.getResult());
			}else{
				dataGrid = new DataGridResult(new Long(gridList.size()),gridList);
			}
		}else{//数据为null
			dataGrid = new DataGridResult(new Long(0),null); 
		}
		
		return dataGrid;
	}
	
}
