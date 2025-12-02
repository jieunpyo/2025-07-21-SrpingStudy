package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MusicMapper;
import com.sist.vo.MusicVO;
@Repository
public class MusicDAO {
	@Autowired
	private MusicMapper mapper;
	
	public List<MusicVO> musicListData(int start,int end)
	{
		return mapper.musicListData(start, end);
	}
	
	public int musicTotalCount()
	{
		return mapper.musicTotalCount();
	}
	
	public List<MusicVO> musicFindListData(int start,int end, String fd)
	{
		return mapper.musicFindListData(start, end, fd);
	}
	public int musicFindTotalPage(String fd)
	{
		return mapper.musicFindTotalPage(fd);
	}
	
}
