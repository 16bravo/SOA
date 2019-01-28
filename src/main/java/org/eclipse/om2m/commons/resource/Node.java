/*******************************************************************************
 * Copyright (c) 2013-2016 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.15 at 03:56:27 PM CEST 
//

package org.eclipse.om2m.commons.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.om2m.commons.constants.ShortName;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResource">
 *       &lt;sequence>
 *         &lt;element name="nodeID" type="{http://www.onem2m.org/xml/protocols}nodeID"/>
 *         &lt;element name="hostedCSELink" type="{http://www.onem2m.org/xml/protocols}ID" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="childResource" type="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded"/>
 *           &lt;choice maxOccurs="unbounded">
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}memory"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}battery"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}areaNwkInfo"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}areaNwkDeviceInfo"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}firmware"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}software"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}deviceInfo"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}deviceCapability"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}reboot"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}eventLog"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}cmdhPolicy"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}activeCmdhPolicy"/>
 *             &lt;element ref="{http://www.onem2m.org/xml/protocols}subscription"/>
 *           &lt;/choice>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = ShortName.NODE)
public class Node extends AnnounceableResource {

	@XmlElement(required = true, name = ShortName.NODE_ID)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String nodeID;
	@XmlElement(name = ShortName.HOSTED_CSE_LINK)
	protected String hostedCSELink;
	@XmlElement(name = ShortName.CHILD_RESOURCE)
	protected List<ChildResourceRef> childResource;
	@XmlElements({
			@XmlElement(name = ShortName.MEMORY, namespace = "http://www.onem2m.org/xml/protocols", type = Memory.class),
			@XmlElement(name = ShortName.BATTERY, namespace = "http://www.onem2m.org/xml/protocols", type = Battery.class),
			@XmlElement(name = ShortName.ANI, namespace = "http://www.onem2m.org/xml/protocols", type = AreaNwkInfo.class),
			@XmlElement(name = ShortName.ANDI, namespace = "http://www.onem2m.org/xml/protocols", type = AreaNwkDeviceInfo.class),
			@XmlElement(name = ShortName.FIRMWARE, namespace = "http://www.onem2m.org/xml/protocols", type = Firmware.class),
			@XmlElement(name = ShortName.SOFTWARE, namespace = "http://www.onem2m.org/xml/protocols", type = Software.class),
			@XmlElement(name = ShortName.DEVICE_INFO, namespace = "http://www.onem2m.org/xml/protocols", type = DeviceInfo.class),
			@XmlElement(name = ShortName.DEVICE_CAPABILITY, namespace = "http://www.onem2m.org/xml/protocols", type = DeviceCapability.class),
			@XmlElement(name = ShortName.REBOOT, namespace = "http://www.onem2m.org/xml/protocols", type = Reboot.class),
			@XmlElement(name = ShortName.EVENT_LOG, namespace = "http://www.onem2m.org/xml/protocols", type = EventLog.class),
			@XmlElement(name = ShortName.CMDH_POLICY, namespace = "http://www.onem2m.org/xml/protocols", type = CmdhPolicy.class),
			@XmlElement(name = ShortName.ACTIVE_CMDH_POLICY, namespace = "http://www.onem2m.org/xml/protocols", type = ActiveCmdhPolicy.class),
			@XmlElement(name = ShortName.SUB, namespace = "http://www.onem2m.org/xml/protocols", type = Subscription.class) })
	protected List<RegularResource> memoryOrBatteryOrAreaNwkInfo;

	/**
	 * Gets the value of the nodeID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNodeID() {
		return nodeID;
	}

	/**
	 * Sets the value of the nodeID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNodeID(String value) {
		this.nodeID = value;
	}

	/**
	 * Gets the value of the hostedCSELink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHostedCSELink() {
		return hostedCSELink;
	}

	/**
	 * Sets the value of the hostedCSELink property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHostedCSELink(String value) {
		this.hostedCSELink = value;
	}

	/**
	 * Gets the value of the childResource property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the childResource property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChildResource().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ChildResourceRef }
	 * 
	 * 
	 */
	public List<ChildResourceRef> getChildResource() {
		if (childResource == null) {
			childResource = new ArrayList<ChildResourceRef>();
		}
		return this.childResource;
	}

	/**
	 * Gets the value of the memoryOrBatteryOrAreaNwkInfo property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the memoryOrBatteryOrAreaNwkInfo property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMemoryOrBatteryOrAreaNwkInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Memory }
	 * {@link Battery } {@link AreaNwkInfo } {@link AreaNwkDeviceInfo }
	 * {@link Firmware } {@link Software } {@link DeviceInfo }
	 * {@link DeviceCapability } {@link Reboot } {@link EventLog }
	 * {@link CmdhPolicy } {@link ActiveCmdhPolicy } {@link Subscription }
	 * 
	 * 
	 */
	public List<RegularResource> getMemoryOrBatteryOrAreaNwkInfo() {
		if (memoryOrBatteryOrAreaNwkInfo == null) {
			memoryOrBatteryOrAreaNwkInfo = new ArrayList<RegularResource>();
		}
		return this.memoryOrBatteryOrAreaNwkInfo;
	}

}
