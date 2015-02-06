/**
 * (c) 2015 ADMB. All rights reserved.
 */
package be.admb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author infglef
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
	private long id;
	private String city;
	private String abbreviation;
	private String nickname;
	private long score;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 * the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation
	 * the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 * the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * @param score
	 * the score to set
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return city + " " + nickname;
	}

}
