package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

@Controller
public class MusicController {

	@Autowired
	private MusicDAO mDao;
	
	@GetMapping("music/list.do")
	public String music_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		int totalpage=mDao.musicTotalCount();
		
		List<MusicVO> list=mDao.musicListData(start, end);
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "music/list";
	}
	@RequestMapping("music/find")
	public String music_find(String page,String fd,Model model)
	{
		if(page==null)
			page="1";
		if(fd==null)
			fd="뛰어";
		
		int curpage=Integer.parseInt(page);
		int rowpage=12;
		int start=(rowpage*curpage)-(rowpage-1);
		int end=rowpage*curpage;
		int totalpage=mDao.musicFindTotalPage(page);
		
		List<MusicVO> list=mDao.musicFindListData(start, end ,fd);
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("fd",fd);
		return "music/find";
	}
}
