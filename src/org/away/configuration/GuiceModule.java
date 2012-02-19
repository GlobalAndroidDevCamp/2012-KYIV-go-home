package org.away.configuration;

import org.away.controller.SuperAI;
import org.away.controller.impl.StupidAI;
import org.away.dao.Dao;
import org.away.dao.impl.LocalDao;

import roboguice.config.AbstractAndroidModule;

public class GuiceModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(Dao.class).to(LocalDao.class);
		bind(SuperAI.class).to(StupidAI.class);
	}

}
