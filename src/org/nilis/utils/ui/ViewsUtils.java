package org.nilis.utils.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public class ViewsUtils {

	public static void unbindDrawables(final View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawables(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}
	
	public static void unbindDrawables(Activity activity) {
		unbindDrawables(activity.getWindow().getDecorView().findViewById(android.R.id.content));
	}
}
