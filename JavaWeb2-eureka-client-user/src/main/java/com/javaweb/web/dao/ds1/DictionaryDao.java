package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.mybatis.api.DaoForMySql;
import com.javaweb.web.eo.dictionary.DictionaryListRequest;
import com.javaweb.web.po.Dictionary;

@Mapper
public interface DictionaryDao extends DaoForMySql<Dictionary> {
    
    public List<Dictionary> getDictionary(Dictionary dictionary);
    
    public List<Dictionary> dictionaryList(DictionaryListRequest dictionaryListRequest);
    
    public Long dictionaryCount(DictionaryListRequest dictionaryListRequest);
	
}