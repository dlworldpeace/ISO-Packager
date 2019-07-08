//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.06.13 at 04:40:43 PM CST 
//


package deskera.fintech.statret;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayloadTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PayloadTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="urn:iso:std:iso:20022:tech:xsd:pain.001.001.02"/&gt;
 *     &lt;enumeration value="urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"/&gt;
 *     &lt;enumeration value="urn:iso:std:iso:20022:tech:xsd:pain.008.001.02"/&gt;
 *     &lt;enumeration value="MT101"/&gt;
 *     &lt;enumeration value="tech:xsd:custom.virtual.wallet"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PayloadTypeEnum")
@XmlEnum
public enum PayloadTypeEnum {


    /**
     * Indicates PAIN 001 version 2 messages.
     *                         Actual URN is used to avoid ambiguity here on type.
     *                     
     * 
     */
    @XmlEnumValue("urn:iso:std:iso:20022:tech:xsd:pain.001.001.02")
    URN_ISO_STD_ISO_20022_TECH_XSD_PAIN_001_001_02("urn:iso:std:iso:20022:tech:xsd:pain.001.001.02"),

    /**
     * Indicates PAIN 001 version 3 messages.
     *                         Actual URN is used to avoid ambiguity here on type.
     *                     
     * 
     */
    @XmlEnumValue("urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
    URN_ISO_STD_ISO_20022_TECH_XSD_PAIN_001_001_03("urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"),

    /**
     * Indicates PAIN 008 version 2 messages.
     *                         Actual URN is used to avoid ambiguity here on type.
     *                     
     * 
     */
    @XmlEnumValue("urn:iso:std:iso:20022:tech:xsd:pain.008.001.02")
    URN_ISO_STD_ISO_20022_TECH_XSD_PAIN_008_001_02("urn:iso:std:iso:20022:tech:xsd:pain.008.001.02"),

    /**
     * Indicates MT101 messages.
     * 
     */
    @XmlEnumValue("MT101")
    MT_101("MT101"),

    /**
     * Indicates VirtualWallet Beneficiary Details.
     * 
     */
    @XmlEnumValue("tech:xsd:custom.virtual.wallet")
    TECH_XSD_CUSTOM_VIRTUAL_WALLET("tech:xsd:custom.virtual.wallet");
    private final String value;

    PayloadTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PayloadTypeEnum fromValue(String v) {
        for (PayloadTypeEnum c: PayloadTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
