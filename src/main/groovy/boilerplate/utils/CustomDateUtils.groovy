
package boilerplate.utils

import grails.compiler.GrailsCompileStatic

import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@GrailsCompileStatic
class CustomDateUtils {

    private static final String DDMMAAAA_FORMAT = "dd/MM/yyyy"
    private static final String ISO_INSTANT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"

    public static String toString(Date fromDate) {
        LocalDate localDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        String formatedDate = localDate.format(DateTimeFormatter.ofPattern(CustomDateUtils.DDMMAAAA_FORMAT))
        return formatedDate
    }

    public static Date toDate(Object fromDate) {
        if (fromDate instanceof Date) return fromDate
        return CustomDateUtils.toDate(fromDate, CustomDateUtils.DDMMAAAA_FORMAT)
    }

    public static Date toDate(Object fromDate, String pattern) {
        LocalDate localDate = LocalDate.parse(fromDate.toString(), DateTimeFormatter.ofPattern(pattern))
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
}