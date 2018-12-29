package com.example.demo.dto;

import com.example.demo.DemoApplication;

public class MessageDTO {
    public Integer id = Integer.valueOf(-1);
    public String message = "NONE";
    public String modifiers = "";

    public MessageDTO() {
        id = DemoApplication.counter.incrementAndGet();
    }

    public MessageDTO(String message, String modifiers) {
        id = DemoApplication.counter.incrementAndGet();
        this.message = message;
        this.modifiers = modifiers;
    }

    private MessageDTO newCopy() {
        MessageDTO newMessageDTO = new MessageDTO();
        newMessageDTO.id = this.id;
        newMessageDTO.message = this.message;
        newMessageDTO.modifiers = this.modifiers;
        return newMessageDTO;
    }

    public MessageDTO transform(String bop, String newMessage, String transformedBy, String instanceIndex) {
        MessageDTO newMessageDTO = newCopy();
        newMessageDTO.message = bop + ":" + newMessage;
        newMessageDTO.modifiers += " ==> " + transformedBy + ":i" + instanceIndex + ":" + bop;
        return newMessageDTO;
    }

    @Override
    public String toString() {
        return String.format("MessageDTO[%8d MSG:'%s' modifiers:'%s']", id, message, modifiers);
    }
}
