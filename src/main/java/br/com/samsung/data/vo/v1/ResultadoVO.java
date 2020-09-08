package br.com.samsung.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

public class ResultadoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String documentNumber;
	private Date documentDate;
	private String currencyCode;
	private String currencyDesc;
	private Double documentValue;
	private Double cotacaoToCurrencyCodeUSD;
	private Double cotacaoToCurrencyCodePEN;
	private Double cotacaoToCurrencyCodeBRL;

	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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

	/**
	 * @return the currencyDesc
	 */
	public String getCurrencyDesc() {
		return currencyDesc;
	}

	/**
	 * @param currencyDesc the currencyDesc to set
	 */
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
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
	 * @return the cotacaoToCurrencyCodeUSD
	 */
	public Double getCotacaoToCurrencyCodeUSD() {
		return cotacaoToCurrencyCodeUSD;
	}

	/**
	 * @param cotacaoToCurrencyCodeUSD the cotacaoToCurrencyCodeUSD to set
	 */
	public void setCotacaoToCurrencyCodeUSD(Double cotacaoToCurrencyCodeUSD) {
		this.cotacaoToCurrencyCodeUSD = cotacaoToCurrencyCodeUSD;
	}

	/**
	 * @return the cotacaoToCurrencyCodePEN
	 */
	public Double getCotacaoToCurrencyCodePEN() {
		return cotacaoToCurrencyCodePEN;
	}

	/**
	 * @param cotacaoToCurrencyCodePEN the cotacaoToCurrencyCodePEN to set
	 */
	public void setCotacaoToCurrencyCodePEN(Double cotacaoToCurrencyCodePEN) {
		this.cotacaoToCurrencyCodePEN = cotacaoToCurrencyCodePEN;
	}

	/**
	 * @return the cotacaoToCurrencyCodeBRL
	 */
	public Double getCotacaoToCurrencyCodeBRL() {
		return cotacaoToCurrencyCodeBRL;
	}

	/**
	 * @param cotacaoToCurrencyCodeBRL the cotacaoToCurrencyCodeBRL to set
	 */
	public void setCotacaoToCurrencyCodeBRL(Double cotacaoToCurrencyCodeBRL) {
		this.cotacaoToCurrencyCodeBRL = cotacaoToCurrencyCodeBRL;
	}
}
