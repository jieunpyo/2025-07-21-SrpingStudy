package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
	public List<FoodVO> FoodListData(int start,int end)
	{
		return mapper.FoodListData(start, end);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	public List<FoodVO> FoodFindListData(int start, int end, String fd)
	{
		return mapper.FoodFindListData(start, end, fd);
	}
	public int FoodFindTotalPage(String fd)
	{
		return mapper.FoodFindTotalPage(fd);
	}
}
