package com.c.w.thirteen;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiveService {

    @Input("myInput")
    SubscribableChannel myInput();

}
