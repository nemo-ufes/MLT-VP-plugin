package br.ufes.inf.nemo.mltplugin;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.VPPlugin;
import com.vp.plugin.VPPluginInfo;

public class MLTPlugin implements VPPlugin {

	public static final String PLUGIN_ID = "br.ufes.inf.nemo.mltplugin";
	private static ProjectModelListener modelListener;
	
	public void loaded(VPPluginInfo arg0) {
		ApplicationManager
			.instance()
			.getViewManager()
			.showMessage("MLT Plugin loaded");
	}

	public void unloaded() {}
	
	public static ProjectModelListener getModelListener() {
		if(modelListener == null){
			modelListener = new ProjectModelListener();
		}
		return modelListener;
	}

	public static void loadModelListener() {
		LogUtilitary.log("Adding listener...");
		ApplicationManager.instance().getProjectManager()
				.getProject().addProjectModelListener(MLTPlugin.getModelListener());
	}
	
	public static void unloadModelListener() {
		if(modelListener!=null){
			LogUtilitary.log("Removing listener...");
			ApplicationManager.instance().getProjectManager()
					.getProject().removeProjectModelListener(MLTPlugin.getModelListener());
			modelListener = null;
		}
	}

}
