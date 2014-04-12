package org.j2eeframework.startoon.service;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ISearchedKeywordDAO;
import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.springframework.stereotype.Service;

@Service
public class SearchedKeywordService extends AbstractService<SearchedKeyword, Long, ISearchedKeywordDAO>
{
	@Resource
	private ISearchedKeywordDAO searchedKeywordDAO;

	@Override
	public ISearchedKeywordDAO getGenericDAO()
	{
		return searchedKeywordDAO;
	}
	
	public SearchedKeyword search(String key) {
		
		SearchedKeyword sk = searchedKeywordDAO.findByKeyword(key);
		
		if(sk!=null) {
			int times = sk.getSearchedTimes();
			times += 1;
			sk.setSearchedTimes(times);
			sk.setLastSearchTime(new Date());
			
			update(sk);
			
		} else {
			sk = new SearchedKeyword();
			sk.setKeyword(key);
			sk.setLastSearchTime(new Date());
			sk.setSearchedTimes(1);
			
			insert(sk);
		}
		
		return sk;
		
	}
	
	public int findCountByKeyword(String keyword) {
		return searchedKeywordDAO.findCountByKeyword(keyword);
	}
	
}
