package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fDao;

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.foodListData(start, end);
	}

	@Override
	public int foodTotalpage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalpage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	@Override
	public FoodVO foodCookieData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodCookieData(fno);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindData(map);
	}

	@Override
	public int foodFindTotalpage(String address) {
		// TODO Auto-generated method stub
		return fDao.foodFindTotalpage(address);
	}

	@Override
	public List<FoodVO> foodTypeData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodTypeData(map);
	}

	@Override
	public int foodTypeTotalpage(String type) {
		// TODO Auto-generated method stub
		return fDao.foodTypeTotalpage(type);
	}
}
