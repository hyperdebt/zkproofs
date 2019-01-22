package com.ing.blockchain.zk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.blockchain.zk.dto.*;

import java.io.*;
import java.math.BigInteger;
import java.util.Base64;

public class JavaScriptRangeProof {

    public static String[] generate(String secretValue, String a, String b) {
        BigInteger i = new BigInteger(secretValue);
        ClosedRange range = ClosedRange.of(a, b);
        TTPMessage message = TTPGenerator.generateTTPMessage(i);
        BoudotRangeProof BRP = RangeProof.calculateRangeProof(message,range);
        Commitment c = message.getCommitment();

        String BRP_string = null;
        String c_string = null;
        try {
            BRP_string =  toString(BRP);
            c_string = toString(c);
        }catch(IOException e){
            e.printStackTrace();
        }

        return new String[]{BRP_string, c_string, a, b};
    }

    public static Boolean verify(String BRP_string, String c_string, String range_string){
        ObjectMapper objectMapper = new ObjectMapper();
        BoudotRangeProof BRP;
        Commitment c;
        ClosedRange range;
        ProofWrapper proofWrapper;
        CommitmentWrapper commitmentWrapper;
        RangeWrapper rangeWrapper;

        try {
            proofWrapper = objectMapper.readValue(BRP_string, ProofWrapper.class);
            BRP = proofWrapper.getProof();
            commitmentWrapper = objectMapper.readValue(c_string, CommitmentWrapper.class);
            c = commitmentWrapper.getCommitment();
            rangeWrapper = objectMapper.readValue(range_string, RangeWrapper.class);
            range = rangeWrapper.getClosedRange();
            RangeProof.validateRangeProof(BRP, c, range);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Proof failed");
            return false;
        }
        System.out.println("Proof has succeeded");
        return true;
    }

    /**
     * Write the object to a Base64 string.
     */
    static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    /**
     * Read the object from Base64 string.
     */
    static Object fromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

}
