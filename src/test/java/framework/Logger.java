package framework;

import framework.functions.DateTimeFunctions;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import java.io.File;
import java.nio.file.Paths;

/**
 * This class is using for a creating extended log
 */
public final class Logger {
	private static final ThreadLocal<org.apache.log4j.Logger> LOG4J = ThreadLocal.withInitial(() ->
			org.apache.log4j.Logger.getLogger(String.valueOf(Thread.currentThread().getId())));
	private static Logger instance;

    private Logger() {
    }

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public synchronized void setUpLogFile(String testName) {
		String fileLogPath = Paths.get("target", "fileLogs").toString();
	    File logFile = new File(String.format(Paths.get(fileLogPath, testName.concat("_logfile_%s.txt")).toString(), DateTimeFunctions.getTimestamp()));
        FileAppender fa = new FileAppender();
        fa.setFile(logFile.getAbsolutePath());
        fa.setLayout(new PatternLayout("%d %-5p - %m%n"));
        fa.setThreshold(Level.INFO);
        fa.activateOptions();
        LOG4J.get().removeAllAppenders();
        LOG4J.get().addAppender(fa);
    }

	public void step(int step, String message) {
		Logger.getInstance().info(String.format("----==[ Step %1$s: %2$s ]==----", step, message));
	}

	public void info(String message) {
		LOG4J.get().info(message);
	}

	public void warn(final String message) {
		LOG4J.get().warn(message);
	}

	public void error(final String message) {
		LOG4J.get().error(message);
	}

	public void fatal(final String message) {
		LOG4J.get().fatal(message);
	}
}