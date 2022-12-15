package com.example.demo.exception;

public class ResourceNotFoundException  extends RuntimeException{
	private String resourceName;
	private String FieldName;
	private String FieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super();
		this.resourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getFieldValue() {
		return FieldValue;
	}
	public void setFieldValue(String fieldValue) {
		FieldValue = fieldValue;
	}
	

}
