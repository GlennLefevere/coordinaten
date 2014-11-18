/**
 * (c) 2014 ADMB. All rights reserved.
 */
package be.admb.entities;

import javax.persistence.Column;

/**
 * @author infglef
 *
 */
public class Leverancier {
	private String naam;
	@Column(name = "ADRES")
	private String straat;
	private String telefoon;
	private String fax;
	private long prof = 0;
	private String email;
	@Column(name = "WWW")
	private String website;
	private double latitude;
	private double longitude;

	/**
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 *            the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return the straat
	 */
	public String getStraat() {
		return straat;
	}

	/**
	 * @param straat
	 *            the straat to set
	 */
	public void setStraat(String straat) {
		this.straat = straat;
	}

	/**
	 * @return the telefoon
	 */
	public String getTelefoon() {
		return telefoon;
	}

	/**
	 * @param telefoon
	 *            the telefoon to set
	 */
	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the prof
	 */
	public long getProf() {
		return prof;
	}

	/**
	 * @param prof
	 *            the prof to set
	 */
	public void setProf(long prof) {
		this.prof = prof;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
