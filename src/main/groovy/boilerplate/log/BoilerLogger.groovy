package boilerplate.log

import grails.compiler.GrailsCompileStatic

import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

import static grails.async.Promises.task

@GrailsCompileStatic
class BoilerLogger {

    private static final String LOGGER_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS"

    public static void info(String message) {
        BoilerLogger.logAsync("INFO", message, null)
    }

    public static void warn(String message) {
        BoilerLogger.logAsync("WARN", message, null)
    }

    public static void error(String message) {
        BoilerLogger.logAsync("ERROR", message)
    }

    public static void error(String message, Exception e) {
        BoilerLogger.logAsync("ERROR", message, e)
    }

    private static void logAsync(String type, String message) {
        BoilerLogger.logAsync(type, message, null)
    }

    private static void logAsync(String type, String message, Exception e) {
        Long currentThreadId = Thread.currentThread().getId()

        task {
            if (e) {
                message = message ? "${message}. " : ""
                message = "${message} Stacktrace follows:\n${BoilerLogger.buildExceptionStackTrace(e)}"
            }

            LocalDateTime localDate = LocalDateTime.now()
            String formatedDate = localDate.format(DateTimeFormatter.ofPattern(BoilerLogger.LOGGER_DATE_PATTERN))

            println "${formatedDate} [Thread-${currentThreadId}] ${type} ${message}"
        }
    }

    private static String buildExceptionStackTrace(Exception e) {
        StringWriter stringWriter = new StringWriter()
        e.printStackTrace(new PrintWriter(stringWriter))
        return stringWriter.toString()
    }
}
