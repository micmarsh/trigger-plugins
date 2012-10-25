package io.trigger.forge.android.modules.keyboard;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;
import android.app.Activity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

public class API {
	public static KeyCharacterMap map = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
	
	public static void typestring(final ForgeTask task, @ForgeParam("input") final String input){
		Activity activity = ForgeApp.getActivity();
		KeyEvent[] events = map.getEvents(input.toCharArray());
		for(KeyEvent e : events){
			activity.dispatchKeyEvent(e);
		}
	}
}