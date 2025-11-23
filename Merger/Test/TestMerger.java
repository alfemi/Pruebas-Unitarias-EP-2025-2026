import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

import java.util.logging.Logger;

public interface TestMerger {
    static final Logger logger = Logger.getLogger(TestMerger.class.getName());

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        logger.info(() -> String.format(
                "About to execute [%s]",
                testInfo.getDisplayName()
        ));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        logger.info(() -> String.format(
                "Finished executing [%s]",
                testInfo.getDisplayName()
        ));
    }
}