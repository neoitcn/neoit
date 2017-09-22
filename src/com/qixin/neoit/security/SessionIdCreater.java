package com.qixin.neoit.security;

import java.io.Serializable;
import java.util.UUID;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

public class SessionIdCreater implements SessionIdGenerator{

	@Override
	public Serializable generateId(Session arg0) {
		return UUID.randomUUID();
	}

}
