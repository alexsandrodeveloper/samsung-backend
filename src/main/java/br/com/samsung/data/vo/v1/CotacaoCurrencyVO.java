package br.com.samsung.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

public class CotacaoCurrencyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fromCurrencyCode;
	private String toCurrencyCode;
	private Double cotacao;
	private Date dataHoraCotacao;

	/**
	 * @return the fromCurrencyCode
	 */
	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	/**
	 * @param fromCurrencyCode the fromCurrencyCode to set
	 */
	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	/**
	 * @return the toCurrencyCode
	 */
	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	/**
	 * @param toCurrencyCode the toCurrencyCode to set
	 */
	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	/**
	 * @return the cotacao
	 */
	public Double getCotacao() {
		return cotacao;
	}

	/**
	 * @param cotacao the cotacao to set
	 */
	public void setCotacao(Double cotacao) {
		this.cotacao = cotacao;
	}

	/**
	 * @return the dataHoraCotacao
	 */
	public Date getDataHoraCotacao() {
		return dataHoraCotacao;
	}

	/**
	 * @param dataHoraCotacao the dataHoraCotacao to set
	 */
	public void setDataHoraCotacao(Date dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cotacao == null) ? 0 : cotacao.hashCode());
		result = prime * result + ((dataHoraCotacao == null) ? 0 : dataHoraCotacao.hashCode());
		result = prime * result + ((fromCurrencyCode == null) ? 0 : fromCurrencyCode.hashCode());
		result = prime * result + ((toCurrencyCode == null) ? 0 : toCurrencyCode.hashCode());
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
		CotacaoCurrencyVO other = (CotacaoCurrencyVO) obj;
		if (cotacao == null) {
			if (other.cotacao != null)
				return false;
		} else if (!cotacao.equals(other.cotacao))
			return false;
		if (dataHoraCotacao == null) {
			if (other.dataHoraCotacao != null)
				return false;
		} else if (!dataHoraCotacao.equals(other.dataHoraCotacao))
			return false;
		if (fromCurrencyCode == null) {
			if (other.fromCurrencyCode != null)
				return false;
		} else if (!fromCurrencyCode.equals(other.fromCurrencyCode))
			return false;
		if (toCurrencyCode == null) {
			if (other.toCurrencyCode != null)
				return false;
		} else if (!toCurrencyCode.equals(other.toCurrencyCode))
			return false;
		return true;
	}
}
