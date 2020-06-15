package com.c.w.fourteen;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SendService {

    @Output("myInput")
    SubscribableChannel sendOrder();

}
