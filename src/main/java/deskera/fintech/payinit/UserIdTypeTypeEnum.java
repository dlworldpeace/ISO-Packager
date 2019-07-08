//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.06.13 at 04:37:49 PM CST 
//


package deskera.fintech.payinit;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserIdTypeTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserIdTypeTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SAFEWORD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UserIdTypeTypeEnum", namespace = "http://com.citi.citiconnect/services/types/oauthtoken/v1")
@XmlEnum
public enum UserIdTypeTypeEnum {


    /**
     * Indicates that userId value is a SafeWord Id (CSA_XXXX).
     *                     
     * 
     */
    SAFEWORD;

    public String value() {
        return name();
    }

    public static UserIdTypeTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
