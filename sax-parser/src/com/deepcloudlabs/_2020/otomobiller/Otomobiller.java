//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.14 at 10:15:20 AM EET 
//


package com.deepcloudlabs._2020.otomobiller;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="otomobil" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="uzunluk" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="genislik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="yŁkseklik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="agirlik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="bagaj_hacmi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="motor_hacmi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="silindir_adedi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="beygir_gucu" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="yuz_km_sn" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="dingil_mesafesi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                   &lt;element name="yakit_tuketimi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
 *                 &lt;/all>
 *                 &lt;attribute name="marka" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="model" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "otomobil"
})
@XmlRootElement(name = "otomobiller")
public class Otomobiller {

    @XmlElement(required = true)
    protected List<Otomobiller.Otomobil> otomobil;

    /**
     * Gets the value of the otomobil property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otomobil property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtomobil().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Otomobiller.Otomobil }
     * 
     * 
     */
    public List<Otomobiller.Otomobil> getOtomobil() {
        if (otomobil == null) {
            otomobil = new ArrayList<Otomobiller.Otomobil>();
        }
        return this.otomobil;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="uzunluk" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="genislik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="yŁkseklik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="agirlik" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="bagaj_hacmi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="motor_hacmi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="silindir_adedi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="beygir_gucu" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="yuz_km_sn" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="dingil_mesafesi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *         &lt;element name="yakit_tuketimi" type="{http://www.deepcloudlabs.com/2020/otomobiller}olcuTipi"/>
     *       &lt;/all>
     *       &lt;attribute name="marka" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="model" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Otomobil {

        @XmlElement(required = true)
        protected OlcuTipi uzunluk;
        @XmlElement(required = true)
        protected OlcuTipi genislik;
        @XmlElement(required = true)
        protected OlcuTipi yŁkseklik;
        @XmlElement(required = true)
        protected OlcuTipi agirlik;
        @XmlElement(name = "bagaj_hacmi", required = true)
        protected OlcuTipi bagajHacmi;
        @XmlElement(name = "motor_hacmi", required = true)
        protected OlcuTipi motorHacmi;
        @XmlElement(name = "silindir_adedi", required = true)
        protected OlcuTipi silindirAdedi;
        @XmlElement(name = "beygir_gucu", required = true)
        protected OlcuTipi beygirGucu;
        @XmlElement(name = "yuz_km_sn", required = true)
        protected OlcuTipi yuzKmSn;
        @XmlElement(name = "dingil_mesafesi", required = true)
        protected OlcuTipi dingilMesafesi;
        @XmlElement(name = "yakit_tuketimi", required = true)
        protected OlcuTipi yakitTuketimi;
        @XmlAttribute(name = "marka", required = true)
        protected String marka;
        @XmlAttribute(name = "model", required = true)
        protected String model;

        /**
         * Gets the value of the uzunluk property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getUzunluk() {
            return uzunluk;
        }

        /**
         * Sets the value of the uzunluk property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setUzunluk(OlcuTipi value) {
            this.uzunluk = value;
        }

        /**
         * Gets the value of the genislik property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getGenislik() {
            return genislik;
        }

        /**
         * Sets the value of the genislik property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setGenislik(OlcuTipi value) {
            this.genislik = value;
        }

        /**
         * Gets the value of the yŁkseklik property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getYŁkseklik() {
            return yŁkseklik;
        }

        /**
         * Sets the value of the yŁkseklik property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setYŁkseklik(OlcuTipi value) {
            this.yŁkseklik = value;
        }

        /**
         * Gets the value of the agirlik property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getAgirlik() {
            return agirlik;
        }

        /**
         * Sets the value of the agirlik property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setAgirlik(OlcuTipi value) {
            this.agirlik = value;
        }

        /**
         * Gets the value of the bagajHacmi property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getBagajHacmi() {
            return bagajHacmi;
        }

        /**
         * Sets the value of the bagajHacmi property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setBagajHacmi(OlcuTipi value) {
            this.bagajHacmi = value;
        }

        /**
         * Gets the value of the motorHacmi property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getMotorHacmi() {
            return motorHacmi;
        }

        /**
         * Sets the value of the motorHacmi property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setMotorHacmi(OlcuTipi value) {
            this.motorHacmi = value;
        }

        /**
         * Gets the value of the silindirAdedi property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getSilindirAdedi() {
            return silindirAdedi;
        }

        /**
         * Sets the value of the silindirAdedi property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setSilindirAdedi(OlcuTipi value) {
            this.silindirAdedi = value;
        }

        /**
         * Gets the value of the beygirGucu property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getBeygirGucu() {
            return beygirGucu;
        }

        /**
         * Sets the value of the beygirGucu property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setBeygirGucu(OlcuTipi value) {
            this.beygirGucu = value;
        }

        /**
         * Gets the value of the yuzKmSn property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getYuzKmSn() {
            return yuzKmSn;
        }

        /**
         * Sets the value of the yuzKmSn property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setYuzKmSn(OlcuTipi value) {
            this.yuzKmSn = value;
        }

        /**
         * Gets the value of the dingilMesafesi property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getDingilMesafesi() {
            return dingilMesafesi;
        }

        /**
         * Sets the value of the dingilMesafesi property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setDingilMesafesi(OlcuTipi value) {
            this.dingilMesafesi = value;
        }

        /**
         * Gets the value of the yakitTuketimi property.
         * 
         * @return
         *     possible object is
         *     {@link OlcuTipi }
         *     
         */
        public OlcuTipi getYakitTuketimi() {
            return yakitTuketimi;
        }

        /**
         * Sets the value of the yakitTuketimi property.
         * 
         * @param value
         *     allowed object is
         *     {@link OlcuTipi }
         *     
         */
        public void setYakitTuketimi(OlcuTipi value) {
            this.yakitTuketimi = value;
        }

        /**
         * Gets the value of the marka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMarka() {
            return marka;
        }

        /**
         * Sets the value of the marka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMarka(String value) {
            this.marka = value;
        }

        /**
         * Gets the value of the model property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModel() {
            return model;
        }

        /**
         * Sets the value of the model property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModel(String value) {
            this.model = value;
        }

    }

}
