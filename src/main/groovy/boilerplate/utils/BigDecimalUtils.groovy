package boilerplate.utils

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class BigDecimalUtils {

    public static BigDecimal toBigDecimal(value) {
        try {
            if (value instanceof BigDecimal) return value
            if (value instanceof Double) return BigDecimal.valueOf(value)
            if (value instanceof String) return BigDecimal.valueOf(value.toDouble())
            return null
        } catch (Exception e) {
            return null
        }
    }
}