package com.ing.blockchain.zk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CommitmentWrapper implements Serializable {

    @JsonProperty("commitment")
    private Commitment commitment;

    public CommitmentWrapper() {
    }

    public CommitmentWrapper(Commitment commitment) {
        this.commitment = commitment;
    }

    public Commitment getCommitment() {
        return commitment;
    }

    public void setCommitment(Commitment commitment) {
        this.commitment = commitment;
    }

    @Override
    public String toString() {
        return "CommitmentWrapper{" +
                "commitment=" + commitment +
                '}';
    }
}
