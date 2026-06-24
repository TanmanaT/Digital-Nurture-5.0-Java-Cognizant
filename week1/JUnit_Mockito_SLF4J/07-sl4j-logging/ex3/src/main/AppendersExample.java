import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendersExample {
    private static final Logger logger = LoggerFactory.getLogger(AppendersExample.class);

    public static void main(String[] args) {
        logger.info("Initializing application setup...");
        logger.debug("Debugging appender configuration parameters");
        logger.warn("This is a mock warning logged to console and file");
        logger.error("This is a mock error logged to console and file");
        logger.info("Application execution finished successfully.");
    }
}
