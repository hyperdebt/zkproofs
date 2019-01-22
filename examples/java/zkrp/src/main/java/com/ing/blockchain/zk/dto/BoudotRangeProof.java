/*
 * Copyright 2017 ING Bank N.V.
 * This file is part of the go-ethereum library.
 *
 * The go-ethereum library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The go-ethereum library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the go-ethereum library. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ing.blockchain.zk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigInteger;

public class BoudotRangeProof implements Serializable {

    @JsonProperty("sqrProofLeft")
    private SquareProof sqrProofLeft;
    @JsonProperty("sqrProofRight")
    private SquareProof sqrProofRight;
    @JsonProperty("cftProofLeft")
    private CFTProof cftProofLeft;
    @JsonProperty("cftProofRight")
    private CFTProof cftProofRight;
    @JsonProperty("cleftSquare")
    private BigInteger cLeftSquare;
    @JsonProperty("crightSquare")
    private BigInteger cRightSquare;

    public BoudotRangeProof() {
    }

    public BoudotRangeProof(BigInteger cLeftSquare, BigInteger cRightSquare, SquareProof sqrProofLeft,
                            SquareProof sqrProofRight, CFTProof cftProofLeft, CFTProof cftProofRight) {
        this.cLeftSquare = cLeftSquare;
        this.cRightSquare = cRightSquare;
        this.sqrProofLeft = sqrProofLeft;
        this.sqrProofRight = sqrProofRight;
        this.cftProofLeft = cftProofLeft;
        this.cftProofRight = cftProofRight;
    }

    public SquareProof getSqrProofLeft() {
        return sqrProofLeft;
    }

    public SquareProof getSqrProofRight() {
        return sqrProofRight;
    }

    public CFTProof getCftProofLeft() {
        return cftProofLeft;
    }

    public CFTProof getCftProofRight() {
        return cftProofRight;
    }

    public BigInteger getCLeftSquare() {
        return cLeftSquare;
    }

    public BigInteger getCRightSquare() {
        return cRightSquare;
    }
}
