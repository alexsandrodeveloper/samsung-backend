package br.com.samsung.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

public class DocumentCurrencyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long documentId;
	private Long documentNumber;
	private Long notaFiscal;
	private Date documentDate;
	private Double documentValue;
	private String currencyCode;

	/**
	 * @return the documentId
	 */
	public Long getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the documentNumber
	 */
	public Long getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the notaFiscal
	 */
	public Long getNotaFiscal() {
		return notaFiscal;
	}

	/**
	 * @param notaFiscal the notaFiscal to set
	 */
	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	/**
	 * @return the documentDate
	 */
	public Date getDocumentDate() {
		return documentDate;
	}

	/**
	 * @param documentDate the documentDate to set
	 */
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	/**
	 * @return the documentValue
	 */
	public Double getDocumentValue() {
		return documentValue;
	}

	/**
	 * @param documentValue the documentValue to set
	 */
	public void setDocumentValue(Double documentValue) {
		this.documentValue = documentValue;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((documentDate == null) ? 0 : documentDate.hashCode());
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((documentNumber == null) ? 0 : documentNumber.hashCode());
		result = prime * result + ((documentValue == null) ? 0 : documentValue.hashCode());
		result = prime * result + ((notaFiscal == null) ? 0 : notaFiscal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentCurrencyVO other = (DocumentCurrencyVO) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (documentDate == null) {
			if (other.documentDate != null)
				return false;
		} else if (!documentDate.equals(other.documentDate))
			return false;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (documentNumber == null) {
			if (other.documentNumber != null)
				return false;
		} else if (!documentNumber.equals(other.documentNumber))
			return false;
		if (documentValue == null) {
			if (other.documentValue != null)
				return false;
		} else if (!documentValue.equals(other.documentValue))
			return false;
		if (notaFiscal == null) {
			if (other.notaFiscal != null)
				return false;
		} else if (!notaFiscal.equals(other.notaFiscal))
			return false;
		return true;
	}
}
