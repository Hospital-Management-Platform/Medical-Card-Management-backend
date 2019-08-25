package com.itwine.mcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



	@Entity
	@Table(name = "attribute")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	public class Attribute  implements Serializable {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		@Column(name = "Attribute_id")
		private long attributeId;

		@Column(name = "Attribute_Name")
		private String attributeName ;
		
		@Column(name = "Attribute_Code")
		private String attributeCode;
		
		@Column(name = "Attribute_Busns_Catg_Code")
		private String businessCatCode;
		
		@Column(name = "Attribute_businessCatName")
		private String businessCatName;

		public String getBusinessCatName() {
			return businessCatName;
		}

		public void setBusinessCatName(String businessCatName) {
			this.businessCatName = businessCatName;
		}

		public long getAttributeId() {
			return attributeId;
		}

		public void setAttributeId(long attributeId) {
			this.attributeId = attributeId;
		}

		public String getAttributeName() {
			return attributeName;
		}

		public void setAttributeName(String attributeName) {
			this.attributeName = attributeName;
		}

		public String getAttributeCode() {
			return attributeCode;
		}

		public void setAttributeCode(String attributeCode) {
			this.attributeCode = attributeCode;
		}

		public String getBusinessCatCode() {
			return businessCatCode;
		}

		public void setBusinessCatCode(String businessCatCode) {
			this.businessCatCode = businessCatCode;
		}
		
	 
}
