package com.javaweb.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.base.BaseService;
import com.javaweb.constant.CommonConstant;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.module.ModuleIdAndNameResponse;
import com.javaweb.web.eo.module.ModuleLevelAndOrdersResponse;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleListResponse;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.UserRole;
import com.javaweb.web.service.ModuleService;

@Service("moduleServiceImpl")
public class ModuleServiceImpl extends BaseService implements ModuleService {
	
	public List<Module> getModule(boolean adminFlag,String userId) {
		if(adminFlag){//管理员
			return moduleDao.selectAllForMySql();
		}else{//非管理员
			//1.获得user_role的所有对应关系
			List<UserRole> userRoleList = userRoleDao.getUserRoleByUserId(userId);
			//2.获得所有模块ID
			List<String> allList = new ArrayList<>(); 
			for(int i=0;i<userRoleList.size();i++){
				List<String> list = null;
				UserRole userRole = userRoleList.get(i);
				int strategy = userRole.getStrategy();//权限获取策略(0:自定义;1:并集;2:交集;3:差集;4:以用户权限为准;5:以角色权限为准;其它:默认为未定义,作为并集处理)
				List<String> list1 = userModuleDao.getModuleIdsByUserId(userRole.getUserId());
				List<String> list2 = roleModuleDao.getModuleIdsByRoleId(userRole.getRoleId());
				if(strategy==1){
					list = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
				}else if(strategy==2){
					list = list1.stream().filter(item->list2.contains(item)).distinct().collect(Collectors.toList());
				}else if(strategy==3){
					List<String> list3 = list1.stream().filter(item->list2.contains(item)).distinct().collect(Collectors.toList());//交集
					List<String> list4 = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());//并集
					list3.stream().forEach(item->list4.remove(item));
					list = list4;
				}else if(strategy==4){
					list = list1;
				}else if(strategy==5){
					list = list2;
				}else{
					list = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
				}
				allList = Stream.concat(allList.stream(),list.stream()).distinct().collect(Collectors.toList());
			}
			//3.获得模块集合
			return moduleDao.getModuleByModuleId(allList);
		}
	}

	public Page moduleList(ModuleListRequest moduleListRequest) {
		List<ModuleListResponse> list = moduleDao.moduleList(moduleListRequest);
		long count = moduleDao.moduleListCount(moduleListRequest);
		Page page = new Page(moduleListRequest,list,count);
		return page;
	}

	@Transactional
	public void moduleDelete(String moduleId) {
		moduleDao.moduleDelete(moduleId);
	}

	@Transactional
	public void moduleAdd(Module module) {
		ModuleLevelAndOrdersResponse moduleLevelAndOrdersResponse = moduleDao.getModuleLevelAndOrdersByParentId(module.getParentId());
		if(moduleLevelAndOrdersResponse==null) {
			moduleLevelAndOrdersResponse = moduleDao.getModuleLevelAndOrdersWithoutParentId();
			
		}
		module.setOrders(moduleLevelAndOrdersResponse.getOrders()+1);
		module.setLevel(moduleLevelAndOrdersResponse.getLevel());
		moduleDao.insertForMySql(module);
	}
	
	@Transactional
	public void moduleModify(Module module) {
		moduleDao.updateForMySql(module);
	}

	public Module moduleDetail(String moduleId) {
		return moduleDao.moduleDetail(moduleId);
	}

    public List<ModuleIdAndNameResponse> getModuleIdAndNameList(String moduleType) {
        Map<String,String> map = new HashMap<>();
        String parameter = null;
        if("1".equals(moduleType)||"2".equals(moduleType)) {
            parameter = moduleType;
        }else if(moduleType==null||CommonConstant.EMPTY_VALUE.equals(moduleType.trim())) {
            parameter = null;
        }else {
            parameter = "-1";
        }
        map.put("moduleType",parameter);
        return moduleDao.getModuleIdAndNameList(map);
    }

}