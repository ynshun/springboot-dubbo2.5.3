package com.ynshun.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ynshun.common.annotation.ReadDataSource;
import com.ynshun.common.annotation.WriteDataSource;
import com.ynshun.system.api.ISystemMemberService;
import com.ynshun.system.domain.SystemMember;
import com.ynshun.system.mapper.SystemMemberMapper;

@Component
public class SystemMemberService implements ISystemMemberService {
	@Autowired
	private SystemMemberMapper systemMemberMapper;

	@Override
	@WriteDataSource
	@Transactional
	public SystemMember insertSystemMember(SystemMember systemMember) {
		systemMemberMapper.insert(systemMember);
		// TODO 测试回滚，故意执行一段异常代码
		int a = 1 / 0;
		System.out.println(a);
		return systemMember;
	}

	@Override
	@ReadDataSource
	public List<SystemMember> selectSystemMember(SystemMember systemMember) {
		return systemMemberMapper.select(systemMember);
	}

}
