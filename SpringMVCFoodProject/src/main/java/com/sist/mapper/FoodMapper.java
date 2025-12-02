package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {

	@Select("SELECT fno,name,poster,type,num "
			   +"FROM (SELECT fno,name,poster,type,rownum as num "
			   +"FROM (SELECT fno,name,poster,type "
			   +"FROM menupan_food ORDER BY fno ASC)) "
			   +"WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> FoodListData(@Param("start") int start,
			@Param("end") int end);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,type,num "
			+ "FROM (SELECT fno,name,poster,type,rownum AS num "
			+ "FROM (SELECT fno,name,poster,type "
			+ "FROM menupan_food "
			+ "WHERE address LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN ${start} AND ${end}")
	public List<FoodVO> FoodFindListData(@Param("start") int start, @Param("end") int end, @Param("fd") String fd);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food WHERE address LIKE '%'||#{fd}||'%'")
	public int FoodFindTotalPage(String fd);
}
