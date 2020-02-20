package boilerplate.utils

import boilerplate.log.BoilerLogger
import grails.util.Holders

class MessageUtils {

    public static String getMessage(String messageCode){
        return getMessage(messageCode, null)
    }

    public static String getMessage(String messageCode, List arguments) {
        try {
            return Holders.applicationContext.getBean("messageSource").getMessage(messageCode, arguments as Object[], new Locale("pt","BR"))
        } catch(Exception e) {
            BoilerLogger.error("MessageUtils -> A mensagem [${messageCode}] não foi encontrada.")
            return ""
        }
    }
}