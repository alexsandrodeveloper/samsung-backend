package br.com.samsung.data.vo.v1;

import java.io.Serializable;

public class CurrencyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long currencyId;
	private String currencyCode;
	private String currencyDesc;

	/**
	 * @return the currencyId
	 */
	public Long getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((currencyDesc == null) ? 0 : currencyDesc.hashCode());
		result = prime * result + ((currencyId == null) ? 0 : currencyId.hashCode());
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
		CurrencyVO other = (CurrencyVO) obj;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (currencyDesc == null) {
			if (other.currencyDesc != null)
				return false;
		} else if (!currencyDesc.equals(other.currencyDesc))
			return false;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		return true;
	}
}
