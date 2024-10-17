package com.juggle.im.messages;

public abstract class BaseMessage {
    public abstract String getType();
    @Override
    public abstract String toString();
}
