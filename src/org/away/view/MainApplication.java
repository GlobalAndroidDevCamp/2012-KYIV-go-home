package org.away.view;

import java.util.List;

import org.away.configuration.GuiceModule;

import com.google.inject.Module;

import roboguice.application.RoboApplication;

public class MainApplication extends RoboApplication {

	@Override
	protected void addApplicationModules(List<Module> modules) {
		modules.add(new GuiceModule());
	}

}
