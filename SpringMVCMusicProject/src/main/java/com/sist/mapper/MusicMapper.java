package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MusicVO;

public interface MusicMapper {
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum AS num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM genie_music ORDER BY no ASC)) "
			+ "WHERE num BETWEEN ${start} AND ${end}")
	public List<MusicVO> musicListData(@Param("start") int start, @Param("end") int end);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM genie_music")
	public int musicTotalCount();
	
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum AS num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM genie_music WHERE title LIKE '%'||#{fd}||'%' ORDER BY no ASC)) "
			+ "WHERE num BETWEEN ${start} AND ${end}")
	public List<MusicVO> musicFindListData(@Param("start") int start, @Param("end") int end, @Param("fd") String fd);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM genie_music WHERE title LIKE '%'||#{fd}||'%'")
	public int musicFindTotalPage(String fd);
}
