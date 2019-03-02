package rc.service.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class YearPlanConsumer {

    private static Logger log = LoggerFactory.getLogger(YearPlanConsumer.class);

    @JmsListener(destination = "yearplan-topic")
    public void consume(String message) {

        log.info("received:" + message );
    }

}

