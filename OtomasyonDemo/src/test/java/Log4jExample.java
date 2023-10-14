import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    // Logger oluştur
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        // Farklı log düzeylerinde mesajlar
        logger.trace("Bu bir trace mesajıdır.");
        logger.debug("Bu bir debug mesajıdır.");;
        logger.error("Bu bir hata mesajıdır.");
        logger.fatal("Bu bir kritik hata mesajıdır.");
    }
}