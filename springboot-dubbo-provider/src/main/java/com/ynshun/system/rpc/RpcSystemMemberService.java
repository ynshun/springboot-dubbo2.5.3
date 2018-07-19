package com.ynshun.system.rpc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ynshun.common.annotation.ReadDataSource;
import com.ynshun.system.api.ISystemMemberService;
import com.ynshun.system.domain.SystemMember;
import com.ynshun.system.service.SystemMemberService;

@Service
public class RpcSystemMemberService implements ISystemMemberService {
	
	@Autowired
	private SystemMemberService systemMemberMapper;

	@Override
	public SystemMember insertSystemMember(SystemMember systemMember) {
		return systemMemberMapper.insertSystemMember(systemMember);
	}

	@Override
	@ReadDataSource
	public List<SystemMember> selectSystemMember(SystemMember systemMember) {
		return systemMemberMapper.selectSystemMember(systemMember);
	}

}
