package com.ing.blockchain.zk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RangeWrapper {

    @JsonProperty("range")
    private ClosedRange closedRange;

    public RangeWrapper() {
    }

    public RangeWrapper(ClosedRange closedRange) {
        this.closedRange = closedRange;
    }

    public ClosedRange getClosedRange() {
        return closedRange;
    }

    public void setClosedRange(ClosedRange closedRange) {
        this.closedRange = closedRange;
    }

    @Override
    public String toString() {
        return "RangeWrapper{" +
                "closedRange=" + closedRange +
                '}';
    }
}
