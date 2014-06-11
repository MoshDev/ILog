package com.moshx.jvmsample;

import com.moshx.ilog.ILog;

public class Main {

	public static void main(String[] args) {

		ILog iLog = ILog.getInstance("tester");
		iLog.d("helllo");
		iLog.getSettings().setEnabled(false);
		iLog.d("asdasdas");

	}
}
