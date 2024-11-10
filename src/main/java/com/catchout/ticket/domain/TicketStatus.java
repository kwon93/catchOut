package com.catchout.ticket.domain;

public enum TicketStatus {
    VALID("사용 유효 티켓"),
    USED("사용 완료된 티켓"),
    EXPIRED("만료된 티켓");

    private final String description;

    TicketStatus(String description) {
        this.description = description;
    }
}
