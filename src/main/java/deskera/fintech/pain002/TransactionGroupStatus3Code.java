//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.06.13 at 04:28:38 PM CST 
//


package deskera.fintech.pain002;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionGroupStatus3Code.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionGroupStatus3Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACTC"/&gt;
 *     &lt;enumeration value="RCVD"/&gt;
 *     &lt;enumeration value="PART"/&gt;
 *     &lt;enumeration value="RJCT"/&gt;
 *     &lt;enumeration value="PDNG"/&gt;
 *     &lt;enumeration value="ACCP"/&gt;
 *     &lt;enumeration value="ACSP"/&gt;
 *     &lt;enumeration value="ACSC"/&gt;
 *     &lt;enumeration value="ACWC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransactionGroupStatus3Code")
@XmlEnum
public enum TransactionGroupStatus3Code {

    ACTC,
    RCVD,
    PART,
    RJCT,
    PDNG,
    ACCP,
    ACSP,
    ACSC,
    ACWC;

    public String value() {
        return name();
    }

    public static TransactionGroupStatus3Code fromValue(String v) {
        return valueOf(v);
    }

}
