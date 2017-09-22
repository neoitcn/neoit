package com.qixin.neoit.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

/**
 * 该类计划用于分布式服务器的session共享。session将会存入到redis服务器中。
 * session管理是手动管理，与Web容器的session无关。
 * 
 *
 */
public class ShiroSessionDao extends AbstractSessionDAO {
	
	private final static Map<Serializable,Session> sessionManager = new HashMap<>();
	
	@Override
	public void delete(Session session) {
		sessionManager.remove(session.getId());
	}

	@Override
	public Collection<Session> getActiveSessions() {
		return sessionManager.values();
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		sessionManager.put(session.getId(),session);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		sessionManager.put(sessionId, session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable serializable) {
		return sessionManager.get(serializable);
	}

}
