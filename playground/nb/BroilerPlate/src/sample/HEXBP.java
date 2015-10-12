/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import com.atlp.zip.ZipString;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author rgsaavedra
 */
public class HEXBP {
    
    public static void main(String[] a){
        String input = "{\n" +
"    \"glossary\": {\n" +
"        \"title\": \"example glossary\",\n" +
"		\"GlossDiv\": {\n" +
"            \"title\": \"S\",\n" +
"			\"GlossList\": {\n" +
"                \"GlossEntry\": {\n" +
"                    \"ID\": \"SGML\",\n" +
"					\"SortAs\": \"SGML\",\n" +
"					\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
"					\"Acronym\": \"SGML\",\n" +
"					\"Abbrev\": \"ISO 8879:1986\",\n" +
"					\"GlossDef\": {\n" +
"                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
"						\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
"                    },\n" +
"					\"GlossSee\": \"markup\"\n" +
"                }\n" +
"            }\n" +
"        }\n" +
"    }\n" +
"}";
//        
//        String input ="Hello World ";
        
        System.out.println("Length:"+input.length());
        System.out.println("bLength:"+input.getBytes().length);
        ZipString zInput = new ZipString();
        zInput.setString(true, input);
        byte[] compressedBytes = zInput.getCompressedByteArray();
        System.out.println("compressed Length:"+compressedBytes.length);
        
//        String hexInput = Hex.encodeHexString(input.getBytes());
//        System.out.println("HEX2:"+hexInput);
//        System.out.println("HEX2 Lenght:"+hexInput.length());
        
        String hexInput = Hex.encodeHexString(compressedBytes);
        System.out.println("HEX:"+hexInput);
        System.out.println("HEX Lenght:"+hexInput.length());
        try {
            ZipString decodeOuput = new ZipString();
            decodeOuput.setCompressedByteArray(Hex.decodeHex(hexInput.toCharArray()));
            System.out.println("DecodedHex:"+decodeOuput.toString());
            System.out.println("isEqual:"+input.equalsIgnoreCase(decodeOuput.toString()));
        } catch (DecoderException ex) {
            Logger.getLogger(HEXBP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        ZipString test = new ZipString();
//        test.setString(true, "7801f348cdc9c95708cf2fca490100180b041d");
//        System.out.println("Lenght3:"+"7801f348cdc9c95708cf2fca490100180b041d".length());
//        System.out.println("Lenght3:"+test.getCompressedByteArray().length);
    }
    
}
