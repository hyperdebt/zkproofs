package com.ing.blockchain.zk;

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

    public static void verify(String[] proof){
        BoudotRangeProof BRP = null;
        Commitment c = null;
        try {
            BRP = (BoudotRangeProof) fromString(proof[0]);
            c = (Commitment) fromString(proof[1]);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        ClosedRange range = ClosedRange.of(proof[2], proof[3]);
        RangeProof.validateRangeProof(BRP, c, range);
        System.out.println("Proof has succeeded");
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
