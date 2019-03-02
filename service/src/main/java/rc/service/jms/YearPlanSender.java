package rc.service.jms;

import javax.jms.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class YearPlanSender {

    private static Logger log = LoggerFactory.getLogger(YearPlanSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    Queue queue;

    public void sendTopic(String message) {
        log.info("sending a message by convertAndSend() to topic:" + message );
        jmsTemplate.convertAndSend(queue, message);
    }
}
