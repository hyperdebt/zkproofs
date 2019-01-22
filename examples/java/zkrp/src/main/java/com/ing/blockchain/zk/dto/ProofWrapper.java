package com.ing.blockchain.zk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ing.blockchain.zk.dto.BoudotRangeProof;

import java.io.Serializable;

public class ProofWrapper implements Serializable {

    @JsonProperty("proof")
    private BoudotRangeProof proof;

    public ProofWrapper() {
    }

    public ProofWrapper(BoudotRangeProof proof) {
        this.proof = proof;
    }

    public BoudotRangeProof getProof() {
        return proof;
    }

    public void setProof(BoudotRangeProof proof) {
        this.proof = proof;
    }

    @Override
    public String toString() {
        return "ProofWrapper{" +
                "proof=" + proof +
                '}';
    }
}
