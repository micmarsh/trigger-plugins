package io.trigger.forge.android.modules.keyboard;
/*
Copyright 2012 Fetchnotes,Inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
  */

import io.trigger.forge.android.core.ForgeActivity;
import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;

public class API {
	public static KeyCharacterMap map = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD);
	private static class StickyListener implements OnTouchListener{
		private ForgeTask task;
		public StickyListener setTask(ForgeTask task){
			this.task = task;
			return this;
		}
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			show(task);
			return false;
		}
	}
	
	private final static StickyListener KEYBOARD_LISTENER = new StickyListener();
	
	public static void stick(final ForgeTask task){
		try{
			ForgeApp.getActivity().webView.setOnTouchListener(KEYBOARD_LISTENER.setTask(task));
			task.success();
		}catch(Exception e){
			task.error(e);
		}
	}
	
	public static void unstick(final ForgeTask task){
		try{
			ForgeApp.getActivity().webView.setOnTouchListener(null);
			task.success();
		}catch(Exception e){
			task.error(e);
		}
	}
	
	public static void show(final ForgeTask task){
		try{
			show();
	        task.success();
		}catch(Exception e){
			task.error(e);
		}
	}
	
	public static void show(){
			ForgeActivity activity = ForgeApp.getActivity();
			InputMethodManager mgr = getKeyboard(activity);
	        mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
	   
	}
		
	private static InputMethodManager getKeyboard(ForgeActivity activity){
		return (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
	}
}