package com.unimedsci.ydata.jxz.commons.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * wanglie 2016.3.7 3:38:58
 */
public class TaskTimerUtil {
	private final static Logger _logger = Logger.getLogger(TaskTimerUtil.class
			.getName());

	private static Timer taskTimer = new Timer();

	public static void init() {
		if (taskTimer == null) {
			taskTimer = new Timer();
		}
	}

	public static void cancel() {
		taskTimer.cancel();
		taskTimer = null;
	}

	/**
	 * Calendar cl = Calendar.getInstance(); cl.add(Calendar.HOUR, 1);
	 * cl.set(Calendar.MINUTE, 0); cl.set(Calendar.SECOND, 0);
	 * 
	 * 
	 * @param task
	 * @param startTime
	 * @param period
	 */
	public static void schedule(TimerTask task, Date startTime, long period) {
		if (task == null) {
			_logger.log(Level.SEVERE, "scheduleTask: task == null");
			return;
		}

		if (startTime == null) {
			_logger.log(Level.SEVERE, "scheduleTask: startTime == null");
			return;
		}

		if (period == 0L) {
			_logger.log(Level.SEVERE, "scheduleTask: period == 0L");
		}

		taskTimer.schedule(task, startTime, period);
	}

	public static void schedule(TimerTask task, long delay, long period) {
		if (task == null) {
			_logger.log(Level.SEVERE, "scheduleTask: task == null");
			return;
		}

		if (period == 0L) {
			_logger.log(Level.SEVERE, "scheduleTask: period == 0L");
		}

		taskTimer.schedule(task, delay, period);
	}

	public static void scheduleTaskOne(TimerTask task, Date startTime) {
		if (task == null) {
			_logger.log(Level.SEVERE, "addTimerTask: task == null");
			return;
		}

		if (startTime == null) {
			_logger.log(Level.SEVERE, "addTimerTask: startTime == null");
			return;
		}

		taskTimer.schedule(task, startTime);
	}

	public static void scheduleTaskOne(TimerTask task, long delay) {
		if (task == null) {
			_logger.log(Level.SEVERE, "addTimerTask: task == null");
			return;
		}

		taskTimer.schedule(task, delay);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Calendar cl = Calendar.getInstance();
		// cl.add(Calendar.HOUR_OF_DAY, 1);
		// cl.set(Calendar.MINUTE, 0);
		// cl.set(Calendar.SECOND, 0);
		//
		// System.err.println(cl.get(Calendar.HOUR_OF_DAY)+","+cl.get(Calendar.MINUTE)+","+cl.get(Calendar.SECOND));
	}

}
